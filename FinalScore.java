import greenfoot.*;
import java.awt.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class FinalScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalScore extends Actor
{
    /**
     * Act - do whatever the FinalScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    CoinsCollected coinscore;
    FlappyBird powscore;
    FlappyWorld pipescore;
    int total = 0;
    public void act() 
    {
        // Add your action code here.
        //setImage(new GreenfootImage("" +total,24,Color.BLACK, Color.WHITE));
        //total = (coinscore.score + powscore.power + pipescore.score) ;
    }  
    public FinalScore()
    {
        /*
    
         GreenfootImage newImage = getImage();
         newImage.clear();
         Color c = new Color(255,255,255,0);
         Font f = new Font("Comic Sans MS", Font.ITALIC, 20);
         newImage.setFont(f);
         
         newImage.setColor(c);
         newImage.fill();
         newImage.setColor(Color.black);
         newImage.drawString("" + total, getWorld().getWidth()/2,getWorld().getHeight()/2-20);
         setImage(newImage);*/
    }
    public void totalscore()
    {
        
    }
}
