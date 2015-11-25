import greenfoot.*;

public class ConcreteHandler6 implements soundHandler {

    private soundHandler successor = null;
    private GreenfootSound sound = new GreenfootSound("coin.wav");

   public void handleRequest( String request ) {
        if ( request.equalsIgnoreCase("coin") )
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
