import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


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
    Power newPower;
    
    FlappyBird flappy;
    StartGame startgame;
    
    PowerImage pImg;
    
    Pipe topPipe;
    Pipe botPipe;

    Coin2 newCoin1;
    Health health = new Health();
    //LevelChange levelchange;
    //Health health;

    soundClient sc = new soundClient();
    
    GreenfootSound music = new GreenfootSound("Music.mp3"); 

    CoinsCollected coinCltcd = new CoinsCollected(flappy);
   
    public FlappyWorld()
    {   
        super(600, 400, 1, false); 
        setPaintOrder(GameOver.class, FlappyBird.class,Score.class,Power.class, Pipe.class);
        //setPaintOrder(FlappyBird.class,Pipe.class, Power.class,Coin.class,GameOver.class, Score.class);
        
        startgame=new StartGame();
        addObject(startgame,getWidth()/2,getHeight()/2+70);
        
        newScore = new Score();
        newScore.setScore(0);
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

        prepare();
    }

    public Health getHealth()
    {
       return health; 
    }
    

    private void prepare()
    {
        addObject(health, 200,40);
        //Health health = new Health();

        health.setLocation(311,15);
    }

    public void act()
    { 
        
        if(flappy.pipeIntState){
            sc.handleSound("stop");
            this.removeObject(botPipe);
            this.removeObject(topPipe);
            this.removeObject(flappy);
            flappy.pipeIntState = false;
        }
        
        if(flappy.powerIntState){
            this.removeObject(newPower);
            flappy.powerIntState = false;
            powerScore++;
            newPowerScore.setScore(powerScore);
           
           
           // Change to angry bird state if bird has consumed more than X fruits
               if (powerScore == stateChangeThreshold)
               {
                   flappy.setBirdState(flappy.getAngryBirdState());
                   flappy.setBirdImage();
                }
        }
            
        if(startgame.start==true){
            this.removeObject(startgame);
            sc.handleSound("titlesong");
            pipeCounter++;
           if(!flappy.pipeIntState){
               
              if(pipeCounter % 100 == 0)
                 {
                   //createPipes();
                   Component obj =new ConcreteDecoratorC( new ConcreteDecoratorB( new ConcreteDecoratorA( new ConcreteComponent(this) ) ) );
                   obj.operation();
                   //System.out.println( result );
                 }
            
            
                if(pipeCounter >= FIRST_PIPE)
                {
                     if(flappyCounter % 100 == 0)
                     {
                         //Create a pipe object
                        score++;
                        newScore.setScore(score);
                        if(score>5){
                            this.setBackground("images/b2.png");
                        }
                        if(score>10){
                            this.setBackground("images/b3.png");                            
                        }
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
          
        }
        
    }

}
