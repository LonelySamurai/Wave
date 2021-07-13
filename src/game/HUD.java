package game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    public static int HEALTH = 100;
    public static int HEALTH2 = 100;
    private int greenValue = 255;
    private int greenValue2 = 255;
    
    private int score = 0;
    private int score2 = 0;
    
    private int level = 1;
    private int level2 = 1;
    
    
    public void tick() {
        
        HEALTH = Game.clamp(HEALTH, 0, 100);
        HEALTH2 = Game.clamp(HEALTH2, 0, 100);
        
        greenValue = Game.clamp(greenValue,0,255);
        greenValue2 = Game.clamp(greenValue2,0,255);
        
        greenValue = HEALTH*2;
        greenValue2 = HEALTH2*2;
        
        
        if(HEALTH!=0)
        {
            score++;
        }
        if(HEALTH2!=0)
        {
            score2++;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(75,greenValue,0));
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);
        
        g.drawString("Score: "+ score, 14,64);
        g.drawString("Level: "+ level, 15,80);
        
        /////////////////////////////////////
        
        g.setColor(Color.GRAY);
        g.fillRect(380, 15, 200, 32);

        g.setColor(new Color(75,greenValue2,0));
        g.fillRect(380, 15, HEALTH2 * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(380, 15, 200, 32);
        
        g.drawString("Score: "+ score2, 514,64);
        //g.drawString("Level: "+ level2, 515,80);

    }

    public void setScore(int score)
    {
        this.score = score;
    }
    public int getScore()
    {
        return score;
    }
    
    public void setLevel(int level)
    {
        this.level = level;
    }
    
    public int getLevel()
    {
        return level;
    }
    ///////////////////////////////
    public void setScore2(int score2)
    {
        this.score2 = score2;
    }
    public int getScore2()
    {
        return score2;
    }
    
    public void setLevel2(int level2)
    {
        this.level2 = level2;
    }
    
    public int getLevel2()
    {
        return level2;
    }
}
