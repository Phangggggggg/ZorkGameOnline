package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.Monster.BlueMonster;
import io.muzoo.ooc.Zork.Monster.GoldMonster;
import io.muzoo.ooc.Zork.Monster.RedMonster;
import io.muzoo.ooc.Zork.Player.Player;

public class PlayCommand implements Command {
    private Simulation simulation;

    public PlayCommand(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void execute(String arg) {
        if (arg.equals("room2")){
            simulation.constructMap(arg,false); // successful constructing map
            simulation.setPlayer(new Player());


        }
        else {
            System.out.println("Cannot find the map that has the same name as " + arg);
            System.out.println("Map name that available is room2");
        }

    }

    @Override
    public String getDescription() {
        return "This command is for starting game";
    }
}
