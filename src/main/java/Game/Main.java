package Game;

import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;

public class Main {
    public static void main(String[] args) {

        baseEnemy enemy1 = new baseEnemy();
        enemy1.printAllValues();
        baseEnemy enemy2 = new baseEnemy(30, 40, "frog");
        enemy2.printAllValues();

        character player = new character("Hooopla");
    }
}