package fr.liva.utils;

import fr.liva.exceptions.InfosException;

import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class LivaReader {

    public String getInfo(String pluginPath, String info) throws InfosException {

        String path;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(pluginPath + "infos.txt");

        if (resource == null) {
            throw new InfosException("Cannot find '" + pluginPath + "/infos.txt' file.");
        } else {
            try {
                path = resource.toURI().getPath();
            } catch (URISyntaxException e) {
                throw new InfosException("Cannot load '" + pluginPath + "/infos.txt', contact the support");
            }
        }

        try {

            FileInputStream fileInputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String key = line.split("=")[0];
                String value = line.split("=")[1];

                if (!key.equalsIgnoreCase(info)) {
                    continue;
                }

                scanner.close();
                return value;
            }

            scanner.close();
        } catch (Exception e) {
            throw new InfosException("Cannot load infos from '" + pluginPath + "/infos.txt', contact the support.");
        }
        if (info.equalsIgnoreCase("version")) {
            return "/";
        } else if (info.equalsIgnoreCase("author")) {
            return "Thomarz";
        }
        throw new InfosException("You need to create and fill the '" + pluginPath + "/infos.txt' file !");
    }

    public String getPluginInfo(String path, String info) throws InfosException {

        try {

            FileInputStream fileInputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String key = line.split("=")[0];
                String value = line.split("=")[1];

                if (!key.equalsIgnoreCase(info)) {
                    continue;
                }

                scanner.close();
                return value;
            }

            scanner.close();
        } catch (Exception e) {
            throw new InfosException("Cannot load infos from '" + path + "', contact the support.");
        }
        if (info.equalsIgnoreCase("version")) {
            return "/";
        } else if (info.equalsIgnoreCase("author")) {
            return "Thomarz";
        }
        throw new InfosException("You need to create and fill the '" + path + "' file !");
    }

}
