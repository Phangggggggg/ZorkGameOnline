package io.muzoo.ooc.Zork.Map;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BFS {
    private Set<String> visited;
    private Set<String> frontiers;
    private String startingPoint;

    public BFS(Set<String> visited, Set<String> frontiers, String startingPoint)  {
        visited = new HashSet<>(Arrays.asList(startingPoint));
        frontiers = new HashSet<>(Arrays.asList(startingPoint));
        while (!frontiers.isEmpty()){
            frontiers = nbrs(frontiers);
            frontiers.removeAll(visited);
            visited.addAll(frontiers);
        }

    }

    public Set<String> nbrs(Set<String> rooms){
        Set<String> union = new HashSet<>();
        for (String r: rooms) {


        }

    }
}
