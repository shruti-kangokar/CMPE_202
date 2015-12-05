import greenfoot.*; 

public class HelpButt extends Button implements Invoker{
 
    private Command HelpCommand;
    public HelpButt(String title){
        super(title);
    }
    

    public void invoke()
    {
        if (Greenfoot.mouseClicked(this)) 
        HelpCommand.execute();
     }
    
    public void setCommand(Command c){
        this.HelpCommand = c;
    }
 
}
