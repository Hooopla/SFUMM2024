package Game;

import java.util.Scanner;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;
//import Game.Model.enemy.regularSkeleton;

public class Main {
    public static void main(String[] args) {
        baseEnemy angrySkeleton = new baseEnemy("Savage Skeleton", "=== Angry Ratting ===", 40, 10, 5);
        baseEnemy swoleSkeleton = new baseEnemy("Swole Skeleton", "=== Thicc Rattling ===", 50, 15, 7);
        baseEnemy dog = new baseEnemy ("Corrupt Chihuahua", "=== Aggressive Barking ===", 10, 5, 2);
        baseEnemy smallGolem = new baseEnemy("Smol Golem", "=== Rock noises ===", 70, 3, 4);
        baseEnemy bigGolem = new baseEnemy("Girthy Golem", "=== Who fed Malphite?===", 110, 20, 20);
        baseEnemy mimic = new baseEnemy("Mimic", "=== Tample Sext ===", 40, 40, 40);

        angrySkeleton.printEnemyInfo();
        angrySkeleton.printEnemyIntro();

        swoleSkeleton.printEnemyInfo();
        swoleSkeleton.printEnemyIntro();

        //gets user's name
        Scanner enterName = new Scanner(System.in);
        System.out.println("Brave soul, what is your name?");
        String userName = enterName.nextLine();

        //create character
        character thePlayer = new character(userName);
    }
}