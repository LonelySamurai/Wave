package game;

import game.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    private boolean[] keyDown2 = new boolean[4];
    
    Game game;
    
    public KeyInput(Handler handler, Game game)
    {
        this.handler = handler;
        this.game = game;
        
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
        
        keyDown2[0] = false;
        keyDown2[1] = false;
        keyDown2[2] = false;
        keyDown2[3] = false;
    }
    
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        for(int i =0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId()==ID.Player)
            {  //key events for player 1
                
                if(key == KeyEvent.VK_UP){tempObject.setVelY(-10); keyDown[0] = true;}
                if(key == KeyEvent.VK_RIGHT){tempObject.setVelX(10); keyDown[1] = true;}
                if(key == KeyEvent.VK_LEFT){tempObject.setVelX(-10); keyDown[2] = true;}
                if(key == KeyEvent.VK_DOWN){tempObject.setVelY(10); keyDown[3] = true;}
                 
                
            }
            
            if(tempObject.getId()==ID.Player2)
            {  //key events for player 2
                
                if(key == KeyEvent.VK_W){ tempObject.setVelY(-10); keyDown2[0] = true;}
                if(key == KeyEvent.VK_D){ tempObject.setVelX(10); keyDown2[1] = true;}
                if(key == KeyEvent.VK_A){ tempObject.setVelX(-10); keyDown2[2] = true;}
                if(key == KeyEvent.VK_S){ tempObject.setVelY(10); keyDown2[3] = true;}
                
            }
        }
        
        if(key == KeyEvent.VK_P) 
        {        
            if(game.gameState == STATE.Game)
            {
                if(Game.paused) Game.paused = false;
                else Game.paused = true;
            }
        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        
    }
    
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        for(int i =0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId()==ID.Player)
            {  //key events for player 1
                
                if(key == KeyEvent.VK_UP) keyDown[0] = false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_RIGHT) keyDown[1] = false; //tempObject.setVelX(0);
                if(key == KeyEvent.VK_LEFT) keyDown[2] = false; //tempObject.setVelX(0);
                if(key == KeyEvent.VK_DOWN) keyDown[3] = false; //tempObject.setVelY(0);
                            
                //vertical & horizontal movement
                if(!keyDown[0] && !keyDown[3]) tempObject.setVelY(0);
                if(!keyDown[1] && !keyDown[2]) tempObject.setVelX(0);
            }
            
            if(tempObject.getId()==ID.Player2)
            {  //key events for player 2
                
                if(key == KeyEvent.VK_W) keyDown2[0] = false;  //tempObject.setVelY(0);
                if(key == KeyEvent.VK_D) keyDown2[1] = false;  //tempObject.setVelX(0);
                if(key == KeyEvent.VK_A) keyDown2[2] = false;  //tempObject.setVelX(0);
                if(key == KeyEvent.VK_S) keyDown2[3] = false;  //tempObject.setVelY(0);
                
                //vertical & horizontal movement
                if(!keyDown2[0] && !keyDown2[3]) tempObject.setVelY(0);
                if(!keyDown2[1] && !keyDown2[2]) tempObject.setVelX(0);
                
            }
        }
        
    }
}
