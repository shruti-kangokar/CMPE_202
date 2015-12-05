import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Menu extends World
{
   
    private PlayButt pb;
    private PlayCommand pc;
    private HelpButt hb;
    private HelpCommand hc;
    public Menu()
    {
        super(600, 400, 1);
        pb = new PlayButt("Play"); //invoker PlayButton
        pc = new PlayCommand(); //menu world created a concrete command object.
        addObject(pb,150,120);
        hb = new HelpButt("Help");
        hc = new HelpCommand();
        addObject(hb,400, 120);
        prepare();      
    }
    
  
    public void prepare(){

        pb.setCommand(pc); //invoker object stores the concretecommand object in this case playcommand
        pc.setReceiver(   //command object has reference to the receiver object.
            new Receiver() 
            {

                public void doAction() //This is actual action which should happen on click on Play Button
                {
                    if(Greenfoot.mouseClicked(pb)){
                        World newWorld = new FlappyWorld();
                        Greenfoot.setWorld(newWorld);
                    }
                }
            });

        hb.setCommand(hc);
        hc.setReceiver(
            new Receiver() 
            {

                public void doAction()
                {
                    if(Greenfoot.mouseClicked(hb)){

                        World newWorld = new Help();
                        Greenfoot.setWorld(newWorld);
                    }

                }
            });

    }
            
    
}
