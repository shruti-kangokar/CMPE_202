import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    double dy = 0;
    double g  = 0.5;
    double BOOST_SPEED = -5;
    boolean intersection=false;
    
    public void act() 
    {
        rotateFlappyBird();
        setLocation(getX(), (int)(getY() + dy));
        Actor actor=getOneIntersectingObject(Pipe.class);
        //if we are touching a pipe game over
        if(actor!=null)
        {
            displayGameOver();
        }
        
        //If user pressed UP arrow, launch flappy Bird upward
        if(intersection){
            
        }else{
        if(Greenfoot.isKeyDown("up") == true || Greenfoot.isKeyDown("space") == true){
            dy = BOOST_SPEED;
        }
    }
        
       
        //If FlappyBird drops out of the world, Game Over:      
        if(getY() > getWorld().getHeight()){
            displayGameOver();
        } 
        //update the UI
        dy = dy+g;
      
    }  
    
    private void displayGameOver(){
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver,getWorld().getWidth()/2,getWorld().getHeight()/2);
        
        PlayAgainButton playagainbutton=new PlayAgainButton();
        getWorld().addObject(playagainbutton,getWorld().getWidth()/2,getWorld().getHeight()/2+70);
        intersection=true;
        //getWorld().removeObject(botPipe);
        //Greenfoot.stop();
        
    }
    
    //Change the angle
    //dy is between -10 and +10 set angle to 30 degrees
        
    private void rotateFlappyBird(){
      if(dy < 1)
           setRotation(-30); 
           else if(dy < 8)
           setRotation(0); 
           else if(dy < 12)
           setRotation(50); 
           else if(dy < 30)
           setRotation(90); 
        }
        
}
