import greenfoot.*;
public class FlappyBirdState implements BirdState 
{
    FlappyBird flappyBird;
    
    public FlappyBirdState(FlappyBird newFlappyBird)
    {
        flappyBird = newFlappyBird;
    }
    
    @Override
    public void setBirdImage()
    {
        GreenfootImage img= new GreenfootImage("flappybird1.png");
        flappyBird.setImage("flappybird1.png");
    } 
}
