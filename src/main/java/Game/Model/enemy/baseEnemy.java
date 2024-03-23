package Game.Model.enemy;

public class baseEnemy {
    private int hp;
    private int mana;
    private String name;

    public baseEnemy(){
        this.hp = 20;
        this.mana = 20;
        this.name = "chicken";
    }

    public baseEnemy(int hp, int mana, String name){
        this.hp = hp;
        this.mana = mana;
        this.name = name;
    }
    public int getHp(){
        return this.hp;
    }
    public int getMana(){
        return this.mana;
    }

    public String getName(){
        return this.name;
    }

    public void setHp(int hp){
        this.hp = hp;
    }
    public void setMana(int mana){
        this.mana = mana;
    }

    public void setName(String name){
        this.name = name;
    }
    public void printAllValues(){
        System.out.println(hp + " " + mana + " " + name) ;
    }
}
