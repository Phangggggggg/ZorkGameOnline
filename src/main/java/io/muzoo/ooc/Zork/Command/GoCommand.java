package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Map.CreateMap;
import io.muzoo.ooc.Zork.Map.ReadFile;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoCommand implements Command {
    private Player player;
    private Map<String,Room> Map;
    private List<String> direction;


    public GoCommand(Player player, Map<String, Room> map) {
        this.player = player;
        this.Map = map;
        direction = new ArrayList<>();
        direction.add("north");
        direction.add("south");
        direction.add("west");
        direction.add("east");



    }

    @Override
    public void execute(String arg) {
        if (!direction.contains(arg)){
            System.out.println("You may be misspelled");
        }
        else {
            if (!player.getCurrentRoom().getNeighbour(arg).equals("Corner")
                    && !player.getCurrentRoom().getNeighbour(arg).equals("Block")){
                String nextRoom = player.getLocation().getNeighbour(arg);
                player.updateLocation(Map.get(nextRoom));
                System.out.println("You are at " + player.getCurrentRoom().getRoomName());

            }
            else {
                System.out.println("This is either block or corner");
            }

        }

    }


    @Override
    public String getDescription() {
        return "Go [north, south, west, east]";
    }
}
