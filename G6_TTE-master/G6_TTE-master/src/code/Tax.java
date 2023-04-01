package code;

import java.util.Random;

public class Tax {
    private static int Gold;
    private static int Tax;

    public Tax(){
        Gold = 200;
    } 
    
    public static int getRandomTax(){
        int[] a = {200,250,300,350,400};
        Random r = new Random();
        Tax = a[r.nextInt(a.length)];
        return Tax;
    }
    
    public static void calcGold() {
            Gold += Tax;
    }
    
    public void setGold(int Gold) {
        this.Gold = Gold;
    }

    public void setTax(int Tax) {
        this.Tax = Tax;
    }
    
    public int getGold() {
        return Gold;
    }
    
    //tower and wall upg -100 , citizen upg -50
    public static void chgGold(int GoldValueChange) {
        Gold += GoldValueChange;
    }
   
    
    public void RandomEvent(){
        Gold += 100;
    }
    
    public void Crime(){
        Gold -= Gold;
    }
    
    public void Travelling(){
        Gold *= 0.5;
    }

}
