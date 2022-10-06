package fr.liva.commands;

import fr.liva.entity.player.Player;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class LivaCommand {

    public static final Map<String, LivaCommand> commands = new HashMap<>();

    private String name;

    public LivaCommand(String name) {
        this.name = name;
    }

    public boolean execute(Player player, String commandLine) {
        String[] args = commandLine.split(" ");
        return onExecute(player, args);
    }

    public abstract boolean onExecute(Player player, String[] args);

    public static LivaCommand getCommand(String name) {
        for (Map.Entry<String, LivaCommand> commandEntry : commands.entrySet()) {
            if (commandEntry.getKey().equalsIgnoreCase(name)) {
                return commandEntry.getValue();
            }
        }
        return name.equalsIgnoreCase("unexist") ? null : getCommand("unexist");
    }
}
