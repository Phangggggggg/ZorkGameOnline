package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Map.CreateMap;
import io.muzoo.ooc.Zork.Map.ReadFile;

public class MapCommand implements Command{
    private CreateMap createMap;

    public MapCommand(CreateMap createMap) {
        this.createMap = createMap;
    }

    @Override
    public void execute(String arg) {
        createMap.getAsciiMap();
    }

    @Override
    public String getDescription() {
        return "This command displays the game's map ";
    }
}
