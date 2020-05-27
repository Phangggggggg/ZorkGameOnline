package io.muzoo.ooc.Zork.Monster;

public class GoldMonster {
    private int HP;
    private int maxHP;
    private int attackPlayer;
    private boolean alive;
    private int finalAttack;
    private String location;

    public GoldMonster() {
        HP = 350;
        maxHP = 350;
        attackPlayer = 80;
        alive = true;
    }

    public GoldMonster(int HP, int maxHP, int attackPlayer, boolean alive) {
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

    public void increasePower(){
        if (HP == maxHP){
            maxHP+=4;
            HP+=4;
        }
        else {
            HP+=4;
        }
        attackPlayer+=8;
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


}
