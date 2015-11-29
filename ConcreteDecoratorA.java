/**
 * Write a description of class ConcreteDecoratorA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class ConcreteDecoratorA extends Decorator
{
    FlappyWorld world;
    

    public ConcreteDecoratorA( Component c)
    {
        super( c ) ;
    }

    public FlappyWorld operation()
    {
        world = super.operation() ;
        return addedBehavior( world ) ;
    }

	private FlappyWorld addedBehavior(FlappyWorld world) {
	    
	world.topPipe = new Pipe();
        world.botPipe = new Pipe();
        world.botPipe.setRotation(180);
        
        GreenfootImage image = world.botPipe.getImage();
        world.addObject(world.botPipe, world.getWidth(), world.getHeight()/2 + image.getHeight() - Greenfoot.getRandomNumber(100)); 
        world.addObject(world.topPipe, world.getWidth(), world.botPipe.getY() - image.getHeight() - world.PIPE_SPACING);
        
		return world;
	}
}
