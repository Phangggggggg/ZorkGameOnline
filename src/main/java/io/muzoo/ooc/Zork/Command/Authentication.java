package io.muzoo.ooc.Zork.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, ArrayList<String>> limitCommand;

    public Authentication(){
        limitCommand = new HashMap<>();
    }

    public void setLimitCommand(){
       ArrayList<String> mainMenu = new ArrayList<>();
       ArrayList<String> game = new ArrayList<>();
       ArrayList<String> attackMonster = new ArrayList<>();
       mainMenu.add("play");
       mainMenu.add("load");
       mainMenu.add("quit");
       mainMenu.add("help");
       game.add("exit");
       game.add("quit");
       game.add("map");
       game.add("take");
       game.add("drop");
       game.add("eat");
       game.add("info");
       game.add("go");
       game.add("initiateBattle");
       attackMonster.add("attack");
       attackMonster.add("take");
       attackMonster.add("drop");
       attackMonster.add("eat");
       attackMonster.add("info");
       attackMonster.add("map");
       attackMonster.add("quit");
       attackMonster.add("help");
       attackMonster.add("initiateBattle");
       attackMonster.add("escape");
       limitCommand.put("MainMenu",mainMenu);
       limitCommand.put("Game",game);
       limitCommand.put("AttackMonster",attackMonster);
    }


    public Map<String, ArrayList<String>> getLimitCommand() {
        setLimitCommand();
        return limitCommand;
    }

    public static void main(String[] args) {
        Authentication au = new Authentication();
        System.out.println(au.getLimitCommand());
    }


}
