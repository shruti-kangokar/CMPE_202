import greenfoot.*; 
import java.awt.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerScore extends Actor
{
    /**
     * Act - do whatever the PowerScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   public PowerScore()
   {
       GreenfootImage newImage = new  GreenfootImage(120,50);
       setImage(newImage);
    }
    
    public void setPowScore(int score)
    {
         GreenfootImage newImage = getImage();
         newImage.clear();
         Color c = new Color(255,255,255,0);
         Font f = new Font("Comic Sans MS", Font.ITALIC, 20);
         newImage.setFont(f);
         
         newImage.setColor(c);
         newImage.fill();
         newImage.setColor(Color.black);
         newImage.drawString("" +score, 20, 40);
         setImage(newImage);
    }
}

