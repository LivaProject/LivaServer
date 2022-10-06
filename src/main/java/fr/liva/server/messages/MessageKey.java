package fr.liva.server.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageKey {

    LEAVE_SELF("Leave_Self", "Vous avez quitté le serveur."),
    LEAVE_FULL("Leave_Full", "Le serveur est plein."),
    JOIN("Join", "{player} a rejoint le serveur"),
    QUIT("Quit", "{player} a quitté le serveur");

    private final String name;
    private final String defaultValue;

    public static MessageKey get(String name) {
        for (MessageKey property : values()) {
            if (property.getName().equalsIgnoreCase(name)) {
                return property;
            }
        }
        return null;
    }

    public static MessageKey getFromLine(String line) {
        for (MessageKey property : values()) {
            if (line.split("=")[0].equalsIgnoreCase(property.getName())) {
                return property;
            }
        }
        return null;
    }
}
