/*
 * Purpose: A class that creates differnct objects and detects collisions and removes onjects
 * 
 * */
import java.util.ArrayList;
import java.util.*;

public class SpaceInvaders{
  Random bulletProbability=new Random();//creates a random variable
  private int height;//for my Y
  private int width;//for my X
 
  int dict=Display.MOVE_RIGHT;  //first set to move right because my alien at forst is at left
  private int alienKilled=0;  //number of alien hit
  private static int totalAlienNumber=0;	//total number of aliens
  private static boolean gameover=false;	//a boolean gameover which will become true if set, but for now false
  private ArrayList<Sprite> arraylist;	//an array list of sprite
  
  public SpaceInvaders(int height, int width){
    this.height=height;	//initializing the parameters
    this.width=width;	//initializing the parameters
    arraylist=new ArrayList<Sprite>(); 	//makes a new arraylist
    for(int i=0;i<5;i++){ 	//for 5 aliens horizontally
      for(int j=0;j<5;j++){	 //for 5 aliens vertically
        int alienSpacing=35;	//spacing betwwen aliens
        int row=alienSpacing*i;	//next x position of aliens
        int col=alienSpacing*j;	//next y position of aliens
       
        totalAlienNumber=(i+1)*(j+1);	//total number of aliens by multipying and add 1 beacuse loop starts from 0
        
    Alien newAlien=new Alien(row,col);	//makes a new alien
    arraylist.add(newAlien);	//adds a new alien to arraylist 
    	}
    }
    PlayerShip player=new PlayerShip(200,350);	//makes  a new playership
    arraylist.add(player);	//adds player ship to arraylist
  }
  public void update(){		//does everything 30 times/second
    
    if(arraylist.get(0).getX()>300){	//if x coorsinate of 1st alien is more than 300
      dict = Display.MOVE_LEFT;		//change direction to move left
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof Alien)	///if object in arraylist is alien
          ((Alien)arraylist.get(i)).onestep();}	//move one step down if touches right edge
    }
    else if(arraylist.get(0).getX()<4){		//if x coorsinate of 1st alien is less than 4
      dict = Display.MOVE_RIGHT;		//change direction to move right
      for(int j=0;j<arraylist.size();j++){
       if(arraylist.get(j) instanceof Alien) 	///if object in arraylist is alien
         ((Alien)arraylist.get(j)).onestep();	//move one step down if touches left edge
      
      }
    }
    
    for(int i=0;i<arraylist.size();i++){
      if(arraylist.get(i) instanceof Bullet){	//if object in arraylist is bullet
        if(arraylist.get(i).getY()<0 ){		//if bullets goes out of canvas
        arraylist.remove(i);			//remove that bullet
        continue;
      }
        ((Bullet)arraylist.get(i)).moveBullet();	//downcast and move that bullet up
        if(crash((Bullet)arraylist.get(i))){	//checks if there is a collision between alien and bullet
          alienKilled++;		//number of aliens killed (my counter) increments by 1
          arraylist.remove(i-1);}		//if hits alien, remove that BULLET
        }
    }
    for(int i=0;i<arraylist.size();i++){
      if(arraylist.get(i) instanceof Enemy){	//if object in arraylist is alien bullet
        
       playerKilled((Enemy)arraylist.get(i));	//checks if there is a collision between alien's bullet and player
        if(arraylist.get(i).getY()>450 ){	// if alien's bullet goes down out of the canvas
        arraylist.remove(i);	//remove alien's bullet
        continue;
      }
      ((Enemy)arraylist.get(i)).moveEnemy();	//moves the alien's bullet down
      }
    }
    
    alienShoot();	//helper
    moveAlien(dict);	//helper  
  }
  
  public void alienShoot(){
    int count=0;//alien bullet counter
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof Enemy){
          ((Enemy)arraylist.get(i)).moveEnemy();	//moves the alien bullet down
          count++;		//counter increments 
        }
      }
      if(count<3){//if counter is less than 3
        for(int i=0;i<arraylist.size();i++){
          if(arraylist.get(i) instanceof Alien){
            int alienBulletX=((arraylist.get(i)).getX()); 	//collects the x position of alien's bullet
            int alienBulletY=((arraylist.get(i)).getY());	//collects the y position of alien's bullet
            
            int k=bulletProbability.nextInt(100);//of 100 types
            if(k<=5)//makes each probability 5%
            arraylist.add(new Enemy(alienBulletX,alienBulletY));	//adds alien bullet with 5% chance
          }
        } 
      } 
  }
  
  public ArrayList<Sprite> getItems(){
    return arraylist;//returns the arraylist

  }
  
  public int status(){
    
    if(alienKilled==totalAlienNumber)	//if aliens killed is total number of alien existed
      return Display.WIN;    //show WIN
    else if(gameover)	//if boolean is true
      return Display.LOSE;  //show LOSE
    else 
      return Display.CONTINUE;//else continue the game      
  }
  
  public void move(int direction){//controls the movement of player ship
    if(direction==Display.MOVE_LEFT){
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof PlayerShip){//if object is a player ship
         ((PlayerShip)arraylist.get(i)).moveLeft();//move it left
        }
      }
    }
     if(direction==Display.MOVE_RIGHT){
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof PlayerShip){	//if object is a player ship
         ((PlayerShip)arraylist.get(i)).moveRight();	//move right
        }
      }
    }
  }
  
  public void shoot(){

    int count=0;
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof Bullet){		//if object is a bullet
          ((Bullet)arraylist.get(i)).moveBullet();	//move the bullet go upward
          count++;//increment the counter
          
        }
      }
      if(count<2){	//if the bullet in canvas is no more than 2
        int xofship = 0;//a variable
        int yofship=0;// a variable
        for(int i=0;i<arraylist.size();i++){
          if(arraylist.get(i) instanceof PlayerShip){	//if object is a playership
           xofship=((arraylist.get(i)).getX()); 	//variable set to find the x position of playership
           yofship=((arraylist.get(i)).getY());	 //variable set to find the y position of playership
          }
        }
        arraylist.add(new Bullet(xofship,yofship));//adds new bullet at the current position of playership
      }
  }
  
  public void moveAlien(int direction){//helper method
    
    if(direction==Display.MOVE_LEFT){//is alien is make to move left 
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof Alien){//if obejct is a alien
         ((Alien)arraylist.get(i)).left();//call the method to make it move left
        }
      }
    }
    if(direction==Display.MOVE_RIGHT){//is alien is make to move right
      for(int i=0;i<arraylist.size();i++){
        if(arraylist.get(i) instanceof Alien)//if obejct is a alien
         ((Alien)arraylist.get(i)).right();//call the method to make it move right
      }
    }
  }
  
  
  public boolean crash(Bullet bullet){//helper method
    int bulletX=bullet.getX();//gets the current x coordinate of bullet
    int bulletY=bullet.getY();//gets the current y coordinate of bullet
    for(int i=0;i<arraylist.size();i++){
      if(arraylist.get(i) instanceof Alien){//if object is a alien
        int alienX=arraylist.get(i).getX();//gets the x coordinate of alien
        int alienY=arraylist.get(i).getY();//gets the y coordinate of alien
        double alienSpacing=Math.sqrt(((alienX-bulletX)*(alienX-bulletX))+((alienY-bulletY)*(alienY-bulletY)));
        //distance formula of 2 points
        if(alienSpacing<30){//if distance between bullet and alien is less than 30
          arraylist.remove(i);//remove that alien
          i--;//decrement the index to set it to normal
          return true;
        }
      }
      
    }
    return false;

  }
  public boolean playerKilled(Enemy bullet){
    int bulletX=bullet.getX();//gets the x coordinate of alien bullet
    int bulletY=bullet.getY();//gets the y coordinayte of alien bullet
    for(int i=0;i<arraylist.size();i++){
      if(arraylist.get(i) instanceof PlayerShip){//is object is a playership
       int playerX=arraylist.get(i).getX();//gets the x coordinate of playership
       int playerY=arraylist.get(i).getY();//gets tge y coordinate of p;ayer ship
       double alienSpacing=Math.sqrt(((playerX-bulletX)*(playerX-bulletX))+((playerY-bulletY)*(playerY-bulletY)));
       //distance formula of 2 points
       if(alienSpacing<20){//if distance between alien bullet and player ship is less than 20
        gameover=true;//set my boolean to true
        return true;
       }
      }
    }
    
   return false; 
    
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}