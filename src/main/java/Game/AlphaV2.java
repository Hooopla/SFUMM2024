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
                    "________   ____ __________    ___________________________    _______    _________\n" +
                    "\\______ \\ |    |   \\      \\  /  _____/\\_   _____/\\_____  \\   \\      \\  /   _____/\n" +
                    " |    |  \\|    |   /   |   \\/   \\  ___ |    __)_  /   |   \\  /   |   \\ \\_____  \\ \n" +
                    " |    `   \\    |  /    |    \\    \\_\\  \\|        \\/    |    \\/    |    \\/        \\\n" +
                    "/_______  /______/\\____|__  /\\______  /_______  /\\_______  /\\____|__  /_______  /\n" +
                    "        \\/                \\/        \\/        \\/         \\/         \\/        \\/ \n");
            GameMessages.titleScreen();
            System.out.print(">>");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    String username;
                    inGame = true;
                    do {
                        System.out.print("Please enter your username: ");
                        username = scanner.nextLine().trim(); // Remove leading and trailing spaces
                        if (username.contains(" ")) {
                            System.out.println("Username cannot contain spaces. Please try again.");
                        }
                    } while (username.contains(" "));
                    player = new character(username);
                    dungeonMap.setNewPlayer(player);
                    GameMessages.clearScreen();
                    player.characterIntroduction();
                    while(inGame) {
                        dungeonMap.printDebugMap(); // <-- DEBUG MAP
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Choose a direction: (up | down | left | right)");
                        System.out.println("-----------------------------------------------------");
                        Scanner movementScanner = new Scanner(System.in);
                        String playerControl = movementScanner.nextLine();
                        switch (playerControl.toLowerCase().replaceAll("\\s", "")) {
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
                        inGame = player.isAlive();
                    }
                    break;
                case "2":
                    GameMessages.showCredits();
                    break;
                case "3":
                    System.out.println("Ending program");
                    ApplicationRunning = false;
                    break;
                default:
                    System.out.println("Sorry, we cannot understand your input. Please try again.");
                    break;
            }
        }
    }
}
