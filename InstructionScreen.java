import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class InstructionScreen extends World
{
    //Varaibles that are used by other classes so they are placed here to be accesible.
    Label Screen;
    Stack<String> nextScreen;
    Stack<String> backScreen;
    Button next;
    Label nextOverlay;
    
    /**
     * Creates a world that contains the instructions. Depending on the value of start at, it will start at that page.
     */
    public InstructionScreen(int startAt)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        nextScreen = new Stack<String>();
        backScreen = new Stack<String>();
        //Uses stacks to contain the screens.
        for(int i = 1; i < startAt; i++)
        {
            backScreen.push("Screen " + i);
        }
        for(int i = 5; i >= startAt; i--)
        {
            nextScreen.push("Screen " + i);
        }
        Screen = new Label(nextScreen.peek(), 100);
        Screen.setFillColor(Color.BLACK);
        addObject(Screen, 300, 200);
        Button back = new Button(false);
        addObject(back, 100, 350);
        next = new Button(true);
        addObject(next, 500, 350);
        Label backOverlay = new Label("Back", 50);
        backOverlay.setFillColor(Color.WHITE);
        addObject(backOverlay, 100, 350);
        nextOverlay = new Label("Next", 50);
        nextOverlay.setFillColor(Color.WHITE);
        addObject(nextOverlay, 500, 350);
    }
    
    /**
     * When the screen changes, it will update and change the text.
     */
    public void updateScreen()
    {
          Screen.setValue(nextScreen.peek());
    }
}
