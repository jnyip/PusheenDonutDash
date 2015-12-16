/* Pusheen.java
 * Pusheen class creates an "avatar" for the user to play as during the game.  
 * 
 * Written by: Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pusheen{
  
  // Instance Variables
  private Paode user;
  private int donutPoints;
  private boolean isHome;
  private DonutStreak donuts;
  private boolean gameOver;
  
  /* Constructor: Create a Pusheen object that can move over the paodes in the 
   * maze. 
   * 
   * Creates a Pusheen at the given Paode, initializes DonutStreak, DonutPoints,
   * and isHome
   * 
   * @param p the Paode where Pusheen begins  
   */
  public Pusheen(){
    user = null;  
    donuts = new DonutStreak();
    donutPoints = 0;
//    isHome = false;
//    gameOver = false;
  }
  
  /**
   * move()
   * Moves Pusheen to the given Paode while checking the given Paode's status 
   * (whether it contains a monster, donut, home, or nothing)
   *
   * @param p A Paode 
   * @return int Returns actual color of the donut  
   */
  public boolean move(Paode p){
    boolean moved = false;
    if (p != null){ // makes sure that the given paode is real first 
      if (p.getHome()){ // check if home
        isHome = true;
        gameOver = true;
        System.out.println("HOME");
        System.out.println("Pusheen says Pusheen is home: " + isHome);
      }
      if (p.getMonster()){ // check if the Paode contains a monster 
        donuts.scared();
        donutPoints = 0;
        System.out.println("MONSTER!"); 
      }
      if (p.getDonut() != null){ // check if Paode contains a donut 
        if (donuts.checkStreak()){ // must check for donut streak first 
          donutPoints += 10;
          System.out.println("DONUT STREAK!"); 
          p.setDonut(0);
        }
        else{ // if no streak, simply adds a donut 
          donutPoints += p.getDonut().getVALUE();
          donuts.eatAndPoop(p.getDonut());
          p.setDonut(0);
          System.out.println("DONUT");
        }
      }
      user = p; // update Pusheen's placement in the maze
      moved = true; 
      System.out.println("Pusheen was able to move.");
    }
    return moved;
  }
  
  // ******************************* GETTERS ******************************* //
  /**
   * getPaode()
   * Gets the current Paode of Pusheen's position 
   *
   * @param None
   * @return Paode The current Paode where the user is  
   */
  public Paode getPaode(){
    return user; 
  }
  
  /**
   * getIsHome()
   * Returns whether or not Pusheen is home
   *
   * @param None
   * @return boolean Returns if Pusheen is home   
   */  
  public boolean getIsHome(){
    return isHome; 
  }
  
  /**
   * getDonuts()
   * Returns the donut queue (Pusheen's stomach)
   *
   * @param None
   * @return DonutStreak The donuts in Pusheen's stomach currently  
   */
  public DonutStreak getDonuts(){
    return donuts; 
  }
  
  /**
   * getPoints()
   * Returns the number of points the user has collected 
   *
   * @param None
   * @return int The number of points Pusheen has   
   */
  public int getPoints(){
    return donutPoints; 
  }
  
  public boolean getGameOver(){
    return gameOver; 
  }
  
// ******************************* SETTERS ******************************* //
  /**
   * setPaode()
   * Sets Pusheen to the Paode given 
   *
   * @param Paode 
   * @return Nothing   
   */
  public void setPaode(Paode p){
    user = p;
  }
  
  public void setPoints(int points){
    donutPoints += points;
  }
  
  public void setGameOver(boolean g){
    gameOver = g;
  }
  
  public void setIsHome (boolean h) {
    isHome = h;
  }
  
  /**
   * toString()
   * Gets the current Paode of Pusheen's position 
   *
   * @param None
   * @return String Representation of Pusheen's donut status, Paode location, 
   *                and whether or not she has made it home yet. 
   */
  public String toString(){
    String s = "";
//    s += "Poade: " + user;
    s += "Donut Points: " + donutPoints;
    s += "\nIs Pusheen home? " + isHome;
    return s;
  }
  
  public static void main(String[] args){
    Paode start = new Paode("0101000");
    Paode d1 = new Paode("0107100");
    Paode d2 = new Paode("0111100");
    Paode d3 = new Paode("0209100");
    Paode d3B = new Paode("0210000"); // Bottom
    Paode d3L = new Paode("0109000"); // Left
    Paode d3R = new Paode("0309000"); // Right 
    
    Paode home = new Paode("1313001");
    Paode monster = new Paode("0506010");
    
    d3.setTop(null);
    d3.setBottom(d3B);
    d3.setLeft(d3L);
    d3.setRight(d3R);
    
    Pusheen user = new Pusheen();
    user.setPaode(start);
    System.out.println(user);
    
    System.out.println("\nEating Donuts");
    user.move(d1);
    user.move(d2);
    user.move(d3);
    System.out.println(user);
    
    System.out.println("\n. . . Moving . . .");
    System.out.println("User's CURRENT POSITION at Paode d3: \n" + user.getPaode());
    System.out.println("Top of this Paode is null, so Pusheen does not move. \n" 
                         + "Assuming that UP arrow has been pressed...");
    user.move(user.getPaode().getTop());
    System.out.println("User's POSITION after trying to go to a null spot: \n" + user.getPaode());
    
    System.out.println("\nBottom of d3 is another Paode.");
    System.out.println("User's CURRENT POSITION: " + user.getPaode());
    user.move(user.getPaode().getBottom());
    System.out.println("Assuming user has pressed down arrow, user's NEW " 
                         + "POSITION: \n" + user.getPaode());
    
    System.out.println("\nMONSTER!");
    user.move(monster);
    System.out.println(user);
    
    System.out.println("\nHOME! :)");
    user.move(home);
    System.out.println(user);
  }
}