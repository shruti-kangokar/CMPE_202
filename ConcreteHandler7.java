import greenfoot.*;

public class ConcreteHandler7 implements soundHandler {

    private soundHandler successor = null;
    private GreenfootSound sound = new GreenfootSound("angrystate.wav");

   public void handleRequest( String request ) {
        if ( request.equalsIgnoreCase("angry") )
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
