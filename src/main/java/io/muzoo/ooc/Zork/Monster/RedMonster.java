package io.muzoo.ooc.Zork.Monster;

public class RedMonster extends Monster {
    public RedMonster() {
        super(100,100,50,50);
        name = "Red Monster";
        description = "Red like Fire";
    }

    public RedMonster(int hp, int maxHP, int maxAttack, int attack) {
        super(hp, maxHP, maxAttack, attack);
        name = "Red Monster";
        description = "Red like Fire";
    }

    @Override
    public int attackPlayer() {
        double attackProb = Math.random();
        if (attackProb <= 0.02){
            System.out.println("You are attacked by Red Monster ");
            return maxAttack;
        }
        else if (attackProb <= 0.1){
            System.out.println("You are lucky!");
            return 0;
        }
        else if (attackProb <= 0.4){
            System.out.println("Prepare yourself, Red Monster is coming");
            double rangeAttack = Math.random() * (15-5); // Math.random() * ( Max - Min )
            return Math.toIntExact(Math.round(rangeAttack));
        }
        else if (attackProb <= 0.7){
            System.out.println("Red Monster is about to attack you !!!");
            double rangeAttack = Math.random() * (49-16);
            return Math.toIntExact(Math.round(rangeAttack));
        }
        else{
            System.out.println("Red monster is behind your back!");
            return attack;
        }
    }

    public void increasePower(){
        if (maxHP == hp){
            maxHP += 2;
            hp += 2;
        }
        else if (hp < maxHP){
            hp += 3;
            maxHP +=3;
        }
    }



}
