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
