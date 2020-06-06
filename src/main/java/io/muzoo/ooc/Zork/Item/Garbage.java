package io.muzoo.ooc.Zork.Item;

import java.util.ArrayList;

public class Garbage extends Item {
    public Garbage() {
        super(0,0);
        itemName = "Garbage";
        description = "This is Garbage";
    }

    @Override
    public ArrayList<Integer> use() {
        ArrayList<Integer> reward = new ArrayList<>();
        reward.add(increaseHP);
        reward.add(increaseAttack);
        return reward;
    }
}
