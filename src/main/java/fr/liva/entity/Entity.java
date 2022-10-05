package fr.liva.entity;

import fr.liva.LivaServer;
import fr.liva.map.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Entity {

    private String name;

    @Setter
    private Location location;

    public Entity(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void sendMessage(String message) {
        LivaServer.livaServerSocket.sendMessage(name, message);
    }
}
