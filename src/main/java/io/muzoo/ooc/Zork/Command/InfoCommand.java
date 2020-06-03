package io.muzoo.ooc.Zork.Command;

import io.muzoo.ooc.Zork.Player.Player;

public class InfoCommand implements Command {
    private Player player;
    private String description;

    public InfoCommand(Player player) {
        this.player = player;
        description = "This is info command getting information of player";
    }

    @Override
    public void execute(String arg) {
        System.out.println("Your HP is" + player.getHP());
        System.out.println("Your attack value" + player.getAttackMonster());
        System.out.println(player.getInventory().getDescription()+player.getInventory().getPlayerInventory());
    }

    @Override
    public String getDescription() {
        return description;
    }
}
