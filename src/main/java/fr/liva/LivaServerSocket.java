package fr.liva;

import fr.liva.plugin.Liva;
import fr.thomarz.TClientSocket;
import fr.thomarz.TServerSocket;

import java.net.InetAddress;

public class LivaServerSocket extends TServerSocket {

    public LivaServerSocket(int port, InetAddress ip) {
        super(port, ip);
    }

    @Override
    public void onReceive(String client, String message) {
        String channel = TClientSocket.getChannel(message);
        String[] args = TClientSocket.getArgs(message);

        if (channel.equalsIgnoreCase("OnlinePlayers")) {
            sendMessage(client, Liva.getServer().getPlayers().size());
        } else if (channel.equalsIgnoreCase("Worlds")) {
            sendMessage(client, Liva.getServer().getWorlds().size());
        } else if (channel.equalsIgnoreCase("Connected")) {
            sendMessage(client, Liva.getPlayer(client) != null);
        }
    }
}
