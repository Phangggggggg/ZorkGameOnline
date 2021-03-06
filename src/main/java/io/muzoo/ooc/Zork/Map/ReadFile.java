package io.muzoo.ooc.Zork.Map;

import io.muzoo.ooc.Zork.Item.Garbage;
import io.muzoo.ooc.Zork.Item.Key;
import io.muzoo.ooc.Zork.Item.Potion;
import io.muzoo.ooc.Zork.Monster.BlueMonster;
import io.muzoo.ooc.Zork.Monster.GoldMonster;
import io.muzoo.ooc.Zork.Monster.RedMonster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile{
    private String fileName;
    private HashMap<String, Room> roomHashMap = new HashMap<>();
    private int[] numLayer = new int[2];
    private int[] startIndex = new  int[2];
    private String id;
    private List<String> monsterItem = new ArrayList<>();


    public ReadFile(String fileName) {

        this.fileName = fileName;
    }

    public int[] getNumLayer() {
        return numLayer;
    }

    public int[] getStartIndex() {
        return startIndex;
    }

    public void setRoomHashMap() {
        try {
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            id = bufferedReader.readLine(); // this will read the first line
            String line1 = null;
            while ((line1 = bufferedReader.readLine()) != null) {
                String room = line1.split(":")[0].trim();
                String nd = line1.split(":")[1].trim();
                String[] neighboursList = nd.split(",");
                if (room.equals("RowColumn")){
                    numLayer[0] = Integer.parseInt(neighboursList[0].trim());// row of map
                    numLayer[1] = Integer.parseInt(neighboursList[1].trim());// column of map
                }
                else if (room.equals("StartIndex")){
                    startIndex[0] = Integer.parseInt(neighboursList[0].trim());//start index row
                    startIndex[1] = Integer.parseInt(neighboursList[1].trim()); //start index column

                }
                else{
                    Room roomObj = new Room(room,neighboursList[neighboursList.length-1].trim(),
                            Arrays.asList(Arrays.copyOf(neighboursList,neighboursList.length-1)));
                    if (room.equals("Mysterious Cave I")){
                        roomObj.generateMonster(new BlueMonster());
                        monsterItem.add(room);
                    }
                    if (room.equals("Mysterious Cave II")){
                        roomObj.generateMonster(new GoldMonster());
                        monsterItem.add(room);
                    }
                    if (room.equals("Mysterious Cave III")){
                        roomObj.generateMonster(new RedMonster());
                        monsterItem.add(room);
                    }
                    if(room.equals("Orge Cave I")){
                        roomObj.generateItem(new Key());
                        monsterItem.add(room);
                    }
                    if (room.equals("Orge Cave II")){
                        roomObj.generateItem(new Potion());
                        monsterItem.add(room);
                    }
                    roomHashMap.put(room,roomObj);
                }


            }


        } catch (IOException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }

    }
//    public static int generateRandomIntIntRange(int min, int max) {
//        Random r = new Random();
//        return r.nextInt((max - min) + 1) + min;
//    }

    public void addItemInRoom(int itemNum) {
        setRoomHashMap();
        Set<Object> repeat = new HashSet<>();
        for (int i = 0; i < itemNum; i++) {
            Object randomName = roomHashMap.keySet().toArray()[new Random().nextInt(roomHashMap.keySet().toArray().length)];
            if (!randomName.equals("Home") && !monsterItem.contains(randomName)) {
                repeat.add(randomName);
            }
        }
        for (Object obj: repeat) {
            roomHashMap.get(obj).generateItem(new Garbage());
        }


    }




    public HashMap<String, Room> getRoomHashMap()
    {
        addItemInRoom(8);
        return roomHashMap;
    }

    public void getAsciiMap(){
        CreateMap cm = new CreateMap(numLayer,startIndex,roomHashMap,id);
        cm.getAsciiMap();
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        ReadFile rf = new ReadFile("/Users/phang/Desktop/Zork/src/main/resources/room1.txt");
        HashMap<String, Room> map = rf.getRoomHashMap();
        rf.getAsciiMap();


    }
}
