package fr.liva.commands;

import fr.liva.entity.player.Player;

public class UnexistCommand extends LivaCommand {

    public UnexistCommand() {
        super("unexist");
    }

    @Override
    public boolean onExecute(Player player, String[] args) {

        player.sendMessage("Commande inconnue, utilisez /help pour afficher l'aide.");

        return true;
    }
}
