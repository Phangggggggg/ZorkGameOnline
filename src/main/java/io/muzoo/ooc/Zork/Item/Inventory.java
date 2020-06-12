package io.muzoo.ooc.Zork.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private ArrayList<String> playerInventory;
    private Map<String,Item> itemMap = new HashMap<>();
    private String description;

    public Inventory() {
        playerInventory = new ArrayList<>();
        itemMap.put("Key",new Key());
        itemMap.put("Potion",new Potion());
        itemMap.put("Garbage", new Garbage());
        description = "This is player Inventory";
    }

    public String getDescription() {
        return description;
    }

    public Inventory(ArrayList<String> playerInventory) {
        this.playerInventory = playerInventory;
        description = "This is player Inventory";
    }
    public void takeItem(String item){
        playerInventory.add(item);
        System.out.println(item + " is already in your inventory");
    }

    public ArrayList<String> getPlayerInventory() {
        return playerInventory;
    }

    public void dropItem(String item){
        if (!playerInventory.isEmpty()){
            playerInventory.remove(item);
        }
        else {
            System.out.println("There is nothing in your inventory");
        }
    }

    public Item getThatItem(String item){
        if (!playerInventory.contains(item)){
            return null;
        }
        else {
            return itemMap.get(item);
        }

    }




}
