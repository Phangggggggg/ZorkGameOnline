//package io.muzoo.ooc.Zork;
//import io.muzoo.ooc.Zork.Command.CommandFactory;
//import io.muzoo.ooc.Zork.Item.*;
//import io.muzoo.ooc.Zork.Map.ReadFile;
//import io.muzoo.ooc.Zork.Monster.BlueMonster;
//import io.muzoo.ooc.Zork.Monster.GoldMonster;
//import io.muzoo.ooc.Zork.Monster.RedMonster;
//import io.muzoo.ooc.Zork.Player.Player;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String userInput = "";
//        System.out.println("\t (start) start game");
//        System.out.println("\t (load) load game");
//        System.out.println("Enter input : ");
//        userInput = scan.nextLine();
//        if(userInput.equals("start")) {
//            Player player = new Player();
//            ReadFile map = new ReadFile("/Users/phang/Desktop/Zork/src/main/resources/rooms.txt");
//            BlueMonster bm = new BlueMonster();
//            RedMonster rm = new RedMonster();
//            GoldMonster gm = new GoldMonster();
//            Item potion = new Potion();
//            Item bomb = new Bomb();
//            Item key = new Key();
//            Inventory iv = new Inventory();
//            while(true) {
//                System.out.println("Enter input : ");
//                userInput = scan.nextLine();
//                if(userInput.equals("info")) {
//                    CommandFactory.getCommand("info");
//                }
//                else {
//                    CommandFactory.getCommand("exit");
//                }
//            }
//        }
//
//    }
//}
