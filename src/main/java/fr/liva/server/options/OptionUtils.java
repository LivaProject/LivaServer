package fr.liva.server.options;

import fr.liva.LivaAPI;
import fr.liva.exceptions.OptionException;

import java.io.*;
import java.util.Scanner;

public abstract class OptionUtils {

    public static final String PATH = "server/";

    public static final String FILE = "options.txt";

    public static void createOptions() throws OptionException {

        System.out.println(LivaAPI.SEPARATOR + " Options");
        System.out.println(LivaAPI.INFO + "Start creating options.txt...");

        File file = new File(PATH + FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(LivaAPI.INFO + "Successfully creating options.txt");
            } catch (IOException e) {
                throw new OptionException("Cannot create '" + PATH + FILE + "'.");
            }
        } else {
            System.out.println(LivaAPI.INFO + "File options.txt already exist");
            return;
        }

        for (OptionKey key : OptionKey.values()) {
            ServerOptions.options.put(key, new OptionValue(key.getDefaultValue()));
            System.out.println(LivaAPI.INFO + "Create default option for " + key.getName());
        }
        saveOptions();
    }

    public static void loadOptions() throws OptionException {

        System.out.println(LivaAPI.INFO + "Start loading options...");

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH + FILE);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String value = line.split("=")[1];

                OptionKey property = OptionKey.getFromLine(line);

                if (property == null) {
                    continue;
                }

                System.out.println(LivaAPI.INFO + "Load option for " + property.getName());
                ServerOptions.options.put(property, new OptionValue(value));
            }

            scanner.close();
        } catch (Exception e) {
            throw new OptionException("Cannot load options from '" + PATH + FILE + "', contact the support.");
        }

        System.out.println(LivaAPI.INFO + "Successfully load options");
    }

    public static void saveOptions() throws OptionException {

        System.out.println(LivaAPI.INFO + "Start saving options...");

        try {
            PrintWriter writer = new PrintWriter(PATH + FILE, "UTF-8");
            ServerOptions.options.forEach((key, value) -> {
                writer.println(key.getName() + "=" + value.getString());
            });
            writer.close();

            System.out.println(LivaAPI.INFO + "Options saved");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new OptionException("Cannot find '" + PATH + FILE + "' file, are you sure you didn't delete it ?");
        }
    }

}
