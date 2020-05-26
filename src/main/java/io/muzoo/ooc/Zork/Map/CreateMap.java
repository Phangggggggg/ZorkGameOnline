package io.muzoo.ooc.Zork.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class CreateMap {
    private String fileName;
    private ArrayList<String> asciiMap = new ArrayList<>();
    private Map<String,Room> roomMap = new HashMap<>();
    public CreateMap(String fileName){
        this.fileName = fileName;
        ReadFile rf = new ReadFile(fileName);
        roomMap = rf.getRoomHashMap();
    }

    public void BFS(){
        ArrayList<String> visited = new ArrayList<>();





    }

    public void swapLayer(String room){

    }



    public void setAsciiMap(){
        String cave = "+";
        String town = "t";
        String cliff = "-";
        String forest = "#";
        String mountain = "@";
        String block = "x";
//        for (Map.Entry me: roomMap.entrySet()) {
//
//
//
//
//
//        }
    }



}
