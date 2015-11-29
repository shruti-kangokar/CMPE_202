/**
 * Write a description of class ConcreteDecoratorC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class ConcreteDecoratorC extends Decorator 
{
    // instance variables - replace the example below with your own
    FlappyWorld world;
    
    

    public ConcreteDecoratorC( Component c)
    {
        super( c ) ;
    }

    public FlappyWorld operation()
    {
        world = super.operation() ;
        return addedBehavior( world ) ;
    }

	private FlappyWorld addedBehavior(FlappyWorld world) {
		world.newCoin1 = new Coin2();
		int rn = Greenfoot.getRandomNumber(500);

		if (rn % world.COIN_OCCURRANCE_PERIOD == 0) {
			world.addObject(world.newCoin1, 600-(2*Greenfoot.getRandomNumber(100)),(2*Greenfoot.getRandomNumber(100)));
		}
		return world;
	}
}
