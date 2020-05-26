package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Player.Player;

public abstract class Item {
    protected String description;
    protected int increaseHP;
    protected int increaseAttack;
    protected String itemName;

    public Item(String description, int increaseHP, int increaseAttack, String itemName) {
        this.description = description;
        this.increaseHP = increaseHP;
        this.increaseAttack = increaseAttack;
        this.itemName = itemName;
    }

    public abstract String getDescription();
    public abstract void increasePlayerPower(Player player);
    public abstract String getItemName();

}
