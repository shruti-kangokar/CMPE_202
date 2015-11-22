import greenfoot.*;
public class Butterfly extends Actor
{
    BirdState halfsword;
    BirdState nosword;
    
    BirdState state;
    public Butterfly(){
        nosword = new NoSwordState(this);
        halfsword = new HalfSwordState(this);
        state = nosword;
    }

    public boolean hasHalf() {
        return state.hasHalf();
    }
    
    public boolean hasNoSword() {
        return state.hasNoSword();
    }
    
    public void display() {
        state.display();
    }
    
    void setState(BirdState state) {
        this.state = state;
    }
    
    public void setSwordState(){ 
        state.setState();
    }
        
    BirdState getHalfSwordState(){
        return halfsword;
    }
    
    BirdState getNoSwordState()
	{
	    return nosword;
	}
    
    public void act() 
    {
        // Add your action code here.
    }
}