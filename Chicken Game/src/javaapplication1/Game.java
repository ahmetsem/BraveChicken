
package javaapplication1;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import javaapplication2.GameObject;
import newpackage.Block;
import javaapplication2.ObjectId;
import newpackage.Player;
import javaapplication2.KeyInput;
import newpackage.Player;
import javaapplication2.Texture;
import newpackage.Cat;
import newpackage.Gate;




public class Game extends Canvas implements Runnable{

    
GameObject object;
private boolean runn=false;
private Thread control;
public static int WIDTH,HEIGHT; 
public BufferedImage level=null;
static Texture tex;
Handler handler;
Camera cam;
Random rand=new Random();
public static int LVL=1;






public static Texture getInstance(){
    return tex;
}



private void init(){
        WIDTH=getWidth();
        HEIGHT=getHeight();
        tex= new Texture();
        bufferdimage loader=new bufferdimage();
        level=loader.loadImage("/level.png");
        cam= new Camera(0,0);
        handler=new Handler(cam);
        cam=new Camera(0,0);
        handler.LoadImageLevel(level);
       
        
       //handler.addObject(new Player(0,0,handler,ObjectId.Player));
        //handler.createLevel();
        
        this.addKeyListener(new KeyInput(handler)); 
                
}

public synchronized void start(){//Game should open 1 times otherwise it cause more problems.
    if(runn){
        return;
    }
    runn=true;
    control=new Thread(this);
    control.start();  
} 


  @Override     
public void run(){
    
init();   
this.requestFocus();
long lastTime = System.nanoTime();
double amountOfTicks = 60.0;
double ns = 1000000000 / amountOfTicks;
double delta = 0;
long timer = System.currentTimeMillis();
int updates = 0;
int frames = 0;
while(runn){
 long now = System.nanoTime();
 delta += (now - lastTime) / ns;
 lastTime = now;
 while(delta >= 1){
  tick();
  updates++;
  delta--;
 }
 render();
 frames++;
   
 if(System.currentTimeMillis() - timer > 1000){
  timer += 1000;
  frames = 0;
  updates = 0;
 }
} 
}  
private void  tick(){
   
    handler.tick();
    for(int i=0;i<handler.object.size();i++){
        if(handler.object.get(i).getId()==ObjectId.Player){
            cam.tick(handler.object.get(i));
        }
    }
}

private void render(){
    BufferStrategy bs =this.getBufferStrategy();
    if(bs== null){
        this.createBufferStrategy(3);
        return;
    }
    Graphics g= bs.getDrawGraphics();
    Graphics2D g2d=(Graphics2D)g;
    g.setColor(new Color(0,255,255));
    g.fillRect(0,0, getWidth(),getHeight());
    g2d.translate(cam.getX(),cam.getY());
    
    handler.render(g);
    g2d.translate(-cam.getX(),-cam.getY());
    g.dispose();
    bs.show(); 
}






public static void main(String args[]){
  new window(800,600,"Falling Chicken",new Game());
//to execute window we send the proper size and title for the game window
}


}
