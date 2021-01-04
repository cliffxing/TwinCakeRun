import greenfoot.*;  


public class TwinOne extends Actor
{
    private GreenfootImage twinOneImage = new GreenfootImage("twin1.png");
    
    public void act() 
    {
        setImage(twinOneImage);
        
        //controls
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation (395, 645);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation (480, 645);
        }
       
    }
    
}
