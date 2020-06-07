package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Monster.BlueMonster;
import io.muzoo.ooc.Zork.Monster.GoldMonster;
import io.muzoo.ooc.Zork.Monster.RedMonster;
import io.muzoo.ooc.Zork.Player.Player;

public class PlayCommand implements Command {
    private Simulation simulation;
    private Room start;

    public PlayCommand(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void execute(String arg) {
        if (arg.equals("room2")){
            simulation.constructMap(arg,false); // successful constructing map
            start = simulation.getStartRoom();
            System.out.println("Map is already created");
            Player player = new Player();
            simulation.setPlayer(player);
            System.out.println(player);
            System.out.println("Player is already created");
            player.updateLocation(start);
            System.out.println("Player is at " + start.getRoomName());


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
