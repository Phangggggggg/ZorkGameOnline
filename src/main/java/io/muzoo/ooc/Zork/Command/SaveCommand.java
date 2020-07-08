package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.JsonForSave.JsonWriter;

import java.io.IOException;

public class SaveCommand implements Command{
    private Simulation simulation;

    public SaveCommand(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void execute(String arg) throws IOException {
        if (!simulation.getExit().get(0)){ // map is already created
            JsonWriter jsonWriter = new JsonWriter(simulation);
            jsonWriter.writeSave(arg);
            System.out.println("saving is done");

        }
        else {
            System.out.println("This command is not allowed currently");
        }


    }

    @Override
    public String getDescription() {
        return "This command is for saving game";
    }
}
