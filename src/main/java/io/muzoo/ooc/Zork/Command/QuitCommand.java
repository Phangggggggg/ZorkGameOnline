package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;

public class QuitCommand implements Command {
    private Simulation simulation;

    public QuitCommand(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void execute(String arg) {
        simulation.setExit(1,true);
        simulation.setQuit(true);
    }

    @Override
    public String getDescription() {
        return "This command is for quiting game";
    }
}
