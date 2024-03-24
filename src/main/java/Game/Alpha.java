package Game;

import Game.Model.map.Direction;
import Game.Model.map.Map;
import Game.Model.player.character;

import java.util.Scanner;

public class Alpha {
    public static void main(String[] args) {
        character Player = new character("Solaire");
        // Create the map
        Map dungeonMap = new Map(10, 10, Player); // Create a 10x10 map
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);

        while (playing) {
            dungeonMap.printMap();
            System.out.println("Choose a direction (up | down | left | right)");
            String movement = scanner.nextLine();
            switch (movement) {
                case "up":
                    dungeonMap.move(Direction.UP);
                    break;
                case "down":
                    dungeonMap.move(Direction.DOWN);
                    break;
                case "left":
                    dungeonMap.move(Direction.LEFT);
                    break;
                case "right":
                    dungeonMap.move(Direction.RIGHT);
                    break;
                default:
                    System.out.println("Invalid direction.");
                    break;
            }
        }
        //scanner.close();**/
    }
}
