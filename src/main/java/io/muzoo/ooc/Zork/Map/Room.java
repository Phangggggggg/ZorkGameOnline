package io.muzoo.ooc.Zork.Map;

import io.muzoo.ooc.Zork.Item.Item;
import io.muzoo.ooc.Zork.Monster.Monster;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String description;
    private List<String> adjacentRooms = new ArrayList<>();
    private boolean hasMonster;
    private boolean hasItem;
    private Monster monster;
    private Item item;


    public Room(String description, List<String> adjacentRooms) {
        this.description = description;
        this.adjacentRooms = adjacentRooms;
        hasItem = false;
        hasMonster = false;
    }

    public boolean HasMonster() {
        return hasMonster;
    }

    public boolean HasItem() {
        return hasItem;
    }

    public Monster getMonster() {
        return monster;
    }

    public Item getItem() {
        return item;
    }

    public void generateMonster(Monster monster){
        this.monster = monster;
        hasMonster = true;
    }

    public void generateItem(Item item){
        this.item = item;
        hasItem = true;
    }




    public String getDescription() {
        return description;
    }

    public List<String> getAdjacentRooms() {
        return adjacentRooms;
    }

    public String getNorth() {
        return adjacentRooms.get(0);
    }

    public String getEast() {
        return adjacentRooms.get(2);
    }

    public String getSouth() {
        return adjacentRooms.get(3);
    }

    public String getWest() {
        return adjacentRooms.get(1);
    }
}
