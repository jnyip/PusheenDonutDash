/* Game.java
 * Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

public class Game{
 
  // instance variables
  private boolean timeLeft;
  private boolean gameOver;
  private Pusheen user;
  private Maze maze;
 
  // constructor 
  public Game(String tgfFilename){
    timeLeft = true;
    Paode p = new Paode("0101000");
    user = new Pusheen(p);
    maze = new Maze(tgfFilename);
  }
  
//  public void play(KeyEvent e){
//    while (timeLeft || !user.getIsHome()){
//      user.keyPressed(e); 
//    }
//  }
  
  public boolean getGameOver(){
   return gameOver; 
  }
  
  public static void main(String[] args){
    Game pdd = new Game("completeMazeUnfilled.tgf");    
  }
  
}