package io.muzoo.ooc.Zork.Map;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class BFS {
    private Set<String> visited;
    private Set<String> frontiers;
    private String startingPoint;
    private Map<Integer, List<String>> arrangeMap = new HashMap<>();


    public BFS(Set<String> visited, Set<String> frontiers, String startingPoint,HashMap<String,Room> roomMap) {
        ReadFile room = new ReadFile("/Users/phang/Desktop/Zork/src/main/resources/rooms.txt");
        roomMap = room.getRoomHashMap();
        arrangeMap.put(1,new ArrayList<>());
        visited = new HashSet<>(Arrays.asList(startingPoint));
        frontiers = new HashSet<>(Arrays.asList(startingPoint));// one that has not visited
        while (!frontiers.isEmpty()){
            frontiers = nbrs(frontiers);
            frontiers.removeAll(visited);
            visited.addAll(frontiers);
        }

    }

    public void BFS(Set<String> visited, Set<String> frontiers, String startingPoint){

    }

    public Set<String> nbrs(Set<String> rooms){
        Set<String> union = new HashSet<>();
        for (String r: rooms) {
            if ()



        }

    }

//    public void setKeytoMap(int numLayer){
//        for (int i =1; i<numLayer+2; i++){
//            arrangeMap.put(i,new ArrayList<>());
//        }
//    }


}
