package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Player.Player;

public class Bomb extends Item{
//    private String description;
//    private int increaseHP;
//    private int increaseAttack ;

    public Bomb() {
        super( "Special item for you. This is Bomb that increase 80 of your attack",0,
                80,"Bomb");
//        description = "Special item for you. This is Bomb that increase 80 of your attack";
//        increaseHP = 0;
//        increaseAttack = 80;
    }

    @Override
    public String getDescription() {
        return description;

    }

    @Override
    public void increasePlayerPower(Player player) {
        player.addAttack(increaseAttack);
        player.addHP(increaseHP);
//        System.out.println(player.getAttackMonster());
    }

    @Override
    public String getItemName() {
        return itemName;
    }



}
