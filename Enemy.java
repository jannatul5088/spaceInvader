/*
 * Purpose: A subclass that represents a enemy bullet object
 * 
 * */
import java.awt.*;    //Needed for graphics
public class Enemy extends Sprite{
  
   public Enemy(int X,int Y){//calls everything from the super class
    super.x=X;
    super.y=Y;
    super.colour=Enemy.BULLET_SHAPE;

  }
 //creates a complex diamond shape for alien bullets  
 public static final Color [][] BULLET_SHAPE ={{null,null,Color.RED,null,null},
   {null,Color.RED,Color.RED,Color.RED,null},
   {Color.RED,Color.RED,Color.RED,Color.RED,Color.RED},
   {null,Color.RED,Color.RED,Color.RED,null},
   {null,null,Color.RED,null,null} };
    
 
    public void moveEnemy(){
      super.y+=1.0;//moves the alien bullets downwards
    }
}