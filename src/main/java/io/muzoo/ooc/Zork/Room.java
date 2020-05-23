package io.muzoo.ooc.Zork;

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
        return north;
    }

    public String getEast() {
        return east;
    }

    public String getSouth() {
        return south;
    }

    public String getWest() {
        return west;
    }
}
