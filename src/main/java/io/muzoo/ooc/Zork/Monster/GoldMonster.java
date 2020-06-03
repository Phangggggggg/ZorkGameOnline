package io.muzoo.ooc.Zork.Monster;

public class GoldMonster extends Monster {
    public GoldMonster() {
        super(350,350,80,80);
        name = "Gold Monster";
        description = "Gold like gold";
    }

    public GoldMonster(int hp, int maxHP, int maxAttack, int attack) {
        super(hp, maxHP, maxAttack, attack);
        name = "Gold Monster";
        description = "Gold like gold";
    }

    @Override
    public int attackPlayer() {
        double attackProb = Math.random();
        if (attackProb <= 0.02){
            System.out.println("You are attacked by Gold Monster ");
            return maxAttack;
        }
        else if (attackProb <= 0.1){
            System.out.println("You are lucky!");
            return 0;
        }
        else if (attackProb <= 0.4){
            System.out.println("Prepare yourself, Gold Monster is coming");
            double rangeAttack = Math.random() * (70-5); // Math.random() * ( Max - Min )
            return Math.toIntExact(Math.round(rangeAttack));
        }
        else if (attackProb <= 0.7){
            System.out.println("Gold Monster is about to attack you !!!");
            double rangeAttack = Math.random() * (80-71);
            return Math.toIntExact(Math.round(rangeAttack));
        }
        else{
            System.out.println("Gold monster is behind your back!");
            return attack;
        }

    }

    @Override
    public void increasePower() {
        if (maxHP == hp){
            maxHP += 1;
            hp += 1;
        }
        else if (hp < maxHP){
            hp += 3;
            maxHP +=3;
        }

    }
}
