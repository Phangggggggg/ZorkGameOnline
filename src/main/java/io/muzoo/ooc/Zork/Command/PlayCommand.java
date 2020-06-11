package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Monster.BlueMonster;
import io.muzoo.ooc.Zork.Monster.GoldMonster;
import io.muzoo.ooc.Zork.Monster.RedMonster;
import io.muzoo.ooc.Zork.Player.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayCommand implements Command {
    private Simulation simulation;
    private Room start;
    private Map<String, Command> commandMap;
    private CommandFactory commandFactory;

    public PlayCommand(Simulation simulation,CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
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
            System.out.println("Player is already created");
            player.updateLocation(start);
            System.out.println("Player is at " + start.getRoomName());
            System.out.println("If it is corner or block, you can not go enter that room");
            commandFactory.getCommandMap().put("go",new GoCommand(player,simulation.getRoomMap()));
            commandFactory.getCommandMap().put("info",new InfoCommand(player));
            commandFactory.getCommandMap().put("eat",new EatCommand(player));
            commandFactory.getCommandMap().put("take",new TakeCommand(player));
            commandFactory.getCommandMap().put("drop", new DropCommand(player));
            commandFactory.getCommandMap().put("initiateBattle",
                    new InitiateBattle(simulation.getCommandFactory(),player,simulation.getAuthentication()));
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
