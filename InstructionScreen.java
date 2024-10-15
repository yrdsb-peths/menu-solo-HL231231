import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class InstructionScreen extends World
{
    Label Screen;
    Stack<String> nextScreen;
    Stack<String> backScreen;
    
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        nextScreen = new Stack<String>();
        backScreen = new Stack<String>();
        for(int i = 5; i >= 1; i--)
        {
            nextScreen.push("Screen " + i);
        }
        Screen = new Label(nextScreen.peek(), 100);
        Screen.setFillColor(Color.BLACK);
        addObject(Screen, 300, 200);
        Button next = new Button(false);
        addObject(next, 100, 350);
        Button back = new Button(true);
        addObject(back, 500, 350);
    }

    public void updateScreen()
    {
          Screen.setValue(nextScreen.peek());
    }
}
