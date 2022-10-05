package fr.liva.server;

import fr.liva.LivaAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ServerUtils {

    public static void createDirectories() {
        List<String> directories = new ArrayList<>();

        directories.add("maps/");
        directories.add("data/");
        directories.add("server/");

        System.out.println(LivaAPI.SEPARATOR + "Directories");
        System.out.println(LivaAPI.INFO + "Start creating directories...");

        int created = 0;

        for (String directory : directories) {
            File file = new File(directory);

            if (!file.exists()) {
                file.mkdirs();
                System.out.println(LivaAPI.INFO + "Created directory '" + directory + "'.");

                created++;
            }
        }

        System.out.println(LivaAPI.INFO + "Created " + created + " directories (" + (directories.size() - created) + " existing, " + created + " new)");
    }
}
