import greenfoot.*;

public class ConcreteHandler1 implements soundHandler {

    private soundHandler successor = null;
    private GreenfootSound sound = new GreenfootSound("au.wav");

   public void handleRequest( String request ) {
        if ( request.equalsIgnoreCase("statechange") )
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
