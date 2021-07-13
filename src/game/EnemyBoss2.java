package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss2 extends GameObject {
    
    private Handler handler;
    Random r = new Random();
    
    private int timer = 100;
    private int timer2 = 30;
    
    
    public EnemyBoss2(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 0;
        velY = 2;
    }
    
     public Rectangle getBounds()
    {
        return new Rectangle(x,y,70,70);
    }
    
    
    public void tick() {
        x += velX;
        y += velY;
        
        timer--;
        
        if(timer <= 0) velY =0;
        else timer--;
           
        if(timer<=0)timer2--;
        if(timer2 <=0)
        {
            if(velX == 0)velX = 3;
            
            int spawn = r.nextInt(10);
            
            if(spawn == 0){
                AudioPlayer.getSound("thud").play(1, 0.1f);
                handler.addObject(new EnemyBossBullet((int) x, (int) y,ID.BasicEnemy, handler));
            }
            
        }
        
        //if(y<=0 || y>=Game.HEIGHT-44) velY *= -1;
        if(x<=0 || x>=Game.WIDTH-72) velX *= -1;
        
        handler.addObject(new Trail(x,y,ID.Trail,Color.magenta,70,70,0.07f,handler));
    }
    
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect(x,y,70,70);
    }
    
}
