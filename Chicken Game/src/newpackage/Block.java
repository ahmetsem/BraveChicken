package newpackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import javaapplication2.ObjectId;
import javaapplication2.GameObject;
import javaapplication2.Texture;
import javaapplication1.Game;

public class Block extends GameObject {
private int type;
    Texture tex=Game.getInstance();
    public Block(float x, float y,int type, ObjectId objectId) {
        super(x,y,objectId);
        this.type=type;
         
    } @Override
    public void tick(LinkedList<GameObject>object) {
       
        
    }
   
    @Override
    public void render(Graphics g) {
      if(type==0)
     g.drawImage(tex.block[0], (int)x, (int)y, null);
      if(type==1)
           g.drawImage(tex.block[1], (int)x, (int)y, null);
      
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y ,32, 32);
        
    }
  
    
    
}
