import greenfoot.*; 

public class PlayButt extends Button implements Invoker{
 
    private Command PlayCommand;
    public PlayButt(String title){
        super(title);
    }
    

    public void invoke()
    {
        if (Greenfoot.mouseClicked(this)) 
        PlayCommand.execute();
     }
    
    public void setCommand(Command c){
        this.PlayCommand = c;
    }
 
}
