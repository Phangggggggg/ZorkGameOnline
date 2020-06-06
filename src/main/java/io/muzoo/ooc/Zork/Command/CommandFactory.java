package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    public static Map<String, Command> commandMap = new HashMap<>();


    public static void putInCommand(Player player, Map<String, Room> roomMap, CommandFactory cmd){
        commandMap.put("info", new InfoCommand(player));
        commandMap.put("eat",new EatCommand(player));
        commandMap.put("take",new TakeCommand(player));
        commandMap.put("drop", new DropCommand(player));
        commandMap.put("go",new GoCommand(player,roomMap));
        commandMap.put("initiateBattle", new InitiateBattle(cmd,player));

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
