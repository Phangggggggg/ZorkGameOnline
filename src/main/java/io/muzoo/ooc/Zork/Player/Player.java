package io.muzoo.ooc.Zork.Player;

import io.muzoo.ooc.Zork.Item.Inventory;
import io.muzoo.ooc.Zork.Map.Room;

public class Player {
    private int HP;
    private int maxHP;
    private int attackMonster;
    private Room currentRoom;
    private Inventory inventory;

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

    public String getCurrentRoom() {
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

    public void updateHP(int newHP) {
        this.HP = newHP;
    }

    public void updateAttackMonster(int newAttack) {
        this.attackMonster = newAttack;
    }

    public Room getLocation(){
        return currentRoom;
    }

    public void updateLocation(Room newRoom){
        this.currentRoom = newRoom;
    }


}
