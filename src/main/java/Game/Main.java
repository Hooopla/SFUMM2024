package Game;

import Game.Model.enemy.baseEnemy;
//import Game.Model.enemy.regularSkeleton;

public class Main {
        public static void main(String[] args) {
                baseEnemy angrySkeleton = new baseEnemy("Skeleton", "=== Angry Ratting ===", 40, 10, 5);
                angrySkeleton.printEnemyIntro();

                baseEnemy swoleSkeleton = new baseEnemy("Skeleton", "=== Thicc Rattling ===", 50, 15, 7);
                angrySkeleton.printEnemyInfo();
                angrySkeleton.printEnemyIntro();

                swoleSkeleton.printEnemyInfo();
                swoleSkeleton.printEnemyIntro();
                //Boss Asylumd = new Boss("");
                swoleSkeleton.printEnemyIntro();
        }
}