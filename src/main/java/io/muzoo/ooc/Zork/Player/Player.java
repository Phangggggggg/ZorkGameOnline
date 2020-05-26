package io.muzoo.ooc.Zork.Player;

public class Player {
    private int HP;
    private int maxHP;
    private int attackMonster;
    private boolean alive;
    private String currentRoom;

    public Player() {
        maxHP = 180;
        HP = 180;
        attackMonster = 60;
        alive = true;
        currentRoom = "Home";
    }

    public Player(int HP, int maxHP, int attackMonster, boolean alive, String currentRoom) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.attackMonster = attackMonster;
        this.alive = alive;
        this.currentRoom = currentRoom;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addAttack(int attack){
        attackMonster += attack;
    }

    public void addHP(int hp){
        if (maxHP != HP){
            HP += hp;
        }
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

    public boolean isAlive() {
        return alive;
    }

    public void increasePower(){
        if (maxHP != HP){
            HP =+ 10;
        }
        attackMonster+= 3;
    }
}
