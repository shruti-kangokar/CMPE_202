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
    final int PIPE_SPACING = 150;
    int score = 0;
    int powerScore = 0;
    final int stateChangeThreshold = 3;
    final int FIRST_PIPE = 240;
    final int POWER_OCCURRANCE_PERIOD = 3;
    final int COIN_OCCURRANCE_PERIOD = 2;
  
    Score newScore = null;
    Score newPowerScore =null;
    
    FlappyBird flappy;
    Pipe topPipe;
    Pipe botPipe;
    StartGame startgame;
    Power newPower;
    PowerImage pImg;
    Coin2 newCoin1;
   
    LevelChange levelchange;
    Health health;
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
        
        newScore = new Score(70,50);
        newScore.setScore(score);
        addObject(newScore, 450, 15);
        
        newPowerScore = new Score(50,50);
         newPowerScore.setScore(powerScore);
        addObject(newPowerScore, 540, 15);
        
        flappy = new FlappyBird();
        addObject(flappy,100,getHeight()/2);
        
        pImg=new PowerImage();
        addObject(pImg,500,20);
              
        addObject(coinCltcd,99,8);
        flappy.attach(coinCltcd);
        
       levelchange = new LevelChange();
        addObject(levelchange,218,27);
        
        health = new Health();
        addObject(health,340,27);     
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
            //flappy.powerIntState = false;
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
            
            if (flappy.pipeIntersection != null) 
            {
                // If in angry bird state go to flappy bird state.
                if (powerScore >= stateChangeThreshold)
                {
                    flappy.setBirdState(flappy.getFlappyBirdState());
                    flappy.setBirdImage();
                    powerScore = 0;
                    newPowerScore.setScore(powerScore);
                    flappy.pipeIntersection = null;
                }
            }
           
           if(flappy.powerIntState){
               //Once the flappy bird reaches power we wil increase the power count
               powerScore++;
               newPowerScore.setScore(powerScore);
               flappy.powerIntState = false;
               
               // Change to angry bird state if bird has consumed more than X fruits
               if (powerScore == stateChangeThreshold)
               {
                   flappy.setBirdState(flappy.getAngryBirdState());
                   flappy.setBirdImage();
                }
           } else {
               
            }
        }
    }
    
    public void createPipes()
    {
        topPipe = new Pipe();
        botPipe = new Pipe();
        botPipe.setRotation(180);
        newPower= new Power();
        newCoin1 = new Coin2();
       
       /*
        Coin[] coins = new Coin[5];
        
        for(int i = 0; i < coins.length; i++)
        {
            coins[i] = new Coin();
            int incr = 0;
            int coinX = getWidth()/2 + 50 + Greenfoot.getRandomNumber(100);
            int coinY = getHeight()/2 + Greenfoot.getRandomNumber(100);
            addObject(coins[i], coinX, coinY);
        }
        */
        
        GreenfootImage image = botPipe.getImage();
        GreenfootImage powerimage = newPower.getImage();
        GreenfootImage newCoinImage = newCoin1.getImage();
        
        addObject(botPipe, getWidth(), getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(100)); 
        addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - PIPE_SPACING);
        
        int rn = Greenfoot.getRandomNumber(500);
        if (rn % POWER_OCCURRANCE_PERIOD == 0) {
            addObject(newPower, 400+Greenfoot.getRandomNumber(200),Greenfoot.getRandomNumber(200));
        }
        if (rn % COIN_OCCURRANCE_PERIOD == 0) {
            addObject(newCoin1, 600-(2*Greenfoot.getRandomNumber(100)),(2*Greenfoot.getRandomNumber(100)));
        }
    }  
}
