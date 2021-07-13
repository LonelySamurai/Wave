package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Health extends GameObject {
    
    private Handler handler;
    
    
    public Health(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 4;
        velY = 0;
    }
    
     public Rectangle getBounds()
    {
        return new Rectangle(x,y,16,16);
    }
    
    
    public void tick() {
        x += velX;
        y += velY;
        
        //if(y<=0 || y>=Game.HEIGHT-44) velY *= -1;
        //if(x<=0 || x>=Game.WIDTH-22) velX *= -1;
        
        //handler.addObject(new Trail(x,y,ID.Trail,Color.green,16,16,0.1f,handler));
    }
    
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x,y,16,16);
    }
    
}
