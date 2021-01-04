import greenfoot.*;  


public class Cake2 extends Actor
{
    //resets touch variable
    public Cake2()
    {
        isTouching2 = false;
    }
    
    private GreenfootImage cake= new GreenfootImage("cake.png");
    private boolean isTouching2=false;
    
    public void act() 
    {
        setImage(cake);        
        setLocation(getX(),getY()+12);
        
        //collision detection
        Actor d=getOneIntersectingObject(TwinOne.class);
        if (d!=null)
        {
            this.getWorld().removeObject(this);
            isTouching2= true;
            
        }
        
        else if (getY()>710)
        {
            this.getWorld().removeObject(this); //deletes if passes twin
            //deletes if passes twin
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
    //resets touch variable

}
