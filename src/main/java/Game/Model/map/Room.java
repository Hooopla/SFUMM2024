package Game.Model.map;

import Game.Model.enemy.baseEnemy;

public class Room {
    private boolean isExit;
    private boolean isExplorable;
    private boolean isPlayerInRoom;
    private baseEnemy enemyInRoom;
    private boolean hasEnemyInRoom;
    private boolean hasTravellingShop;
    private travellingShop shopkeeper;

    public Room() {
        this.isExit = false;
        this.isExplorable = false;
        this.isPlayerInRoom = false;
        this.hasEnemyInRoom = false;
        this.hasTravellingShop = false;
    }

    // Getters

    public boolean isExplorable() {
        return this.isExplorable;
    }

    public boolean isPlayerInRoom() {
        return isPlayerInRoom;
    }

    public boolean hasEnemyInRoom() {
        return hasEnemyInRoom;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public boolean isTravellingShop() {
        return hasTravellingShop;
    }

    public baseEnemy getEnemyInRoom() {
        return enemyInRoom;
    }

    public travellingShop getShopkeeper() {
        return shopkeeper;
    }

    // Setters
    public void setExit(boolean condition) {
        isExit = condition;
    }

    public void setExplorable(boolean condition) {
        isExplorable = condition;
    }

    public void setPlayerInRoom(boolean condition) {
        isPlayerInRoom = condition;
    }

    public void setHasTravellingShop(boolean condition) {
        this.hasTravellingShop = condition;
    }
    public void setEnemyInRoom(baseEnemy enemyInRoom) {
        this.enemyInRoom = enemyInRoom;
        hasEnemyInRoom = true;
    }

    public void setShopkeeper(travellingShop shopkeeper) {
        this.shopkeeper = shopkeeper;
        this.hasTravellingShop = true;
    }

    // Other methods as needed
}