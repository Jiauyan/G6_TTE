package code;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Background extends GameObject{
    public Background(GameFrame gameFrame){
        super(gameFrame);
    }
    Image bg = Toolkit.getDefaultToolkit().getImage("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\Spring.jpg");
    
    public void paintSelf(Graphics g){
        g.drawImage(bg, 0, 0, null);
    }

    
    public Rectangle getRec() {
       return null;
    }
}
