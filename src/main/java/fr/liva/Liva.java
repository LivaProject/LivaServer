package fr.liva;

import fr.liva.entity.player.Player;
import fr.liva.map.world.World;
import fr.liva.server.Server;
import lombok.Getter;

public class Liva {

    @Getter
    private static Server server = new Server();

    public static Player getPlayer(String name) {
        return server.getPlayer(name);
    }

    public static World getWorld(String name) {
        return server.getWorld(name);
    }

}
