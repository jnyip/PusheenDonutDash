/******************************************************************************
  * Paode.java
  * Pusheen Donut Dash - Paode Object Class
  * 
  * CS 230 Fall 2015 Final Project
  * Written by: Jamie Yip
  * Date: December 09, 2015
  * Purpose: Path/Node Object of a Maze. Contains the information of what 
  * is at each location in the maze. 
  ****************************************************************************/


public class Paode{
  
  // Instance Variables:
  private String paodeNumber;
  private int xcoor, ycoor;
  private boolean home;
  private boolean donut;
  private boolean monster;
  private Paode top, bottom, left, right;
  
  
  /* Constructor: Create a Paode object with the reference number
   * from the yEd information. From this number, the x coordinate,
   * y coordinate, donut, monster, and home information. 
   * @param yEdNum  The string version of the node label from yEd
   */
  public Paode (String yEdNum){
    paodeNumber = yEdNum.substring(0,4);
    
    xcoor= Integer.parseInt(yEdNum.substring(0,2));
    ycoor = Integer.parseInt(yEdNum.substring(2,4));
    donut = Integer.parseInt(yEdNum.substring(4,5)) == 1;
    monster = Integer.parseInt(yEdNum.substring(5,6)) == 1;
    home = Integer.parseInt(yEdNum.substring(6,7)) == 1;
    
    // Setting all pointers to null at creation
    top = null; bottom = null; left = null; right = null; 
  }
  
  /*****************************************************************
    **************             GETTERS            ******************
    ***************************************************************/
  /* PaodeNumber */
  public String getPaodeNumber(){
    return paodeNumber;
  }
  
  public int getXCoor(){
    return xcoor;
  }
  
  public int getYCoor(){
    return ycoor;
  }
  
  public boolean getHome(){
    return home;
  }
  
  public boolean getDonut(){
    return donut;
  }
  
  public boolean getMonster(){
    return monster;
  }
  
  public Paode getTop(){
    return this.top;
  }
  
  public Paode getBottom(){
    return this.bottom;
  }
  
  public Paode getLeft(){
    return this.left;
  }
  
  public Paode getRight(){
    return this.right;
  }
  
  /*****************************************************************
    **************             SETTERS            ******************
    ***************************************************************/
  /* setDonut()- Update donut status
   * @param update  The new boolean value.
   * @return void
   */
  public void setDonut(boolean update){
    donut = update;
  }
  
  /* setTop() - Sets the top pointer to the desired Paode
   * @param top  The Paode that this paode points to from its top
   * @return void
   */ 
  public void setTop (Paode top){
    this.top = top;
  }
  
  /* setBottom() - Sets the bottom pointer to the desired Paode
   * @param bottom  The Paode that this paode points to from its bottom
   * @return void
   */
  public void setBottom (Paode bottom){
    this.bottom = bottom;
  }
  
  /* setLeft() - Sets the left pointer to the desired Paode
   * @param left  The Paode that this paode points to from its left
   * @return void
   */
  public void setLeft (Paode left){
    this.left = left;
  }
  
  /* setRight - Sets the right pointer to the desired Paode
   * @param right  The Paode that this paode points to from its right
   * @return void
   */
  public void setRight (Paode right){
    this.right = right;
  }
  
  /* toString() - Formats the Object for easy reading 
   * @return String version of Object
   */
  public String toString(){
    String result = "Paode #" + paodeNumber + ": \n";
    result += ("Coordinate: (" + xcoor + ", " + ycoor + "); ");
    result += ("Donut: " + donut + "; Monster: " + monster + "; Home: " + home + "\n");
    result += ("Top: " + ((top == null) ? "null" : top.getPaodeNumber()) + 
               "; Bottom: " + (bottom == null ? "null" : bottom.getPaodeNumber()) + 
               "; Left: " + (left == null ? "null" : left.getPaodeNumber()) + 
               "; Right: " + (right == null ? "null" : right.getPaodeNumber()));
    return result;
  }
  
  public static void main (String[] args){
    Paode p1 = new Paode ("1107010");
    Paode p2l = new Paode ("1007010");
    Paode p3r = new Paode ("1207100");
    Paode p4t = new Paode ("1106010");
    Paode p5b = new Paode ("1108101");
    
    p1.setTop(p4t);
    p4t.setBottom(p1);
    p1.setBottom(p5b);
    p5b.setTop(p1);
    p1.setLeft(p2l);
    p2l.setRight(p1);
    p1.setRight(p3r);
    p3r.setLeft(p1);
    
    System.out.println("After adding connections for p1, p2l, p3r, p4t, p5b and the corresponding pointers");
    System.out.println(p1);
    System.out.println("Paode: " + p1.getPaodeNumber());
    System.out.println("X: " + p1.getXCoor());
    System.out.println("Y: " + p1.getYCoor());
    System.out.println("Home: " + p1.getHome());
    System.out.println("Donut: " + p1.getDonut());
    p1.setDonut(true);
    System.out.println("Updated Donut Status: " + p1.getDonut());
    System.out.println("Monster: " + p1.getMonster());
    System.out.println("Top of p1: " + p1.getTop());
    System.out.println("Bottom of p1: " + p1.getBottom());
    System.out.println("Left of p1: " + p1.getLeft());
    System.out.println("Right of p1: " + p1.getRight());
    System.out.println("\n\t=============p2l==============\n");
    System.out.println(p2l);
    System.out.println("Paode: " + p2l.getPaodeNumber());
    System.out.println("X: " + p2l.getXCoor());
    System.out.println("Y: " + p2l.getYCoor());
    System.out.println("Home: " + p2l.getHome());
    System.out.println("Donut: " + p2l.getDonut());
    System.out.println("Monster: " + p2l.getMonster());
    System.out.println("Top of p2l: " + p2l.getTop());
    System.out.println("Bottom of p2l: " + p2l.getBottom());
    System.out.println("Left of p2l: " + p2l.getLeft());
    System.out.println("Right of p2l: " + p2l.getRight());
    System.out.println("\n\t============p3r===============\n");
    System.out.println(p3r);
    System.out.println("\n\t============p4t===============\n");
    System.out.println(p4t);
    System.out.println("\n\t============p5b===============\n");
    System.out.println(p5b);
  }
}