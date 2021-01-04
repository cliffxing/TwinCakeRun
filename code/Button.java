import greenfoot.*;  

public class Button extends Actor
{
    private MouseInfo m;
    
    private GreenfootImage buttonImage1= new GreenfootImage("button1.png");
    private GreenfootImage buttonImage2= new GreenfootImage("button2.png");
    
    //variables
    private GreenfootImage idleImage;
    private GreenfootImage mouseOverImage;
    private GreenfootImage clickedImage;
    
    private boolean mouseOver;
    private boolean clicked;
    
    //resets variables and images
    public Button ()
    {
        mouseOver = false;
        clicked = false;
        setImage(buttonImage1);
    }
    
    public void act() 
    {
        m = Greenfoot.getMouseInfo();
        if (m != null)
        {
            // MouseOver State
            if (!mouseOver && Greenfoot.mouseMoved(this))
            {
                mouseOver = true;
            }
            
            if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
            {
                mouseOver = false;
            }
            // Clicked State
            if (Greenfoot.mouseClicked(this))
            {
                if (m.getButton() == 1)
                { // main LEFT mouse button
                    clicked = true;                    
                } 
                else if (m.getButton () == 3)
                { // RIGHT mouse button
                    clicked = false;
                }
            }
            
            if (clicked)
            {
                setImage(buttonImage2);
                this.getWorld().removeObject(this);
                
            } 
            else if (mouseOver)
            {
                setImage(buttonImage2);
            } 
            
            else 
            {
                setImage(buttonImage1);
            }
            
            
        }
    }    
    
    //returns clicked variable
    public boolean ifClicked()
    {
        return clicked;
    }
    
}





