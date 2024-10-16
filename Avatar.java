import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Avatar extends Actor
{
    Queue<GreenfootImage> Faces;
    GreenfootImage avatar;
    public Avatar()
    {
        Faces = new Queue<GreenfootImage>();
        Faces.enqueue(new GreenfootImage("images/Faces/face_a.png"));
        Faces.enqueue(new GreenfootImage("images/Faces/face_b.png"));
        Faces.enqueue(new GreenfootImage("images/Faces/face_c.png"));
    }
    
    public void act()
    {
        setImage(Faces.checkFirst());
    }
}
