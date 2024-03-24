package Game.Model.enemy;

public class miniBoss extends baseEnemy{
    private String bossOST;
    private String halfHpCry;
    private String defeatMsg;
    private String killPlayerMsg;
    private int maxHp;
    //constructors
    public miniBoss(String name, String enemyIntro, int hp, int attPower, int goldDrop, String bossOST, String halfHpCry, String defeatMsg, String killPlayerMsg) {
        super(name, enemyIntro, hp, attPower, goldDrop);
        this.bossOST = bossOST;
        this.halfHpCry = halfHpCry;
        this.defeatMsg = defeatMsg;
        this.killPlayerMsg = killPlayerMsg;
        this.maxHp = hp;
    }
    //getters

    public int getMaxHp() {
        return maxHp;
    }
    
    public String getBossOST(){
        return bossOST;
    }
    public String getHalfHpCry(){
        return halfHpCry;
    }
    public String getDefeatMsg(){
        return defeatMsg;
    }
    public String getKillPlayerMsg() { return killPlayerMsg;}
    //setters
    public String setBossOST(String bossOst){
        return this.bossOST = bossOst;
    }
    public String setHalfHpCry(String halfHpCry){
        return this.halfHpCry = halfHpCry;
    }
    public String setDefeatMsg(String defeatMsg){
        return this.defeatMsg = defeatMsg;
    }
    public String setKillPlayerMsg(String killPlayerMsg) { return this.killPlayerMsg = killPlayerMsg;}

    //At 50% Hp, the boss will play a message and permanently increase it's attack by 30%
    public void enrage(){
        System.out.println("\n" + getHalfHpCry() + "\n");
        int currentAttPower = getAttPower();
        //type cast currentAttPower to double then *1.3
        double newAttPower = currentAttPower * 1.3;

        //increase the attack
        setAttPower((int)newAttPower);

        System.out.println(getName() + " is enraged!");
    }
}
