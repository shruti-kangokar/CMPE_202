import greenfoot.*;

public class ConcreteHandler3 implements soundHandler {

    private soundHandler successor = null;
    private GreenfootSound sound = new GreenfootSound("won.mp3");

   public void handleRequest( String request ) {
        if ( request.equalsIgnoreCase("won") )
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
