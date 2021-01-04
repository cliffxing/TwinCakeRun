import greenfoot.*;  


public class Bomb extends Actor
{
    
    private GreenfootImage bombImage= new GreenfootImage("bomb2.png");
    private boolean isTouching;
    
    
    //resets touch variable
    public Bomb()
    {
        isTouching = false;
    }
    
    public void act() 
    {
        setImage(bombImage);        
        setLocation(getX(),getY()+12);

        //collision detection
        Actor a=getOneIntersectingObject(TwinTwo.class);
        if (a!=null)
        {
            this.getWorld().removeObject(this);
            isTouching = true;
            
        }
        
        else if (getY()>710)
        {
            this.getWorld().removeObject(this); //deletes if passes twin
        }
        
    }
    
    //returns touch variable
    public boolean ifTouching()
    {
        return isTouching;
    }
    
    //resets touch variable
    public void setTouchFalse()
    {
        isTouching = false;
    }
    
}
