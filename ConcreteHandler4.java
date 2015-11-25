import greenfoot.*;

public class ConcreteHandler4 implements soundHandler {

    private soundHandler successor = null;
    private GreenfootSound sound = new GreenfootSound("powercollect.wav");

   public void handleRequest( String request ) {
        if ( request.equalsIgnoreCase("power") )
        {
            sound.play();
        }
        else
        {
            if ( successor != null )
                successor.handleRequest(request);
        }

   }

    public void setSuccessor(soundHandler next) {
        this.successor = next ;
    }
}
