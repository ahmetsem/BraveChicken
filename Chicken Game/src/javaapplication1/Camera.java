    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import javaapplication1.window;
import javaapplication2.GameObject;

/**
 *
 * @author ahmet
 */
public class Camera {
    private float x,y;
    public Camera(float x,float y){
        this.x=x;
        this.y=y;
        
    }
    public void tick(GameObject player){
        y=-player.getY()+Game.HEIGHT/2;
        if(player.getVelY()==0){
            y=y;
        }
        
    }
    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
        
    }
    public float getX(){
        return x;
        
    }
    public float getY(){
        return y;
    }

    
    
}
