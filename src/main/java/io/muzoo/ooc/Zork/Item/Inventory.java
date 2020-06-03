package io.muzoo.ooc.Zork.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> playerInventory;
    private String description;

    public Inventory() {
        playerInventory = new ArrayList<>();
        description = "This is player Inventory";
    }

    public String getDescription() {
        return description;
    }

    public Inventory(ArrayList<Item> playerInventory) {
        this.playerInventory = playerInventory;
        description = "This is player Inventory";
    }
    public void takeItem(Item item){
        playerInventory.add(item);
        System.out.println(item.getItemName() + "is already in your inventory");
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public void dropItem(Item item){
        if (!playerInventory.isEmpty()){
            playerInventory.remove(item);
        }
        else {
            System.out.println("There is nothing in your inventory");
        }
    }




}
