package fr.liva.entity.player;

import fr.liva.entity.Entity;
import fr.liva.map.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Player extends Entity {

    @Setter
    private int foodLevel;

    public Player(String name, Location location) {
        super(name, location);
        this.foodLevel = 100;
    }
}
