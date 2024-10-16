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
                    InstructionScreen instructions = new InstructionScreen(1);
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
                    else
                    {
                        if(instructionWorld.nextScreen.isNextEmpty())
                        {
                            HighScoreScreen HighScoreWorld = new HighScoreScreen();
                            Greenfoot.setWorld(HighScoreWorld);
                        }
                    }
                }
            }
            else
            {
                if(getWorld().getClass() == InstructionScreen.class)
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
                else
                {
                    InstructionScreen instructions = new InstructionScreen(5);
                    Greenfoot.setWorld(instructions);
                }
            }
        }
        else
        {
            MenuScreen menu = (MenuScreen) getWorld();
            menu.avatar.Faces.enqueue(menu.avatar.Faces.dequeue());
        }
    }
}
