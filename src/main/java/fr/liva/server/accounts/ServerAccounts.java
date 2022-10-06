package fr.liva.server.accounts;

import java.util.HashMap;
import java.util.Map;

public class ServerAccounts {

    public static final Map<String, String> accounts = new HashMap<>();

    public static boolean exist(String pseudo) {
        return accounts.containsKey(pseudo);
    }

    public static String getPassword(String pseudo) {
        return accounts.get(pseudo);
    }

}
