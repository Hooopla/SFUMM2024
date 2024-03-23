package Game.Model.player;

import java.util.Random;

public class character {
    private String username;
    private int healthPoints;
    private int level;
    private int currentEXP;


    public character(String username) {
        this.username = username;
        this.healthPoints = randomizeStartingHP();
        this.level = 1;
        this.currentEXP = 0;
        characterIntroduction();
    }

    // THIS IS ONLY TO BE CALLED DURING THE CREATION PROCCESS
    private int randomizeStartingHP() {
        Random random = new Random();
        return random.nextInt(16) + 5; // Generates a random number between 0 and 15 and adds 5
    }

    public void characterIntroduction() {
        if (this.healthPoints < 10) {
            System.out.println("You are feeling very weak.");
        } else if (this.healthPoints < 15) {
            System.out.println("Your health is a bit low.");
        } else if (this.healthPoints < 20) {
            System.out.println("You are in decent health.");
        } else {
            System.out.println("You are in excellent health.");
        }
    }
}
