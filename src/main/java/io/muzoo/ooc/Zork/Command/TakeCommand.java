package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Player.Player;

public class TakeCommand implements Command{
    private Player player;

    public TakeCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String arg) {
        if (player.getCurrentRoom().HasItem()){
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
