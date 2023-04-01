/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import javaapplication2.GameObject;
import javaapplication2.ObjectId;
import javaapplication2.Texture;
import javaapplication1.Game;


/**
 *
 * @author ahmet
 */
public class Bigegg extends GameObject {
    Texture tex=Game.getInstance();
  
  
    public Bigegg(int i, int i0, ObjectId objectId) {
        super(i,i0,objectId);
    }
    
    

    @Override
    public void tick(LinkedList<GameObject> object) {
      
    }

    @Override
    public void render(Graphics g) {
       g.drawImage(tex.Bigegg[0],(int)x, (int)y, null);
       
       
       
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,24,24);
    }
    
    
}