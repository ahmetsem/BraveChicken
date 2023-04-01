/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.image.BufferedImage;
import javaapplication1.bufferdimage;

/**
 *
 * @author ahmet
 */
public class Texture {
    
    SpireteSheet bs,ps,cs,gs,es,ebs;
    private BufferedImage block_sheet=null;
    private BufferedImage Player_sheet=null;
    private BufferedImage Cat_sheet=null;
    private BufferedImage Gate_sheet=null;
    private BufferedImage Egg_sheet=null;
    private BufferedImage Bigegg_sheet=null;
    public BufferedImage[] block=new BufferedImage[2];
    public BufferedImage[]Player=new BufferedImage[1];
    public BufferedImage[]Cat=new BufferedImage[1];
    public BufferedImage[]Gate=new BufferedImage[1];
    public BufferedImage[]Egg=new BufferedImage[1];
    public BufferedImage[]Bigegg=new BufferedImage[1];
  
    
    public Texture(){
        bufferdimage loader=new bufferdimage();
        try{
            block_sheet=loader.loadImage("/ground.png");
            Player_sheet=loader.loadImage("/player.png");
            Cat_sheet=loader.loadImage("/Cat.png");
            Gate_sheet=loader.loadImage("/gate.png");
            Egg_sheet=loader.loadImage("/Egg.png");
            Bigegg_sheet=loader.loadImage("/bigegg.png");
        }catch(Exception e){
            e.printStackTrace();
        }
        bs=new SpireteSheet(block_sheet);
        ps=new SpireteSheet(Player_sheet);
        cs=new SpireteSheet(Cat_sheet);
        gs=new SpireteSheet(Gate_sheet);
        es=new SpireteSheet(Egg_sheet);
        ebs=new SpireteSheet(Bigegg_sheet);
        
        
        getTextures();
          
    }
    private void getTextures(){
        block[0]=bs.grabImage(1, 1, 32, 32);
        block[1]=bs.grabImage(2, 1, 32, 32);
        Player[0]=ps.grabImage(1, 1, 32, 64);
        Cat[0]=cs.grabImage(1, 1, 32, 64);
        Gate[0]=gs.grabImage(1, 1, 32, 64);
        Egg[0]=es.grabImage(1, 1, 32, 32);
        Bigegg[0]=ebs.grabImage(1, 1, 32, 32);
        
        
      
    }
    
            
    
}
