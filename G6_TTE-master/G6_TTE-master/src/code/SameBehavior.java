
package code;


abstract class SameBehavior {
    
    int AP;
    double Crit;
    double Accu;
    
    public abstract int getAP();
    public abstract double getCrit();
    public abstract double getAccu();
    public abstract void upgAP();
    public abstract void upgCrit();
    public abstract boolean hit();
    
    
}
