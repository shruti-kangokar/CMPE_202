import greenfoot.*; 
import java.awt.Color;
import java.awt.Font;

 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  
   public Score()
   {
       GreenfootImage newImage = new  GreenfootImage(70,50);
       setImage(newImage);
    }
    
   public Score(int width, int height)
   {
       GreenfootImage newImage = new  GreenfootImage(width, height);
       setImage(newImage);
    }
    
   public void setScore(int score)
   {
         GreenfootImage newImage = getImage();
         newImage.clear();
         
         Color c = new Color(255,255,255,0);
         Font f = new Font("Comic Sans MS", Font.ITALIC, 20);
         newImage.setFont(f);
         
         newImage.setColor(c);
         newImage.fill();
         newImage.setColor(Color.black);
         newImage.drawString("" + score, 20, 40);
         setImage(newImage);
   }
    
}
