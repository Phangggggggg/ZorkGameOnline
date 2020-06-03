package io.muzoo.ooc.Zork.Monster;

public class RedMonster {
    private int HP;
    private int maxHP;
    private int attackPlayer;
    private boolean alive;
    private int finalAttack;
    private String location;

    public RedMonster(){
        maxHP = 100;
        HP = 100;
        attackPlayer = 50;
        alive = true;
        location = "Mysterious Cave III";
    }

    public RedMonster(int HP, int maxHP, int attackMonster, boolean alive) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.attackPlayer = attackMonster;
        this.alive = alive;
        location = "Mysterious Cave III";
    }

    public int getHP() {
        return HP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int setFinalAttack(){
        double rand = Math.random();
        if (rand <= 0.2){
            finalAttack = 0;
        }
        else if (rand <= 0.5){
            finalAttack = attackPlayer - attackPlayer/2;
        }
        else if (rand <= 0.8){
            finalAttack = attackPlayer;
        }
        return finalAttack;
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
