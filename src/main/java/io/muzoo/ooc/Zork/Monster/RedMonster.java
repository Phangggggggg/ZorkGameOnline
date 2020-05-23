package io.muzoo.ooc.Zork.Monster;

public class RedMonster {
    private int HP;
    private int maxHP;
    private int attackPlayer;
    private boolean alive;

    public RedMonster(){
        maxHP = 100;
        HP = 100;
        attackPlayer = 50;
        alive = true;

    }

    public RedMonster(int HP, int maxHP, int attackMonster, boolean alive) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.attackPlayer = attackMonster;
        this.alive = alive;
    }

    public int getHP() {
        return HP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttackMonster() {
        return attackPlayer;
    }

    public boolean isAlive() {
        return alive;
    }

    public void increasePower(){
        if (HP == maxHP){
            maxHP+=5;
            HP+=5;
        }
        else {
            HP+=5;
        }
        attackPlayer+=2;
    }
}
