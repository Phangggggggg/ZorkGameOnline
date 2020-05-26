package io.muzoo.ooc.Zork.Command;

public class ExitCommand extends Command {
    ExitCommand(){

    }

    public void exitProgram() {
        System.exit(0);
    }

    @Override
    public Command getCommand() {

    }
}
