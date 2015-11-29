
public class Decorator implements Component
{
    private Component component;
    

    public Decorator( Component c )
    {
        component = c ;
    }

    public FlappyWorld operation()
    {
        return component.operation() ;
    }
    
}
