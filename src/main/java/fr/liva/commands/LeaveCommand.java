package fr.liva.commands;

import fr.liva.LivaServer;
import fr.liva.entity.player.Player;
import fr.liva.server.messages.MessageKey;
import fr.liva.server.messages.ServerMessages;

public class LeaveCommand extends LivaCommand {

    public LeaveCommand() {
        super("leave");
    }

    @Override
    public boolean onExecute(Player player, String[] args) {

        LivaServer.livaServerSocket.sendMessage(player.getName(), "Leave " + ServerMessages.messages.get(MessageKey.LEAVE_SELF));
        LivaServer.livaServerSocket.onQuit(player.getName());

        return true;
    }
}
