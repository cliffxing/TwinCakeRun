import java.util.List;
import greenfoot.*;  
/**
 * Image Credits:
 *(Background, twins, title screens made by myself)
 * Bomb: https://www.google.com/search?q=bomb+png+clip+art&rlz=1C1GCEA_enCA865CA865&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiqiqX_74jnAhUDUK0KHce3C4EQ_AUoAXoECAsQAw&biw=1164&bih=801&safe=active&ssui=on#imgrc=YFfidIuGK4IjJM:
 * Cake: https://www.google.com/search?rlz=1C1GCEA_enCA865CA865&biw=1164&bih=801&tbm=isch&sa=1&ei=SrwgXuqbJsK0tQbJpre4CQ&q=cake+slice+png+clip+art&oq=cake+slice+png+clip+art&gs_l=img.3...2759.3202..3217...0.0..0.94.542.7......0....1..gws-wiz-img.......0i10j0i10i30j0i8i10i30j0i8i30.ZTzuxWjHt1Q&ved=0ahUKEwjq6OaI8IjnAhVCWs0KHUnTDZcQ4dUDCAc&uact=5&safe=active&ssui=on#imgrc=Q4q76BrRg7dgBM:
 * Bomb Explosion: https://freesound.org/people/ryansnook/sounds/110115/
 * Slurp Noise: https://freesound.org/people/Breviceps/sounds/445974/
 * 
 * Code Credits:
 * Code found within 'Button' class is inspired/borrowed off of Mr.Cohen's "MouseOver Button" code: https://www.greenfoot.org/scenarios/24913
 * Collision detection code used for cakes and bombs inspired by: https://www.youtube.com/watch?v=IOTxl2IuSgs 
 * 
 * INSTRUCTIONS:
 * Welcome to Twin Cake Run! The objective of the game is to collect as many cake as 
 * possible, while avoiding the bombs! Get as many cakes as possible and dodge the bombs to survive!
 * Aim for the highest score!
 * 
 * One Cake= +1 Score
 * One Bomb= -1 Life
 *
 * 
 * 
 * Controls:
 * Control Twin One (Twin on the left) using 'A' and 'D'
 * 
 * Control Twin Two (Twin on the right) using 'LEFT' and 'RIGHT' arrow keys
 * 
 * Bugs:
 * When two cakes or two bombs are eaten consequtively very quickly, sometimes the
 * explosion and eating noises do not play. Besides that, as of January 17, 2020, 
 * there are no known bugs yet (sound does not play ocassionally because the first noise did
 * not finish playing yet).
 */


public class MyWorld extends greenfoot.World
{
    //Initializing Twin Objects
    private TwinOne twinOne = new TwinOne();
    private TwinTwo twinTwo = new TwinTwo();
    
    //variables for spawning bombs and cake
    private int ifBomb;
    private int pickLane1;
    private int timeCount=1;
    private int timeCount2=2;
    private int dropCake;
    private int dropCake2;
    
    //variables holding coordinates of lanes
    private int lane1X=115;
    private int lane2X=200;
    private int lane3X=400;
    private int lane4X=485;
    private int allLaneY=105;
    
    //variables for lives and score
    private int lives=3;
    private int score=0;
    
    //bombs and cake variables
    private Bomb bomb = new Bomb();
    private Bomb2 bomb2 = new Bomb2();
    private Cake cake= new Cake();
    private Cake2 cake2= new Cake2();
    private Button button=new Button();
    
    //sounds
    private GreenfootSound eatingSound;
    private GreenfootSound explodeSound;
    private GreenfootSound musicSound;
    
    public MyWorld()
    {    

        super(600, 900, 1); 
        
        //titlepage
        GreenfootImage startScreen=new GreenfootImage("titlepage.png");
        startScreen.scale(getWidth(),getHeight());
        setBackground(startScreen);
        
        
        //add objects
        addObject (button, 300, 750);
        addObject (twinOne, 395, 645);
        addObject (twinTwo, 115, 645);
        
        
        //sound initializing
        eatingSound = new GreenfootSound("eatingnoise.wav");
        explodeSound = new GreenfootSound("bombexplosion.wav");
        musicSound = new GreenfootSound("song.wav");
        
    }

    public void act ()
    {
        musicSound.play(); //main background song
        
        //starts game when button is clicked
        if (button.ifClicked()==true)
        {
            GreenfootImage background=new GreenfootImage("background.png");
            background.scale(getWidth(),getHeight());
            setBackground(background);
            
            setup();
            subtractLives2();
            subtractLives();
            
            addScore();
            addScore2();
            
            
            if (lives>0) //score and life counter
            {
                showText("Lives: "+lives,300,400);
                showText("Score: "+score,300,300);
            }
            
            
        }
        
        
    }
    
    //checks if there is enough lives to run game
    private void setup()
    {

            if (lives>0) //begins spawning bombs and cakes
            {
                checkTimer1();
                checkTimer2();
            }
            
            else //game over screen (if player loses)
            {
                explodeSound.play();
                GreenfootImage gameOver=new GreenfootImage("gameOverScreen.png");
                gameOver.scale(getWidth(),getHeight());
                
                Greenfoot.stop();
                setBackground(gameOver);
                
                List objects = getObjects(null);
                removeObjects(objects);
                
                showText("",300,400);
                showText("",300,300);
                showText("Score: "+score,300,600);
            }
            
    }
    
    //time intervals for spawning bombs in lanes 1 and 2
    private void checkTimer1()
    {
        if (score<25) //speed for score under 25
        {
            if (timeCount%25!=0)
            {
                timeCount=timeCount+1;
                if (timeCount%25==0)
                {
                    bombDrop1();
                    
                }
            }
            else
            {
                timeCount=timeCount+1;
            }
        }
        else if (score<50) //speed change for score above 25
        {
            if (timeCount%18!=0)
            {
                timeCount=timeCount+1;
                if (timeCount%18==0)
                {
                    bombDrop1();
                    
                }
            }
            else
            {
                timeCount=timeCount+1;
            }
        }
        else if (score>=50) //speed change for score above 50
        {
            if (timeCount%14!=0)
            {
                timeCount=timeCount+1;
                if (timeCount%14==0)
                {
                    bombDrop1();
                    
                }
            }
            else
            {
                timeCount=timeCount+1;
            }
        }
        
    }
    
    //time intervals for spawning bombs in lanes 3 and 4
    private void checkTimer2()
    {
        if (score<25) //speed for score under 25
        {
            if (timeCount2%25!=0)
            {
                timeCount2=timeCount2+1;
                if (timeCount2%25==0)
                {
                    bombDrop2();
                    
                }
            }
            else
            {
                timeCount2=timeCount2+1;
            }
        }
        else if (score<50)//speed for score above 25
        {
            if (timeCount2%18!=0)
            {
                timeCount2=timeCount2+1;
                if (timeCount2%18==0)
                {
                    bombDrop2();
                    
                }
            }
            else
            {
                timeCount2=timeCount2+1;
            }
        }
        else if (score>=50) //speed for score above 50
        {
            if (timeCount2%14!=0)
            {
                timeCount2=timeCount2+1;
                if (timeCount2%14==0)
                {
                    bombDrop2();
                    
                }
            }
            else
            {
                timeCount2=timeCount2+1;
            }
        }
        }
    
    
    
    //Randomizes bomb drops in lanes 1 and 2
    private void bombDrop1()
    {
        
        ifBomb=Greenfoot.getRandomNumber(2);
        if (ifBomb == 0)
        {
            pickLane1 = Greenfoot.getRandomNumber (2);
            if (pickLane1== 0) //spawns bomb in lane 1
            {
                addObject (bomb, lane1X , allLaneY );
                
                dropCake=Greenfoot.getRandomNumber(2); //randomizing cake drop in the other lane with bomb
                if (dropCake==0) //50% chance cake drops
                {
                    addObject (cake, lane2X , allLaneY );
                }


            }
            
            else if(pickLane1 == 1) //spawns bomb in lane2
            {
                addObject (bomb, lane2X , allLaneY );
                
                dropCake=Greenfoot.getRandomNumber(2); //randomizing cake drop in the other lane with bomb
                if (dropCake==0)
                {
                    addObject (cake, lane1X , allLaneY );
                }
                
            }
            
        }
        
    }
    
    
    
    //randomizes bomb drop in lanes 3 and 4
    private void bombDrop2()
    {

        ifBomb=Greenfoot.getRandomNumber(2);
        if (ifBomb==0)
        {
            pickLane1 = Greenfoot.getRandomNumber (2);
            if (pickLane1==0) //spawns bomb in lane 3
            {
                
                addObject (bomb2, lane3X , allLaneY );
                if(bomb2.ifTouching2() == true)
                    {
                        lives--;
                    }
                    
                dropCake2=Greenfoot.getRandomNumber(2); //randomizing cake drop in the other lane with bomb
                if (dropCake2==0)
                {
                    addObject (cake2, lane4X , allLaneY );
                }
                

            }
            else if(pickLane1 == 1) //spawns bomb in lane 4
            {
                
                addObject (bomb2, lane4X , allLaneY );
                if(bomb2.ifTouching2() == true)
                {
                    lives--;
                }
                dropCake2=Greenfoot.getRandomNumber(2); //randomizing cake drop in the other lane with bomb
                
                if (dropCake2==0)
                {
                    addObject (cake2, lane3X , allLaneY );
                }
            }

        }
    
    }
    
    //deducts lives if bomb is touched in lanes 1 and 2
    private void subtractLives()
    {
        if(bomb.ifTouching() == true)
        {
            explodeSound.play();
            lives--;
            bomb.setTouchFalse();
            
        }
    }
    
    //deducts lives if bomb is touched in lanes 3 and 4
    private void subtractLives2()
    {
       if(bomb2.ifTouching2() == true)
        {
            explodeSound.play();
            lives--;
            bomb2.setTouchFalse();
            
        } 
    }
    
    //increases lives if cake is touched in lanes 1 and 2
    private void addScore()
    {
        if(cake.ifTouching()==true)
        {
            score++;
            cake.setTouchFalse();
            eatingSound.play();
        }
    }
    
    //increases lives if cake is touched in lanes 3 and 4
    private void addScore2()
    {
        if(cake2.ifTouching2()==true)
        {
            score++;
            cake2.setTouchFalse();
            eatingSound.play();
        }
    }
    

    
   

}

