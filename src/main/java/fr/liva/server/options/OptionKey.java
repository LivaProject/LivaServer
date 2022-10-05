package fr.liva.server.options;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OptionKey {

    NAME("server_name", "MyServer"),
    PORT("server_port", "30001");

    private final String name;
    private final String defaultValue;

    public static OptionKey get(String name) {
        for (OptionKey property : values()) {
            if (property.getName().equalsIgnoreCase(name)) {
                return property;
            }
        }
        return null;
    }

    public static OptionKey getFromLine(String line) {
        for (OptionKey property : values()) {
            if (line.split("=")[0].equalsIgnoreCase(property.getName())) {
                return property;
            }
        }
        return null;
    }
}
