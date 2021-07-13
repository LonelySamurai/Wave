package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JFrame;

public class Window extends Canvas{
    
    private static final long serialVersionUID = 20000000000000L;
    
    public Window(int width, int height, String title, Game game)
    {
        JFrame frame = new JFrame("Wave");
        
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //not resizable window
        frame.setLocationRelativeTo(null); //window starts in the middle
        frame.add(game);
        frame.setVisible(true);
        game.start();
        
    }
    
}
