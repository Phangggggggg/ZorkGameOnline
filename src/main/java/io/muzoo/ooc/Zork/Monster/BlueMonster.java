package io.muzoo.ooc.Zork.Monster;

public class BlueMonster extends Monster{
    public BlueMonster() {
        super(200,200,75,75);
        name = "Blue Monster";
        description = "Blue like Ocean";
    }

    public BlueMonster(int numUpgrade) {
        super(200+(numUpgrade * 2), 200+(numUpgrade * 2), 75, 75);
        name = "Blue Monster";
        description = "Blue like Ocean";
    }

    @Override
    public int attackPlayer() {
        double attackProb = Math.random();
        if (attackProb <= 0.02){
            System.out.println("You are attacked by Blue Monster ");
            return maxAttack;
        }
        else if (attackProb <= 0.1){
            System.out.println("You are lucky!");
            return 0;
        }
        else if (attackProb <= 0.4){
            System.out.println("Prepare yourself, Blue Monster is coming");
            double rangeAttack = Math.random() * (45-5); // Math.random() * ( Max - Min )
            return Math.toIntExact(Math.round(rangeAttack));
        }
        else if (attackProb <= 0.7){
            System.out.println("Blue Monster is about to attack you !!!");
            double rangeAttack = Math.random() * (75-46);
            return Math.toIntExact(Math.round(rangeAttack));
        }
        else{
            System.out.println("Blue monster is behind your back!");
            return attack;
        }

    }

    @Override
    public void increasePower() {
        hp += 2;
        maxHP +=2;
        countUpgrade += 1;

    }

}
