package Game.Model.enemy;

public class baseEnemy {
    private String name;
    private int hp;
    private int attPower;
    private int goldDrop;
    private int expDrop;
    private String enemyIntro;

    public baseEnemy(String name, String enemyIntro, int hp, int attPower, int goldDrop, int expDrop){
        this.name = name;
        this.enemyIntro = enemyIntro;
        this.hp = hp;
        this.attPower = attPower;
        this.goldDrop = goldDrop;
        this.expDrop = expDrop;
    }

    //setter?
    public String getName(){
        return this.name;
    }
    public void sayEnemyIntro(){
        System.out.println(this.enemyIntro);
    }
    public int getHp(){
        return this.hp;
    }
    public int getAttPower(){
        return this.attPower;
    }
    public int getGoldDrop(){
        return this.goldDrop;
    }
    public int getExp() {
        return this.expDrop;
    }

    //getter?
    public void setName(String name){
        this.name = name;
    }

    public void setEnemyIntro(String enemyIntro){
        this.enemyIntro = enemyIntro;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setAttPower(int attPower){
        this.attPower = attPower;
    }
    public void setGoldDrop(int goldDrop){
        this.goldDrop = goldDrop;
    }
    public void setExpDrop(int expDrop){
        this.expDrop = expDrop;
    }

    public void printEnemyInfo(){
        System.out.println(name + " with Hp of " + hp + " and attack power of " + attPower + " that has " + goldDrop + " dollars and drops " + expDrop + " exp.");
    }
    public void printEnemyIntro() {
        System.out.println(enemyIntro);
    }
}
