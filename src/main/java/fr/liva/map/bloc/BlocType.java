package fr.liva.map.bloc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BlocType {

    GRASS("grass"),
    PATH("path"),
    STONE("stone");

    private final String name;

    public static BlocType get(String name) {
        for (BlocType blocType : values()) {
            if (blocType.getName().equalsIgnoreCase(name)) {
                return blocType;
            }
        }
        return null;
    }

}
