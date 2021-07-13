package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i); //shows which object

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    /*public void clearEnemys() {
               
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            GameObject tempObject2 = object.get(i);

            if (tempObject.getId() == ID.Player || tempObject.getId() == ID.Player2) {
                object.clear();
                if(Game.gameState != Game.STATE.End){
                    addObject(new Player((int)tempObject.getX(),(int)tempObject.getY(),ID.Player, this));
                    addObject(new Player2((int)tempObject.getX(),(int)tempObject.getY(),ID.Player2,this));
                }
            }            
        }
    }*/
    
     public void clearEnemys(){
        Object array[] = object.toArray();
        for(int i = 0; i < array.length; i++){
                GameObject tempObject = (GameObject) array[i];
                if(Game.gameState != Game.STATE.End){
                if(tempObject.getId() != ID.Player && tempObject.getId() !=ID.Player2){
                        removeObject(tempObject);
                }
        }else{
                    object.clear();
                }
        }
}

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
