package io.muzoo.ooc.Zork.Player;

public class Player {
    private int HP;
    private int maxHP;
    private int attackMonster;
    private boolean alive;

    public Player() {
        maxHP = 180;
        HP = 180;
        attackMonster = 60;
        alive = true;
    }

    public Player(int HP, int maxHP, int attackMonster, boolean alive) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.attackMonster = attackMonster;
        this.alive = alive;
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
