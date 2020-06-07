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
        for (String commandName: commandFactory.getCommandMap().keySet()) {
            System.out.println(commandName + ": " + commandFactory.getCommandMap().get(commandName).getDescription());

        }

    }

    @Override
    public String getDescription() {
        return "This is command that inform descriptions of command";
    }
}
