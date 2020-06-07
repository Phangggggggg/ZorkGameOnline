package io.muzoo.ooc.Zork.Command;

import java.util.ArrayList;
import java.util.Map;

public class SplitCommand {

    public void getCommand(CommandFactory commandFactory, Parser parser, String gameState, Map<String,
            ArrayList<String>> limitCommandMap){
        String command = parser.getCommand();
        String commandOne = command.split("/")[0];
        String commandTwo = command.split("/")[1];
        if(limitCommandMap.get(gameState).contains(commandOne)){
            commandFactory.getCommand(commandOne).execute(commandTwo);
        }
        else {
            System.out.println("This command is not available in " + gameState);
        }


//        if (cmdFactory.containCommand(commandOne)){
//            cmdFactory.getCommand(commandOne).execute(commandTwo); // in case for go  north
//        }
    }





}
