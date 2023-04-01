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
import javaapplication1.Handler;


/**
 *
 * @author ahmet
 */
public class Cat extends GameObject {
    Texture tex=Game.getInstance();
    private Handler handler;
  
   
    public Cat(int i, int i0, Handler handler,ObjectId objectId) {
        super(i,i0,objectId);
        this.handler=handler;
     
    }
   
      int control=0; 
    @Override
    public void tick(LinkedList<GameObject> object) {
      for(int i=0;i<3;i++){
          if(control==0){
              x+=0.03;
          }
          if(control==1){
              x-=0.03;
          }
          y+=0.02;
      }  
      Collision(object);
    }
     private void Collision(LinkedList<GameObject> object){
         
        for(int i =0;i<handler.object.size();i++){
            
            GameObject tempObject= handler.object.get(i);
            if(tempObject.getId()==ObjectId.Block){
                
                if(getBounds().intersects(tempObject.getBounds())){
                    y=tempObject.getY()- 64;
                    velY=0;
                    falling=true;
                }
                
                 if(getBoundsRight_cat().intersects(tempObject.getBounds())){
                    x=tempObject.getX()-35;
                    control=1;
                    
                }
                if(getBoundsLeft_cat().intersects(tempObject.getBounds())){
                    x=tempObject.getX()+35;
                    control=1;       
                }
            }
        }
     }
    
    @Override
    public void render(Graphics g) {
       g.drawImage(tex.Cat[0],(int)x, (int)y, null);
          
    }
    @Override
    public Rectangle getBounds() {
       return new Rectangle((int)((int)x+(32/2)-((32/2)/2)),(int)((int)y+(64/2)),(int)32/2,(int)64/2);
    }
     public Rectangle getBoundsRight_cat() {
        return new Rectangle((int)((int)x+32-5),(int)y+5,(int)5,(int)64-10);
    }
    public Rectangle getBoundsLeft_cat() {
        return new Rectangle((int)x,(int)y+5,(int)5,(int)64-10);
    }
    
    
}