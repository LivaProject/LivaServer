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

    public static Location fromString(World world, String s) {
        try {
            Location location = new Location(world, Integer.parseInt(s.split(";")[0]), Integer.parseInt(s.split(";")[1]),
                    Direction.get(Integer.parseInt(s.split(";")[2])));

            return location;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public String toString() {
        return x + ";" + y + ";" + direction.getId();
    }
}
