package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

public class AttackCommand implements Command{

    private Player player;
    private Monster monster;
    private String description;

    public AttackCommand(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        description = "It is your turn to fight";
    }

    @Override
    public void execute(String arg) {
        System.out.println(description);
        monster.updateHP(monster.getHp() - player.getAttackMonster());
    }

    @Override
    public String getDescription() {
        return description;
    }
}
