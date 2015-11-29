
public class ConcreteComponent implements Component
{
    FlappyWorld world;
    
    public ConcreteComponent(FlappyWorld world)
    {
        this.world=world;        
    }
    
    
    public FlappyWorld operation() {
		return world;		
	}

}
