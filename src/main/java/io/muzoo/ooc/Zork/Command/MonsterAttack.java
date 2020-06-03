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

    public MonsterAttack(Player player, Monster monster, CommandFactory commandFactory) {
        this.player = player;
        this.monster = monster;
        this.commandFactory = commandFactory;
        parser = new Parser();
        cmd = new SplitCommand();
    }
}
