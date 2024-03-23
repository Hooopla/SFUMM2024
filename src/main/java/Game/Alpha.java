package Game;

import Game.Model.enemy.baseEnemy;
import Game.Model.map.Map;
import Game.Model.player.character;

public class Alpha {
    public static void main(String[] args) {
        // Create the map
        Map dungeonMap = new Map(10, 10); // Create a 10x10 map
        dungeonMap.printMap();
    }

}
