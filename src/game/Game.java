package game;

import java.util.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 600, HEIGHT = 500;
    private Thread thread;
    private boolean running = false;

    public static boolean paused = false;
    
    private Random r = new Random();
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    
    public enum STATE
    {
      Menu,
      Help,
      Game,
      End
    };

    public static STATE gameState = STATE.Menu;
    
    public static BufferedImage sprite_sheet;
    
    public Game() {
        
        /////Sprite/////
        BufferedImageLoader loader = new BufferedImageLoader();
        
        try{
        sprite_sheet = loader.loadImage("/players.png");
        }catch (Exception e) {
            e.printStackTrace();
        }
        ///////////////
        
        handler = new Handler();        
        hud = new HUD();  
        menu = new Menu(this, handler, hud);        
        this.addKeyListener(new KeyInput(handler,this));
        this.addMouseListener(menu);
        
//        AudioPlayer.load();
        
        //AudioPlayer.getMusic("music").loop();
        
        new Window(WIDTH, HEIGHT, "Wave!", this);
        
        spawner = new Spawn(handler, hud);        
        r = new Random();
        
        if(gameState == STATE.Game)
        {
        handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
        handler.addObject(new Player2(WIDTH/2-32, HEIGHT/2-32, ID.Player2, handler));
               
        //handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler ));
        //handler.addObject(new Player(WIDTH/2-64, HEIGHT/2-32, ID.Player2, handler));    
        }
        
        
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus(); //no need to click on window after running
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
                
        if(gameState == STATE.Game)
        {
            if(!paused)
            {
                hud.tick();
            spawner.tick();  
            handler.tick();
            
            if(HUD.HEALTH<= 0 && HUD.HEALTH2<= 0)
            {
                HUD.HEALTH = 100;
                HUD.HEALTH2 = 100;
                gameState = STATE.End;
                handler.clearEnemys();
                           
            }
        }
            
        }else if(gameState == STATE.Menu || gameState == STATE.End)
        {
            menu.tick();
            handler.tick();
        }
                
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
              
        handler.render(g);
        
        if(paused)
        {
            
            g.drawString("PAUSED", 275, 390);
        }
        
        if(gameState == STATE.Game)
        {
             hud.render(g);    
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End)
        {
            menu.render(g);            
        }
        
             
        g.dispose();
        bs.show();
    }
    
    public static int clamp(int var, int min, int max)
    {
        if(var >= max) return var = max;
        else if(var <=min) return var = min;
        else return var;
    }

    public static void main(String[] args) {
        new Game();
    }

}
