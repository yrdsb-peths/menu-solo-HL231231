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
                clickObject();
        }
    }
    
    public void clickObject()
    {
        if(usesStack)
        {
            if(isNext)
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
                        if(instructionWorld.nextScreen.isNextEmpty())
                        {
                            instructionWorld.removeObject(instructionWorld.next);
                            instructionWorld.removeObject(instructionWorld.nextOverlay);
                        }
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
                    instructionWorld.addObject(instructionWorld.next, 500, 350);
                    instructionWorld.addObject(instructionWorld.nextOverlay, 500, 350);
                }
            }
        }
        else
        {
            
        }
    }
}
