package fr.liva.map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Direction {

    TOP(0),
    BOTTOM(1),
    LEFT(2),
    RIGHT(3);

    private final int id;

    public static Direction get(int id) {
        for (Direction direction : values()) {
            if (direction.getId() == id) {
                return direction;
            }
        }
        return null;
    }

}
