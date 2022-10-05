package fr.liva.server;

import fr.liva.entity.player.Player;
import fr.liva.map.world.World;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Server {

    private List<Player> players;

    private List<World> worlds;


    public Server() {
        this.players = new ArrayList<>();
    }

    public Player getPlayer(String name) {
        Optional<Player> player = players.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findAny();
        return player.orElse(null);
    }

    public World getWorld(String name) {
        Optional<World> world = worlds.stream().filter(w -> w.getName().equalsIgnoreCase(name)).findAny();
        return world.orElse(null);
    }
}
