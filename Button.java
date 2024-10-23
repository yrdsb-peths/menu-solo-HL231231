import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Button extends Actor
{
    //Variables that are needed to be assecible by other classes.
    public boolean isNext;
    public boolean usesStack;
    
    /**
     * Create an instance of button. isNext determines if the button will move the screen back or forward. Makes sure that the button uses the stack.
     */
    public Button(boolean isNext)
    {
        this.isNext = isNext;  
        usesStack = true;
    }
    
    /**
     * Creates an instance of button that is used to rotate the queue.
     */
    public Button()
    {
        usesStack = false;
    }
    
    /**
     * Checks if user clicks an object.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
                changeScreen();
        }
    }
    
    /**
     * Changes the screen or scrolls the queue that contains the avatar depending on the variables in the button class.
     */
    public void changeScreen()
    {
        //Checks if the button changes the queue or the stack.
        if(usesStack)
        {
            //Checks if the button moves the screen forward or backwards
            if(isNext)
            {
                //Checks if the current screen is the menu world.
                if(getWorld().getClass() != InstructionScreen.class)
                {
                    //Changes the world from menu to instructions
                    InstructionScreen instructions = new InstructionScreen(1);
                    Greenfoot.setWorld(instructions);
                }
                else
                {
                    InstructionScreen instructionWorld = (InstructionScreen) getWorld();
                    //Checks if at the end of instructions. If it is, it will move onto high scores.
                    if(!instructionWorld.nextScreen.isNextEmpty())
                    {
                        //Moves to the next instruction screen
                        instructionWorld.backScreen.push(instructionWorld.nextScreen.pop());
                        instructionWorld.updateScreen();
                    }
                    else
                    {
                        //Changes world from instruction to high scores.
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
                //Checks if the world is InstructionScreen
                if(getWorld().getClass() == InstructionScreen.class)
                {
                    InstructionScreen instructionWorld = (InstructionScreen) getWorld();
                    //Checks if the screen is the beginning of instructions.
                    if(instructionWorld.backScreen.isEmpty())
                    {
                        //Sets the world from instructions to menu
                        MenuScreen menu = new MenuScreen();
                        Greenfoot.setWorld(menu);
                    }
                    else
                    {
                        //Moves the instruction screen backwards
                        instructionWorld.nextScreen.push(instructionWorld.backScreen.pop());
                        instructionWorld.updateScreen();
                    }
                }
                else
                {
                    //Turns the world into instruction screen if it is not.
                    InstructionScreen instructions = new InstructionScreen(5);
                    Greenfoot.setWorld(instructions);
                }
            }
        }
        else
        {
            //Scrolls the queue that contains the avatars.
            MenuScreen menu = (MenuScreen) getWorld();
            menu.avatar.Faces.enqueue(menu.avatar.Faces.dequeue());
        }
    }
}
