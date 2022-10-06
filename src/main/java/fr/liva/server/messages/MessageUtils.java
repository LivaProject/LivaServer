package fr.liva.server.messages;

import fr.liva.LivaAPI;
import fr.liva.exceptions.OptionException;
import fr.liva.server.options.OptionKey;
import fr.liva.server.options.OptionValue;
import fr.liva.server.options.ServerOptions;

import java.io.*;
import java.util.Scanner;

public abstract class MessageUtils {

    public static final String PATH = "server/";

    public static final String FILE = "messages.txt";

    public static void createMessages() throws OptionException {

        System.out.println(LivaAPI.SEPARATOR + " Messages");
        System.out.println(LivaAPI.INFO + "Start creating messages.txt...");

        File file = new File(PATH + FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(LivaAPI.INFO + "Successfully creating messages.txt");
            } catch (IOException e) {
                throw new OptionException("Cannot create '" + PATH + FILE + "'.");
            }
        } else {
            System.out.println(LivaAPI.INFO + "File messages.txt already exist");
            return;
        }

        for (MessageKey key : MessageKey.values()) {
            ServerMessages.messages.put(key, key.getDefaultValue());
            System.out.println(LivaAPI.INFO + "Create default message for " + key.getName());
        }
        saveMessages();
    }

    public static void loadMessages() throws OptionException {

        System.out.println(LivaAPI.INFO + "Start loading messages...");

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH + FILE);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String value = line.split("=")[1];

                MessageKey property = MessageKey.getFromLine(line);

                if (property == null) {
                    continue;
                }

                System.out.println(LivaAPI.INFO + "Load messages for " + property.getName());
                ServerMessages.messages.put(property, value);
            }

            scanner.close();
        } catch (Exception e) {
            throw new OptionException("Cannot load messages from '" + PATH + FILE + "', contact the support.");
        }

        System.out.println(LivaAPI.INFO + "Successfully load messages");
    }

    public static void saveMessages() throws OptionException {

        System.out.println(LivaAPI.INFO + "Start saving messages...");

        try {
            PrintWriter writer = new PrintWriter(PATH + FILE, "UTF-8");
            ServerMessages.messages.forEach((key, value) -> {
                writer.println(key.getName() + "=" + value);
            });
            writer.close();

            System.out.println(LivaAPI.INFO + "Messages saved");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new OptionException("Cannot find '" + PATH + FILE + "' file, are you sure you didn't delete it ?");
        }
    }

}
