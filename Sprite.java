/*
 * Purpose: Abstract class giving accesss to x,y,and array to different objects
 * 
 * */
import java.awt.Color;

abstract class Sprite{
  protected int y;///y coordinate
  protected int x;//x coordinate
  protected Color[][] colour;//a 2D array of colours
  
  public Sprite(){}//nothing to do in constructor
  
  
  
  public int getX(){
    return x;//returns the x position
    
  }
  public int getY(){
    return y;//returns the y position
    
  }
  public Color[][] getColorGrid(){
    return colour;//returns the array
    
    
  }
  
  
  
  
  
  
  
  
  
  
  
}