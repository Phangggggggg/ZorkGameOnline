package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class TakeCommand implements Command{
    private Player player;
    private List<String> itemName;

    public TakeCommand(Player player) {
        this.player = player;
        itemName = new ArrayList<>();
        itemName.add("Garbage");
        itemName.add("Key");
        itemName.add("Potion");

    }

    @Override
    public void execute(String arg) {
        if (arg == null ||  !itemName.contains(arg)){
            System.out.println("You might misspelled the item name");
            System.out.println("Item name that available are [Garbage, Key, Potion]");
        }
        else if (player.getCurrentRoom().HasItem()){
            if (player.getCurrentRoom().getItem().getItemName().equals("Garbage")){
                player.getInventory().takeItem(arg);
                player.getCurrentRoom().takeOut();
            }
            else if (player.getCurrentRoom().getItem().getItemName().equals("Key")){
                player.getInventory().takeItem(arg);
                player.getCurrentRoom().takeOut();

            }
            else if (player.getCurrentRoom().getItem().getItemName().equals("Potion")){
                player.getInventory().takeItem(arg);
                player.getCurrentRoom().takeOut();
            }

        }
        else {
            System.out.println("no such item exist in this room you are in");
        }

    }

    @Override
    public String getDescription() {
        return "Take item by this command";
    }
}
