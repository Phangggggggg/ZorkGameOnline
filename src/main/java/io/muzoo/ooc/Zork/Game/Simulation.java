package io.muzoo.ooc.Zork.Game;

import io.muzoo.ooc.Zork.Command.*;
import io.muzoo.ooc.Zork.Map.ReadFile;
import io.muzoo.ooc.Zork.Map.Room;
import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Player.Player;
import java.util.*;

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
    private Room startRoom;


    public Simulation(CommandFactory commandFactory) {
        exit = new ArrayList<>();
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
        roomMap = readFile.getRoomHashMap();
        startRoom = roomMap.get("Home");
        mapId = readFile.getId();
        commandFactory.getCommandMap().put("map",new MapCommand(readFile));
        exit.set(0,bool); // has map
    }

    public Room getStartRoom() {
        return startRoom;
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

    public Authentication getAuthentication() {
        return authentication;
    }



    public boolean isQuit() {
        return quit;
    }

    public List<Boolean> getExit() {
        return exit;
    }

    public CommandFactory getCommandFactory() {
        return commandFactory;
    }

    public Parser getParser() {
        return parser;
    }

    public SplitCommand getCommand() {
        return command;
    }

    public ReadFile getReadFile() {
        return readFile;
    }

    public String getMapId() {
        return mapId;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Room> getRoomMap() {
        return roomMap;
    }



    public void checkGameFinish(){
        Room currentRoom = player.getCurrentRoom();
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

    public Player getPlayer() {
        return player;
    }

    public void setExit(int index, boolean bool) {  // set clear game
        exit.set(index,bool);
    }

    public void play(){
        System.out.println("Welcome to Zork!");
        while (!quit){
            command.getCommand(commandFactory,parser,"MainMenu",authentication.getLimitCommand());
            while (!exit.contains(true)){
                command.getCommand(commandFactory,parser,"Game",authentication.getLimitCommand());
                checkGameFinish();
                upgradeMonsterPower();
                player.updateHP(3);// update hp of player
                if (player.getHP() <= 0){
                    System.out.println("You lost");
                    exit.set(1,true);
                }
            }

        }
    }
}
