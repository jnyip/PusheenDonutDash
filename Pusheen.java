/* Pusheen.java
 * Written by: Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pusheen{
 
  // instance variables
  private Paode user;
  private int donutPoints;
  private boolean isHome;
  private DonutStreak donuts;
  
  public Pusheen(Paode p){
   user = p;  
   donuts = new DonutStreak();
   donutPoints = 0;
   isHome = false;
  }
   
  // returns true if Pusheen was able to move 
  public boolean move(Paode p){
    boolean moved = false;
    if (p != null){
      if (p.getHome()){
        isHome = true;
        System.out.println("Pusheen is home!");
      }
      if (p.getMonster()){
        donuts.scared();
        donutPoints = 0;
        System.out.println("Pusheen ran into a monster!"); 
      }
      if (p.getDonut() != null){
        if (donuts.checkStreak()){
          donutPoints += 10;
          System.out.println("Donut Streak!"); 
        }
        else
          donutPoints += p.getDonut().getVALUE();
          donuts.eatAndPoop(p.getDonut());
          System.out.println("Pusheen ate a donut!"); 
      }
      user = p; // update Pusheen's placement in the maze
      moved = true;
      System.out.println("Pusheen has been moved.");
    }
    return moved;
  }
  
  // Getters
  public Paode currentPosition(){
    return user; 
  }
  
  public Paode getTop(){
    return user.getTop();
  }
  
  public Paode getBottom(){
    return user.getBottom(); 
  }
  
  public Paode getLeft(){
    return user.getLeft(); 
  }
  
  public Paode getRight(){
    return user.getRight();
  }
  
  public boolean getIsHome(){
    return isHome; 
  }
  
  public DonutStreak getDonuts(){
    return donuts; 
  }
  
  public int getPoints(){
    return donutPoints; 
  }
  
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
    
    Pusheen user = new Pusheen(start);
    System.out.println(user);
    
    System.out.println("\nEating Donuts");
    user.move(d1);
    user.move(d2);
    user.move(d3);
    System.out.println(user);
    
    System.out.println("\n. . . Moving . . .");
    System.out.println("User's CURRENT POSITION at Paode d3: \n" + user.currentPosition());
    System.out.println("Top of this Paode is null, so Pusheen does not move. \n" 
                         + "Assuming that UP arrow has been pressed...");
    user.move(user.getTop());
    System.out.println("User's POSITION after trying to go to a null spot: \n" + user.currentPosition());
    
    System.out.println("\nBottom of d3 is another Paode.");
    System.out.println("User's CURRENT POSITION: " + user.currentPosition());
    user.move(user.getBottom());
    System.out.println("Assuming user has pressed down arrow, user's NEW " 
                         + "POSITION: \n" + user.currentPosition());
    
    System.out.println("\nMONSTER!");
    user.move(monster);
    System.out.println(user);
    
    System.out.println("\nHOME! :)");
    user.move(home);
    System.out.println(user);
  }
}