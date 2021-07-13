package game;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.newdawn.slick.Music;
//import org.newdawn.slick.SlickException;
//import org.newdawn.slick.Sound;

public class AudioPlayer {



        public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
        public static Map<String, Music> musicMap = new HashMap<String, Music>();

        public static void load()
        {
            try {
                
                soundMap.put("select", new Sound("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\Select.wav"));
                soundMap.put("thud", new Sound("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\Thud.wav"));
                soundMap.put("gameover", new Sound("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\GameOver.wav"));
                soundMap.put("health", new Sound("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\Health.wav"));                
                soundMap.put("move", new Sound("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\Move.wav"));
                soundMap.put("hit", new Sound("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\Hit.wav"));
                musicMap.put("music", new Music("C:\\Users\\Emon\\Desktop\\Games\\Game\\res\\Music.wav"));
            
            } catch (SlickException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public static Music getMusic(String key)
        {
            return musicMap.get(key);
        }
        
        public static Sound getSound(String key)
        {
            return soundMap.get(key);
        }

}
