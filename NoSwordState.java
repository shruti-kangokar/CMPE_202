public class NoSwordState implements BirdState
{
  
    public Butterfly sword;
    public NoSwordState(Butterfly sword)
    {
        this.sword = sword;
    }
    public boolean hasHalf()
    {
        return false;
    }
        
    public boolean hasNoSword()
    {
        return true;
    }
     
    public void setState()
    {
        sword.setState(sword.getHalfSwordState());
        System.out.println(" Getting half");
    }
    
    public void display()
    {
        System.out.println("No sword is taken");
    }


}