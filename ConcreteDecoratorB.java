/**
 * Write a description of class ConcreteDecoratorB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class ConcreteDecoratorB extends Decorator
{
    FlappyWorld world;
    

    public ConcreteDecoratorB( Component c)
    {
        super( c ) ;
    }

    public FlappyWorld operation()
    {
        world = super.operation() ;
        return addedBehavior( world ) ;
    }

    private FlappyWorld addedBehavior(FlappyWorld world) {
        world.newPower= new Power();

        int rn = Greenfoot.getRandomNumber(500);
        if (rn % world.POWER_OCCURRANCE_PERIOD == 0) {
            world.addObject(world.newPower, 400+Greenfoot.getRandomNumber(200),Greenfoot.getRandomNumber(200));
        }

        //world.addObject(world.newPower, 500,200);
	return world;

	}
}
