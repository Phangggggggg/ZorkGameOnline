package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static Map<String, Command> commandMap = new HashMap<>();

    public void putInCommand(Simulation simulation){
        Player player = simulation.getPlayer();
        Map<String,Room> roomMap = simulation.getRoomMap();
        CommandFactory cmd = simulation.getCommandFactory();
        Authentication authentication = simulation.getAuthentication();
        commandMap.put("quit", new QuitCommand(simulation));
        commandMap.put("help", new HelpCommand(cmd));
        commandMap.put("play",new PlayCommand(simulation,cmd));
        commandMap.put("exit", new ExitCommand(simulation));


    }

    public  Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public Command getCommand(String cmd)
    {
        return commandMap.get(cmd);
    }

    public boolean containCommand(String cmd){
        if (commandMap.containsKey(cmd)){
            return true;
        }else {
            return false;
        }
    }

}
