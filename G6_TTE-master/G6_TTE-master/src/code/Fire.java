package code;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fire extends GameObject{
    public Fire(GameFrame gameFrame){
        super(gameFrame);
    }
    Image fire1 = Toolkit.getDefaultToolkit().getImage("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\fire 128.png");
    Image fire2 = Toolkit.getDefaultToolkit().getImage("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\fire 128.png");
    Image fire3 = Toolkit.getDefaultToolkit().getImage("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\fire 128.png");
    Image fire4 = Toolkit.getDefaultToolkit().getImage("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\fire 128.png");
    Image fire5 = Toolkit.getDefaultToolkit().getImage("D:\\SE\\SEMESTER 1\\WIX1002 FUNDAMENTALS OF PROGRAMMING\\Source Code\\G6_TTE\\img\\fire 128.png");
    
    public void paintSelf(Graphics g){
        g.drawImage(fire1, 10, 460, null);
        g.drawImage(fire2, 250, 460, null);
        g.drawImage(fire3, 200, 400, null);
        g.drawImage(fire4, 80, 300, null);
        g.drawImage(fire5, 130, 460, null);
    }

    
    public Rectangle getRec() {
       return null;
    }
}