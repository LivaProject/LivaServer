package fr.liva.map.world;

import fr.liva.map.bloc.Bloc;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class World {

    private String name;

    private WorldType type;

    private List<Bloc> blocs;

    public World(String name) {
        this.name = name;
        this.type = WorldType.DEFAULT;
        this.blocs = new ArrayList<>();
    }
}
