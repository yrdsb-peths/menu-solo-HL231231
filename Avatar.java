import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Avatar extends Actor
{
    //Variables that are needed to be accesible by other classes.
    Queue<GreenfootImage> Faces;
    GreenfootImage avatar;
    
    /**
     * Creates an instance of Avatar, creates a queue and places the avatars into that queue.
     */
    public Avatar()
    {
        Faces = new Queue<GreenfootImage>();
        Faces.enqueue(new GreenfootImage("images/Faces/face_a.png"));
        Faces.enqueue(new GreenfootImage("images/Faces/face_b.png"));
        Faces.enqueue(new GreenfootImage("images/Faces/face_c.png"));
    }
    
    /**
     * Sets the avatar to the current image in the queue.
     */
    public void act()
    {
        setImage(Faces.checkFirst());
    }
}
