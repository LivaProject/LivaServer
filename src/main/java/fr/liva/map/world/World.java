package fr.liva.map.world;

import lombok.Getter;

@Getter
public class World {

    private String name;

    private WorldType type;

    public World(String name) {
        this.name = name;
    }

}
