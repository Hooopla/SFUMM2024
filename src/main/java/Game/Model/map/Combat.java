package Game.Model.map;
import Game.Model.enemy.baseEnemy;
import Game.Model.player.character;
import Game.Model.map.Room;

import java.util.Scanner;


public class Combat {
    baseEnemy enemy;
    character player;
    int damage;
    public Combat(baseEnemy enemy123, character player) {
        enemy = enemy123;
        this.player = player;
}
    //while in combat
    public void startFight() {
        enemy.printEnemyInfo();
        while (enemy.getHp() > 0 || player.getHealthPoints() > 0){
            //print status
            Scanner action = new Scanner(System.in);
            System.out.println("What is your move? \n" + "| Attack |\t" + "| Bag |\t");
            String command = action.nextLine().trim().toLowerCase();

            if(command.equals("attack")){
                //damage calc shit thingy
                System.out.println("You attacked the " + enemy.getName());
                //damage = enemy.getHp() - player.getAttPoints();
                enemy.setHp(enemy.getHp() - player.getAttPoints());
                enemy.printEnemyInfo();
            }
            else if(command.equals("bag")){
                //open bag thingy
                System.out.println("You opened your bag");
            }
            else{
                System.out.println("Try again bozo");
            }

        }

    }
    //print hud(enemy stats, your stats)
}
