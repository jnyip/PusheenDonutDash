/******************************************************************************
  * Paode.java
  * Pusheen Donut Dash - Paode Object Class
  * 
  * CS 230 Fall 2015 Final Project
  * Date: December 09, 2015
  * Purpose: Path/Node Object of a Maze. Contains the information of what 
  * is at each location in the maze. 
  ****************************************************************************/


public class Paode{
  
  // Instance Variables:
  private String paodeNumber;
  private int xcoor, ycoor;
  private boolean home;
  private Donut donut;
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
    donut = (Integer.parseInt(yEdNum.substring(4,5)) == 1) ? new Donut(paodeNumber) : null;
    monster = Integer.parseInt(yEdNum.substring(5,6)) == 1;
    home = Integer.parseInt(yEdNum.substring(6,7)) == 1;
    
    
    // Setting all pointers to null at creation
    top = null; bottom = null; left = null; right = null; 
  }
  
  /*****************************************************************
    **************             GETTERS            ******************
    ***************************************************************/
  /* getPaodeNumber() - Get Paode Number
   * @param  None
   * @return String the first 4 numbers of the yED label of the paode. 
   *        Also the coordinates of the paode
   */
  public String getPaodeNumber(){
    return paodeNumber;
  }
  
  /* getXCoor() - Get X-Coordinate
   * @param  None
   * @return int The x-coordinate of the Paode
   */
  public int getXCoor(){
    return xcoor;
  }
  
  /* getYCoor() - Get Y-Coordinate
   * @param  None
   * @return int The y-coordinate of the Paode
   */
  public int getYCoor(){
    return ycoor;
  }
  
  /* getHome() - Get Home Status
   * @param  None
   * @return boolean  Whether this Paode is Home
   */
  public boolean getHome(){
    return home;
  }
  
  /* getDonut() - Get Donut Stattus
   * @param  None
   * @return boolean  Whether there is a donut at this Paode
   */
  public Donut getDonut(){
    return donut;
  }
  
  /* getMonster() - Get Monster Status
   * @param  None
   * @return boolean  Whether ther is a Monster at this Paode
   */
  public boolean getMonster(){
    return monster;
  }
  
  /* getTop() - Get Top Paode 
   * @param  None
   * @return Paode  Return the Paode above this Paode
   */
  public Paode getTop(){
    return this.top;
  }
  
  /* getBottom() - Get Bottom Paode
   * @param  None
   * @return Paode  Return the Paode below this Paode
   */
  public Paode getBottom(){
    return this.bottom;
  }
  
  /* getLeft() - Get Left Paode
   * @param  None
   * @return Paode  Return the Paode to the left of this Paode
   */
  public Paode getLeft(){
    return this.left;
  }
  
  /* getRight() - Get Right Paode
   * @param  None
   * @return Paode  Return the Paode Right of this Paode
   */
  public Paode getRight(){
    return this.right;
  }
  
  /*****************************************************************
    **************             SETTERS            ******************
    ***************************************************************/
  /* setDonut()- Update donut status
   * @param c  If 0, changes the donut to point to null.
   * @return void
   */
  public void setDonut(int c){
    if (c == 0) 
      donut = null;
  }
  
  /* setTop() - Sets the top pointer to the desired Paode
   * @param top  The Paode that this paode points to from its top
   * @return void
   */ 
  public void setTop (Paode top){
    if (this.top != null)
      System.out.println("Replacing top node at " + paodeNumber);
    this.top = top;
  }
  
  /* setBottom() - Sets the bottom pointer to the desired Paode
   * @param bottom  The Paode that this paode points to from its bottom
   * @return void
   */
  public void setBottom (Paode bottom){
    if (this.bottom != null)
      System.out.println("Replacing bottom node at " + paodeNumber);
    this.bottom = bottom;
  }
  
  /* setLeft() - Sets the left pointer to the desired Paode
   * @param left  The Paode that this paode points to from its left
   * @return void
   */
  public void setLeft (Paode left){
    if (this.left != null)
      System.out.println("Replacing left node at " + paodeNumber);
    this.left = left;
  }
  
  /* setRight - Sets the right pointer to the desired Paode
   * @param right  The Paode that this paode points to from its right
   * @return void
   */
  public void setRight (Paode right){
    if (this.right != null)
      System.out.println("Replacing right node at " + paodeNumber);
    this.right = right;
  }
  
  /*****************************************************************
    **************     Formatting for Printing      ****************
    ***************************************************************/
  /* toString() - Formats the Object for easy reading 
   * @return String version of Object
   */
  public String toString(){
    String result = "Paode #" + paodeNumber + ": ";
    result += ("Coordinate: (" + xcoor + ", " + ycoor + ");\t");
    result += ("Donut: " + ((donut == null) ? "null" : donut )+ ";\tMonster: " + monster + ";\tHome: " + home +";\t");
    result += ("Top: " + ((top == null) ? "null" : top.getPaodeNumber()) + 
               "; Bottom: " + (bottom == null ? "null" : bottom.getPaodeNumber()) + 
               "; Left: " + (left == null ? "null" : left.getPaodeNumber()) + 
               "; Right: " + (right == null ? "null" : right.getPaodeNumber()));
    return result;
  }
  
  /*****************************************************************
    **************             Testing            ******************
    ***************************************************************/
  public static void main (String[] args){
    Paode p1 = new Paode ("1107110");
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
    p1.setDonut(0);
    System.out.println("Updated Donut Status: " + p1.getDonut());
    System.out.println("Monster: " + p1.getMonster());
    System.out.println("Top of p1: " + p1.getTop());
    System.out.println("Bottom of p1: " + p1.getBottom());
    System.out.println("Left of p1: " + p1.getLeft());
    System.out.println("Right of p1: " + p1.getRight());
    System.out.println("\t=============p2l==============");
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
    System.out.println("\t============p3r===============");
    System.out.println(p3r);
    System.out.println("\t============p4t===============");
    System.out.println(p4t);
    System.out.println("\t============p5b===============");
    System.out.println(p5b);
  }
}