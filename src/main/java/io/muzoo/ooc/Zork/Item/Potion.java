package io.muzoo.ooc.Zork.Item;

public class Potion extends Item {
    public Potion() {
        super(30,30);
        itemName = "Potion";
        description = "The Potion";
    }

    public Potion(int increaseHP, int increaseAttack) {
        super(increaseHP, increaseAttack);
        itemName = "Potion";
        description = "The Potion";
    }
}
