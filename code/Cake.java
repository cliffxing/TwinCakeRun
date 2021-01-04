import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Cake extends Actor
{

    private GreenfootImage cake= new GreenfootImage("cake.png");
    
    private boolean isTouching=false;
    
    
    //resets touch variable
    public Cake()
    {
        isTouching = false;
    }
    
    public void act() 
    {
        setImage(cake);        
        setLocation(getX(),getY()+12);
        
        //collision detection
        Actor c=getOneIntersectingObject(TwinTwo.class);
        if (c!=null)
        {
            this.getWorld().removeObject(this);
            isTouching= true;
            
        }
        else if (getY()>710)
        {
            this.getWorld().removeObject(this); //deletes if passing player

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
