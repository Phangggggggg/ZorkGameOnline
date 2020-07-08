package io.muzoo.ooc.Zork.JsonForSave;

import com.sun.tools.example.debug.tty.LineNotFoundException;
import io.muzoo.ooc.Zork.Game.Simulation;
import io.muzoo.ooc.Zork.Item.Inventory;
import io.muzoo.ooc.Zork.Monster.BlueMonster;
import io.muzoo.ooc.Zork.Monster.GoldMonster;
import io.muzoo.ooc.Zork.Monster.Monster;
import io.muzoo.ooc.Zork.Monster.RedMonster;
import io.muzoo.ooc.Zork.Player.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class JsonReader {
    private Simulation simulation;
    private JSONArray jsonArray;

    public JsonReader(Simulation simulation) {
        this.simulation = simulation;
    }
    public void readFile(String fileName){
        String path = "/Users/phang/Desktop/Zork/src/main/resources/"+fileName+".json";
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(path)){
            Object obj = jsonParser.parse(fileReader);
            jsonArray = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void loadFile(String fileName){
        readFile(fileName);
        JSONObject mapForMap = (JSONObject)jsonArray.get(0);
        JSONObject mapForMonster = (JSONObject)jsonArray.get(3);
        String idMap = (String) mapForMap.get("map");
        if (idMap.contains("1")){
            simulation.constructMap("room1",false); // create map successful
        }else if (idMap.contains("2")){
            simulation.constructMap("room2",false);
        }
        JSONObject mapForRemovedItem = (JSONObject) jsonArray.get(4);
        JSONObject mapForRemovedMonster = (JSONObject) jsonArray.get(5);
        Set setMapRemovedItem = (Set) mapForRemovedItem.keySet();
        Set setMapRemovedeMosnter = (Set) mapForRemovedMonster.keySet();



        for (String room : simulation.getRoomMap().keySet()){
            if (simulation.getRoomMap().get(room).HasMonster()){
                if (simulation.getRoomMap().get(room).getMonster().getName().equals("Gold Monster")
                        && mapForRemovedMonster.containsKey("Gold Monster")){
                    Monster goldMonster = new GoldMonster(Math.toIntExact((Long) mapForMonster.get("Gold Monster")));
                    simulation.getRoomMap().get(room).generateMonster(goldMonster);
                }
                else if (simulation.getRoomMap().get(room).getMonster().getName().equals("Blue Monster")
                        && mapForRemovedMonster.containsKey("Blue Monster")){
                    System.out.println(Math.toIntExact((Long) mapForMonster.get("Blue Monster")));
                    Monster blueMonster = new BlueMonster(Math.toIntExact((Long) mapForMonster.get("Blue Monster")));
                    simulation.getRoomMap().get(room).generateMonster(blueMonster);
                }
                else if (simulation.getRoomMap().get(room).getMonster().getName().equals("Red Monster")
                        && mapForRemovedMonster.containsKey("Red Monster")){
                    Monster redMonster = new RedMonster(Math.toIntExact((Long) mapForMonster.get("Red Monster")));
                    simulation.getRoomMap().get(room).generateMonster(redMonster);
                }

            }

        }

        for (Object room: setMapRemovedItem) {
            if (simulation.getRoomMap().containsKey((String) room)){
                simulation.getRoomMap().get(room).takeOut();
            }
        }

        for (Object room: setMapRemovedeMosnter) {
            if (simulation.getRoomMap().containsKey(room)){
                simulation.getRoomMap().get(room).removeMonster();
            }
        }
        JSONObject mapForPlayer = (JSONObject)jsonArray.get(1);
        JSONObject mapForInventory = (JSONObject)jsonArray.get(2);
        Player player = new Player(Math.toIntExact((Long) mapForPlayer.get("playerHp")),
                Math.toIntExact((Long) mapForPlayer.get("playerMaxHp")),
                Math.toIntExact((Long) mapForPlayer.get("playerAttack")),
                        simulation.getRoomMap().get((String) mapForPlayer.get("playerLocation")));
        simulation.setPlayer(player);

        Inventory playerInventory = new Inventory();
        for (Object item: mapForInventory.keySet()) {
            playerInventory.takeItem((String) item);
        }
        simulation.getPlayer().setInventory(playerInventory);
        simulation.setUseLoad(true);


        }









    }






