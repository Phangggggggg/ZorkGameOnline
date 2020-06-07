package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;

public class ExitCommand implements Command {
    private Simulation simulation;

    public ExitCommand(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void execute(String arg) {
        simulation.setExit(0,true); // remove map out in order to stop inner while loop
        System.out.println("You exit the game");
        System.out.println("Create a new map to continue playing");

    }

    @Override
    public String getDescription() {
        return "This is a command that exit the game";
    }
}
