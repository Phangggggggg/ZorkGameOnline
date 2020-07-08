package io.muzoo.ooc.Zork.Player;

import io.muzoo.ooc.Zork.Item.Inventory;
import io.muzoo.ooc.Zork.Map.Room;

import java.util.List;

public class Player {
    private int HP;
    private int maxHP;
    private int attackMonster;
    private Room currentRoom;
    private Inventory inventory;
    private List<String> adjacentRoom;
    private Room twoBack;

    public Player() {
        maxHP = 200;
        HP = 200;
        attackMonster = 70;
        inventory = new Inventory();
    }

    public Player(int HP, int maxHP, int attackMonster,Room currentRoom) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.attackMonster = attackMonster;
        this.currentRoom = currentRoom;
    }
    public void setInventory(Inventory inv){
        inventory = inv;

    }

    public List<String> getAdjacentRoom() {
        return currentRoom.getAdjacentRooms();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public String getStringCurrentRoom(){
        return currentRoom.getRoomName();
    }



    public int getHP() {
        return HP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttackMonster() {
        return attackMonster;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public List<String> displayInventory(){
        return inventory.getPlayerInventory();
    }

    public void updateHP(int newHP) {
        if (HP < maxHP){
            HP = HP + newHP;
        }
        else {
            maxHP = maxHP + newHP;
            HP = HP + newHP;
        }


    }

    public void updateAttackMonster(int newAttack) {
        attackMonster += newAttack;
    }

    public Room getLocation(){
        return currentRoom;
    }

    public void updateLocation(Room newRoom){
        this.currentRoom = newRoom;
    }


}
