package code;

public class Citizen{
    
    private static int Emotional,Nervous,Lazy,Berserk,Diligent,Fearless;
    private final int initialEmotional=10;
    private final int initialNervous=10;
    private final int initialLazy=10;
    private final int initialBerserk=10;
    private final int initialDiligent=10;
    private final int initialFearless=10;
     
    public Citizen() {
        Emotional = initialEmotional;
        Nervous = initialNervous;
        Lazy = initialLazy;
        Berserk = initialBerserk;
        Diligent = initialDiligent;
        Fearless = initialFearless;
    }

    public void setEmotional(int Emotional) {
        this.Emotional = Emotional;
    }

    public void setNervous(int Nervous) {
        Citizen.Nervous = Nervous;
    }

    public void setLazy(int Lazy) {
        Citizen.Lazy = Lazy;
    }

    public void setBerserk(int Berserk) {
        Citizen.Berserk = Berserk;
    }

    public void setDiligent(int Diligent) {
        Citizen.Diligent = Diligent;
    }

    public void setFearless(int Fearless) {
        Citizen.Fearless = Fearless;
    }
    
    public void chgEmotional(int value_change){
        if (Emotional > 0) {
            Tax.chgGold(-50);
            Emotional += value_change;
        }
        else
            System.out.println("\nYou can't decreased Citizen's Emotional any more!");
        if (Emotional <= 0)
            Emotional = 0;
        CheckCondition();
    }

    public void chgNervous(int value_change){
        if (Nervous > 0) {
            Tax.chgGold(-50);
            Nervous += value_change;
        }
        else
            System.out.println("\nYou can't decreased Citizen's Nervous any more!");
        if (Nervous <= 0)
        Nervous = 0;
        CheckCondition();
    }

    public void chgLazy(int value_change){
        if (Lazy > 0) {
            Tax.chgGold(-50);
            Lazy += value_change;
        }
        else
            System.out.println("\nYou can't decreased Citizen's Lazy any more!");
        if (Lazy <= 0)
        Lazy = 0;
        CheckCondition();
    }

    public void chgBerserk(int value_change){
        Tax.chgGold(-50);
        Berserk += value_change;
        CheckCondition();
    }

    public void chgDiligent(int value_change){
        Tax.chgGold(-50);
        Diligent += value_change;
        CheckCondition();
    }

    public void chgFearless(int value_change){
        Tax.chgGold(-50);
        Fearless += value_change;
        CheckCondition();
    }

    public void randomChgEmotional(int value_change){
        if (Emotional > 0) {
            Emotional += value_change;
        }
        else
            System.out.println("\nYou can't decreased Citizen's Emotional any more!");
        if (Emotional <= 0)
            Emotional = 0;
        CheckCondition();
    }

    public void randomChgNervous(int value_change){
        if (Nervous > 0) {
            Nervous += value_change;
        }
        else
            System.out.println("\nYou can't decreased Citizen's Nervous any more!");
        if (Nervous <= 0)
        Nervous = 0;
        CheckCondition();
    }

    public void randomChgLazy(int value_change){
        if (Lazy > 0) {
            Lazy += value_change;
        }
        else
            System.out.println("\nYou can't decreased Citizen's Lazy any more!");
        if (Lazy <= 0)
        Lazy = 0;
        CheckCondition();
    }

    public void randomChgBerserk(int value_change){
        Berserk += value_change;
        CheckCondition();
    }

    public void randomChgDiligent(int value_change){
        Diligent += value_change;
        CheckCondition();
    }

    public void randomChgFearless(int value_change){
        Fearless += value_change;
        CheckCondition();
    }
    
    public static int getEmotional(){
        return Emotional;
    }
    public static int getNervous(){
        return Nervous;
    }
    public static int getLazy(){
        return Lazy;
    }
    public static int getBerserk(){
        return Berserk;
    }
    public static int getDiligent(){
        return Diligent;
    }
    public static int getFearless(){
        return Fearless;
    }
      
    public static void CheckCondition() {
        if(getEmotional()>=100 || getNervous()>=100 || getLazy()>=100 || getBerserk()>=100 || getDiligent()>=100 || getFearless()>=100 ) {
            if(getEmotional()>=100){
            Tower.AP-=1;
            System.out.println("Tower Attack Point decreased by 1");
            Emotional-=100;
            }
            if(getNervous()>=100){
            Tower.Accu-=0.05;
            System.out.println("Tower Accuracy Chance decreased by 5%");
            Nervous-=100;
            }
            if(getLazy()>=100){
            Wall.HP-=100; 
            System.out.println("Wall Health Point decreased by 100");
            Lazy-=100;
            }
            if(getBerserk()>=100){
            Tower.AP+=1;
            System.out.println("Tower Attack Point increased by 1");
            Berserk-=100;
            }
            if(getDiligent()>=100){
            Wall.HP+=75;
            System.out.println("Wall Health Point increased by 75");
            Diligent-=100;
            }
            if(getFearless()>=100){
            Tower.Crit+=0.05;
            System.out.println("Tower Critical Chance increased 5%");
            Fearless-=100;
            }
            
        }
    }
    
}