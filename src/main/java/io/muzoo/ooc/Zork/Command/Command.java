package io.muzoo.ooc.Zork.Command;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {

    void execute(String arg) throws IOException;

    String getDescription();

}
