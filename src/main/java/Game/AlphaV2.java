package Game;

import Game.Model.map.Direction;
import Game.Model.map.Map;
import Game.Model.player.character;

import java.util.Scanner;

public class AlphaV2 implements  GameMessages {
    public static void main(String[] args) {
        character player = null;
        Map dungeonMap = new Map(10,10, null);
        boolean ApplicationRunning = true;
        boolean inGame = false;
        Scanner scanner = new Scanner(System.in);

        // Continuous input loop
        while (ApplicationRunning) {
            System.out.println("\n" +
                    "                                                 \n" +
                    " ____   _____  _____  _____  _____  _____  _____ \n" +
                    "|    \\ |  |  ||   | ||   __||   __||     ||   | |\n" +
                    "|  |  ||  |  || | | ||  |  ||   __||  |  || | | |\n" +
                    "|____/ |_____||_|___||_____||_____||_____||_|___|\n" +
                    "                                                 \n");
            GameMessages.titleScreen();
            System.out.print(">>");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    String username;
                    inGame = true;
                    do {
                        System.out.print("What is your name, lost one? ");
                        username = scanner.nextLine().trim(); // Remove leading and trailing spaces
                        if (username.isEmpty()) {
                            System.out.println("Though may be lost you can't truly forget you name can you?...");
                            GameMessages.clearScreen();
                        }
                        username = username.trim();
                    } while (username.contains(" ") || username.isEmpty());
                    player = new character(username);
                    dungeonMap.setNewPlayer(player);
                    GameMessages.clearScreen();
                    player.characterIntroduction();
                    while (inGame) {
                        Scanner movement = new Scanner(System.in);
                        // Prompt the user to press Enter to continue

                        System.out.println("Press Enter to continue...");
                        movement.nextLine();
                        GameMessages.clearScreen();
                        GameMessages.printMapText();
                        dungeonMap.printDebugMap(); // <-- DEBUG MAP
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Choose a direction: (up | down | left | right)");
                        System.out.println("-----------------------------------------------------");

                        String playerControl = movement.nextLine().toLowerCase().replaceAll("\\s", "");
                        switch (playerControl) {
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
                        if (player.isAlive() && player.isWinCondition()) {
                            inGame = false;
                            ApplicationRunning = false;
                            break;
                        }
                        else if(player.isAlive() == false) {
                            inGame = false;
                        }
                    }
                    break;
                case "2":
                    GameMessages.showCredits();
                    break;
                case "3":
                    ApplicationRunning = false;
                    break;
                default:
                    System.out.println("Sorry, we cannot understand your input. Please try again.");
                    break;
            }
        }
        System.out.println("The dungeon crumbles apart... Wait no.. It's rebuilding?!??!....");
    }
}
