package Game.Model.enemy;

public class miniBoss extends baseEnemy{
    public miniBoss(String name, String enemyIntro, int hp, int attPower, int goldDrop) {
        super(name, enemyIntro, hp, attPower, goldDrop);
    }
    private boolean isAggro;
}
