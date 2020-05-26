package io.muzoo.ooc.Zork.Item;

import io.muzoo.ooc.Zork.Player.Player;

public class Key extends Item{
    private String goldMonsterLocation;


    public Key() {
        super("The key that unlock Gold Monster", 50, 50, "Key");
        goldMonsterLocation = "Mysterious cave I";
    }

    public Key(String description, int increaseHP, int increaseAttack, String goldMonsterLocation) {
        super(description, increaseHP, increaseAttack,"Key");
        this.goldMonsterLocation = goldMonsterLocation;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void increasePlayerPower(Player player) {
        player.addHP(increaseHP);
        player.addAttack(increaseAttack);
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    public String getGoldMonsterLocation() {
        return goldMonsterLocation;
    }


}
