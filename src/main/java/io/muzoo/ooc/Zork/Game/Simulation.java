package io.muzoo.ooc.Zork.Game;

import io.muzoo.ooc.Zork.Command.*;
import io.muzoo.ooc.Zork.Map.ReadFile;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulation {
    private Authentication authentication;
    private boolean quit;
    private List<Boolean> exit;
    private CommandFactory commandFactory;
    private Parser parser;
    private Player player;
    private SplitCommand command;
    private ReadFile readFile;
    private String mapId;

    private int count;
    private Map<String, Room> roomMap;


    public Simulation(CommandFactory commandFactory) {
        quit = false;
        this.commandFactory = commandFactory;
        parser = new Parser();
        command = new SplitCommand();
        authentication = new Authentication();
        exit.add(true);
        exit.add(false);
        count = 0;
    }
    public void constructMap(String filePath,boolean bool){
        String defaultPath =  "/Users/phang/Desktop/Zork/src/main/resources/";
        readFile = new ReadFile(defaultPath + filePath + ".txt");
        mapId = readFile.getId();
        roomMap = readFile.getRoomHashMap();
        exit.set(0,bool); // has map

    }

    public boolean isHasMap() {
        return exit.get(0);
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void upgradeMonsterPower(){
        for(Map.Entry<String, Room> nameRoom: roomMap.entrySet()) {
            Room room = nameRoom.getValue();
            if (room.HasMonster()) {
                Monster monster = room.getMonster();
                monster.increasePower();
            }
        }
    }





    public void checkGameFinish(){
        if (player.getCurrentRoom().HasMonster()){
            Monster monster = player.getCurrentRoom().getMonster();
            String nameMonster = monster.getName();
            if (nameMonster.equals("Red Monster") && monster.getHp() <= 0){
                count +=1;
            }
            if (nameMonster.equals("Gold Monster") && monster.getHp() <= 0){
                count +=1;
            }
            if (nameMonster.equals("Blue Monster") && monster.getHp() <=0){
                count+=1;
            }

        }
        if (count == 3){
            exit.set(1,true);
        }



    }
    public void setQuit(boolean bool){
        quit = bool;

    }

    public void play(){
        while (!quit){
            String cmd1 = parser.getCommand().split("/")[0];
            if (authentication.getLimitCommand().get("MainMenu").contains(cmd1)) {
                command.getCommand(commandFactory, parser);
        }
            else {
                System.out.println("This command is not available in Main Menu");
            }
            while (!exit.contains(true)){
                String c1 = parser.getCommand().split("/")[0];
                if (authentication.getLimitCommand().get("Game").contains(c1)){
                    command.getCommand(commandFactory,parser);
                }
                checkGameFinish();
                upgradeMonsterPower();
                player.updateHP(3);// update hp of player
            }
            if (player.getHP() <= 0){
                System.out.println("You lost");
                exit.set(1,true);
            }

        }
    }
}
