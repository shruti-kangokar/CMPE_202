import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Power here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Power extends Actor
{
    
   int PIPE_SPEED = 10;
    soundClient sc = new soundClient();
    public void act() 
    {
      setLocation(getX() - PIPE_SPEED , getY());
      turn(5);
    }   
}
