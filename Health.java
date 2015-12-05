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
    int health = 100;
    int healthWidth = 100;
    int healthHeight = 15;
    int pixelsPerHealthPoint = 1;
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /*public Health()
    {
    update();
    }*/
    public void act()
    {
    update();
    }
    public void looseHealth()
    {
    health = health - 1 ;
    }
    public void gainHealth()
    {
        health = health + 30;
    }
    public void update()
    {
         
         setImage(new GreenfootImage(healthWidth + 2, healthHeight + 2));
         GreenfootImage myImage = getImage();
         myImage.setColor(Color.GREEN);
         myImage.drawRect(0,0,healthWidth + 1 , healthHeight + 1);
         myImage.setColor(Color.WHITE);
         myImage.fillRect(1,1, health*pixelsPerHealthPoint , healthHeight);
        /* GreenfootImage newImage = getImage();
         newImage.clear();
         
         Color c = new Color(255,255,255,0);
         Font f = new Font("Comic Sans MS", Font.ITALIC, 20);
         newImage.setFont(f);
         newImage.setColor(c);
         newImage.fill();
         newImage.setColor(Color.black);
         World myWorld = getWorld();
         FlappyWorld flappyworld = (FlappyWorld)myWorld;
         Health health = flappyworld.getHealth();
         newImage.drawString("" + health, 20, 40);
         setImage(newImage);*/
         
    }
    
}
