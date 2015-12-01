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
    
//     boolean b1 = true, b2 = false, b3 = false;

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
	     CoinPattern(world.b1,world.b2,world.b3,world);
		 return world;
	}
	public void CoinPattern(boolean P1, boolean P2, boolean P3,FlappyWorld world)
    {
	    int coinX = 0,coinY = 0;
        int incrPos = 0;
        if(P1 == true)
        {
            for(int i = 0; i < world.coins.length; i++)
            {
                world.coins[i] = new Coin();  
                
                coinX = world.getWidth()/2 + incrPos;
                coinY = world.getHeight()/2;
                
                world.addObject(world.coins[i], coinX, coinY);
                incrPos += 50;
            }
            world.b1=false;world.b2=true;world.b3=false;
        }
        
        if(P2 == true)
        {
            for(int i = 0; i < world.coins.length; i++)
            {
                world.coins[i] = new Coin();   
                if(i == 0)     
                {
                    coinX = world.getWidth()/2;
                    coinY = world.getHeight()/2;
                }
                if(i > 0 && i < 3)
                {
                    coinX = world.coins[i-1].getX()+25;
                    coinY = world.coins[i-1].getY()+25;
                }
                if(i > 2)
                {
                    coinX = world.coins[i-1].getX()+25;
                    coinY = world.coins[i-1].getY()-25;
                }
                
                world.addObject(world.coins[i], coinX, coinY);
            }
            world.b1=false;world.b2=false;world.b3=true;
        }
        
        if(P3 == true)
        {
            for(int i = 0; i < world.coins.length; i++)
            {
                world.coins[i] = new Coin();   
                if(i == 0)     
                {
                    coinX = world.getWidth()/2;
                    coinY = world.getHeight()/2;
                }
                if(i > 0 && i < 3)
                {
                    coinX = world.coins[i-1].getX()+25;
                    coinY = world.coins[i-1].getY()-25;
                }
                if(i > 2)
                {
                    coinX = world.coins[i-1].getX()+25;
                    coinY = world.coins[i-1].getY()+25;
                }
                
                world.addObject(world.coins[i], coinX, coinY);
            }
            world.b1=true;world.b2=false;world.b3=false;
        }
	    
    }
}
