import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuScreen extends World
{
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Button play = new Button(true);
        addObject(play, 300, 350);
        Label menuLabel = new Label("Menu" , 100);
        menuLabel.setFillColor(Color.BLACK);
        addObject(menuLabel, 300, 250);
        Button switchAvatar = new Button();
        addObject(play, 300, 350);
    }
}
