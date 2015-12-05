import greenfoot.*;

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends World
{

    /**
     * Constructor for objects of class Help.
     * 
     */
    private BackButt bb;
    private PlayCommand bc;
    public Help()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        bb = new BackButt("Back"); //invoker BackButton
        bc = new PlayCommand(); //menu world created a concrete command object.
        addObject(bb,500,70);
        prepare(); 
    }
    
    public void prepare(){

        bb.setCommand(bc); //invoker object stores the concretecommand object in this case playcommand
        bc.setReceiver(   //command object has reference to the receiver object.
            new Receiver() 
            {

                public void doAction() //This is actual action which should happen on click on Play Button
                {
                    if(Greenfoot.mouseClicked(bb)){
                        World newWorld = new Menu();
                        Greenfoot.setWorld(newWorld);
                    }
                }
            });

}
}


