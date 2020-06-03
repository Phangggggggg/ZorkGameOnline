package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Map.Room;

import java.util.HashMap;

public class Key extends Item {
    public Key() {
        super(20, 30);
    }

    public Key(int increaseHP, int increaseAttack) {
        super(increaseHP, increaseAttack);
        itemName = "Key";
        description = "The Key";
    }




}
