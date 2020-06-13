package io.muzoo.ooc.Zork.Map;

import sun.net.util.IPAddressUtil;

import java.lang.reflect.Array;
import java.util.*;

public class CreateMap {
    private String id;
    private String[][] asciiMap;
    private Map<String,Room> roomMap;
    private int[] numLayer;
    private int[] startIndex;
    private Set<String> visited;
    private Set<String> frontiers;
    private String startingPoint;
    private HashMap<String,int[]> keep;
    public CreateMap(int[] numLayer, int[] startIndex, Map<String, Room> roomMap,String id) {
        this.id = id;
        this.roomMap = roomMap;
        this.numLayer = numLayer;
        this.startIndex = startIndex;
        asciiMap = new String[numLayer[0]][numLayer[1]];
        startingPoint = "Home";
        keep = new HashMap<>();
    }

    public void setAsciiMap() {
        frontiers = new HashSet<>(Arrays.asList(startingPoint));
        visited = new HashSet<>(Arrays.asList(startingPoint));
        keep.put(startingPoint,startIndex);
        while (!frontiers.isEmpty()){
            frontiers = nbrs(frontiers);
            frontiers.removeAll(visited);
            visited.addAll(frontiers);
        }

    }

    public Set<String> nbrs(Set<String> frontiers) {
        Set<String> union = new HashSet<>();
        for (String room:frontiers){
            int row = keep.get(room)[0];
            int column = keep.get(room)[1];
            Room rm = roomMap.get(room);
            String east = rm.getEast();
            String north = rm.getNorth();
            String south = rm.getSouth();
            String west = rm.getWest();
            if (!east.equals("Corner")){
                asciiMap[row][column + 1] = east;
                int[] index = new int[2];
                index[0] = row;
                index[1] = column+1;
                keep.put(east,index);
                if (!east.equals("Block")){
                    union.add(east);
                }
            }
            if (!north.equals("Corner")){
                asciiMap[row-1][column] = north;
                int[] index = new int[2];
                index[0] = row-1;
                index[1] = column;
                keep.put(north,index);
                if (!north.equals("Block")){
                    union.add(north);
                }
            }
            if (!south.equals("Corner")){
                asciiMap[row+1][column] = south;
                int[] index = new int[2];
                index[0] = row+1;
                index[1] = column;
                keep.put(south,index);
                if (!south.equals("Block")){
                    union.add(south);
                }
            }
            if (!west.equals("Corner")){
                asciiMap[row][column-1] = west;
                int[] index = new int[2];
                index[0] = row;
                index[1] = column-1;
                keep.put(west,index);
                if (!west.equals("Block")){
                    union.add(west);
                }
            }
        }

        return union;

    }

    public void getAsciiMap() {
        setAsciiMap();
        for (String[] str:asciiMap) {
            String line = "";
            for (String s:str) {
                line = line + s + "|";
            }
            System.out.println(line);

        }
    }




    public static void main(String[] args) {
        ReadFile rf = new ReadFile("/Users/phang/Desktop/Zork/src/main/resources/room1.txt");
        rf.setRoomHashMap();
        CreateMap cm = new CreateMap(rf.getNumLayer(),rf.getStartIndex(),rf.getRoomHashMap(),rf.getId());
        cm.getAsciiMap();
    }
}
