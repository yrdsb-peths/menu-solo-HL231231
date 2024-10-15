import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    public boolean isNext;
    public boolean usesStack;
    public Button(boolean isNext)
    {
        this.isNext = isNext;  
        usesStack = true;
    }
    
    public Button()
    {
        usesStack = false;
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(usesStack)
            {
                clickObjectStack();   
            }
            else
            {
                clickObjectQueue();
            }
        }
    }
    
    public void clickObjectStack()
    {
        if(isNext == true)
        {
            if(getWorld().getClass() != InstructionScreen.class)
            {
                InstructionScreen instructions = new InstructionScreen();
                Greenfoot.setWorld(instructions);
            }
            else
            {
                InstructionScreen instructionWorld = (InstructionScreen) getWorld();
                if(!instructionWorld.nextScreen.isNextEmpty())
                {
                    instructionWorld.backScreen.push(instructionWorld.nextScreen.pop());
                    instructionWorld.updateScreen();
                }
            }
        }
        else
        {
            InstructionScreen instructionWorld = (InstructionScreen) getWorld();
            if(instructionWorld.backScreen.isEmpty())
            {
                MenuScreen menu = new MenuScreen();
                Greenfoot.setWorld(menu);
            }
            else
            {
                instructionWorld.nextScreen.push(instructionWorld.backScreen.pop());
                instructionWorld.updateScreen();
            }
        }
    }
    
    public void clickObjectQueue()
    {
        
    }
}
