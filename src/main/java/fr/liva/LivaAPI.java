package fr.liva;

import fr.liva.exceptions.OptionException;
import fr.liva.map.Location;
import fr.liva.map.bloc.Bloc;
import fr.liva.map.bloc.BlocType;
import fr.liva.map.world.World;
import fr.liva.server.ServerUtils;
import fr.liva.server.accounts.AccountUtils;
import fr.liva.server.messages.MessageUtils;
import fr.liva.server.options.OptionUtils;
import fr.liva.server.options.ServerOptions;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LivaAPI {

    public static final String ERROR = "Error: ";
    public static final String INFO = "Info: ";
    public static final String SEPARATOR = "--";

    public void onLoad() {

        // Directories Create
        ServerUtils.createDirectories();

        // Create
        try {
            OptionUtils.createOptions();
            MessageUtils.createMessages();
            AccountUtils.createAccounts();

            World world = Liva.getServer().loadWorld("main");
            world.getBlocs().add(new Bloc(new Location(world, 0, 0), BlocType.GRASS));
            Liva.getServer().saveWorld(world);
        } catch (OptionException e) {
            e.printStackTrace();
        }

        // Load
        try {
            OptionUtils.loadOptions();
            MessageUtils.loadMessages();
            AccountUtils.loadAccounts();
        } catch (OptionException e) {
            e.printStackTrace();
        }

        // Worlds Load
        Liva.getServer().getWorlds().add(new World("main"));
    }

    public void onStart() {

        // Server
        try {
            LivaServer.livaServerSocket = new LivaServerSocket(ServerOptions.getName(), ServerOptions.getPort(), InetAddress.getByName("172.20.10.2"));
        } catch (UnknownHostException e) {
            System.out.println(ERROR + "Cannot start server on port " + LivaServer.livaServerSocket.getPort() + ".");
        }


    }

    public void onStop() {
        try {
            OptionUtils.saveOptions();
            MessageUtils.saveMessages();
            AccountUtils.saveAccounts();
        } catch (OptionException e) {
            e.printStackTrace();
        }
    }
}
