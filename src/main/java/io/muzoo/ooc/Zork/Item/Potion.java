package io.muzoo.ooc.Zork.Item;

import java.util.ArrayList;

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

    @Override
    public ArrayList<Integer> use() {
        ArrayList<Integer> reward = new ArrayList<>();
        reward.add(increaseHP); // first elt is hp
        reward.add(increaseAttack); // first elt is attack
        return reward;
    }
}
