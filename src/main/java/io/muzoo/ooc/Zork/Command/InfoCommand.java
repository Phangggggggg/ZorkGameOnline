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
        System.out.println("You are at " + player.getCurrentRoom().getRoomName() + ": " + player.getCurrentRoom().getDescription());
        System.out.println("Your HP is " + player.getHP());
        System.out.println("Your attack value " + player.getAttackMonster());
        if (player.getInventory().getPlayerInventory().isEmpty()){
            System.out.println(player.displayInventory()+ "  player inventory is empty");
        }
        else {
            System.out.println(player.displayInventory() + "  This is your current inventory");
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}
