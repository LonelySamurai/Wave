package game;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player2 extends GameObject {

    Random r = new Random();
    Handler handler2; 
    
    private BufferedImage player_image;
      
    public Player2(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler2 = handler;
       
        /////Sprite/////
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        
        player_image = ss.grabImage(1, 5, 38 , 45);
        ///////////////
    }
    
    public Rectangle getBounds()
    {
        return new Rectangle(x,y,32,32);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        if(HUD.HEALTH2!=0){
        x = Game.clamp(x,0,Game.WIDTH -38);
        y = Game.clamp(y,0,Game.HEIGHT-70);
        }
       //handler.addObject(new Trail(x,y,ID.Trail,Color.white,32,32,0.1f,handler));
        
        collision();
        
    }
    
    private void collision()
    {
        for(int i = 0; i< handler2.object.size(); i++)
        {
            GameObject tempObject = handler2.object.get(i);
            
            if(tempObject.getId() == ID.EnemyBoss || tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.FastEnemy2)//tempObject is BasicEnemy
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    //collision code
                    AudioPlayer.getSound("hit").play();
                    HUD.HEALTH2 -= 2;
                    
                    if(HUD.HEALTH2 <= 0)
                    {
                        x = Game.WIDTH+100000;
                        y = Game.HEIGHT+100000;
                        AudioPlayer.getSound("gameover").play(1, 3f);
                        
                    }                    
                }
            }
            
            if(tempObject.getId() == ID.Health)//gives health if touched
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    AudioPlayer.getSound("health").play(1, 0.2f);
                    //collision code
                    HUD.HEALTH2 += 3;
                    
                    
                }
            }           
            
        }
    }

    public void render(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        if (id == ID.Player2) {
            
            //g.setColor(Color.blue);
            //g.fillRect(x, y, 32, 32);
            
            g.drawImage(player_image, x, y, null);
            
        }                
    }
}
