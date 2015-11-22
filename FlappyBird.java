import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlappyBird extends Actor
{
    double dy = 0;
    double g  = 0.5;
    double BOOST_SPEED = -5;
    int power=0;
    
    boolean pipeintersectionState=false;
    
    boolean highPowerState = false;
    
    boolean powerIntersectionState = false;
    
    StartGame startgame=new StartGame();
    
    Butterfly bfly=new Butterfly();
    PowerScore ps=new PowerScore();
    

    public void act() 
    {
        if(startgame.start==true){
            rotateFlappyBird();
            //move(5);
            setLocation(getX(), (int)(getY() + dy));
            getWorld().addObject(ps,600,15);
            
            Actor pipeIntersection = getOneIntersectingObject(Pipe.class);
            
            Actor powerIntersection = getOneIntersectingObject(Power.class);
            
            if(powerIntersection!=null) //&& Two strwberries then change to angry)
            {
                power++;
                System.out.println("Current Power level: " + power);
                powerIntersectionState = true;
                
                ps.setPowScore(power);//updating the score

                if(power > 2)// && highPowerState == false)
                {
                    System.out.println("Getting ready to switch states!");
                    highPowerState = true;
                    bfly.setSwordState();
                    this.setImage("angry-bird-icon.png");
                    
                }
            }
            //if we are touching a pipe game over
            
            if(pipeIntersection!=null) {
                pipeintersectionState = true;
                if(highPowerState==true){
                    
                    GreenfootImage img= new GreenfootImage("flappybird1.png");
                    this.setImage("flappybird1.png");  
                    
                }
                else
                {
                    System.out.println("About to Die");
                    highPowerState=false;
                    displayGameOver();
                }
                
            }
            //If user pressed UP arrow and SPACE bar launch flappy Bird upward
            if(!pipeintersectionState){
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
    private void displayGameOver(){
        startgame.start=false;
        
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver,getWorld().getWidth()/2,getWorld().getHeight()/2);
        
        PlayAgainButton playagainbutton=new PlayAgainButton();
        getWorld().addObject(playagainbutton,getWorld().getWidth()/2,getWorld().getHeight()/2+70);
        
        pipeintersectionState=false;
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
