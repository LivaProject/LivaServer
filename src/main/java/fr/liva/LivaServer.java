package fr.liva;

import fr.liva.entity.player.Player;
import fr.liva.plugin.Liva;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LivaServer {

    public static LivaServerSocket livaServerSocket;

    public static void main(String[] args) throws UnknownHostException {

        LivaAPI livaAPI = new LivaAPI();

        // Load
        livaAPI.onLoad();

        // Start
        livaAPI.onStart();

        // Stop
        livaAPI.onStop();

        livaServerSocket = new LivaServerSocket(2222, InetAddress.getLocalHost());
        livaServerSocket.sendMessage("*", "ah");

        Player player = new Player("Client", null);

        Liva.getServer().getPlayers().add(player);

    }
}
