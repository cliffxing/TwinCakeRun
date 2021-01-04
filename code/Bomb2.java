import greenfoot.*;  


public class Bomb2 extends Actor
{
    private GreenfootImage bombImage= new GreenfootImage("bomb2.png");
    private boolean isTouching2;
    
    //resets touch variable
    public Bomb2()
    {
        isTouching2 = false;
    }
    
    public void act() 
    {
        setImage(bombImage);        
        setLocation(getX(),getY()+12);
        
        //collision detection
        Actor b=getOneIntersectingObject(TwinOne.class);
        if (b!=null)
        {
            this.getWorld().removeObject(this);
            isTouching2 = true;
            

        }
        else if (getY()>710)
        {
            this.getWorld().removeObject(this); //deletes if passes twin
        }
        
    }
    
    //returns touch variable
    public boolean ifTouching2()
    {
        return isTouching2;
    }
    
    //resets touch variable
    public void setTouchFalse()
    {
        isTouching2 = false;
    }
}
