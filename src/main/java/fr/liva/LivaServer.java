package fr.liva;

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

        livaServerSocket = new LivaServerSocket("ServerTest", 2222, InetAddress.getLocalHost());

    }
}
