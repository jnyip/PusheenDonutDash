/* Pusheen.java
 * Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 


public class Pusheen{
 
  // instance variables
//  private Maze maze; // does Pusheen need to know about the maze?
  private int paodeNumber;
  private int donutPoints;
  private boolean isHome;
  private DonutStreak donuts;
  
  public Pusheen(int pNum){
   paodeNumber = pNum;   
  }
  
  // take in a coordinate? 
//  public boolean canMove(Paode p){
//    if p == home coordinates
//       isHome = true;
//    if p == monster
//       donuts.scared()
//       donutPoints = 0;
//    if p == donut
//       donutPoints += donut.value
//       donuts.eatAndPoop()
//    update paodeNumber 
//  }
  
  public boolean getIsHome(){
    return isHome; 
  }
  
//  public String toString(){
//    String s = "";
//    s += "Poade Number: " + paodeNumber;
//    s += "\nDonut Points: " + donutPoints;
//    s += "\nIs Pusheen home? " + isHome;
//    
//  }
  
  public static void main(String[] args){
    Pusheen p = new Pusheen(101011);
    
  }
  
}