package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

public class InitiateBattle implements Command{
    private CommandFactory cmdFactory;
    private Player player;

    public InitiateBattle(CommandFactory cmdFactory, Player player) {
        this.cmdFactory = cmdFactory;
        this.player = player;
    }

    @Override
    public void execute(String arg) {
        if (player.getCurrentRoom().HasMonster()){
            Monster monster = player.getCurrentRoom().getMonster();
            CommandFactory.commandMap.put("attack",new AttackCommand(player,monster));
            MonsterAttack battle = new MonsterAttack(player,monster,cmdFactory);
            battle.fighting();
        }
        else {
            System.out.println("There is no monster in this room");
        }


    }

    @Override
    public String getDescription() {
        return "you can initiate the battle with Monster";
    }
}
