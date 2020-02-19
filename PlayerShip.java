/*
 * Purpose: A subclass that represents a player ship object
 * 
 * */
public class PlayerShip extends Sprite{
 
  public PlayerShip(int X,int Y){    //initializes evertyhong from the super class
    super.colour=Display.SHIP_SHAPE;
    super.x=X;
    super.y=Y;
  }
  
  public void moveRight(){//makes the ship go right
    super.x+=10;
  }
  
  public void moveLeft(){//makes the ship go left
    super.x-=20.0;
  }
  
  
  
  
  
  
  
  
}