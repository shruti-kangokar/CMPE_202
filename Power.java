import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Power here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Power extends Collectible
{
    
   int POWER_SPEED = 7;
    public void act() 
    {
      setLocation(getX() - POWER_SPEED , getY());
      turn(5);
    }   
}
