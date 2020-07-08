package io.muzoo.ooc.Zork.JsonForSave;

import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.Monster.Monster;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    private Simulation simulation;

    public JsonWriter(Simulation simulation) {
        this.simulation = simulation;
    }



    public void writeSave(String fileName){
        // keep map details where {map:map_id}
        JSONObject forMap = new JSONObject();
        forMap.put("map",simulation.getMapId());
        // keep player details
        JSONObject forPlayer = new JSONObject();
        forPlayer.put("playerHp",simulation.getPlayer().getHP());
        forPlayer.put("playerMaxHp",simulation.getPlayer().getMaxHP());
        forPlayer.put("playerAttack",simulation.getPlayer().getAttackMonster());
        forPlayer.put("playerLocation",simulation.getPlayer().getCurrentRoom().getRoomName());
        // keep inventory details
        JSONObject forInventory = new JSONObject();
        for (String items:simulation.getPlayer().getInventory().getPlayerInventory()){
            forInventory.put(items,"x");

        }
        // keep removed Item details
        JSONObject forRemovedItems = new JSONObject();

        JSONObject forRemovedMonster = new JSONObject();

        // keep monster details
        JSONObject forMonster = new JSONObject();
        for (String room: simulation.getRoomMap().keySet()) {
            if (simulation.getRoomMap().get(room).HasMonster()){
                String monsterName = simulation.getRoomMap().get(room).getMonster().getName();
                int countUpgrade = simulation.getRoomMap().get(room).getMonster().getCountUpgrade();
                forMonster.put(monsterName,countUpgrade);
            }
            if (simulation.getRoomMap().get(room).getMonster() == null){
                if (room.equals("Mysterious Cave I")) {
                    forRemovedMonster.put(room,"removedMonster");
                }
                else if (room.equals("Mysterious Cave II")){
                    forRemovedMonster.put(room,"removedMonster");
                }
                else if (room.equals("Mysterious Cave III")){
                    forRemovedMonster.put(room,"removedMonster");
                }
            }
            if (simulation.getRoomMap().get(room).getItem() == null){
                if (room.equals("Orge Cave I") || room.equals("Orge Cave IT")){
                    forRemovedItems.put(room,"removedItem");
                }

            }
        }
        JSONArray main =new JSONArray();
        main.add(forMap);
        main.add(forPlayer);
        main.add(forInventory);
        main.add(forMonster);
        main.add(forRemovedItems);
        main.add(forRemovedMonster);
        try(FileWriter fileWriter = new FileWriter("/Users/phang/Desktop/Zork/src/main/resources/"+fileName+".json")) {
            fileWriter.write(main.toJSONString());
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
