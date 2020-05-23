package io.muzoo.ooc.Zork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Map {
    String fileName;
    HashMap<String, Room> roomHashMap = new HashMap<>();

    public Map(String fileName) {
        this.fileName = fileName;
    }

    public void setRoomHashMap(HashMap<String, Room> roomHashMap) {
        try {
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine(); // this will read the first line
            String line1 = null;
            while ((line1 = bufferedReader.readLine()) != null) {
                String room = line1.split(":")[0].trim();
                String nd = line1.split(":")[1].trim();
                String[] neighboursList = nd.split(",");

                Room roomObj = new Room(neighboursList[neighboursList.length-1],
                        Arrays.asList(Arrays.copyOf(neighboursList,neighboursList.length-1)));
                roomHashMap.put(room,roomObj);

            }


        } catch (IOException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }

    }

    public HashMap<String, Room> getRoomHashMap() {
        return roomHashMap;
    }
}
