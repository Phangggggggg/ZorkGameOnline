package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Map.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Key extends Item {
    public Key() {
        super(20, 30);
        itemName = "Key";
        description = "The Key";
    }

    public Key(int increaseHP, int increaseAttack) {
        super(increaseHP, increaseAttack);
        itemName = "Key";
        description = "The Key increases attack and HP";
    }

    @Override
    public ArrayList<Integer> use() {
        ArrayList<Integer> reward = new ArrayList<>();
        reward.add(increaseHP); // first elt is hp
        reward.add(increaseAttack); // first elt is attack
        return reward ;
    }


}
