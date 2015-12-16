/******************************************************************************
  * Maze.java
  * Pusheen Donut Dash - Maze Object Class
  * 
  * CS 230 Fall 2015 Final Project
  * Date: December 10, 2015
  * Purpose: Constructs the Maze of Pusheen Donut Dash 
  ****************************************************************************/

import java.util.*;
import java.io.*;

public class Maze{
  // Constants:
  private final int INIT_CAPACITY = 10;
  
  // Instance Variables:
  private int n; // number of Paodes
  private String[] yEdLabels;
  private LinkedList<Paode> maze;
  private Paode beginning;
  private Paode home;
  
  
  /* Constructor: Create a Maze object from the given tgf file. 
   * 
   * Opens the tgf file to store the nodes in an array, 
   * extract the needed information to create the Paodes and their connections.
   * Also identifies the beginning and the home Paodes.  
   * 
   * @param tgf_file_name  The tgf file created from yEd that contains the maze
   *                       layout. 
   */
  public Maze(String tgf_file_name){
    try{
      // Initializing Instance Variables with defaults
      n = 1;
      yEdLabels = new String[INIT_CAPACITY];
      maze = new LinkedList<Paode>();
      beginning = null;
      home = null;
      
      /* In the tgf files from yEd, the nodes begin at 0. 
       * In order to use the file's document with transposing every node, 
       * the array of yEd labels and the maze contain one placeholder.
       */
      yEdLabels[0] = "YEDOFF1";  
      maze.add( new Paode ( "0000000"));
      
      /************** Parsing tgf file *****************/
      Scanner scan = new Scanner (new File(tgf_file_name));
      
      // Parsing for Nodes until # divider in tgf file 
      while (!scan.next().equals("#")){
        if (n == yEdLabels.length) expandArray(); //Expand Array for more space
        
        yEdLabels[n] = scan.next(); // Storing node label in array
        Paode newPaode = new Paode ( yEdLabels[n] ); // Creating Paodes 
        maze.add( newPaode ); // Adding them to the Linked List
        
        // Checks to see if the paode is the beginning or Home
        if (newPaode.getXCoor() == 1 && newPaode.getYCoor() == 1) 
          beginning = newPaode;
        if (newPaode.getHome()) home = newPaode;
        n++;// Increments the number of nodes
      }
      
      // Parsing for Links between Paodes
      while (scan.hasNext()){
        // Parsing the yEd nodes that are connected
        int paode1 = Integer.parseInt(scan.next());
        int paode2 = Integer.parseInt(scan.next());
        
        // Gets the corresponding Paodes within the Linked List and passes them
        // on to be calculated for nodes
        Paode p1 = maze.get(paode1);
        Paode p2 = maze.get(paode2);
        calculateConnections(p1, p2); 
      }
    }
    catch (FileNotFoundException exception){
      System.out.println("File not found... Remember to include .tgf");
    }
  }
  
  /* expandArray() - Private Method to expand the yEdLabels Array
   * to twice it's current size
   * @param  None
   * @return void
   */
  private void expandArray(){
    String[] largerArray = new String[ yEdLabels.length*2 ];
    for (int i = 0; i < n; i++){
      largerArray[i] = yEdLabels[i];
    }
    System.out.println("Expanding array. One moment please...");
    yEdLabels = largerArray;
  }
  
  /* calculateConnections() - Private Method to figure out the relationship 
   * between the two Paodes passed in. 
   * @param p1  First paode in the tgf line
   * @param p2  Second paode in the tgf line
   * @return void
   */
  private void calculateConnections(Paode p1, Paode p2){
    // Gets the x and y coordinates of both paodes
    int p1x = p1.getXCoor();
    int p1y = p1.getYCoor();
    int p2x = p2. getXCoor();
    int p2y = p2.getYCoor();        
    
    // Looks at the x-coordinate first
    switch (p1x - p2x){
      case -1: // the first paode is left of the second paode
        p2.setLeft(p1);
        p1.setRight(p2);
        break;
      case 0: 
        if (p1y - p2y == -1){ // the first paode is above the second paode
          p2.setTop(p1);
          p1.setBottom(p2); }
        if (p1y - p2y == 1){ // the first paode is below the second paode
          p1.setTop(p2);
          p2.setBottom(p1); }
        break;
      case 1: // the first paode is right of the second paode
        p1.setLeft(p2);
        p2.setRight(p1);
        break;
    } 
  }
  
  
  /*****************************************************************
    **************             GETTERS            ******************
    ***************************************************************/
  /* getBeginning() - Get First Paode of the maze
   * @param  None
   * @return Paode  the first Paode
   */
  public Paode getBeginning(){
    return beginning;
  }
  
  /* getHome() - Get Home Paode
   * @param  None
   * @return Paode  the Home Paode
   */
  public Paode getHome(){
    return home;
  }
  
  /* getSize() - Get n
   * @param  None
   * @return int  n (the size)
   */
  public int getSize(){
    return n;
  }
  
  /* getMaze() - Get the Linked List of Paodes
   * @param  None
   * @return LinkedList<Paode>  the Linked List of Paodes
   */
  public LinkedList<Paode> getMaze(){
    return maze;
  }
  
  /*****************************************************************
    **************     Formatting for Printing      ****************
    ***************************************************************/
  /* toString() - Formats the Object for easy reading 
   * @return String version of Object
   */
  public String toString(){
    String result = "Paodes of the Maze: \n["; 
    
    for (int i = 1; i<n; i++){
      result +=("\n " + maze.get(i));
    }
    
    result += "\n]\n\n Maze:\n";
    result += mazeFormatting();
    return result;
  }
  
  /* mazeFormatting() - Formats the Maze from a LinkedList to a 2D Array
   * FOR TESTING PURPOSES
   * @return String  Converts the 2D Array to a String to be appended to the 
   *                 result string in the toString()
   */
  private String mazeFormatting(){
    // Hard-coded to accomodate a 13 by 13 maze
    String[][] paodeMaze = new String[15][15];
    String result = "";
    paodeMaze[0][0] = "----";
    
    // Populating maze with with blank spaces or the index
    for (int i = 1; i < 14; i++){
      // Nicely formats the indices (cause I'm crazy)
      paodeMaze[i][0] = (i<10) ? " 0"+String.valueOf(i)+" " :" " +String.valueOf(i)+" ";
      paodeMaze[0][i] = (i<10) ? " 0"+String.valueOf(i)+" " :" " +String.valueOf(i)+" ";
      for (int j = 1;j<14; j++){
        paodeMaze[i][j] = "    ";
      }
    }
    
    // Goes through each node in the Linked List and adds them to the 2D Array
    for (int i = 1; i < n; i++){
      Paode current = maze.get(i);
      paodeMaze[current.getXCoor()][current.getYCoor()] = current.getPaodeNumber();
    }
    
    // Because I am slightly paranoid...
    // Checking if the LinkedList and the 2D array are correct:
//    verifyingMaze(paodeMaze);
    
   
    // ==== ACTUALLY FORMATTING NOW ====
    // Traverses the 2D Maze and appends them to the String
    for (int i = 0; i < 14; i++){
      for( int j = 0; j < 14; j++){
        // Swapped j and i so that the 2D visual is matching the Cartesian 
        // coordinate system with 0,0 at the top left corner
        result += (paodeMaze[j][i]+" "); 
      }
      result +="\n";
    }
    return result; // Return the formated 2D Maze created from the LinkedList
  }
  
  /* verifyingMaze() - Takes the 2D Array and verifies the information from the 
   *                   Linked list with it
   *                   FOR TESTING PURPOSES
   * @param paodeMaze  2D Array created in mazeFormatting()
   */
  private void verifyingMaze(String[][] paodeMaze){
    // Goes through each node in the Linked List and prints out the information
    // stored in both systems
    for (int i = 1; i < n; i++){
      Paode current = maze.get(i);
      int currentX = current.getXCoor();
      int currentY = current.getYCoor();
      
      // Get Current node information to print out
      System.out.println("Paode's X: " + currentX + "|| Paode's Y: " +currentY);
      System.out.println("Paode String at paodeMaze("+currentX+", " + currentY
                           +"): " + paodeMaze[currentX][currentY]);
      System.out.println("Current Paode: " + current);
      
      // Prints out top, bottom, left, right info
      Paode top = current.getTop();
      System.out.println("Above should be " + 
                         ((top!= null) ? top.getPaodeNumber() : "null") + 
                         " --> " + paodeMaze[currentX][currentY-1] );
      
      Paode bottom = current.getBottom();
      System.out.println("Below should be " + 
                         ((bottom!= null) ? bottom.getPaodeNumber() : "null") + 
                         " --> " + paodeMaze[currentX][currentY+1] );
      Paode left = current.getLeft();
      System.out.println("Left should be " + 
                         ((left!= null) ? left.getPaodeNumber() : "null") + 
                         " --> " + paodeMaze[currentX-1][currentY] );
      Paode right = current.getRight();
      System.out.println("Right should be " + 
                         ((right!= null) ? right.getPaodeNumber() : "null") + 
                         " --> " + paodeMaze[currentX+1][currentY] + "\n\n");
      
    }
  }
  
  /*****************************************************************
    **************             Testing            ******************
    ***************************************************************/
  public static void main (String[] args){
    System.out.println("Test #1 of completeMazeUnfilled.tgf");
    Maze real = new Maze("completeMazeUnfilled.tgf");
    System.out.println(real);
    System.out.println(real.getBeginning());
    System.out.println(real.getHome());
    System.out.println(real.getBeginning().getRight());
    
//    System.out.println("\nTest #2 of maze2.tgf");
//    Maze maze2 = new Maze("maze2.tgf");
//    System.out.println(maze2);
//    System.out.println(maze2.getBeginning());
//    System.out.println(maze2.getHome());
  }
}