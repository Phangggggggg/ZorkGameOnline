package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Item.Inventory;
import io.muzoo.ooc.Zork.Item.Item;
import io.muzoo.ooc.Zork.Player.Player;

import java.util.ArrayList;
import java.util.List;

public class EatCommand implements Command {
    private Player player;

    public EatCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String arg) {
        Item playerItem = player.getInventory().getThatItem(arg);
        if (playerItem != null){
            Integer hp = playerItem.use().get(0);
            System.out.println("Increase Hp " + hp);
            Integer attack = playerItem.use().get(1);
            System.out.println("Increase attack " + attack);
            player.updateHP(hp);
            player.updateAttackMonster(attack);
            System.out.println("That "+ arg + "  is already eaten by you");
            player.getInventory().dropItem(arg);

        }
        else {
            System.out.println("no such item in your inventory");
        }



    }

    @Override
    public String getDescription() {
        return "Command to eat items in your inventory -[Key, Potion]" ;
    }
}
