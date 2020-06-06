package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Player.Player;

import java.util.ArrayList;

public abstract class Item {
    protected String description;
    protected int increaseHP;
    protected int increaseAttack;
    protected String itemName;


    public Item(int increaseHP, int increaseAttack) {
        this.increaseHP = increaseHP;
        this.increaseAttack = increaseAttack;
    }

    public String getDescription() {
        return description;
    }

    public int getIncreaseHP() {
        return increaseHP;
    }

    public int getIncreaseAttack() {
        return increaseAttack;
    }

    public String getItemName() {
        return itemName;
    }

    public abstract ArrayList<Integer> use();
}
