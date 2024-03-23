package Game;

import Game.Model.enemy.baseEnemy;

public class Main {
    public static void main(String[] args) {

        baseEnemy enemy1 = new baseEnemy();
        enemy1.printAllValues();
        baseEnemy enemy2 = new baseEnemy(30, 40, "frog");
        enemy2.printAllValues();
    }
}