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
    private Boolean escape;


    public MonsterAttack(Player player, Monster monster, CommandFactory commandFactory, Authentication authentication) {
        this.player = player;
        this.monster = monster;
        this.commandFactory = commandFactory;
        parser = new Parser();
        cmd = new SplitCommand();
        this.authentication = authentication;
        escape = false;
    }

    public void setEscape(Boolean escape) {
        this.escape = true;
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
            System.out.println("< escape from Monster");
            cmd.getCommand(commandFactory,parser,"AttackMonster",authentication.getLimitCommand());
            if (escape){
                break;
            }
            if (monster.getName().equals("Gold Monster")){
                int playerCurrentHp = player.getHP() - monster.attackPlayer();
                System.out.println("Your current HP " + playerCurrentHp);
                player.updateHP(-playerCurrentHp);
            }
            else {
                int playerCurrentHp = player.getHP() - monster.attackPlayer();
                System.out.println("Your current HP " + playerCurrentHp);
                player.updateHP(-playerCurrentHp);
            }
        }
        System.out.println("out of attack Monster loop");

        }

    }

