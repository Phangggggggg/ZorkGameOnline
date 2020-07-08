package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.JsonForSave.JsonReader;

import java.io.IOException;

public class LoadCommand implements Command{
    private Simulation simulation;

    public LoadCommand(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void execute(String arg) throws IOException {
        JsonReader jsonReader = new JsonReader(simulation);
        jsonReader.loadFile(arg);
        simulation.getCommandFactory().getCommandMap().put("go",new GoCommand(simulation.getPlayer(),simulation.getRoomMap()));
        simulation.getCommandFactory().getCommandMap().put("info",new InfoCommand(simulation.getPlayer()));
        simulation.getCommandFactory().getCommandMap().put("eat",new EatCommand(simulation.getPlayer()));
        simulation.getCommandFactory().getCommandMap().put("take",new TakeCommand(simulation.getPlayer()));
        simulation.getCommandFactory().getCommandMap().put("drop", new DropCommand(simulation.getPlayer()));
        simulation.getCommandFactory().getCommandMap().put("initiateBattle",
                new InitiateBattle(simulation.getCommandFactory(),simulation.getPlayer(),simulation.getAuthentication()));

    }

    @Override
    public String getDescription() {
        return "use this as a load";
    }
}
