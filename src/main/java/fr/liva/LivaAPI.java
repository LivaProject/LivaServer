package fr.liva;

import fr.liva.exceptions.OptionException;
import fr.liva.server.ServerUtils;
import fr.liva.server.options.OptionUtils;

public class LivaAPI {

    public static final String ERROR = "Error: ";
    public static final String INFO = "Info: ";
    public static final String SEPARATOR = "--";

    public void onLoad() {

        // Directories Create
        ServerUtils.createDirectories();

        // Options Create
        try {
            OptionUtils.createOptions();
        } catch (OptionException e) {
            e.printStackTrace();
        }

        // Options Load
        try {
            OptionUtils.loadOptions();
        } catch (OptionException e) {
            e.printStackTrace();
        }


        // Plugins Load
        /*
        for (String pluginName : PluginsUtils.getPlugins()) {
            try {
                JarFile jarFile = new JarFile("plugins/" + pluginName);

                Enumeration<JarEntry> entries = jarFile.entries();

                while (entries.hasMoreElements()) {

                    JarEntry entry = entries.nextElement();
                    if (entry.getName().contains(".")) {
                        JarEntry fileEntry = jarFile.getJarEntry(entry.getName());
                        InputStream input = jarFile.getInputStream(fileEntry);

                        try {
                            LivaReader livaReader = new LivaReader();

                            String mainClass = livaReader.getPluginInfo(entry.getName(), "main");

                            Class<? extends LivaPlugin> plugin = Class.forName(mainClass).asSubclass(LivaPlugin.class);

                            try {
                                LivaPlugin livaPlugin = plugin.newInstance();

                                livaPlugin.onLoad();

                                livaPlugin.onStart();

                                livaPlugin.onEnd();

                            } catch (InstantiationException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        } catch (ClassNotFoundException | InfosException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         */
    }

    public void onStart() {

        // Server

    }

    public void onStop() {
        try {
            OptionUtils.saveOptions();
        } catch (OptionException e) {
            e.printStackTrace();
        }
    }
}
