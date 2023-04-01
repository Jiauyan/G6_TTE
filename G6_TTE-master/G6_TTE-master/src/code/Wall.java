
package code;

import java.util.Random;
import java.util.Scanner;

public class Wall {
    
    private final int initialHP = 100;
    private final double initialBlockPercentage = 0.1;
  
    //need method to check whether BlockPercentage is reached 0.5
    private final double maxBlockPercentage = 0.5;
    
    static int HP;
    private static double BlockPercentage;

    public Wall() {
    HP = initialHP;
    BlockPercentage = initialBlockPercentage;
    }
    
    public int getHP() {
        return HP;
    }
    
    public int minusHP(int dmg) {
        return HP -= dmg ;
    }
    
    public void chgHP(int chg) {
        HP += chg;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    
    public void setBlockPercentage(double BlockPercentage) {
        this.BlockPercentage = BlockPercentage;
    }
  
    public double getBlockPercentage() {
        return BlockPercentage;
    }


    public void upgWallHP() {
        Tax.chgGold(-100);
        HP += 75;
    }
    
    public void upgWallBlockPercentage() {
        if (BlockPercentage <= maxBlockPercentage-0.05){
            Tax.chgGold(-100);
            BlockPercentage += 0.05;
        }
        else
            System.out.println("\nYour wall already have max Block Percentage!");
    }

    public void RandomEvent() {
        HP -= 50;
    }
    
    public void Learning() {
        BlockPercentage += 0.05;
    }
    
    //wall block/not block dmg from dragon
    public boolean block(){
    Random a = new Random();
    boolean accuracy = a.nextDouble() <= BlockPercentage;
        return accuracy;
    }

}
