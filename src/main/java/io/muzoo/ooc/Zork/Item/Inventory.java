package io.muzoo.ooc.Zork.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private HashMap<String,Item> playerInventory = new HashMap<>();
    private HashMap<String,Item> allItem = new HashMap<>();

    public Inventory() {
        Item bomb = new Bomb();
        Item key = new Key();
        Item potion = new Potion();
        allItem.put(bomb.getItemName(),bomb);
        allItem.put(key.getItemName(),key);
        allItem.put(potion.getItemName(),potion);

    }

    public void addItem(String itemName){
        if(!playerInventory.containsKey(itemName)){
            playerInventory.put(itemName,allItem.get(itemName));
        }
    }

    public void dropItem(String itemName){
        playerInventory.remove(itemName);
    }

    public HashMap<String, Item> getPlayerInventory() {
        return playerInventory;
    }

}
