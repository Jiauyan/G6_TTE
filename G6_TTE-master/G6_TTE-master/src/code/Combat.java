
package code;

import java.util.Random;

public class Combat {
    
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    
    private boolean win;
    private boolean lose;
    
    public Combat() {
        win = false;
        lose = false;
    }
    
    Tower tw = new Tower();
    Dragon dg = new Dragon();
    Wall w = new Wall();    

    //calculate the damage done to dragon by tower
    public void TowerAttack(){
        Random rd = new Random();
        double dmg;
        boolean crit;
        System.out.println("");
        //if tower hit dragon
        if (tw.hit()==true) {
            //determine whether tower does critical damage to dragon or not
            crit = rd.nextDouble() <= tw.getCrit();
            //if tower does critical damage, calculate critical damage
            if (crit == true) {
                dmg = tw.getAP()*1.5;
                System.out.println(TEXT_GREEN + "Tower attacked dragon with critical attack!" + TEXT_RESET);
                System.out.println(TEXT_GREEN + "Dragon's HealthPoint minus "+(int)dmg + TEXT_RESET);
                dg.minusHP((int)dmg);
                System.out.println("Current Dragon's Healthpoint: "+dg.getHP());
            }
            else {
                dmg = tw.getAP();
                System.out.println("Tower attacked dragon!");
                System.out.println("Dragon's HealthPoint minus "+(int)dmg);
                dg.minusHP((int)dmg);
                System.out.println("Current Dragon's Healthpoint: "+dg.getHP());
            }
        }
        //if tower miss
        else {
            System.out.println(TEXT_RED + "Tower missed the attack!" + TEXT_RESET);
            System.out.println(TEXT_RED + "Dragon's HealthPoint minus 0" + TEXT_RESET);
            System.out.println("Current Dragon's Healthpoint: "+dg.getHP());      
        }
    }

    
    //calculate the damage done to wall by dragon
    public void DragonAttack() {
        Random rd = new Random();
        double dmg;
        boolean crit;
        System.out.println("");
        //if dragon hit tower
        if (dg.hit()==true) {
            //if wall didnt block the dmg from dragon
            if (w.block()==false) {
                //determine whether dragon does critical damage to wall or not
                crit = rd.nextDouble() <= dg.Crit;
                //if tower does critical damage, calculate critical damage
                if (crit == true) {
                    dmg = dg.getAP()*1.5;
                    System.out.println(TEXT_RED + "Dragon attacked our wall with critical attack!" + TEXT_RESET);
                    System.out.println(TEXT_RED + "Wall's HealthPoint minus "+(int)dmg + TEXT_RESET);
                    w.minusHP((int)dmg);
                    System.out.println("Current Wall's Healthpoint: "+w.getHP());
                }
                else {
                    dmg = dg.getAP();
                    System.out.println("Dragon attacked our wall!");
                    System.out.println("Wall's HealthPoint minus "+(int)dmg);
                    w.minusHP((int)dmg);
                    System.out.println("Current Wall's Healthpoint: "+w.getHP());
                }
            }
            else {
                System.out.println(TEXT_GREEN + "Wall successfully blocked dragon's attack!" + TEXT_RESET);
                System.out.println(TEXT_GREEN +"Wall's HealthPoint minus 0" + TEXT_RESET);
                System.out.println("Current Wall's Healthpoint: "+w.getHP());
            }
        }
        else {
            System.out.println(TEXT_GREEN + "Dragon missed the attack!" + TEXT_RESET);
            System.out.println(TEXT_GREEN + "Wall's HealthPoint minus 0" + TEXT_RESET);
            System.out.println("Current Wall's Healthpoint: "+w.getHP()); 
        }
    }
    
    
    //Check win and lose condition
    //should perform condition check after each round
    
    //Win condition
    public static boolean Win(int dragonHP) {
        if (dragonHP <= 0) {
            return true;
        }
        else 
            return false;
    }
    
    //Lose condition
    //need to add exception for flood event case(health<=0 not losing yet)
    public static boolean Lose(int wallHP) {
        if (wallHP <= 0 && Events.flooded==false && Events.droughtiness==false) {
            return true;
        }
        else
            return false;
    }
    
    //Condition check method
    //check whether win or lose -> return true
    public boolean EndGame () {
        if (Win(dg.getHP())==true || Lose(w.getHP())==true) 
            return true;
        else
            return false;  
    }
    
}
