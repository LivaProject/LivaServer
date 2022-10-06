package fr.liva.map;

import fr.liva.map.world.World;
import lombok.Getter;

@Getter
public class Location {

    private World world;

    private int x;
    private int y;

    private Direction direction;

    public Location(World world, int x, int y) {
        this(world, x, y, Direction.BOTTOM);
    }

    public Location(World world, int x, int y, Direction direction) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void subtract(int x, int y) {
        this.x -= x;
        this.y -= y;
    }

    public void multiply(int x, int y) {
        this.x *= x;
        this.y *= y;
    }

    public void divide(int x, int y) {
        this.x /= x;
        this.y /= y;
    }
}
