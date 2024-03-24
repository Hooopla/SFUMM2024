package Game.Model.player;

import java.util.Random;

public class character {
    private String username;
    private int healthPoints;
    private int attPoints;
    private int currentGold;
    private  boolean hasMetAurelia;
    private boolean alive;
    private boolean hasKey;
    private int hpPots;
    private int papers;

    public character(String username) {
        this.username = username;
        //this.healthPoints = randomizeStartingHP();
        this.healthPoints = 500;
<<<<<<< Updated upstream
        this.attPoints = 20;
        this.currentGold = 0;
=======
        this.attPoints = 100;
        this.currentGold = 1000;
>>>>>>> Stashed changes
        this.alive = true;
        this.hasMetAurelia = false;
        this.hasKey = false;
        this.hpPots = 0;
        this.papers = 0;
    }

    public int getHpPots() {
        return hpPots;
    }

    public void setHpPots(int hpPots) {
        this.hpPots = hpPots;
    }

    public void addHpPots(int hpPots) {
        this.hpPots += hpPots;
    }

    public void removeHpPots(int hpPots) {
        this.hpPots -= hpPots;
    }

    public int getPapers() {
        return papers;
    }

    public void setPapers(int papers) {
        this.papers = papers;
    }

    public void addPaper(int papers) {
        this.papers += papers;
    }

    public void removePaper(int papers) {
        this.papers -= papers;
    }

    public boolean isHasMetAurelia() {
        return hasMetAurelia;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setHasMetAurelia(boolean condition) {
        this.hasMetAurelia = condition;
    }

    public boolean getHasMetAurelia() {
        return this.hasMetAurelia;
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
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }

    public void addHealthPoints(int healthPoints) {
        this.healthPoints += healthPoints;
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
