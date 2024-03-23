package Game.Model.map;

import Game.Model.enemy.baseEnemy;

public class Room {
    private boolean isExit;
    private boolean isExplorable;
    private boolean isPlayerInRoom;
    private baseEnemy enemyInRoom;
    private boolean hasEnemyInRoom;

    public Room() {
        this.isExit = false;
        this.isExplorable = false;
        this.isPlayerInRoom = false;
        this.hasEnemyInRoom = false;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public boolean isExplorable() {
        return this.isExplorable;
    }

    public boolean isPlayerInRoom() {
        return isPlayerInRoom;
    }

    public boolean hasEnemyInRoom() {
        return hasEnemyInRoom;
    }

    public baseEnemy getEnemyInRoom() {
        return enemyInRoom;
    }

    public void setExit(boolean condition) {
        isExit = condition;
    }

    public void setExplorable(boolean condition) {
        isExplorable = condition;
    }

    public void setPlayerInRoom(boolean condition) {
        isPlayerInRoom = condition;
    }

    public void setEnemyInRoom(baseEnemy enemyInRoom) {
        this.enemyInRoom = enemyInRoom;
        hasEnemyInRoom = true;
    }

    // Other methods as needed
}