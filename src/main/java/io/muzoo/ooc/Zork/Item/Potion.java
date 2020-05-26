package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Player.Player;

public class Potion extends Item{

    public Potion() {
        super("The potion will increase your blood", 60, 0, "Potion");
    }

    public Potion(String description, int increaseHP, int increaseAttack) {
        super(description, increaseHP, increaseAttack,"Potion");
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void increasePlayerPower(Player player) {
        player.addHP(increaseHP);
        player.addAttack(increaseAttack);

    }

    @Override
    public String getItemName() {
        return itemName;
    }
}
