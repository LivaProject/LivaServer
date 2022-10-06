package fr.liva.commands;

import fr.liva.Liva;
import fr.liva.entity.player.Player;

public class PlayersCommand extends LivaCommand {

    public PlayersCommand() {
        super("players");
    }

    @Override
    public boolean onExecute(Player player, String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        for (Player online : Liva.getServer().getPlayers()) {
            i++;
            stringBuilder.append(online.getName()).append(i == Liva.getServer().getPlayers().size() ? "." : ", ");
        }

        player.sendMessage(stringBuilder.toString());

        return true;
    }
}
