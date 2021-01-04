import greenfoot.*;  


public class TwinTwo extends Actor
{
    private GreenfootImage twinTwoImage = new GreenfootImage("twin2.png");
     
    public void act() 
    {
        //controls
        setImage(twinTwoImage);
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation (115, 645);
        }
        
        if (Greenfoot.isKeyDown("d")){
            setLocation (200, 645);
        }
    }    
}
