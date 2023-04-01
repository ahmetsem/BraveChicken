
package javaapplication1;
import java.awt.Dimension;
import javax.swing.JFrame;

public class window {
    public window(int height,int weight,String game_title,Game game){
        
        game.setPreferredSize(new Dimension(height,weight));
        game.setMaximumSize(new Dimension(height,weight));
        game.setMinimumSize(new Dimension(height,weight));
        
        
        JFrame frame =new JFrame(game_title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      
        game.start();
      
        
    }
    
}
