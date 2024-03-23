package Game.Model.map;

public class Room {
    private boolean isExit;
    private boolean isExplorable;

    private boolean isPlayerInRoom;

    public Room() {
        this.isExit = false;
        this.isExplorable = false;
        this.isPlayerInRoom = false;
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

    public void setExit(boolean condition) {
        isExit = condition;
    }

    public void setExplorable(boolean condition) {
        isExplorable = condition;
    }

    public void setPlayerInRoom(boolean condition) {
        isPlayerInRoom = condition;
    }


    // Other methods as needed
}