package io.muzoo.ooc.Zork.Monster;

public class BlueMonster {
    private int HP;
    private int maxHP;
    private int attackPlayer;
    private boolean alive;
    private int finalAttack;
    public BlueMonster() {
        HP = 200;
        maxHP = 200;
        attackPlayer = 75;
        alive = true;
    }

    public BlueMonster(int HP, int maxHP, int attackPlayer, boolean alive) {
        this.HP = HP;
        this.maxHP = maxHP;
        this.attackPlayer = attackPlayer;
        this.alive = alive;
    }

    public int getHP() {
        return HP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getAttackPlayer() {
        return attackPlayer;
    }

    public boolean isAlive() {
        return alive;
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

    public int getFinalAttack() {
        return finalAttack;
    }

    public void increasePower(){
        if (HP == maxHP){
            maxHP+=6;
            HP+=6;
        }
        else {
            HP+=3;
        }
        attackPlayer+=3;
    }
}
