package fr.liva.commands;

import fr.liva.entity.player.Player;

public class HelpCommand extends LivaCommand {

    public HelpCommand() {
        super("help");
    }

    @Override
    public boolean onExecute(Player player, String[] args) {

        player.sendMessage("--- MENU AIDE ---");
        player.sendMessage(" /online: Afficher nombre de joueurs");
        player.sendMessage(" /players: Afficher les joueurs");
        player.sendMessage(" /leave: quitter le serveur");

        return true;
    }
}
