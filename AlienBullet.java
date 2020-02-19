/*
 * Purpose: A subclass that represents a alien bullet object
 * 
 * */
import java.awt.*;    //Needed for graphics
public class AlienBullet extends Sprite{
  
   public AlienBullet(int X,int Y){//calls everything from the super class
    super.x=X;
    super.y=Y;
    super.colour=AlienBullet.BULLET_SHAPE;

  }
 //creates a complex diamond shape for alien bullets  
 public static final Color [][] BULLET_SHAPE ={{null,null,Color.RED,null,null},
   {null,Color.RED,Color.RED,Color.RED,null},
   {Color.RED,Color.RED,Color.RED,Color.RED,Color.RED},
   {null,Color.RED,Color.RED,Color.RED,null},
   {null,null,Color.RED,null,null} };
    
 
    public void moveAlienBullet(){
      super.y+=2.0;//moves the alien bullets downwards
    }
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
}