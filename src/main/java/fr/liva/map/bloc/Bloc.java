package fr.liva.map.bloc;

import fr.liva.map.Location;
import fr.liva.map.world.World;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Bloc {

    private Location location;

    @Setter
    private BlocType type;

    public Bloc(Location location, BlocType type) {
        this.location = location;
        this.type = type;
    }

    public static Bloc fromString(World world, String s) {
        String[] args = s.split("-");

        return new Bloc(Location.fromString(world, args[0]), BlocType.get(args[1]));
    }

    public String toString() {
        return location.toString() + "-" + type.getName();
    }
}
