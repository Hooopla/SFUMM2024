package Game.Model.map;

import Game.Model.enemy.baseEnemy;

public class Room {
    private boolean containsExit;
    private boolean containsExplorable;
    private boolean containsPlayer;
    private baseEnemy enemyInRoom;
    private boolean containsEnemy;
    private boolean containsSafeZone;
    private boolean containsNPC;

    private NPC npc;

    public Room() {
        containsExit = false;
        containsExplorable = false;
        containsPlayer = false;
        containsEnemy = false;
        containsSafeZone = false;
        containsNPC = false;
    }

    public boolean isContainsExit() {
        return containsExit;
    }

    public void setContainsExit(boolean containsExit) {
        this.containsExit = containsExit;
    }

    public boolean isContainsExplorable() {
        return containsExplorable;
    }

    public void setContainsExplorable(boolean containsExplorable) {
        this.containsExplorable = containsExplorable;
    }

    public boolean isContainsPlayer() {
        return containsPlayer;
    }

    public void setContainsPlayer(boolean containsPlayer) {
        this.containsPlayer = containsPlayer;
    }

    public baseEnemy getEnemyInRoom() {
        return enemyInRoom;
    }

    public void setEnemyInRoom(baseEnemy enemyInRoom) {
        this.enemyInRoom = enemyInRoom;
        setContainsEnemy(true);
    }

    public boolean isContainsEnemy() {
        return containsEnemy;
    }

    private void setContainsEnemy(boolean containsEnemy) {
        this.containsEnemy = containsEnemy;
    }

    public boolean isContainsSafeZone() {
        return containsSafeZone;
    }

    public void setContainsSafeZone(boolean containsSafeZone) {
        this.containsSafeZone = containsSafeZone;
    }

    public boolean isContainsNPC() {
        return containsNPC;
    }

    private void setContainsNPC(boolean containsNPC) {
        this.containsNPC = containsNPC;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
        setContainsNPC(true);
    }
}