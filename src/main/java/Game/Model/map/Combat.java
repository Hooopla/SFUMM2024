package Game.Model.map;
import Game.Model.enemy.baseEnemy;
import Game.Model.enemy.miniBoss;
import Game.Model.player.character;
import Game.Model.map.Room;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Combat {
    baseEnemy enemy;
    miniBoss mBoss;
    character player;
    boolean battleOutcome;
    int roll;
    public boolean getBattleOutcome(){
        return this.battleOutcome;
    }
    public boolean setBattleOutcome(boolean battleOutcome){
        return this.battleOutcome = battleOutcome;
    }
    public Combat(baseEnemy enemy123, character player) {
        enemy = enemy123;
        this.player = player;
        this.battleOutcome = false;
    }

    public Combat(miniBoss enemy123, character player) {
        this.mBoss = enemy123;
        this.player = player;
        this.battleOutcome = false;
    }
    //while in combat with
    public void fightScenarioChecker() {
        if(!(enemy == null)) {
            startFight();
        }
        else if(!(mBoss == null)) {
            startBossFight();
        }
    }
    private void startBossFight() {
        System.out.println(mBoss.getEnemyIntro());
        mBoss.printEnemyInfo();
        System.out.println(mBoss.getBossOST() + "\nYou brace yourself for a difficult battle.");
        int maxHp = mBoss.getHp();
        boolean isBossEnraged = false;

        while (mBoss.getHp() > 0 && player.getHealthPoints() > 0){
            //print status
            Scanner action = new Scanner(System.in);
            System.out.println("What is your move? \n" + "| Attack |\t" + "| Bag |\t" + "| Talk |");
            String command = action.nextLine().trim().toLowerCase();

            switch (command) {
                case "attack" -> {
                    System.out.println("You attacked the " + mBoss.getName() + " for " + player.getAttPoints() + " damage!");
                    mBoss.setHp(mBoss.getHp() - player.getAttPoints());
                    //enemy.printEnemyInfo();
                    //check if enemy is dead
                    // Check if boss is under 50% HP and hasn't been enraged before
                    if (mBoss.getHp() < maxHp / 2 && !isBossEnraged) {
                        mBoss.enrage();
                        isBossEnraged = true; // Set the flag to true to indicate that the boss has been enraged
                    }
                    if(mBoss.getHp() <= 0){
                        System.out.println(mBoss.getDefeatMsg());
                        System.out.println("\nYou have defeated " + mBoss.getName() + "!");
                        player.setCurrentGold(player.getCurrentGold() + mBoss.getGoldDrop());
                        System.out.println("You have gained " + mBoss.getGoldDrop() + " gold from the " + mBoss.getName() + "!");
                        setBattleOutcome(true);
                        return;
                    }

                    //if enemy is not dead
                    if (mBoss.getHp() > 0) {
                        mBoss.printEnemyInfo();
                        //enemy attack
                        System.out.println("===" + mBoss.getName() + "'s Turn ===");
                        player.setHealthPoints(player.getHealthPoints() - mBoss.getAttPower());
                        System.out.println(mBoss.getName() + " Bodies you for " + mBoss.getAttPower() + " damage!\n");
                        //player.printPlayerStatus();

                        //if player is deadge
                        if(player.getHealthPoints() <= 0){
                            System.out.println("You Died");
                            System.out.println(mBoss.getName() + ": " + mBoss.getKillPlayerMsg());
                            return;
                        }

                    }
                    player.printPlayerStatus();
                }
                case "talk" -> {
                    if(Objects.equals(mBoss.getName(), "Slave Knight Gael") || Objects.equals(mBoss.getName(), "Malenia, Blade of Miquella")){
                        System.out.println("Now is not the time for that!");
                    }
                    else {
                        System.out.println("You try reasoning with " + mBoss.getName());
                        roll = roll();
                        if (roll <= 5) {
                            System.out.println("=== " + mBoss.getEnemyIntro() + " ===");
                            System.out.println("What did you expect...");
                        } else {
                            System.out.println("=== Bass boosted " + mBoss.getEnemyIntro() + " ===");
                            System.out.println("Your ears are ringing... >:(");
                        }
                    }
                }
                case "bag" -> {
                    System.out.println("You opened your bag");
                    if (player.getHpPots() > 0) {
                        System.out.println("You have " + player.getHpPots() + " Bottle of life(s).");
                        System.out.println("Would you like to use a potion?\n| Yes |\t| No |");

                        Scanner scanner = new Scanner(System.in);
                        String response = scanner.nextLine().trim().toLowerCase();

                        if (response.equals("yes")) {
                            // Use a potion
                            int healingAmount = 10;
                            player.setHealthPoints(player.getHealthPoints() + healingAmount);
                            player.removeHpPots(1); // Decrement the number of potions
                            System.out.println("You used a potion and healed for " + healingAmount + " HP.");
                            System.out.println("Your current HP: " + player.getHealthPoints());
                        } else if (response.equals("no")) {
                            System.out.println("You chose not to use a potion.");
                        } else {
                            System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                        }
                    } else {
                        System.out.println("Your bag is empty.");
                    }
                }

                default -> System.out.println("Please try again.");
            }

        }

    }

    private void startFight() {
        System.out.println("NORMAL ENEMY");
        enemy.printEnemyInfo();
        while (enemy.getHp() > 0 && player.getHealthPoints() > 0){
            //print status
            Scanner action = new Scanner(System.in);
            System.out.println("What is your move? \n" + "| Attack |\t" + "| Bag |\t" + "| Talk |");
            String command = action.nextLine().trim().toLowerCase();

            switch (command) {
                case "attack" -> {
                    System.out.println("You attacked the " + enemy.getName() + " for " + player.getAttPoints() + " damage!");
                    enemy.setHp(enemy.getHp() - player.getAttPoints());
                    //enemy.printEnemyInfo();
                    //check if enemy is dead
                    if(enemy.getHp() <= 0){
                        System.out.println("You have defeated the " + enemy.getName() + "!");
                        player.setCurrentGold(player.getCurrentGold() + enemy.getGoldDrop());
                        System.out.println("You have gained " + enemy.getGoldDrop() + " gold from the " + enemy.getName() + "!");
                        setBattleOutcome(true);
                        return;
                    }
                    enemy.printEnemyInfo();

                    //if enemy is not dead
                    if (enemy.getHp() > 0) {
                        //enemy attack
                        System.out.println("===" + enemy.getName() + "'s Turn ===");
                        player.setHealthPoints(player.getHealthPoints() - enemy.getAttPower());
                        System.out.println(enemy.getName() + " backhanded you for " + enemy.getAttPower() + " damage!\n");
                        //player.printPlayerStatus();

                        //if player is deadge
                        if(player.getHealthPoints() <= 0){
                            System.out.println("| You Died |");
                            return;
                        }

                    }
                    player.printPlayerStatus();
                }
                case "talk" -> {
                    if(Objects.equals(mBoss.getName(), "Slave Knight Gael") || Objects.equals(mBoss.getName(), "Malenia, Blade of Miquella"))
                        System.out.println("Now is not the time for that!");
                    else {
                        System.out.println("You try reasoning with the " + enemy.getName());
                        roll = roll();
                        if (roll <= 5) {
                            System.out.println("=== " + enemy.getEnemyIntro() + " ===");
                            System.out.println("What did you expect...");
                        } else {
                            System.out.println("=== Bass boosted " + enemy.getEnemyIntro() + " ===");
                            System.out.println("Your ears are ringing... >:(");
                        }
                    }
                }
                case "bag" ->
                    //open bag thingy
                        System.out.println("You opened your bag");
                default -> System.out.println("Try again bozo");
            }

        }
    }

    private int roll() {
        Random roll = new Random();
        return roll.nextInt(11);// generates random number 1-10 for options
    }
    //print hud(enemy stats, your stats)
}
