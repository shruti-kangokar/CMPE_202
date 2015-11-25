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
   CoinsCollected coinCltcd = new CoinsCollected(flappy);

  
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {   
        super(600, 400, 1, false); 
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class,Pipe.class, Power.class);
        
        startgame=new StartGame();
        addObject(startgame,getWidth()/2,getHeight()/2+70);
        
        newScore = new Score();
        newScore.setScore(0);
        addObject(newScore, 450, 15);
        
        flappy = new FlappyBird();
        addObject(flappy,100,getHeight()/2);
        
        pImg=new PowerImage();
        addObject(pImg,540,21);
              
        addObject(coinCltcd,99,8);
        flappy.attach(coinCltcd);
    }

    public void act()
    { 
        
        if(flappy.pipeIntState){
            this.removeObject(botPipe);
            this.removeObject(topPipe);
            this.removeObject(flappy);
            flappy.pipeIntState = false;
        }
        
        if(flappy.powerIntState){
            this.removeObject(newPower);
            flappy.powerIntState = false;
        }
            
        if(startgame.start==true){
            this.removeObject(startgame);
            pipeCounter++;
           if(!flappy.pipeIntState){
               
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
       
        Coin[] coins = new Coin[5];
        
        for(int i = 0; i < coins.length; i++)
        {
            coins[i] = new Coin();
            int incr = 0;
            int coinX = getWidth()/2 + 50 + Greenfoot.getRandomNumber(100);
            int coinY = getHeight()/2 + Greenfoot.getRandomNumber(100);
            addObject(coins[i], coinX, coinY);
        }
        
        GreenfootImage image = botPipe.getImage();
        GreenfootImage powerimage = newPower.getImage();
        
        addObject(botPipe, getWidth(), getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(100)); 
        addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - PIPE_SPACING);
        
        addObject(newPower, 500,200);

    }  
}
