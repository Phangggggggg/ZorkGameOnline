package io.muzoo.ooc.Zork.Command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AutopilotCommand implements Command {
    private CommandFactory commandFactory;
    private List<String> textName;

    public AutopilotCommand(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
        textName = new ArrayList<>();
        textName.add("auto");
        textName.add("pilot");
    }

    @Override
    public void execute(String arg) throws IOException {
        if (!textName.contains(arg)){
            System.out.println("You might spell the name of file wrong");
        }
        else {
            String path = "/Users/phang/Desktop/Zork/src/main/resources/" + arg + ".txt";
            FileReader fileReader = new FileReader(new File(path));
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] command = line.split(" ");
                if (commandFactory.containCommand(command[0])) {
                    commandFactory.getCommand(command[0]).execute(command[1]);
                }
            }
        }



    }

    @Override
    public String getDescription() {
        return null;
    }
}
