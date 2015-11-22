public class HalfSwordState implements BirdState
{
  
    public Butterfly sword;
    public HalfSwordState(Butterfly sword)
    {
    this.sword = sword;
    }

    public boolean hasHalf()
    {
        return true;
    }
    
     public boolean hasNoSword()
    {
        return false;
    }
     
    public void setState()
    {
        sword.setState(sword.getNoSwordState());
        System.out.println("Getting nothin");
    }
    
    public void display()
    {
        System.out.println("Half sword is taken");
    }


}