package code;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Tower_img extends GameObject{
    
    public Tower_img(GameFrame gameFrame){
        super(gameFrame);
        setImg("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\tower.png");
        setX(0);
        setY(310);
    }
    
    public Rectangle getRec() {
        return new Rectangle(getX(), getY(), 0, 0);
    }

    public void paintSelf(Graphics g) {
        g.drawImage(getImg(), getX(), getY(), null);
    }
    
}