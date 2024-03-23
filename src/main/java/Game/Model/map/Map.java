package Game.Model.map;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;

public class Map {
    private Room[][] grid;
    private final int width;
    private final int height;

    // Player Tracker
    character player;
    private int playerXCoordinate;
    private int playerYCoordinate;

    // Player Last Location Tracker
    private int lastPlayerXCoordinate;
    private int lastPlayerYCoordinate;

    public Map(int width, int height, character player) {
        this.width = width;
        this.height = height;
        this.player = player;
        grid = new Room[height][width];
        initializeMap();
        placePlayer();
    }

    private void initializeMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Room(); // Initialize all cells with Room objects
            }
        }
        // Place obstacles or special tiles on the map as needed
        alphaMap();
    }

    private void alphaMap() {
        // Example of setting attributes for specific rooms
        grid[0][4].setExplorable(true);
        // THIS IS A ROOM THAT WILL HAVE AN ENEMY FOR NOW FOR TESTING LOL
        grid[1][4].setExplorable(true);
        baseEnemy angrySkeleton = new baseEnemy("Savage Skeleton", "=== Angry Ratting ===", 40, 10, 5, 5);
        grid[1][4].setEnemyInRoom(angrySkeleton);

        grid[2][4].setExplorable(true);
        grid[3][4].setExplorable(true);
        grid[4][4].setExplorable(true);
        grid[5][4].setExplorable(true);
        grid[6][4].setExplorable(true);
        grid[7][4].setExplorable(true);
        grid[8][4].setExplorable(true);
    }

    private void placePlayer() {
        playerXCoordinate = 4;
        playerYCoordinate = 0;
        lastPlayerXCoordinate = -1;
        lastPlayerYCoordinate = -1;
        grid[0][4].setPlayerInRoom(true);

    }

    public void printMap() {
        for (Room[] row : grid) {
            for (Room room : row) {
                // Print symbols based on room attributes
                if (room.isExit()) {
                    System.out.print("X ");
                }
                else if(room.isPlayerInRoom()) {
                    System.out.print("P ");
                }
                else if (room.isExplorable()) {
                    System.out.print("E ");
                }
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void moveForward() {
        if (inBounds()) {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false); // Clear current player position
            playerYCoordinate++;
            if (grid[playerYCoordinate][playerXCoordinate].isExplorable()) {
                grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true); // Place player at new position
                if(grid[playerYCoordinate][playerXCoordinate].hasEnemyInRoom()) {
                    enemyEncounter(grid[playerYCoordinate][playerXCoordinate]);
                }
            }
            else {
                playerYCoordinate--;
                System.out.println("Ouch I just hit my head on the wall...");
                grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true);
            }
        } else {
            System.out.println("Cannot move forward. Reached the edge of the map.");
        }
    }

    public void moveLeft() {
        if (playerXCoordinate > 0) {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false); // Clear current player position
            playerXCoordinate--;
            if (grid[playerYCoordinate][playerXCoordinate].isExplorable()) {
                grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true); // Place player at new position
            } else {
                playerXCoordinate++;
                System.out.println("Ouch, I just bumped into a wall.");
                grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true);
            }
        } else {
            System.out.println("Cannot move left. Reached the edge of the map.");
        }
    }

    public void moveRight() {
        if (playerXCoordinate < width - 1) {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false); // Clear current player position
            playerXCoordinate++;
            if (grid[playerYCoordinate][playerXCoordinate].isExplorable()) {
                grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true); // Place player at new position
            } else {
                playerXCoordinate--;
                System.out.println("Ouch, I just bumped into a wall.");
                grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true);
            }
        } else {
            System.out.println("Cannot move right. Reached the edge of the map.");
        }
    }

    public void moveBackwards() {
        if (lastPlayerXCoordinate == -1 && lastPlayerYCoordinate == -1) {
            System.out.println("Ouch I just hit the back of my head.");
        }
        else {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false); // Clear current player position
            grid[lastPlayerYCoordinate][lastPlayerXCoordinate].setPlayerInRoom(true);
            System.out.println("Look at me I walked backwards");
        }

    }

    public void enemyEncounter(Room grid) {
        baseEnemy currentEnemy = grid.getEnemyInRoom();
        currentEnemy.sayEnemyIntro();
    }

    public boolean inBounds() {
        return playerXCoordinate >= 0 && playerXCoordinate < width && playerYCoordinate >= 0 && playerYCoordinate < height;
    }
}
