package Game.Model.map;
import Game.GameMessages;
import Game.Model.enemy.baseEnemy;
import Game.Model.enemy.miniBoss;
import Game.Model.player.character;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Map implements GameMessages {
    private final Room[][] grid;
    private final int width;
    private final int height;

    private final NPC Aurelia = new NPC();

    // Player Tracker
    private character player;
    private int playerXCoordinate;
    private int playerYCoordinate;

    // Player Last Location Tracker
    private List<Integer> lastPlayerYCoordinate = new LinkedList<>();
    private List<Integer> lastPlayerXCoordinate = new LinkedList<>();

    public Map(int width, int height, character player) {
        this.width = width;
        this.height = height;
        this.player = player;
        grid = new Room[height][width];
        initializeMap();
        placePlayer();
    }

    private void initializeMap() {
        // Initialize all cells with Room objects
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Room();
            }
        }
        // Place obstacles or special tiles on the map as needed
        alphaMap();
    }

    public void setNewPlayer(character player) {
        this.player = player;
        placePlayer();
        lastPlayerXCoordinate = new LinkedList<>();
        lastPlayerYCoordinate = new LinkedList<>();

    }
    private void alphaMap() {
        // Example of setting attributes for specific rooms
        // STARTING ROOM
        grid[0][4].setContainsExplorable(true);


        // THIS IS A ROOM THAT WILL HAVE AN ENEMY FOR NOW FOR TESTING LOL
        grid[1][4].setContainsExplorable(true);
        grid[1][4].setBossInRoom(new miniBoss("Savage Skeleton", "Angry Ratting", 70, 10, 5, "Slave Knight Gael OST", "Is this the blood... The blood of the dark soul?", "Augh...", "For my lady's painting."));
        grid[1][5].setContainsExplorable(true);
        grid[1][5].setEnemyInRoom(new baseEnemy("Swole Skeleton", "=== Thicc Rattling ===", 50, 15, 7));
        grid[1][6].setContainsExplorable(true);
        grid[1][7].setContainsExplorable(true);
        grid[1][7].setContainsShop(true);
        grid[1][3].setContainsExplorable(true);
        grid[1][3].setEnemyInRoom(new baseEnemy("Smol Golem", "Rock noises", 70, 3, 4));
        grid[1][2].setContainsExplorable(true);
        grid[1][2].setEnemyInRoom(new baseEnemy("Girthy Golem", "Who fed Malphite?", 110, 20, 20));
        grid[1][1].setContainsExplorable(true);
        grid[1][1].setContainsShop(true);
        grid[1][0].setContainsExplorable(true);
        grid[1][0].setLocked(true);
        //grid[1][0] <-- CONTAINS MINI BOSS
        // We meet Aurelia
        grid[2][4].setContainsExplorable(true);
        grid[2][4].setNpc(Aurelia);
        grid[3][4].setContainsExplorable(true);
        grid[3][4].setEnemyInRoom(new baseEnemy("Corrupt Chihuahua", "Aggressive Barking", 10, 5, 2));
        grid[4][4].setContainsExplorable(true);
        grid[5][4].setContainsExplorable(true);
        grid[5][4].setContainsShop(true);

        grid[6][4].setContainsExplorable(true);
        grid[6][4].setBossInRoom(new miniBoss("Haligtree Knight Loretta", "Glintstone Phalanx noises", 100, 20, 50, "Knight of the Haligtree", "Loretta's Mastery noises", "Great Enemy Felled", "..."));
        //grid[6][4] MINI BOSS Haligtree Knight Loretta

        grid[7][4].setContainsExplorable(true);
        grid[7][4].setBossInRoom(new miniBoss("Malenia, Blade of Miquella", "| Heed my words. | \n| I am Malenia. Blade of Miquella |\n| And I have never known defeat.|", 100, 20, 50, "Malenia, Blade of Miquella", "| Wait. |\n| The scarlet bloom flowers once more |\n| You will witness true horror. |\n| Now, rot! |", "| Your Strength, extraordinary... |\n| O, dearest Miquella |\n| I'm sorry. I finally met my match... |", "I am Malenia, Blade of Miquella..."));
        //grid[7][4] MINI BOSS Malenia :huh:

        grid[0][0].setContainsExplorable(true);
        grid[5][3].setContainsExplorable(true);
        grid[5][2].setContainsExplorable(true);
        grid[5][2].setEnemyInRoom(new baseEnemy("Ravaging Raven", "Piercing Caws", 10, 5, 2));
        grid[5][1].setContainsExplorable(true);
        grid[4][1].setContainsExplorable(true);
        //grid[4][1] MINI BOSS
        grid[3][1].setContainsExplorable(true);
        grid[6][5].setContainsExplorable(true);
        grid[6][5].setEnemyInRoom(new baseEnemy ("Colin", "That demon in there can't take your soul. He'll only get stronger... I must take your life then.. I'm sorry..", 40, 6, 2));
        grid[6][6].setContainsExplorable(true);
        grid[5][6].setContainsExplorable(true);
        grid[5][6].setEnemyInRoom(new baseEnemy("Crazed Imp", "Hehehe! giggles mischievously Snicker-snack!", 40, 30, 5));

        grid[4][6].setContainsExplorable(true);
        //grid[4][6] boss asylum demon

        grid[7][3].setContainsExplorable(true);
        grid[7][3].setContainsShop(true);
        grid[7][2].setContainsExplorable(true);
        grid[7][2].setContainsKey(true);
        grid[7][1].setContainsExplorable(true);
        //grid[7][0]
        grid[7][0].setContainsExplorable(true);
        grid[7][0].setBossInRoom(new miniBoss("Slave Knight Gael", "| What, still here?|\n| Hand it over. That thing, your dark soul |\n| For my lady's painting. |", 100, 20, 50, "The Ringed City - Slave Knight Gael", "| Ahh, is this the blood? |\n | The blood of the dark soul? |", "Soul of slave knight gael", "For my lady's painting."));
        grid[7][0].setContainsExit(true);
    }
    private void placePlayer() {
        playerXCoordinate = 4;
        playerYCoordinate = 0;
        grid[0][4].setContainsPlayer(true);
    }

    public void printMap() {
        for (Room[] row : grid) {
            for (Room room : row) {
                // Print symbols based on room attributes
                if (room.isContainsExit()) {
                    System.out.print("X ");
                } else if (room.isContainsPlayer()) {
                    System.out.print("P ");
                } else if (room.isContainsExplorable()) {
                    System.out.print("E ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void printDebugMap() {
        for (Room[] row : grid) {
            for (Room room : row) {
                // Print symbols based on room attributes
                if (room.isContainsExit()) {
                    System.out.print("X ");
                } else if(room.isLocked()) {
                    System.out.print("L ");
                } else if (room.isContainsPlayer()) {
                    System.out.print("P ");
                } else if (room.isContainsShop()) {
                    System.out.print("S ");
                } else if (room.isContainsEnemy()) {
                    System.out.print("E ");
                } else if (room.isContainsBoss()) {
                    System.out.print("B ");
                } else if (room.isContainsNPC()) {
                    System.out.print("A ");
                } else if (room.isContainsKey()) {
                    System.out.print("K ");
                } else if (room.isContainsExplorable()) {
                    System.out.print(". ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void move(Direction direction) {
        int newX = playerXCoordinate;
        int newY = playerYCoordinate;
        switch (direction) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }
        if (isValidMove(newX, newY)) {
            movePlayerToRoom(newX, newY);
        } else {
            System.out.println("Cannot move in that direction.");
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height && grid[y][x].isContainsExplorable();
    }

    private void movePlayerToRoom(int newX, int newY) {
        grid[playerYCoordinate][playerXCoordinate].setContainsPlayer(false);
        lastPlayerYCoordinate.add(playerYCoordinate);
        lastPlayerXCoordinate.add(playerXCoordinate);
        playerXCoordinate = newX;
        playerYCoordinate = newY;
        grid[playerYCoordinate][playerXCoordinate].setContainsPlayer(true);
        checkForEvents(grid[playerYCoordinate][playerXCoordinate]);
    }

    private void checkForEvents(Room grid) {
        GameMessages.clearScreen();
        if(grid.isContainsMessage()) {
            System.out.println("You found a piece of paper and it reads...");
            System.out.println(grid.getMessage());
            System.out.println("I should be careful the blood stains on this notes tells me something bad...");
            grid.setContainsMessage(false);
        }
        // Checking for Basic Enemy
        if(grid.isContainsEnemy()) {
            GameMessages.printCombatText();
            System.out.println("You stumble into an enemy..");
            Combat battleSequence = new Combat(grid.getEnemyInRoom(), player);
            battleSequence.fightScenarioChecker();
            this.player.setAlive(battleSequence.getBattleOutcome());
            if(!this.player.isAlive()) {
                grid.setContainsPlayer(false);
                if(this.player.isHasKey()) {
                    grid.setContainsKey(true);
                }
                if(this.player.getPapers() != 0) {
                    System.out.println("With your last dying breath you remember the piece of paper you bought...");
                    System.out.print("Write your message: ");
                    Scanner messageInput = new Scanner(System.in);
                    String message = messageInput.nextLine();
                    grid.setMessage(message);
                }
            }
            else {
                grid.setContainsEnemy(false);
            }
        }
        // Checking for Boss
        else if(grid.isContainsBoss()) {
           GameMessages.printCombatText();
           Combat battleSequence = new Combat(grid.getBossInRoom(), player);
           battleSequence.fightScenarioChecker();
            this.player.setAlive(battleSequence.getBattleOutcome());
            if(!this.player.isAlive()) {
                grid.setContainsPlayer(false);
                if (this.player.isHasKey()) {
                    grid.setContainsKey(true);
                }
                if (this.player.getPapers() != 0) {
                    System.out.println("With your last dying breath you remember the piece of paper you bought...");
                    System.out.print("Write your message: ");
                    Scanner messageInput = new Scanner(System.in);
                    String message = messageInput.nextLine();
                    grid.setMessage(message);
                }
            }
            else {
                grid.setContainsBoss(false);
                if(grid.isContainsExit()) {
                    System.out.println("ENDING SHIT IS HERE");
                }
            }
        }
        // Checking for NPC
        else if(grid.isContainsNPC()) {
            grid.setContainsNPC(false);
            NPC tempNPC = grid.getNpc();
            int scenario = tempNPC.converse(player);
            if(scenario == 1) {
                this.grid[0][0].setNpc(Aurelia);
            }
            else if(scenario == 2) {
                this.grid[7][1].setNpc(Aurelia);
            }
        }
        else if(grid.isContainsKey()) {
            System.out.println("You found a key!");
            grid.setContainsKey(false);
            player.setHasKey(true);
        }
        // Checking for SHOP
        else if(grid.isContainsShop()) {
            GameMessages.printShopKeeper();
            if(player.getCurrentGold() == 0) {
                System.out.println("Shopkeeper: Hey there you! Yes you!! Come take a look you might find things you need...");
                System.out.println("Shopkeeper: Wait a minute... You have no gold..");
                System.out.println("*They close up shop...*");
            }
            else {
                System.out.println("Shopkeeper: Come here take a look at me items");
                Scanner shopPurchase = new Scanner(System.in);
                int userInput;
                boolean Shopping = true;
                while (Shopping) {
                    System.out.println("Shop Inventory");
                    System.out.println("Current Gold: " + player.getCurrentGold());
                    System.out.println("1. Bottle of life - 'heals player for 10 health points' (20 gold)");
                    System.out.println("2. A piece of paper - 'This must be useful right?' (15 gold)");
                    System.out.println("3. Exit Shop");
                    try {
                        System.out.print(">>");
                        userInput = Integer.parseInt(shopPurchase.nextLine());
                        if (userInput == 1) {
                            if (player.getCurrentGold() > 20) {
                                System.out.println("Shopkeeper: Ahh the Bottle of Life a classic...");
                                System.out.println("+1 Bottle of Life");
                                player.addHpPots(1);
                                player.setCurrentGold(player.getCurrentGold() - 20);
                            }
                            else {
                                System.out.println("Shopkeeper: You know things like this isn't for free for a reason...");
                            }
                        }
                        else if (userInput == 2) {
                            if (player.getCurrentGold() > 15) {
                                System.out.println("Shopkeeper: People say things you write down this paper may help those in need like yourself!..");
                                System.out.println("+1 Piece of paper");
                                player.addPaper(1);
                                player.setCurrentGold(player.getCurrentGold() - 15);
                            }
                            else {
                                System.out.println("Shopkeeper: You can't even afford a piece of paper?!?!");
                            }
                        }
                        else if (userInput == 3) {
                            System.out.println("Shopkeeper: Leaving so soon? Alright then take care.. Don't die out there!!");
                            Shopping = false;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Shopkeeper: Uhmm I don't quite understand... Speak up!!! What is it again??");
                    }
                }
            }
        }
        // Checking for the boss door that is locked.
        else if(grid.isLocked() && player.isHasKey()) {
            System.out.println("You unlock the door using the key.");
            grid.setLocked(false);
        }
        else if(grid.isLocked() && !player.isHasKey()) {
            System.out.println("Hmmm the door is stuck or maybe I just need a key?...");
            grid.setContainsPlayer(false);
            playerXCoordinate = lastPlayerXCoordinate.removeLast();
            playerYCoordinate = lastPlayerYCoordinate.removeLast();
        }
        else {
            System.out.println("Just another empty dungeon cell..");
        }
    }
}