package code;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Lose_Dragon_img extends GameObject{
    
    
    public Lose_Dragon_img(GameFrame gameFrame){
        super(gameFrame);
        setImg("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\dragon2.png");
        setX(720);
        setY(310);
    }
  
    public Rectangle getRec() {
        return new Rectangle(getX(), getY(), 0, 0);
    }

    public void paintSelf(Graphics g) {
        g.drawImage(getImg(), getX(), getY(), null);
    }
    
}