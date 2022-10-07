package fr.liva.server;

import fr.liva.Liva;
import fr.liva.entity.player.Player;
import fr.liva.map.bloc.Bloc;
import fr.liva.map.world.World;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Getter
public class Server {

    private List<Player> players;

    private List<World> worlds;


    public Server() {
        this.players = new ArrayList<>();
        this.worlds = new ArrayList<>();
    }

    public Player getPlayer(String name) {
        Optional<Player> player = players.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findAny();
        return player.orElse(null);
    }

    public World getWorld(String name) {
        Optional<World> world = worlds.stream().filter(w -> w.getName().equalsIgnoreCase(name)).findAny();
        return world.orElse(null);
    }

    public World loadWorld(String name) {
        World world = new World(name);
        try {
            FileInputStream fileInputStream = new FileInputStream("maps/" + name + ".txt");
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String key = line.split("=")[0];
                String value = line.split("=")[1];

                if (key.equals("Bloc")) {
                    Bloc bloc = Bloc.fromString(world, value);
                    world.getBlocs().add(bloc);
                }
            }

            scanner.close();
        } catch (Exception e) {
            return null;
        }

        Liva.getServer().getWorlds().add(world);
        return world;
    }

    public void saveWorld(World world) {

        try {
            PrintWriter writer = new PrintWriter("maps/" + world.getName() + ".txt", "UTF-8");
            world.getBlocs().forEach(bloc -> {
                writer.println("Bloc=" + bloc.toString());
            });
            writer.close();

        } catch (FileNotFoundException | UnsupportedEncodingException e) {

        }
    }
}
