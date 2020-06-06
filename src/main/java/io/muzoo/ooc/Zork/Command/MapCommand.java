package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Map.CreateMap;
import io.muzoo.ooc.Zork.Map.ReadFile;

public class MapCommand implements Command{
    private CreateMap Map;

    public MapCommand(CreateMap map) {
        Map = map;
    }

    @Override
    public void execute(String arg) {
        Map.getAsciiMap();
    }

    @Override
    public String getDescription() {
        return "This command displays the game's map ";
    }
}
