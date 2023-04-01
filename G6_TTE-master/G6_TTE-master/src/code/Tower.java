
package code;

import java.util.Random;


public class Tower extends SameBehavior{
    
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    
    //declare initial value for Tower
    private final int initialAP = 7;
    private final double initialCrit = 0.1;
    private final double initialAccu = 0.8;
    
    final double maxCrit = 0.5;
    final double maxAccu = 1.0;

    static int AP;
    static double Crit;
    static double Accu;
    
    public Tower() {
        AP = initialAP;
        Crit = initialCrit;
        Accu = initialAccu;
    }
    
    public void setAP(int AP) {
        Tower.AP = AP;
    }

    public void setCrit(double Crit) {
        Tower.Crit = Crit;
    }
    
    public void setAccu(double Accu) {
        Tower.Accu = Accu;
    }
    
    @Override
    public int getAP() {
        return AP;
    }

    @Override
    public void upgAP() {
        Tax.chgGold(-100);
        Tower.AP += 1;
    }

    @Override
    public double getCrit() {
        return Crit;
    }

    @Override
    public void upgCrit() {
        if (Tower.Crit <= maxCrit-0.05){
            Tax.chgGold(-100);
            Tower.Crit += 0.05;
        }
        else
            System.out.println(TEXT_YELLOW + "\nYour tower already have max Critical Chance!" + TEXT_RESET);
    }

    @Override
    public double getAccu() {
        return Accu;
    }

    public void upgAccu() {
        if (Tower.Accu <= maxAccu-0.039999){
            Tax.chgGold(-100);
            Tower.Accu += 0.04;
        }
        else
            System.out.println(TEXT_YELLOW + "\nYour tower already have max Accuracy Chance!" + TEXT_RESET);
    }
    
    public void upgAccu(double n) {
    if (Tower.Accu <= maxAccu){
        Tower.Accu += n;
    }
    else
        System.out.println(TEXT_YELLOW + "\nYour tower already have max Accuracy Chance!" + TEXT_RESET);
    }
  
    public void RandomEvent(double n) {
        Tower.Accu += n;
    }
    
    public void Learning() {
        Tower.Crit += 0.05;
    }

    public void Status() {
        System.out.printf("Tower's AttackPoint : %d \n",AP);
        System.out.printf("Tower's Critical Chance : %.2f %% \n",Crit*100);
        System.out.printf("Tower's Accuracy : %.2f %% \n",Accu*100);
        System.out.println("");
    }

    //tower hit/not hit dragon 
    @Override
    public boolean hit(){
    double AccuracyPercentage = Accu;
    Random a = new Random();
    boolean accuracy = a.nextDouble() <= AccuracyPercentage;
        return accuracy;
    }

    @Override
    public String toString() {
        String str = "Tower's AttackPoint : "+AP;
        str += "\nTower's Critical Chance : "+Crit*100+"%";
        str += "\nTower's Accuracy : "+Accu*100+"%";
        return str;
    }

}
