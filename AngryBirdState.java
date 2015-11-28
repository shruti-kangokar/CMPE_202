import greenfoot.*;
public class AngryBirdState implements BirdState 
{
    FlappyBird flappyBird;
    
    public AngryBirdState(FlappyBird newFlappyBird)
    {
        flappyBird = newFlappyBird;
    }
    
    @Override
    public void setBirdImage()
    {
        GreenfootImage img= new GreenfootImage("angry-bird-icon.png");
        flappyBird.setImage("angry-bird-icon.png");
    }
}
