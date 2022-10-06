package fr.liva.commands;

import fr.liva.Liva;
import fr.liva.entity.player.Player;

public class OnlineCommand extends LivaCommand {

    public OnlineCommand() {
        super("online");
    }

    @Override
    public boolean onExecute(Player player, String[] args) {

        player.sendMessage(Liva.getServer().getPlayers().size() + " Joueurs connectés");

        return true;
    }
}
