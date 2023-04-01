/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javaapplication1.Handler;
import javaapplication2.GameObject;
import newpackage.bullet;

/**
 *
 * @author ahmet
 */
public class KeyInput extends KeyAdapter {
    Handler handler;
    private boolean contnt=false;
    public KeyInput(Handler handler){
        this.handler = handler;
        
    }
    @Override
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        for(int i=0;i<handler.object.size();i++){
            GameObject tempObject=handler.object.get(i);
            if(tempObject.getId()==ObjectId.Player){
                if(key==KeyEvent.VK_D)tempObject.setVelX(4);
                if(key==KeyEvent.VK_A)tempObject.setVelX(-4);
                if(key==KeyEvent.VK_W&&contnt==false){
                    contnt=true;
                    handler.addObject(new bullet(tempObject.getX(),tempObject.getY()+32,handler,ObjectId.bullet,tempObject.getFacing()*6));
                   
                    
                }
                
            }
            
            
    
        }
        if(key==KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        for(int i=0;i<handler.object.size();i++){
            GameObject tempObject=handler.object.get(i);
            if(tempObject.getId()==ObjectId.Player){
                if(key==KeyEvent.VK_D)tempObject.setVelX(0);
                if(key==KeyEvent.VK_A)tempObject.setVelX(0);
                if(key==KeyEvent.VK_W){
                    contnt=false;
                }
            }
        }
        
    }
    
}
