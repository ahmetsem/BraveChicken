/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.image.BufferedImage;

/**
 *
 * @author ahmet
 */
public class SpireteSheet {
    private BufferedImage image;
    public SpireteSheet(BufferedImage image){
        this.image=image;
        
    }

    
    public BufferedImage grabImage(int col,int row,int width,int height){
        BufferedImage img=image.getSubimage( (col*width)-width,(row*height)-height,width,height);
        return img;
                
    }
    
}
