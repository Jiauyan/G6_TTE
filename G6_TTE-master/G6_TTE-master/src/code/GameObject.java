package code;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;


public abstract class GameObject {
    private int x;
    private int y;
    
    Image img;
    
    GameFrame gameFrame;

    public GameObject(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    
    public GameObject(GameFrame gameFrame, int x, int y) {
        this.gameFrame = gameFrame;
        this.x = x;
        this.y = y;
    }
     
    public abstract Rectangle getRec();
    
    public abstract void paintSelf(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
}