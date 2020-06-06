package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Map.CreateMap;
import io.muzoo.ooc.Zork.Map.ReadFile;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Player.Player;

import java.util.HashMap;
import java.util.Map;

public class GoCommand implements Command {
    private Player player;
    private Map<String,Room> Map;

    public GoCommand(Player player, Map<String, Room> map) {
        this.player = player;
        this.Map = map;
    }

    @Override
    public void execute(String arg) {
        if (arg.equals("north")){
            String roomNorth = player.getCurrentRoom().getNorth();
            Room roomObj = Map.get(roomNorth);
            player.updateLocation(roomObj);
            System.out.println("North" + roomNorth);
        }
        else if (arg.equals("south")){
            String roomSouth = player.getCurrentRoom().getSouth();
            Room roomObj = Map.get(roomSouth);
            player.updateLocation(roomObj);
            System.out.println("South " + roomSouth);

        }
        else if (arg.equals("west")){
            String roomWest = player.getCurrentRoom().getWest();
            Room roomObj = Map.get(roomWest);
            player.updateLocation(roomObj);
            System.out.println("West " + roomWest);

        }
        else if (arg.equals("east")){
            String roomEast = player.getCurrentRoom().getEast();
            Room roomObj = Map.get(roomEast);
            player.updateLocation(roomObj);
            System.out.println("East " + roomEast);


        }
        else {
            System.out.println("maybe you spell something wrong");
        }

    }

    @Override
    public String getDescription() {
        return "Go [north, south, west, east]";
    }
}
