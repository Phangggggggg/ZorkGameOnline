package io.muzoo.ooc.Zork.Command;

public class EscapeCommand implements Command {
    private MonsterAttack monsterAttack;

    public EscapeCommand(MonsterAttack monsterAttack) {
        this.monsterAttack = monsterAttack;
    }

    @Override
    public void execute(String arg) {
        monsterAttack.setEscape(true);
    }

    @Override
    public String getDescription() {
        return "This is the command for you to escape from monster";
    }
}
