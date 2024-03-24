package Game.Model.map;
import Game.GameMessages;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;

import java.util.LinkedList;
import java.util.List;

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
        grid[1][4].setEnemyInRoom(new baseEnemy("Savage Skeleton", "Angry Ratting", 40, 10, 5));
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
        //grid[6][4] MINI BOSS
        grid[7][4].setContainsExplorable(true);
        //grid[7][4] MINI BOSS
        grid[0][0].setContainsExplorable(true);
        grid[0][0].setNpc(Aurelia);
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
        //grid[4][6].set
        grid[7][3].setContainsExplorable(true);
        grid[7][3].setContainsShop(true);
        grid[7][2].setContainsExplorable(true);
        grid[7][1].setContainsExplorable(true);
        grid[7][1].setNpc(Aurelia);
        grid[7][0].setContainsExplorable(true);
        // grid[7][0] // FINAL BOSS
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
                } else if (room.isContainsMiniBoss()) {
                    System.out.print("M ");
                } else if (room.isContainsFinalBoss()) {
                    System.out.print("F ");
                } else if (room.isContainsNPC()) {
                    System.out.print("A ");
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
        // Checking for Basic Enemy
        if(grid.isContainsEnemy()) {
            GameMessages.printCombatText();
            System.out.println("You stumble into an enemy..");
            Combat battleSequence = new Combat(grid.getEnemyInRoom(), player);
            battleSequence.startFight();
            this.player.setAlive(battleSequence.getBattleOutcome());
            if(!this.player.isAlive()) {
                grid.setContainsPlayer(false);
            }
            else {
                grid.setContainsEnemy(false);
            }
        }
        // Checking for Mini Boss
        if(grid.isContainsMiniBoss()) {
           Combat battleSequence = new Combat(grid.getEnemyInRoom(), player);
           battleSequence.startFight();
            this.player.setAlive(battleSequence.getBattleOutcome());
            if(!this.player.isAlive()) {
                grid.setContainsPlayer(false);
            }
            else {
                grid.setContainsEnemy(false);
            }
        }
        // Checking for Final Boss
        if(grid.isContainsFinalBoss()) {
            Combat battleSequence = new Combat(grid.getEnemyInRoom(), player);
            battleSequence.startFight();
            this.player.setAlive(battleSequence.getBattleOutcome());
            if(!this.player.isAlive()) {
                grid.setContainsPlayer(false);
            }
            else {
                grid.setContainsEnemy(false);
            }
        }
        // Checking for NPC
        if(grid.isContainsNPC()) {
            System.out.println("NPC Dialogue");
        }
        // Checking for SHOP
        else if(grid.isContainsShop()) {
            GameMessages.printShopKeeper();
            if(player.getCurrentGold() < 1000000) {
                System.out.println("Shopkeeper: Hey there you! Yes you!! Come take a look you might find things you need...");
                System.out.println("Shopkeeper: Wait a minute... You have no gold..");
                System.out.println("*They close up shop...*");
            }
            else {
                System.out.println("Shopkeeper: Come here take a look at me items");
            }
        }
        else {
            System.out.println("Just another empty dungeon cell..");
        }
    }
}