
package newpackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import javaapplication2.GameObject;
import javaapplication2.ObjectId;
import javaapplication1.Handler;
import javaapplication2.Texture;
import javaapplication1.Game;
import javaapplication1.Camera;

public class Player extends GameObject {
        
        private float width=32, height=64;
        private float gravity=0.002f;
        private Handler handler;
        private Camera cam;
    
        Texture tex=Game.getInstance();
        public Player(int x,int y,Handler handler,Camera cam,ObjectId id){
            super(x,y,id);
            this.handler=handler;
            this.cam=cam;
        }
    
    @Override
    public void tick(LinkedList<GameObject> object) {
        x+= velX;
        y+= velY;
        
        if(velX<0)facing=-1;
        else if(velX>0)facing=1;
        
        
        
        if(falling)
        {
            velY+=gravity;
        }
        Collision(object);
    }

    private void Collision(LinkedList<GameObject> object){
        for(int i =0;i<handler.object.size();i++){
            
            GameObject tempObject= handler.object.get(i);
            
         
            if(tempObject.getId()==ObjectId.Block){
                
                if(getBounds().intersects(tempObject.getBounds())){
                    y=tempObject.getY()- height;
                    velY=0;
                    falling=true;
                    
                }
                 
                if(getBoundsRight().intersects(tempObject.getBounds())){
                    x=tempObject.getX()-35;
                    
                }
                if(getBoundsLeft().intersects(tempObject.getBounds())){
                    x=tempObject.getX()+35;
                    
                }
            }

             else if(tempObject.getId() == ObjectId.Cat){
                if(getBounds().intersects((tempObject.getBounds()))){
                    System.out.println("GAME OVER");
                    System.exit(1);
                   
                }
             }
            
            
            else if(tempObject.getId() == ObjectId.Gate){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.switchLevel();
                }
                    
                
            }
        
        }
         
    }
    
    
    
    @Override
    public void render(Graphics g) {
        
      
        g.drawImage(tex.Player[0],(int)x, (int)y, null);
       
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)((int)x+(width/2)-((width/2)/2)),(int)((int)y+(height/2)),(int)width/2,(int)height/2);
    }
    
    public Rectangle getBoundTop() {
        return new Rectangle((int)((int)x+(width/2)-((width/2)/2)),(int)y,(int)width/2,(int)height/2);
    }
    public Rectangle getBoundsRight() {
        return new Rectangle((int)((int)x+width-5),(int)y+5,(int)5,(int)height-10);
    }
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
    }
    
    
    
}
