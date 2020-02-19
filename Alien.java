/*
 * Purpose: A subclass that represents a alien object
 * 
 * */
public class Alien extends Sprite{
  
  
  public Alien(int X,int Y){//calls everything from the super class
    super.colour=Display.ALIEN_SHAPE;
    super.x=X;
    super.y=Y;
    
  }
  public void left(){
    super.x-=3;//moves the aliens left
    
    
  }
  
  public void right(){
    super.x+=3;//moves the aliens right
    
    
  }
  public void onestep(){
     super.y+=10;//moves the aliens come down every time it hits the edge of canvas
     
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}