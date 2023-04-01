package javaapplication1;
import java.util.LinkedList;
import  javaapplication2.GameObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javaapplication2.ObjectId;
import newpackage.Bigegg;
import newpackage.Block;
import newpackage.Cat;
import newpackage.Gate;
import newpackage.Player;
import newpackage.Egg;
import newpackage.bullet;




public class Handler {

    public LinkedList<GameObject>object=new LinkedList<GameObject>();
    private GameObject tempObject;
    private Camera cam;
    private BufferedImage level2 =null;
    private BufferedImage level3 =null;
   
   
    public Handler(Camera cam){
        this.cam=cam;
         bufferdimage loader=new bufferdimage();
        level2=loader.loadImage("/level2.png");
        level3=loader.loadImage("/level3.png");
                
    }
    
    public void tick(){
        for(int i=0;i<object.size();i++){
            tempObject=object.get(i);
            tempObject.tick(object);
            
        }
    }
    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            tempObject=object.get(i);
            tempObject.render(g);
        }   
    
    }
    
    public void LoadImageLevel(BufferedImage image){
    int w=image.getWidth();
    int h=image.getHeight();
    for(int m=0;m<h;m++){
        for(int n=0;n<w;n++){
                int pixel=image.getRGB(m, n);
                int r=(pixel>>16)&0xff;
                int g=(pixel>>8)&0xff;
                int b=(pixel)&0xff;
               
                if(r==255 && g==255 && b==255)addObject(new Block(m*32,n*32,1,ObjectId.Block));
                if(r==0 && g==0 && b==255)addObject(new Player(m*32,n*32,this,cam,ObjectId.Player)); 
                if(r==255 && g==106 && b==0)addObject(new Gate(m*32,n*32,ObjectId.Gate));
                if(r==255 && g==0 && b==0)addObject(new Cat(m*32,n*32,this,ObjectId.Cat));
                if(r==255 && g==216 && b==0)addObject(new Egg(m*32,n*32,ObjectId.Egg));
                 if(r==0 && g==255 && b==0)addObject(new Bigegg(m*32,n*32,ObjectId.Bigegg));
                           
        }
    }
}
    
    public void switchLevel(){
       clearLevel();
       cam.setX(0);
     
       switch(Game.LVL){
           case 1:
               LoadImageLevel(level2);
               
               break;
           case 2:
               LoadImageLevel(level3);
               break;
              }
       if(Game.LVL==3){
           System.out.println("YOU FINISH THE GAME ");
           System.exit(1);
           
       }
         Game.LVL++;
    }
    
    
    
    
    
    public  void clearLevel(){
        object.clear();
    }
   
    public void addObject(GameObject object){
        this.object.add(object);
        
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
        
    }
   
   
}
