package io.muzoo.ooc.Zork.Game;

import io.muzoo.ooc.Zork.Command.CommandFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandFactory commandFactory = new CommandFactory();
        Game game = new Game(commandFactory);
        game.play();
    }
}
