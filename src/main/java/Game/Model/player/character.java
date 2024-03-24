package Game.Model.player;

import java.util.Random;

public class character {
    private String username;
    private int healthPoints;
    private int attPoints;
    private int currentGold;

    private boolean alive;

    public character(String username) {
        this.username = username;
        //this.healthPoints = randomizeStartingHP();
        this.healthPoints = 50;
        this.attPoints = 10;
        this.currentGold = 0;
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    //getter
    public String getUsername(){
        return this.username;
    }
    public int getHealthPoints(){
        return this.healthPoints;
    }

    public int getAttPoints(){
        return this.attPoints;
    }

    public int getCurrentGold(){
        return this.currentGold;
    }

    //setter
    public String setUsername(String username){
        return this.username = username;
    }
    public int setHealthPoints(int healthPoints){
        return this.healthPoints = healthPoints;
    }

    public int setAttPoints(int attPoints){
        return this.attPoints = attPoints;
    }

    public int setCurrentGold(int currentGold){
        return this.currentGold = currentGold;
    }

    // THIS IS ONLY TO BE CALLED DURING THE CREATION PROCCESS
    private int randomizeStartingHP() {
        Random random = new Random();
        return random.nextInt(16) + 5; // Generates a random number between 0 and 15 and adds 5
    }

    public void characterIntroduction() {
        if (this.healthPoints < 10) {
            System.out.println("You wake up in a pit of darkness... You feel so weak and frail.");
        } else if (this.healthPoints < 15) {
            System.out.println("You wake up in what seems like a... dungeon?? Ouch.. why do I have scratches..");
        } else if (this.healthPoints < 20) {
            System.out.println("You wake up but you can't help but cough due to the coldness of the floor.");
        } else {
            System.out.println("You are in excellent health.");
        }
    }

    public void printPlayerStatus(){
        System.out.println("Player " + getUsername() + " is at " + getHealthPoints() + " Hp.");
    }

}
