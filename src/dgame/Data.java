
package dgame;

import java.util.Random;

public class Data {
    Random rand = new Random();
    //Game Variable
    int attackDamage = 50;
    int enemyAttackDamage = 25;


    //Player Data
   public static String Name;
   public int health = 100;
   public final int maxhealth = 100;
   int numHealthPotions = 3;
   public static int attack ;
   public static int kills ;
   int healthPotionHealAmount = 30;
   
   //Enemy Details
    public String[] enemyName = { "Skeliton","Zombie","Assassin","Warrior"};
    int maxEnemyHealth = 100;
    
    public static int healthPotionDropChance;
    public int enemyHealth;
    public String enemy;

    public void selectEnemy(){
        enemyHealth = rand.nextInt(maxEnemyHealth);
        enemy= enemyName[rand.nextInt(enemyName.length)];
    }



}
