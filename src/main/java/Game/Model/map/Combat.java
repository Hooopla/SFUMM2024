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
    int damage;
    int roll;
    public Combat(baseEnemy enemy123, character player) {
        enemy = enemy123;
        this.player = player;
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
                    //damage = enemy.getHp() - player.getAttPoints();
                    enemy.setHp(enemy.getHp() - player.getAttPoints());
                    enemy.printEnemyInfo();

                    if (enemy.getHp() > 0) {
                        System.out.println("===" + enemy.getName() + "'s Turn ===");
                        player.setHealthPoints(player.getHealthPoints() - enemy.getAttPower());
                        System.out.println(enemy.getName() + " backhanded you for " + enemy.getAttPower() + " damage!\n");
                        player.printPlayerStatus();
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