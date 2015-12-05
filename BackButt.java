import greenfoot.*; 

public class BackButt extends Button implements Invoker{
 
    private Command BackCommand;
    public BackButt(String title){
        super(title);
    }
    

    public void invoke()
    {
        if (Greenfoot.mouseClicked(this)) 
        BackCommand.execute();
     }
    
    public void setCommand(Command c){
        this.BackCommand = c;
    }
 
}
