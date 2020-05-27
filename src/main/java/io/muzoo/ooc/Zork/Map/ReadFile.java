package io.muzoo.ooc.Zork.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
    private String fileName;
    private HashMap<String, Room> roomHashMap = new HashMap<>();
    private int[] numLayer = new int[2];
    private int[] startIndex = new  int[2];
    private String id;




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
                    Room roomObj = new Room(neighboursList[neighboursList.length-1].trim(),
                            Arrays.asList(Arrays.copyOf(neighboursList,neighboursList.length-1)));
                    roomHashMap.put(room,roomObj);
                }


            }


        } catch (IOException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }

    }

    public HashMap<String, Room> getRoomHashMap() {
        return roomHashMap;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        ReadFile rf = new ReadFile("/Users/phang/Desktop/Zork/src/main/resources/room2.txt");
        rf.setRoomHashMap();
        HashMap<String, Room> map = rf.getRoomHashMap();
        System.out.println(map.size());


    }
}
