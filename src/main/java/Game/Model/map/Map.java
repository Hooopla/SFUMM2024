package Game.Model.map;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;

import java.util.LinkedList;
import java.util.List;

public class Map {
    private Room[][] grid;
    private final int width;
    private final int height;

    private NPC Aurelia = new NPC();

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

    private void alphaMap() {
        // Example of setting attributes for specific rooms
        // STARTING ROOM
        grid[0][4].setContainsExplorable(true);


        // THIS IS A ROOM THAT WILL HAVE AN ENEMY FOR NOW FOR TESTING LOL
        grid[1][4].setContainsExplorable(true);
        grid[1][4].setEnemyInRoom(new baseEnemy("Savage Skeleton", "=== Angry Ratting ===", 40, 10, 5));
        // We meet Aurelia
        grid[2][4].setContainsExplorable(true);
        grid[2][4].setNpc(Aurelia);
        //
        grid[3][4].setContainsExplorable(true);
        //
        grid[4][4].setContainsExplorable(true);
        //
        grid[5][4].setContainsExplorable(true);
        //
        grid[6][4].setContainsExplorable(true);
        //
        grid[7][4].setContainsExplorable(true);
        //
        grid[1][5].setContainsExplorable(true);
        grid[1][6].setContainsExplorable(true);
        grid[1][7].setContainsExplorable(true);

        //
        grid[1][3].setContainsExplorable(true);
        grid[1][2].setContainsExplorable(true);
        grid[1][1].setContainsExplorable(true);
        grid[1][0].setContainsExplorable(true);
        grid[0][0].setContainsExplorable(true);


        //
        grid[5][3].setContainsExplorable(true);
        grid[5][2].setContainsExplorable(true);
        grid[5][1].setContainsExplorable(true);
        grid[4][1].setContainsExplorable(true);
        grid[3][1].setContainsExplorable(true);

        //
        grid[6][5].setContainsExplorable(true);
        grid[6][6].setContainsExplorable(true);
        grid[5][6].setContainsExplorable(true);
        grid[4][6].setContainsExplorable(true);

        //
        grid[7][3].setContainsExplorable(true);
        grid[7][2].setContainsExplorable(true);
        grid[7][1].setContainsExplorable(true);
        grid[7][0].setContainsExplorable(true);

        //

        //

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
                return;
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
        // Check for Combat
        if(grid.isContainsEnemy()) {
            // Call the combat Function
            System.out.println("Call combat function");
            Combat BattleSequence = new Combat(grid.getEnemyInRoom(), player);
        }
        else if(grid.isContainsNPC()) {
            //
            System.out.println("NPC Dialogue");
        }
    }
}