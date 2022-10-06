package fr.liva;

import fr.liva.commands.*;

public class LivaServer {

    public static LivaServerSocket livaServerSocket;

    public static void main(String[] args) {

        LivaAPI livaAPI = new LivaAPI();

        // Commands
        LivaCommand.commands.put("unexist", new UnexistCommand());
        LivaCommand.commands.put("help", new HelpCommand());
        LivaCommand.commands.put("leave", new LeaveCommand());
        LivaCommand.commands.put("players", new PlayersCommand());
        LivaCommand.commands.put("online", new OnlineCommand());

        // Load
        livaAPI.onLoad();

        // Start
        livaAPI.onStart();

    }
}
