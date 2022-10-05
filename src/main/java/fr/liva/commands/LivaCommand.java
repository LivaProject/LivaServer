package fr.liva.commands;

import fr.liva.entity.player.Player;
import lombok.Getter;

@Getter
public abstract class LivaCommand {

    private String name;

    public LivaCommand(String name) {
        this.name = name;
    }

    public boolean execute(Player player, String commandLine) {
        String[] args = commandLine.split(" ");
        return onExecute(player, args);
    }

    public abstract boolean onExecute(Player player, String[] args);
}
