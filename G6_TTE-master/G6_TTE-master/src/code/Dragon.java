
package code;

import java.util.Random;

public class Dragon extends SameBehavior{
 
    //initial value for Dragon
    private final int initialHP = 100;
    private final int initialMaxHP = 100;
    private final int initialAP = 7;
    private final int initialLevel = 1;
    private final double initialCrit = 0.2;

    private final double maxCrit = 1.0;
    private final double initialAccu = 0.8;

    private static int HP;
    private static int maxHP;
    private static int AP;
    private static int Level;
    static double Crit = 0.2;
    static double Accu = 0.8;
    
    public Dragon(){
        Level = initialLevel;
        AP = initialAP ;
        HP = initialHP;
        maxHP = initialMaxHP;
        Crit = initialCrit;
        Accu = initialAccu;
    }

    public void setAP(int AP) {
        Dragon.AP = AP;
    }

    public void setCrit(double Crit) {
        Dragon.Crit = Crit;
    }

    public static void setAccu(double Accu) {
        Dragon.Accu = Accu;
    }

    public void setLevel(int Level) {
        Dragon.Level = Level;
    }
    
    @Override
    public int getAP() {
        return AP;
    }

    public int getLevel() {
        return Level;
    }

    public int getHP() {
        return HP ;
    }

    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public double getCrit() {
        return Crit;
    }

    @Override
    public double getAccu() {
        return Accu;
    }  
    
    public int minusHP(int dmg) {
    return HP -= dmg ;
    }
    

    public void setHP(int HP) {
        Dragon.HP = HP;
    }

    
    public void upgDragonLevel() {
        Level++;
        upgHP();
        upgAP();
        upgCrit();
    }
    
    public void upgHP() {
        maxHP += 15;
    }
    
    @Override
    public void upgAP() {
        AP++;
    }
    
    @Override
    public void upgCrit() {
        if (Crit <= maxCrit){
            Crit += 0.02;
        }
        else
            ;
    }
    
    public void Wishes() {
        HP *= 0.75;
    }
    
    public void Pandemic() {
        AP += 3;
    }
    
    public void Mutation() {
        AP -= 4;
        Crit -= 0.08;
    }
    
    public void Status() {
        System.out.printf("Dragon's Level : %d \n",Level);
        System.out.printf("Dragon's HealthPoint : %d \n",HP);
        System.out.printf("Dragon's AttackPoint : %d \n",AP);
        System.out.printf("Dragon's Critical Chance : %.2f %% \n",Crit*100);
        System.out.printf("Dragon's Accuracy Chance : %.2f %% \n",Accu*100);
    }
    
    //dragon hit/not hit wall
    @Override
    public boolean hit(){
    double AccuracyPercentage = Accu;
    Random a = new Random();
    boolean accuracy = a.nextDouble() <= AccuracyPercentage;
        return accuracy;
    }
 
}
