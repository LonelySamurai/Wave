package game;

import static game.Game.HEIGHT;
import game.Game.STATE;
import static game.Game.WIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    public Menu(Game game, Handler handler, HUD hud)
    {
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }
    
    
    public void mousePressed(MouseEvent e)
    {
        int mx = e.getX();
        int my = e.getY();
        
        if(game.gameState == STATE.Menu)
        {
            //Start Button
        if(mouseOver(mx,my,200,150,200,64))
        {
            AudioPlayer.getSound("select").play();
            game.gameState = STATE.Game;
            handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
            handler.addObject(new Player2(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player2, handler));
            //handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player2, handler));
            
            //handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler));
            
            
        }
        
        //Help Button
        if(mouseOver(mx,my,200,250,200,64))
        {
        AudioPlayer.getSound("select").play();
            game.gameState = STATE.Help;
               
        }      
                
        //Quit Button
        if(mouseOver(mx,my,200,350,200,64))
        {
            AudioPlayer.getSound("select").play();
            System.exit(0);
        }
        }
        
          //Back Button for Help
        if(game.gameState == STATE.Help)
        {
            if(mouseOver(mx,my,200,350,200,64))
                {
                    AudioPlayer.getSound("select").play();
                    game.gameState = STATE.Menu;
                    return;
                }
        }
        
          //Try Again Button
         if(game.gameState == STATE.End)
        {
            if(mouseOver(mx,my,200,350,200,64))
                {
                    AudioPlayer.getSound("select").play();
                    game.gameState = STATE.Game;
                    hud.setLevel(1);
                    hud.setScore(0);
                    hud.setScore2(0);
                    handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                    handler.addObject(new Player2(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player2, handler));
                    //handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player2, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,handler));
                }
        }
            
    }
    
    public void mouseReleased(MouseEvent e)
    {
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
    {
        if(mx > x && mx < x + width)
        {
            if(my > y && my < y + height)
            {
                return true;
            }
            else 
            {
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g)
    {
        if(game.gameState == STATE.Menu)
        {
        Font font = new Font("Street Soul",1,120);
        Font font2 = new Font("Karmatic Arcade",1,30);
        
        
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString("WAVE", 200, 100);
        
        g.setFont(font2);
        g.setColor(Color.white);
        
        g.drawRect(200, 150, 200, 64);
        g.drawString("Start", 233, 190);
        
        g.drawRect(200, 250, 200, 64);
        g.drawString("Help", 245, 290);
        
        g.drawRect(200, 350, 200, 64);
        g.drawString("Quit", 250, 390);    
        }
        
        else if(game.gameState == STATE.Help)
        {
        Font font = new Font("Karmatic Arcade",1,45);
        Font font2 = new Font("Karmatic Arcade",1,30);
        Font font3 = new Font("Arial",1,20);
                
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Instructions", 65, 73);
        
        g.setFont(font3);
        g.drawString("Use Up, Down, Left, Right keys to move", 110, 160);    
        g.drawString("(W A S D for Player 2)", 190, 195);
        g.drawString("Dodge enemies to progress", 165, 230);    
        g.drawString("(Green boxes replenishes health)", 140, 265);    
        g.drawString("Try to get the highest score!", 165, 300);    
        
        
        g.setFont(font2);
        g.drawRect(200, 350, 200, 64);
        g.drawString("Back", 243, 390);    
        }
        
        else if(game.gameState == STATE.End)
        {
                
        Font font = new Font("Karmatic Arcade",1,50);
        Font font2 = new Font("Karmatic Arcade",1,20);
        Font font3 = new Font("Arial",1,20);
                
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Game Over", 95, 73);
        
        g.setFont(font3);
        g.drawString("Player1 Score: " + hud.getScore(), 50, 200);    
        g.drawString("Player2 Score: " + hud.getScore2(), 50, 240);    
        
        g.setFont(font2);
        g.drawRect(200, 350, 200, 64);
        g.drawString("Try Again", 225, 390);    
        }
        
        
    }
}
