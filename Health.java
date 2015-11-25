import greenfoot.*;
import java.awt.*;

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    int health = 5;
    int healthWidth = 80;
    int healthHeight = 15;
    int pixelsPerHealthPoint = (int)healthWidth/health;
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Health()
    {
        
    }
    
   
    
    public void show(int health)
    {
         health--;
         setImage(new GreenfootImage(healthWidth + 2, healthHeight + 2));
         GreenfootImage myImage = getImage();
         myImage.setColor(Color.WHITE);
         myImage.drawRect(0,0,healthWidth + 1 , healthHeight + 1);
         myImage.setColor(Color.RED);
         myImage.fillRect(1,1, health*pixelsPerHealthPoint , healthHeight);
         
         
    }
    
}
