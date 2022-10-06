package fr.liva.server.accounts;

import fr.liva.LivaAPI;
import fr.liva.exceptions.OptionException;
import fr.liva.server.options.OptionKey;
import fr.liva.server.options.OptionValue;
import fr.liva.server.options.ServerOptions;

import java.io.*;
import java.util.Scanner;

public abstract class AccountUtils {

    public static final String PATH = "accounts/";

    public static final String FILE = "accounts.txt";

    public static void createAccounts() throws OptionException {

        System.out.println(LivaAPI.SEPARATOR + " Players");
        System.out.println(LivaAPI.INFO + "Start creating accounts.txt...");

        File file = new File(PATH + FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(LivaAPI.INFO + "Successfully creating accounts.txt");
            } catch (IOException e) {
                throw new OptionException("Cannot create '" + PATH + FILE + "'.");
            }
        } else {
            System.out.println(LivaAPI.INFO + "File accounts.txt already exist");
            return;
        }

        ServerAccounts.accounts.put("admin", "admin");
        saveAccounts();
    }

    public static void loadAccounts() throws OptionException {

        System.out.println(LivaAPI.INFO + "Start loading accounts...");

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH + FILE);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String key = line.split("=")[0];
                String value = line.split("=")[1];

                ServerAccounts.accounts.put(key, value);
            }

            scanner.close();
        } catch (Exception e) {
            throw new OptionException("Cannot load accounts from '" + PATH + FILE + "', contact the support.");
        }

        System.out.println(LivaAPI.INFO + "Successfully load accounts");
    }

    public static void saveAccounts() throws OptionException {

        System.out.println(LivaAPI.INFO + "Start saving accounts...");

        try {
            PrintWriter writer = new PrintWriter(PATH + FILE, "UTF-8");
            ServerAccounts.accounts.forEach((key, value) -> {
                writer.println(key + "=" + value);
            });
            writer.close();

            System.out.println(LivaAPI.INFO + "Accounts saved");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new OptionException("Cannot find '" + PATH + FILE + "' file, are you sure you didn't delete it ?");
        }
    }

}
