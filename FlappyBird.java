import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class FlappyBird extends Actor
{
    BirdState angryBirdState;
    BirdState flappyBirdState;
    BirdState birdState;
    

    double dy = 0;
    double g  = 0.5;
    double BOOST_SPEED = -5;
    int power=0;
    int counter=0;
    Actor pipeIntersection;
    
    boolean pipeIntState=false;
    
    boolean highPowerState = false;

    boolean keypress = false;
    
    boolean powerIntState = false;
    
    StartGame startgame = new StartGame();

    //Health health = new Health();

    soundClient sc = new soundClient();
    
    
    //PowerScore ps = new PowerScore();
    
    FlappyBird()
    {
        
        angryBirdState = new AngryBirdState(this);
        flappyBirdState = new FlappyBirdState(this);
        birdState = flappyBirdState;
        sc.handleSound("Music");
        
    }

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
        
        if(isTouching(Coin.class))
        {
              get(Coin.class);
              notifyObservers();
              sc.handleSound("coin");
        }
        
        if(startgame.start==true)
          {
            rotateFlappyBird();
            //move(5);
            setLocation(getX(), (int)(getY() + dy));
            //getWorld().addObject(ps,600,15);
            
            pipeIntersection = getOneIntersectingObject(Pipe.class);
            
            Actor powerIntersection = getOneIntersectingObject(Power.class);
            
            if(powerIntersection!=null)
            {
                power++;
                powerIntState = true;
                ((FlappyWorld)getWorld()).getHealth().gainHealth();
                
                if(power == 3)
                {
                    highPowerState = true;
                    sc.handleSound("angry");
                    //this.setImage("angry-bird-icon.png");
                }
                else
                {
                    sc.handleSound("power");
                }
            }
            
            if(pipeIntersection!=null) {
                
                if(highPowerState == true){                    
                    //GreenfootImage img= new GreenfootImage("flappybird1.png");
                    // this.setImage("flappybird1.png");  
                    sc.handleSound("statechange");
                    highPowerState = false;
                    power = 0;
                    // pipeIntersection=null;
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
                    counter++;
                    dy = BOOST_SPEED;
                   if(counter >3) {
                   ((FlappyWorld)getWorld()).getHealth().looseHealth();
                   counter = 0;
                    if(((FlappyWorld)getWorld()).getHealth().health <=0 )
                    {
                        sc.handleSound("stop");
                        displayGameOver();
                        
                    }
                }
                }
            }
            //If FlappyBird drops out of the world, Game Over:      

            //update the UI
            dy = dy+g;
       
    } 
}
     
    //method to check whether flappybird touches the coin  
    public boolean isTouching(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0,clss);
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
    public void displayGameOver(){
        startgame.start=false;
        sc.handleSound("stop");
        GameOver gameOver = new GameOver();
       
        getWorld().addObject(gameOver,getWorld().getWidth()/2,getWorld().getHeight()/2-130);
       
        PlayAgainButton playagainbutton=new PlayAgainButton();
        FinalScore finalscore = new FinalScore();
        getWorld().addObject(playagainbutton,getWorld().getWidth()/2,getWorld().getHeight()/2+100);
        getWorld().addObject(finalscore,getWorld().getWidth()/2,getWorld().getHeight()/2-20);
        
        
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
