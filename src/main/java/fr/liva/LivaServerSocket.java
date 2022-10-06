package fr.liva;

import fr.liva.commands.LivaCommand;
import fr.liva.entity.player.Player;
import fr.liva.exceptions.OptionException;
import fr.liva.map.Location;
import fr.liva.server.messages.MessageKey;
import fr.liva.server.messages.ServerMessages;
import fr.liva.server.options.OptionUtils;
import fr.thomarz.TClientSocket;
import fr.thomarz.TServerSocket;

import java.net.InetAddress;

public class LivaServerSocket extends TServerSocket {

    public LivaServerSocket(String name, int port, InetAddress ip) {
        super(name, port, ip);
    }

    @Override
    public void onReceive(String client, String message) {
        String channel = TClientSocket.getChannel(message);
        String[] args = TClientSocket.getArgs(message);

        Player player = Liva.getServer().getPlayer(client);

        if (channel.equalsIgnoreCase("Chat")) {
            sendMessage("*", message);
        } else if (channel.equalsIgnoreCase("OnlinePlayers")) {
            sendMessage(client, Liva.getServer().getPlayers().size());
        } else if (channel.equalsIgnoreCase("Command")) {
            try {
                String name = args[0];

                LivaCommand command = LivaCommand.getCommand(name);
                command.execute(player, message.replaceFirst(channel + " ", ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onJoin(String clientName) {
        super.onJoin(clientName);

        Player online = Liva.getServer().getPlayer(clientName);

        if (online != null) {
            onQuit(clientName);
        }

        Player player = new Player(clientName, new Location(Liva.getServer().getWorld("main"), 0, 0));

        Liva.getServer().getPlayers().add(player);

        sendMessage("*", "Message " + ServerMessages.messages.get(MessageKey.JOIN).replaceAll("\\{player}", player.getName()));
    }

    @Override
    public void onQuit(String clientName) {
        super.onQuit(clientName);

        Player player = Liva.getServer().getPlayer(clientName);
        if (player == null) {
            return;
        }

        Liva.getServer().getPlayers().remove(player);

        sendMessage("*", "Message " + ServerMessages.messages.get(MessageKey.QUIT).replaceAll("\\{player}", player.getName()));
    }

    @Override
    public void onStop() {
        super.onStop();

        try {
            OptionUtils.saveOptions();
        } catch (OptionException e) {
            e.printStackTrace();
        }
    }
}
