package fr.liva;

import fr.liva.server.Server;
import lombok.Getter;

public class Liva {

    @Getter
    private static Server server = new Server();

}
