package Game;

import Game.Model.map.Map;

import java.util.Scanner;

public class Alpha {
    public static void main(String[] args) {
        // Create the map
        Map dungeonMap = new Map(10, 10); // Create a 10x10 map
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);

        while (playing) {
            dungeonMap.printMap();
            System.out.println("Choose a direction (forwards, backwards, left, right)");
            String movement = scanner.nextLine();

            switch (movement) {
                case "forwards":
                    dungeonMap.moveForward();
                    break;
                case "backwards":
                    //dungeonMap.moveBackward();
                    break;
                case "left":
                    //dungeonMap.moveLeft();
                    break;
                case "right":
                    //dungeonMap.moveRight();
                    break;
                default:
                    System.out.println("Invalid direction.");
                    break;
            }
        }
        //scanner.close();**/
    }
}
