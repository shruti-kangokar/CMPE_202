import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class FlappyBird extends Actor implements Subject
{
    BirdState angryBirdState;
    BirdState flappyBirdState;
    BirdState birdState;
    
    FlappyBird()
    {
        angryBirdState = new AngryBirdState(this);
        flappyBirdState = new FlappyBirdState(this);
        birdState = flappyBirdState;
    }
    
    double dy = 0;
    double g  = 0.5;
    double BOOST_SPEED = -5;
    int power=0;
    Actor pipeIntersection;
    boolean pipeIntState=false;
    
    boolean highPowerState = false;
    
    boolean powerIntState = false;
    
    StartGame startgame = new StartGame();
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer obj) {
        observers.add(obj) ;
    }

    public void detach(Observer obj) {
        observers.remove(obj) ;
    }

    public void notifyObservers() {
        for (Observer obj  : observers)
        {
            obj.update();
        }
    }

    public void setBirdState(BirdState newBirdState)
    {
        birdState = newBirdState;
    }
    
    public void setBirdImage()
    {
        birdState.setBirdImage();
    }
    
    public BirdState getFlappyBirdState()
    {
       return flappyBirdState;
    }
    
    public BirdState getAngryBirdState()
    {
       return angryBirdState;
    }
    
    public void act() 
    {
        /*
         * Checking if the flappyBird is touching the coin and if yes then remove coin object from FlappyWorld
         */
       if(isTouching(Coin2.class))
       {
           get(Coin2.class);
       }
        if(startgame.start==true){
            rotateFlappyBird();
            //move(5);
            setLocation(getX(), (int)(getY() + dy));
            
            pipeIntersection = getOneIntersectingObject(Pipe.class);
            
            Actor powerIntersection = getOneIntersectingObject(Power.class);
            
            if(powerIntersection!=null)
            {
                power++;
                powerIntState = true;
                System.out.println("Power level is now: " + power);
                if(power == 3)
                {
                    highPowerState = true;
                    System.out.println("Changing highPowerState to true");
                    //this.setImage("angry-bird-icon.png");
                }
            }
            
            if(pipeIntersection!=null) {
                
                if(highPowerState == true){                   
                    //GreenfootImage img= new GreenfootImage("flappybird1.png");
                    //this.setImage("flappybird1.png");  
                    highPowerState = false;
                    System.out.println("Changing highPowerState to false");
                    //pipeIntersection=null;
                    power = 0;
                    //getWorld().removeObjects(getIntersectingObjects(Pipe.class));
                    setLocation(200,200);
                }
                else
                {
                    pipeIntState = true;
                    displayGameOver();
                }
                
            }
            //If user pressed UP arrow and SPACE bar launch flappy Bird upward
            if(!pipeIntState){
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
    }  
    
    //method to check whether flappybird touches the coin  
    public boolean isTouching(Class clss)
    {
        Actor actor = getOneObjectAtOffset(5,5,clss);
        return actor != null;
    }

    //method to remove coin object if flappybird touches coin
    public void get(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null)
        {
            getWorld().removeObject(actor);
        }
    }
    
    private void displayGameOver(){
        startgame.start=false;
        
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver,getWorld().getWidth()/2,getWorld().getHeight()/2);
        
        PlayAgainButton playagainbutton=new PlayAgainButton();
        getWorld().addObject(playagainbutton,getWorld().getWidth()/2,getWorld().getHeight()/2+70);
        
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
