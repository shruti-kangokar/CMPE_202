import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainButton extends Actor
{
    /**
     * Act - do whatever the PlayAgainButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    FlappyWorld flappyworld;
    
    public void act() 
    {
        // Add your action code here.
        //System.out.println("in playagain button");
        if(Greenfoot.mouseClicked(this)){  
           flappyworld=new FlappyWorld();
           Greenfoot.setWorld(flappyworld);           
        }else{
            //System.out.println("not clicked play again");
        }

    }    
}
