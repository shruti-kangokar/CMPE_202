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
    Score newScore = null;
    int FIRST_PIPE = 240;
    FlappyBird flappy;
    Pipe topPipe;
    Pipe botPipe;
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
         //set paint order
        setPaintOrder(GameOver.class, Score.class, FlappyBird.class,Pipe.class);
        
         //Create a flappy bird object
        flappy = new FlappyBird();
        //Add flappy bird to our world
        addObject(flappy,100,getHeight()/2);
        
        //Create a Score Object and add it to our world
        newScore = new Score();
        newScore.setScore(0);
        addObject(newScore, 300, 20);
    }
    
    public void act()
    {
       pipeCounter++;
        if(flappy.intersection){
            this.removeObject(botPipe);
            this.removeObject(topPipe);
            this.removeObject(flappy);
        }else{
            
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
           
                }
            flappyCounter++;
            
        }
    }
    }
    
    public void createPipes()
    {
        topPipe = new Pipe();
        botPipe = new Pipe();
        botPipe.setRotation(180);
        GreenfootImage image = botPipe.getImage();
        
        addObject(botPipe, getWidth(), getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(100)); 
        addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - PIPE_SPACING);
    }
    
    
}
