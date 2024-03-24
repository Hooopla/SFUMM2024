package Game.Model.map;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;

import java.util.LinkedList;
import java.util.List;

public class Map {
    private Room[][] grid;
    private final int width;
    private final int height;

    private travellingShop Aurelia = new travellingShop();

    // Player Tracker
    character player;
    private int playerXCoordinate;
    private int playerYCoordinate;

    // Player Last Location Tracker
    private List<Integer> lastPlayerYCoordinate = new LinkedList<Integer>();
    private List<Integer> lastPlayerXCoordinate = new LinkedList<Integer>();

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
        // STARTING ROOM
        grid[0][4].setExplorable(true);


        // THIS IS A ROOM THAT WILL HAVE AN ENEMY FOR NOW FOR TESTING LOL
        grid[1][4].setExplorable(true);
        baseEnemy angrySkeleton = new baseEnemy("Savage Skeleton", "=== Angry Ratting ===", 40, 10, 5, 5);
        grid[1][4].setEnemyInRoom(angrySkeleton);
        // We meet Aurelia
        grid[2][4].setExplorable(true);
        grid[2][4].setShopkeeper(Aurelia);
        //
        grid[3][4].setExplorable(true);
        //
        grid[4][4].setExplorable(true);
        //
        grid[5][4].setExplorable(true);
        //
        grid[6][4].setExplorable(true);
        //
        grid[7][4].setExplorable(true);
        //
        grid[1][5].setExplorable(true);
        grid[1][6].setExplorable(true);
        grid[1][7].setExplorable(true);

        //
        grid[1][3].setExplorable(true);
        grid[1][2].setExplorable(true);
        grid[1][1].setExplorable(true);
        grid[1][0].setExplorable(true);
        grid[0][0].setExplorable(true);


        //
        grid[5][3].setExplorable(true);
        grid[5][2].setExplorable(true);
        grid[5][1].setExplorable(true);
        grid[4][1].setExplorable(true);
        grid[3][1].setExplorable(true);

        //
        grid[6][5].setExplorable(true);
        grid[6][6].setExplorable(true);
        grid[5][6].setExplorable(true);
        grid[4][6].setExplorable(true);

        //
        grid[7][3].setExplorable(true);
        grid[7][2].setExplorable(true);
        grid[7][1].setExplorable(true);
        grid[7][0].setExplorable(true);

        //

        //

    }

    private void placePlayer() {
        playerXCoordinate = 4;
        playerYCoordinate = 0;
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
        if (!inBounds()) {
            System.out.println("Cannot move forward. Reached the edge of the map.");
            return;
        }

        grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false);
        lastPlayerYCoordinate.add(playerYCoordinate);
        lastPlayerXCoordinate.add(playerXCoordinate);
        playerYCoordinate++;

        Room currentRoom = grid[playerYCoordinate][playerXCoordinate];
        if (currentRoom.isExplorable()) {
            currentRoom.setPlayerInRoom(true);

            if (currentRoom.hasEnemyInRoom()) {
                enemyEncounter(currentRoom);
            } else if (currentRoom.isTravellingShop()) {
                shopEncounter(currentRoom);
            } else if (currentRoom.isExit()) {
                // Handle exit logic here
            }
        } else {
            lastPlayerXCoordinate.remove(playerXCoordinate);
            lastPlayerYCoordinate.remove(playerYCoordinate);
            playerYCoordinate--;
            System.out.println("Ouch! I just hit my head on the wall...");
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true);
        }
    }

    public void moveLeft() {
        if (!inBounds() || playerXCoordinate <= 0) {
            System.out.println("Cannot move left. Reached the edge of the map.");
            return;
        }

        grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false); // Clear current player position
        lastPlayerYCoordinate.add(playerYCoordinate);
        lastPlayerXCoordinate.add(playerXCoordinate);
        playerXCoordinate--;

        if (grid[playerYCoordinate][playerXCoordinate].isExplorable()) {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true); // Place player at new position
        } else {
            lastPlayerXCoordinate.remove(playerXCoordinate);
            lastPlayerYCoordinate.remove(playerYCoordinate);
            playerXCoordinate++;
            System.out.println("Ouch, I just bumped into a wall.");
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true);
        }
    }
    public void moveRight() {
        if (!inBounds() || playerXCoordinate >= width - 1) {
            System.out.println("Cannot move right. Reached the edge of the map.");
            return;
        }

        grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false); // Clear current player position
        lastPlayerYCoordinate.add(playerYCoordinate);
        lastPlayerXCoordinate.add(playerXCoordinate);

        playerXCoordinate++;

        if (grid[playerYCoordinate][playerXCoordinate].isExplorable()) {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true); // Place player at new position
        } else {
            lastPlayerXCoordinate.remove(playerXCoordinate);
            lastPlayerYCoordinate.remove(playerYCoordinate);
            playerXCoordinate--;
            System.out.println("Ouch, I just bumped into a wall.");
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true);
        }
    }

    public void moveBackwards() {
        grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(false);
        playerXCoordinate = lastPlayerXCoordinate.removeLast();
        playerYCoordinate = lastPlayerYCoordinate.removeLast();
        if (grid[playerYCoordinate][playerXCoordinate].isExplorable()) {
            grid[playerYCoordinate][playerXCoordinate].setPlayerInRoom(true); // Place player at new position
        }
    }

    public boolean inBounds() {
        return playerXCoordinate >= 0 && playerXCoordinate < width && playerYCoordinate >= 0 && playerYCoordinate < height;
    }

    public void enemyEncounter(Room grid) {
        baseEnemy currentEnemy = grid.getEnemyInRoom();
        currentEnemy.sayEnemyIntro();
    }

    public void shopEncounter(Room grid) {
        // The first time we meet her
        travellingShop Aurelia = grid.getShopkeeper();
        grid.setHasTravellingShop(false);
        Aurelia.converse();
        Aurelia.runsOffVoiceLine();
    }
}
