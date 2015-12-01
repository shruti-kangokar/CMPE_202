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
         
         GreenfootImage scoreImg = getImage();
        scoreImg.clear();
        scoreImg.setColor(Color.WHITE);
        scoreImg.setFont(new Font("Trebuchet MS", Font.BOLD,20));
        
        scoreImg.drawString(""+score,20,40);
        
   }
    
}
