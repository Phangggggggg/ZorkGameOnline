package io.muzoo.ooc.Zork.Command;

public interface Command {

    void execute(String arg);

    String getDescription();

}
