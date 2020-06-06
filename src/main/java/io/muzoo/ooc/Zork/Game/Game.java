package io.muzoo.ooc.Zork.Game;

import io.muzoo.ooc.Zork.Command.CommandFactory;
import io.muzoo.ooc.Zork.Command.Parser;
import io.muzoo.ooc.Zork.Command.SplitCommand;
import io.muzoo.ooc.Zork.Map.ReadFile;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Player.Player;

import java.io.IOException;
import java.util.Map;

public class Game {
    private CommandFactory cmdFactory;
    private Player player;
    private Parser parser;
    private Room currentRoom;
    private boolean existGame;
    private SplitCommand command;
    private ReadFile map;
    private boolean quit;


    public Game(CommandFactory cmdFactory) throws IOException {
        this.cmdFactory = cmdFactory;
        parser = new Parser();
        existGame = false;
        command = new SplitCommand();
        currentRoom = constructMap("/Users/phang/Desktop/Zork/src/main/resources/room2.txt").get("Home");
    }

    public Map<String, Room> constructMap(String path) throws IOException {
        map = new ReadFile(path);
        return map.getRoomHashMap();
    }

    public void setPlayer(Player player){
        this.player = player;
    }
    public void play() throws IOException {
        System.out.println("Welcome to Game");
        while (!existGame){
            setPlayer(new Player());
            player.updateLocation(currentRoom);
            CommandFactory.putInCommand(player, constructMap("/Users/phang/Desktop/Zork/src/main/resources/room2.txt"),cmdFactory);
            command.getCommand(cmdFactory,parser);
            if (player.getHP() <= 0){
                System.out.println("you are lost");
                quit = true;
            }
            if (quit || command.equals("quit")){
                break;
            }

        }
    }



}
