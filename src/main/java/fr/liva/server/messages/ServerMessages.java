package fr.liva.server.messages;

import java.util.HashMap;
import java.util.Map;

public class ServerMessages {

    public static final Map<MessageKey, String> messages = new HashMap<>();

    private static String get(MessageKey key) {
        return messages.get(key);
    }
}
