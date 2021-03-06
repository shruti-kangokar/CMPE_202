import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * Write a description of class CoinsCollected here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinsCollected extends Actor implements Observer
{
     public int score = 0;
     protected FlappyBird flappy;
     
     public CoinsCollected(FlappyBird thesubject)
    {
        flappy = thesubject ;
        setImage(new GreenfootImage(60,40));
        show();
    }
    
    public void update()
    {
        score++;
        show();
    }
    
    public void show()
    {
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.WHITE);
        img.setFont(new Font("Trebuchet MS", Font.BOLD,20));
        //img.setFont(img.getFont().deriveFont(Font.BOLD,15));
        img.drawString(""+score,15,40);
    }
}
