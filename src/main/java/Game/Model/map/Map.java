package Game.Model.map;

import Game.Model.enemy.baseEnemy;

import java.util.Arrays;

public class Map {
    private char[][] grid;
    private int playerX;
    private int playerY;
    private final int width;
    private final int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new char[height][width];
        initializeMap();
        placePlayer();
    }

    private void initializeMap() {
        for (char[] row : grid) {
            Arrays.fill(row, '.'); // Initialize all cells with '.'
        }
        // Place obstacles or special tiles on the map as needed
        alphaMap();
    }

    private void alphaMap() {
        grid[0][4] = 'X';
        grid[1][4] = 'X';
        grid[2][4] = 'X';
        grid[3][4] = 'X';
        grid[4][4] = 'X';
        grid[5][4] = 'X';
        grid[6][4] = 'X';
        grid[7][4] = 'X';
        grid[8][4] = 'X';
        grid[9][4] = 'X';
    }

    private void placePlayer() {
        playerX = 4;
        playerY = 0;
        grid[playerY][playerX] = 'P'; // Place player at the starting position
    }
    private void getPlayerLocation() {
        System.out.println("X:" + playerX + " Y:" + playerY);
    }

    public void printMap() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void moveLeft() {
        if (playerX > 0) {
            grid[playerY][playerX] = '.'; // Clear current player position
            playerX--;
            grid[playerY][playerX] = 'P'; // Place player at new position
        } else {
            System.out.println("Cannot move left. Reached the edge of the map.");
        }
    }

    public void moveRight() {
        if (playerX < width - 1) {
            grid[playerY][playerX] = '.'; // Clear current player position
            playerX++;
            grid[playerY][playerX] = 'P'; // Place player at new position
        } else {
            System.out.println("Cannot move right. Reached the edge of the map.");
        }
    }

    public void moveForward() {
        if (inBounds()) {
            grid[playerY][playerX] = '.'; // Clear current player position
            playerY++;
            grid[playerY][playerX] = 'P'; // Place player at new position
        } else {
            System.out.println("Cannot move forward. Reached the edge of the map.");
        }
    }

    public boolean inBounds() {
        return playerX >= 0 && playerX < width && playerY >= 0 && playerY < height;
    }



    public static void main(String[] args) {
        Map dungeonMap = new Map(10, 10); // Create a 10x10 map
    }
}
