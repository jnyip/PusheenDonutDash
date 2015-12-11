/******************************************************************************
  * Maze.java
  * Pusheen Donut Dash - Maze Object Class
  * 
  * CS 230 Fall 2015 Final Project
  * Written by: Jamie Yip
  * Date: December 10, 2015
  * Purpose: Constructs the Maze of Pusheen Donut Dash 
  ****************************************************************************/

import java.util.*;
import java.io.*;

public class Maze{
  // Constants:
  private final int INIT_CAPACITY = 20;
  
  // Instance Variables:
  private int n; // number of Paodes
  private String[] yEdLabels;
  private LinkedList<Paode> maze;
  private Paode beginning;
  private Paode home;
  
  
  /* Constructor:
   * 
   */
  public Maze(String tgf_file_name){
    try{
      n = 0;
      yEdLabels = new String[INIT_CAPACITY];
      Scanner scan = new Scanner (new File(tgf_file_name));
      
      while (!scan.next().equals("#")){
        // Need to expand Array...
        yEdLabels[n] = scan.next();
        n++;
      }
      
    }
    catch (FileNotFoundException exception){
      System.out.println("File not found.");
    }
  }
  
  /* toString() - Formats the Object for easy reading 
   * @return String version of Object
   */
  public String toString(){
    String result = "[";
    for (int i  = 0; i < n; i++){
      result += (yEdLabels[i] + "  " );
    }
    result += "]";
    return result;
  }
  
  public static void main (String[] args){
    Maze m = new Maze("testingDiningHallFruit.tgf");
    System.out.println(m);
  }
  
  
}