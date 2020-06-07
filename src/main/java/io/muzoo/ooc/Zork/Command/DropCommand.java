package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Item.Item;
import io.muzoo.ooc.Zork.Player.Player;

public class DropCommand implements Command {
    private Player player;

    public DropCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String arg) {
        if (player.getInventory().getThatItem(arg).equals(null)){ // bug
            System.out.println("no such item in your inventory or you misspelled your item name");
        }
        else {
            player.getInventory().dropItem(arg);
            System.out.println(arg + "has been removed from your inventory");
        }

    }

    @Override
    public String getDescription() {
        return "Drop your item from your inventory [Key, Potion, Garbage]";
    }
}
