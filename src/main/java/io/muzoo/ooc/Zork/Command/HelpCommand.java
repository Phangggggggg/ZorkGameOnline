package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Map.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command {
    private CommandFactory commandFactory;

    public HelpCommand(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void execute(String arg) {
        for (Map.Entry <String, Command> commmandName : commandFactory.getCommandMap().entrySet()) {
            System.out.println(commmandName + ": " + commmandName.getValue().getDescription());
        }
    }

    @Override
    public String getDescription() {
        return "This is command that inform descriptions of command";
    }
}
