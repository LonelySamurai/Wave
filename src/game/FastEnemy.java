package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {
    
    private Handler handler;
    
    private BufferedImage enemy_image;
    
    
    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 2;
        velY = 7;
        
        /*
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        
        enemy_image = ss.grabImage(1, 7, 20, 20);
        */
    }
    
     public Rectangle getBounds()
    {
        return new Rectangle(x,y,20,20);
    }
    
    
    public void tick() {
        x += velX;
        y += velY;
        
        if(y<=0 || y>=Game.HEIGHT-44) {
            AudioPlayer.getSound("thud").play(1, 0.2f);
            velY *= -1;
        }
        if(x<=0 || x>=Game.WIDTH-22){
            AudioPlayer.getSound("thud").play(1, 0.2f);
            velX *= -1;
        }
        
        handler.addObject(new Trail(x,y,ID.Trail,Color.blue,20,20,0.1f,handler));
    }
    
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,20,20);
        //g.drawImage(enemy_image, x, y, null);
    }
    
}
