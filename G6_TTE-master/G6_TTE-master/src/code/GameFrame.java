package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
    //size of window
    private int windowWidth = 1000;
    private int windowHeight = 680;
    
    Background background = new Background(this);
    Tower_img tow = new Tower_img(this);
    Wall_img w = new Wall_img(this);
    Lose_Dragon_img losedrag = new Lose_Dragon_img(this);
    Win_Dragon_img windrag = new Win_Dragon_img(this);
    Fire fire = new Fire(this);
    Combat cond = new Combat();
    Dragon dg = new Dragon();
    
    public void launch(){
        setSize(windowWidth,windowHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setTitle("Till the End");
        setVisible(true);
        
        while(true){
            repaint();
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void paint(Graphics g){
        background.paintSelf(g);
        tow.paintSelf(g);
        w.paintSelf(g);

        if(cond.Win(dg.getHP()) == false){
            g.setColor(Color.red);
            g.setFont(new Font("No surrender", Font.BOLD, 100)); 
            g.drawString("GAME OVER", 200, 200);
            fire.paintSelf(g);
            losedrag.paintSelf(g);
        }
        else{
            g.setColor(Color.green);
            g.setFont(new Font("No surrender", Font.BOLD, 100));
            g.drawString("WIN", 400, 200);
            windrag.paintSelf(g);
        }
    }
    
}