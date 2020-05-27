package io.muzoo.ooc.Zork.Map;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String description;
    private List<String> adjacentRooms = new ArrayList<>();
    private String north;
    private String east;
    private String south;
    private String west;


    public Room(String description, List<String> adjacentRooms) {
        this.description = description;
        this.adjacentRooms = adjacentRooms;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAdjacentRooms() {
        return adjacentRooms;
    }

    public String getNorth() {
        return adjacentRooms.get(0);
    }

    public String getEast() {
        return adjacentRooms.get(2);
    }

    public String getSouth() {
        return adjacentRooms.get(3);
    }

    public String getWest() {
        return adjacentRooms.get(1);
    }
}
