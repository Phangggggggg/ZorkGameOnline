package io.muzoo.ooc.Zork.Command;

public class SplitCommand {
    public void getCommand(CommandFactory cmdFactory, Parser parser){
        String command = parser.getCommand();
        String commandOne = command.split("/")[0];
        String commandTwo = command.split("/")[1];
        if (cmdFactory.containCommand(commandOne)){
            cmdFactory.getCommand(commandOne).execute(commandTwo); // in case for go  north
        }


    }


}
