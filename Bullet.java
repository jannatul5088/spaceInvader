/*
 * Purpose: A subclass that represents a bullet object
 * 
 * */
import java.awt.*;    //Needed for graphics
public class Bullet extends Sprite{
 
 public Bullet(int X,int Y){//calls and initializes everything from the superclass
    super.x=X;
    super.y=Y;
    super.colour=Bullet.BULLET_SHAPE;

  }
 //makes a cool Trident shape
 public static final Color [][] BULLET_SHAPE ={{Color.BLUE,null,Color.BLUE,null,Color.BLUE},
   {Color.BLUE,null,Color.BLUE,null,Color.BLUE},
   {Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE},
 {null,null,Color.BLUE,null,null},
   {null,null,Color.BLUE,null,null}};
    
 
    public void moveBullet(){//makes the bullet go upwards
      super.y-=5.0;
    }
    
   
    
    
    
    
}