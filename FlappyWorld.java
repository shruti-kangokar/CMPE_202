import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    int pipeCounter =0;
    int flappyCounter = 0;
    int PIPE_SPACING = 150;
    int score = 0;
    int powScore = 0;
    int FIRST_PIPE = 240;
  
    Score newScore = null;
    PowerScore powerScore =null;
    
    FlappyBird flappy;
    Pipe topPipe;
    Pipe botPipe;
    StartGame startgame;
    Power newPower;
    PowerImage pImg;
   //Butterfly butter;
  
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
       
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
         //set paint order
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class,Pipe.class, Power.class);
        
        //Create a new start game and add the object to the world
        startgame=new StartGame();
        addObject(startgame,getWidth()/2,getHeight()/2+70);
        
        newScore = new Score();
        newScore.setScore(0);
        addObject(newScore, 450, 15);
        
        flappy = new FlappyBird();
        
        addObject(flappy,100,getHeight()/2);
        
       
       /*powerScore = new PowerScore();
       powerScore.setPowScore(0);
       addObject(powerScore,600,15);*/
       
       pImg=new PowerImage();
       addObject(pImg,540,21);
       
       /*butter=new Butterfly();
       addObject(butter,400,21);*/
       
       
    }

    public void act()
    { 
        
        if(flappy.pipeintersectionState && flappy.highPowerState==false){
            this.removeObject(botPipe);
            this.removeObject(topPipe);
            flappy.pipeintersectionState = false;
            
            //this.removeObject(flappy);
        }
        
      if(flappy.powerIntersectionState){
            this.removeObject(newPower);
            flappy.powerIntersectionState = false;
        }
          /*   powScore++;
           //System.out.println("Power Score" +powScore);
           powerScore.setPowScore(powScore);
           if(powScore > 1)
           {
               flappy.setImage("angry-bird-icon.png");
               butter.setSwordState();
                this.removeObject(butter);
            }
        }*/
            
        if(startgame.start==true){
            this.removeObject(startgame);
            pipeCounter++;
           if(!flappy.pipeintersectionState){
               
              if(pipeCounter % 100 == 0)
                 {
                   createPipes();
                 }
            
            //Once the flappy bird reaches first pipe we wil increase the bird count
                if(pipeCounter >= FIRST_PIPE)
                {
                     if(flappyCounter % 100 == 0)
                     {
                         //Create a pipe object
                        score++;
                        newScore.setScore(score);
                        //System.out.println("Score : " +score);
                        }
                    flappyCounter++;
                }
            }
          
        }
        
    }
    
    public void createPipes()
    {
        topPipe = new Pipe();
        botPipe = new Pipe();
        botPipe.setRotation(180);
        newPower= new Power();
       
        
        GreenfootImage image = botPipe.getImage();
        GreenfootImage powerimage = newPower.getImage();
        
        addObject(botPipe, getWidth(), getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(100)); 
        addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - PIPE_SPACING);
        
        addObject(newPower, 500,200);

    }  
}
