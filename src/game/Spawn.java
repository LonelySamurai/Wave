package game;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    private int ch =0;
    
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;
        
        if(ch==0)
        {
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy,handler));
            ch++;
        }
        
        if(scoreKeep >= 300)
        {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);
                                
            //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy,handler));
            
            if(hud.getLevel()== 2) handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy,handler));
            if(hud.getLevel()== 3) handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.FastEnemy,handler));
            if(hud.getLevel()== 4) handler.addObject(new FastEnemy2(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.FastEnemy2,handler));
            if(hud.getLevel()== 5) handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy,handler));
            if(hud.getLevel()== 6) handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.FastEnemy,handler));            
            if(hud.getLevel()== 7) handler.addObject(new FastEnemy2(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.FastEnemy2,handler));
            if(hud.getLevel()== 8) handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.BasicEnemy,handler));
            if(hud.getLevel()== 9) handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.FastEnemy,handler));          
            
            
            if(hud.getLevel() == 5 || hud.getLevel() == 8)
            {
                handler.addObject(new Health(Game.WIDTH-800,r.nextInt(Game.HEIGHT-50), ID.Health,handler));                
            
            }
            
            if(hud.getLevel() == 10)
            {
                handler.clearEnemys();
                handler.addObject(new EnemyBoss((Game.WIDTH/2)-38,-75, ID.EnemyBoss,handler));
            }
            if(hud.getLevel() == 15)
            {
                handler.addObject(new Health(Game.WIDTH-800,r.nextInt(Game.HEIGHT-50), ID.Health,handler));  
                handler.addObject(new EnemyBoss2((Game.WIDTH/2)-38,-75, ID.EnemyBoss2,handler));
            }
             if(hud.getLevel() == 18)
            {
             
                handler.addObject(new EnemyBoss((Game.WIDTH/2)-38,-75, ID.EnemyBoss,handler));
            }
             if(hud.getLevel() == 25)
            {
                handler.addObject(new Health(Game.WIDTH-800,r.nextInt(Game.HEIGHT-50), ID.Health,handler));  
                handler.addObject(new EnemyBoss2((Game.WIDTH/2)-38,-75, ID.EnemyBoss2,handler));
            }
           
            
            
            //handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50), ID.SmartEnemy,handler));
            
                    
        }
    }

}
