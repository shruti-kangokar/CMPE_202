import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Actor
{
    /**
     * Act - do whatever the StartGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //FlappyWorld flappyworld;
    static Boolean start=false;
    //FlappyBird flappy;

    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){  
            //flappy = new FlappyBird();
            start=true;
            //flappyworld=new FlappyWorld();
            //flappyworld.addObject(flappy,100,getWorld().getHeight()/2);
            //flappyworld.act();
            
        }
    }    
}
