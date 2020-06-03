package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Player.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> commandMap = new HashMap<>();


    public void putInCommand(Player player){
        commandMap.put("info", new InfoCommand(player));

    }
    public Command getCommand(String cmd){
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
