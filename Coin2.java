import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin2 extends Collectible
{
    
   int COIN_SPEED = 5;
    public void act() 
    {
      setLocation(getX()-COIN_SPEED, getY());
      turn(5);
    }   
}
