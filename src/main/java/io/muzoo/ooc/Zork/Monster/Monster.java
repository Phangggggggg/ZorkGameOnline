package io.muzoo.ooc.Zork.Monster;

import java.util.Map;

public abstract class Monster {

    protected int hp;
    protected int maxHP;
    protected int maxAttack;
    protected int attack;
    protected String description;
    protected String name;



    public Monster(int hp, int maxHP, int maxAttack, int attack) {
        this.hp = hp;
        this.maxHP = maxHP;
        this.maxAttack = maxAttack;
        this.attack = attack;
    }

    abstract public int attackPlayer();
    abstract public void increasePower();

    public int getHp() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public int getAttack() {
        return attack;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
    public void updateHP(int newHP) {
        hp = hp + newHP;
    }




}
