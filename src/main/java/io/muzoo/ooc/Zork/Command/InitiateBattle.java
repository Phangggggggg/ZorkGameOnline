package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

import java.io.IOException;

public class InitiateBattle implements Command{
    private CommandFactory cmdFactory;
    private Player player;
    private Authentication authentication;

    public InitiateBattle(CommandFactory cmdFactory, Player player, Authentication authentication) {
        this.cmdFactory = cmdFactory;
        this.player = player;
        this.authentication = authentication;
    }

    @Override
    public void execute(String arg) throws IOException {
        if (player.getCurrentRoom().HasMonster()){
            Monster monster = player.getCurrentRoom().getMonster();
            MonsterAttack battle = new MonsterAttack(player,monster,cmdFactory,authentication);
            cmdFactory.getCommandMap().put("attack",new AttackCommand(player,monster));
            cmdFactory.getCommandMap().put("escape",new EscapeCommand(battle));
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
