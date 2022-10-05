package fr.liva.server.options;

import java.util.HashMap;
import java.util.Map;

public class ServerOptions {

    public static final Map<OptionKey, OptionValue> options = new HashMap<>();

    private static OptionValue get(OptionKey key) {
        return options.get(key);
    }

    public static String getName() {
        return get(OptionKey.NAME).getString();
    }

    public static int getPort() {
        return get(OptionKey.PORT).getInt();
    }
}
