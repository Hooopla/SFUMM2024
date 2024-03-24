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
    private boolean containsMiniBoss;
    private boolean containsFinalBoss;
    private boolean containsShop;
    private boolean locked;

    private NPC npc;

    public Room() {
        containsExit = false;
        containsExplorable = false;
        containsPlayer = false;
        containsEnemy = false;
        containsSafeZone = false;
        containsNPC = false;
        containsMiniBoss = false;
        containsFinalBoss = false;
        containsShop = false;
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isContainsShop() {
        return containsShop;
    }

    public void setContainsShop(boolean containsShop) {
        this.containsShop = containsShop;
    }

    public boolean isContainsFinalBoss() {
        return containsFinalBoss;
    }

    public void setContainsFinalBoss(boolean containsFinalBoss) {
        this.containsFinalBoss = containsFinalBoss;
    }

    public boolean isContainsMiniBoss() {
        return containsMiniBoss;
    }

    public void setContainsMiniBoss(boolean containsMiniBoss) {
        this.containsMiniBoss = containsMiniBoss;
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

    public void setContainsEnemy(boolean containsEnemy) {
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