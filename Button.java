import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    public boolean isNext;
    
    public Button(boolean isNext)
    {
        this.isNext = isNext;   
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            clickObject();
        }
    }
    
    public void clickObject()
    {
        if(isNext == true)
        {
            if(getWorld().getClass() != InstructionScreen.class)
            {
                InstructionScreen instructions = new InstructionScreen();
                Greenfoot.setWorld(instructions);
            }
        }
        else
        {
            
        }
    }
}
