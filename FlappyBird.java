import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;


public class FlappyBird extends Actor implements Subject
{
    double dy = 0;
    double g  = 0.5;
    double BOOST_SPEED = -5;
    int power=0;
    int health = 100;
    FlappyWorld flappyworld ;
    boolean pipeIntState=false;
    
    boolean highPowerState = false;
    
    boolean powerIntState = false;
    
    soundClient sc = new soundClient();
    StartGame startgame = new StartGame();
    FlappyBird flappy;
    Butterfly bfly = new Butterfly();
    Health healthbar = new Health();
    PowerScore ps = new PowerScore();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    public FlappyBird(){
    sc.handleSound("Music");
    }
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

    public void act() 
    {
        /*
         * Checking if the flappyBird is touching the coin and if yes then remove coin object from FlappyWorld
         */
        if(isTouching(Coin.class))
        {
              get(Coin.class);
              sc.handleSound("coin");
        }
        if(startgame.start==true){
            rotateFlappyBird();
            /*if(Greenfoot.isKeyDown("up") == true || Greenfoot.isKeyDown("space") == true)
            {
                health-- ;
                ho.show(health);
                
            }*/
            //move(5);
            setLocation(getX(), (int)(getY() + dy));
            getWorld().addObject(ps,600,15);
            
            Actor pipeIntersection = getOneIntersectingObject(Pipe.class);
            
            Actor powerIntersection = getOneIntersectingObject(Power.class);
            
            if(powerIntersection!=null)
            {
                power++;
                powerIntState = true;
               
                ps.setPowScore(power);
                if(power > 2)
                {
                    highPowerState = true;
                    this.setImage("angry-bird-icon.png");
                    sc.handleSound("angry");
                }
                else
                {
                    sc.handleSound("power");
                }
            }
            
            if(pipeIntersection!=null) {
                
                if(highPowerState == true){                    
                    GreenfootImage img= new GreenfootImage("flappybird1.png");
                    this.setImage("flappybird1.png");  
                    sc.handleSound("statechange");
                    highPowerState = false;
                    pipeIntersection=null;
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
                    healthbar.show(health);
                    
                    
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
