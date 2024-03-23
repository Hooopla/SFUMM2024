package Game.Model.map;
import Game.Model.map.Room;

import java.util.Arrays;

public class Map {
    private Room[][] grid;
    private final int width;
    private final int height;

    private int playerXCoordinate;
    private int playerYCoordinate;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
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
        grid[1][4].setExplorable(true);
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

    public boolean inBounds() {
        return playerXCoordinate >= 0 && playerXCoordinate < width && playerYCoordinate >= 0 && playerYCoordinate < height;
    }

    public static void main(String[] args) {
        Map dungeonMap = new Map(10, 10); // Create a 10x10 map
        dungeonMap.printMap();
    }
}
