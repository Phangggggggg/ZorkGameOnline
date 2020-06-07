package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

// monster attacks player
public class MonsterAttack {
    private Player player;
    private Monster monster;
    private Parser parser;
    private CommandFactory commandFactory;
    private SplitCommand cmd;
    private Authentication authentication;

    public MonsterAttack(Player player, Monster monster, CommandFactory commandFactory, Authentication authentication) {
        this.player = player;
        this.monster = monster;
        this.commandFactory = commandFactory;
        parser = new Parser();
        cmd = new SplitCommand();
        this.authentication = authentication;
    }

    public void fighting(){
        System.out.println(monster.getName() + " is come for your life");
        System.out.println(monster.getName()+ " has hp" + monster.getHp());
        System.out.println("Your hp is" + player.getHP());
        while (monster.getHp() > 0 && player.getHP() > 0){
            System.out.println("What would you do?");
            System.out.println("< attack");
            System.out.println("< eat key");
            System.out.println("< eat potion");
            cmd.getCommand(commandFactory,parser,"AttackMonster",authentication.getLimitCommand());
            if (monster.getName().equals("Gold Monster")){
                int playerCurrentHp = player.getHP() - monster.attackPlayer();
                System.out.println("Your current HP" + playerCurrentHp);
                player.updateHP(playerCurrentHp + 4);
            }
            else {
                int playerCurrentHp = player.getHP() - monster.attackPlayer();
                System.out.println("Your current HP" + playerCurrentHp);
                player.updateHP(playerCurrentHp + 3);
            }
        }

        }

    }

