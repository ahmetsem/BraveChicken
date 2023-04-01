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
import javaapplication1.Handler;
import javaapplication2.GameObject;
import javaapplication2.ObjectId;


/**
 *
 * @author ahmet
 */
public class bullet extends GameObject {
    private Handler handler;
    public static int skor=0;
    
    public bullet(float x,float y,Handler handler,ObjectId id,int velX){
        super(x,y,id);
        this.velX=velX;
        this.handler=handler;
        
    }
    
 

    @Override
    public void tick(LinkedList<GameObject> object) {
       x+=velX;
       Collision(object);
      
    }
     private void Collision(LinkedList<GameObject> object){
        for(int i =0;i<handler.object.size();i++){
            
            GameObject tempObject= handler.object.get(i);
            
         
            if(tempObject.getId()==ObjectId.Egg){//NORMAL EGGS ARE 100 POINT
               
                 if(getBoundsRight_egg().intersects(tempObject.getBounds())
                  ||getBoundsLeft_egg().intersects(tempObject.getBounds()))
                 {
                    handler.removeObject(tempObject);
                    skor+=100;
                    System.out.println("SKOR="+skor);
                    handler.removeObject(this);
                    
         
                }  
            }
            if(tempObject.getId()==ObjectId.Bigegg){// BIG EGGS ARE 250 POINT
               
                 if(getBoundsRight_egg().intersects(tempObject.getBounds())
                  ||getBoundsLeft_egg().intersects(tempObject.getBounds()))
                 {
                    handler.removeObject(tempObject);
                    skor+=250;
                    System.out.println("SKOR="+skor);
                     handler.removeObject(this);
         
                }  
            }
            if(tempObject.getId()==ObjectId.Block){// MISS SHOTS ARE -50 POINT
               
                 if(getBoundsRight_egg().intersects(tempObject.getBounds())
                  ||getBoundsLeft_egg().intersects(tempObject.getBounds()))
                 {
                    skor-=50;
                    System.out.println("SKOR="+skor);
                     handler.removeObject(this);
         
                }  
            }
            
        }
     }
    
    @Override
    public void render(Graphics g) {
       g.setColor(Color.red);
       g.fillRect((int)x,(int) y, 16, 16);  
    }

    
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    public Rectangle getBoundsRight_egg() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    public Rectangle getBoundsLeft_egg() {
        return new Rectangle((int)x,(int)y,16,16);
    }
    
    
}
