package Game.Model.map;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;
import Game.Model.map.Room;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;


public class Combat {
    baseEnemy enemy;
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
    //while in combat
    public void startFight() {
        enemy.printEnemyInfo();
        while (enemy.getHp() > 0 && player.getHealthPoints() > 0){
            //print status
            Scanner action = new Scanner(System.in);
            System.out.println("What is your move? \n" + "| Attack |\t" + "| Bag |\t" + "| Talk |");
            String command = action.nextLine().trim().toLowerCase();

            switch (command) {
                case "attack" -> {
                    //damage calc shit thingy
                    System.out.println("You attacked the " + enemy.getName() + " for " + player.getAttPoints() + " damage!");
                    enemy.setHp(enemy.getHp() - player.getAttPoints());
                    enemy.printEnemyInfo();
                    //check if enemy is dead
                    if(enemy.getHp() <= 0){
                        System.out.println("You have defeated the " + enemy.getName() + "!");
                        setBattleOutcome(true);
                        System.out.println(getBattleOutcome());
                        return;
                    }

                    //if enemy is not dead
                    if (enemy.getHp() > 0) {
                        //enemy attack
                        System.out.println("===" + enemy.getName() + "'s Turn ===");
                        player.setHealthPoints(player.getHealthPoints() - enemy.getAttPower());
                        System.out.println(enemy.getName() + " backhanded you for " + enemy.getAttPower() + " damage!\n");
                        player.printPlayerStatus();

                        //if player is deadge
                        if(player.getHealthPoints() <= 0){
                            System.out.println("u ded");
                            System.out.println(getBattleOutcome());
                            return;
                        }

                    }
                }
                case "talk" -> {
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
