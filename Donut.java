/* Donut.java
 * Donut Class creates a donut of a random color to be be placed randomly in the
 * maze. The Donut object will award points to the user if Pusheen eats a donut. 
 * 
 * Written by: Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 
import java.util.Random;

public class Donut { 

  // Constants 
  private final int VALUE = 2; 
  
  // Instance Variables
  private String paodeNumber;
  private int color; // 1: pink, 2: brown, 3: blue
  
  
  /* Constructor: Create a Donut object given a paodeNumber 
   * 
   * Generates a random number that will be used to correspond to a color and
   * sets the paodeNumber to the paode reference number that is given.
   * 
   * @param paodeNum The String representation of where the paode is in the maze 
   */
  public Donut(String paodeNum){
    Random rand = new Random();
    paodeNumber = paodeNum;
    color = rand.nextInt(3)+1; 
  }
  
  /**
   * printColor()
   * Returns a String representation of the color associated with the number
   *
   * @param None
   * @return int Returns actual color of the donut  
   */
  public String printColor(){
    String s = "";
    if (color == 1) 
      s = "pink";
    if (color == 2) 
      s = "brown";
    if (color == 3) 
      s = "blue";
    return s;
  }
  
  // ******************************* GETTERS ******************************* //
  /**
   * getColor()
   * Returns the number associated with the color of the donut. 
   *
   * @param None
   * @return int Returns the number associated with the color  
   */
  public int getColor(){
    return color;
  }
  
  /**
   * NEED???
   * getPaodeNumber()
   * Returns the paodeNumber where the donut is located on the maze. 
   *
   * @param None
   * @return String Returns the PaodeNumber  
   */
  public String getPaodeNumber(){
    return paodeNumber;
  }
  
  /** 
   * getVALUE()
   * Returns the amount of points the donut gives. 
   *
   * @param None
   * @return int Returns the value of the donut. 
   */
  public int getVALUE(){
   return VALUE;
  }
  
  /**
   * toString()
   * Returns a String representation of the donut 
   *
   * @return String Returns the String version of the donut  
   */  
  public String toString(){
    String s = "";
    s += printColor();
    s += " (" + VALUE +")";
    return s;
  }
  
  /**
   * The main method that tests the creation of a donut and the getters and 
   * the setters.
   * 
   * @param args Unused
   * @return Nothing   
   */
  public static void main(String[] args){
    Donut d = new Donut("0101000");
    System.out.println("String representation (color and value): " + d);
    System.out.println("\nTesting printColor()\nColor: " + d.printColor());
    System.out.println("\nTesting getColor()\nColor Number: " + d.getColor());
    System.out.println("\nTesting getVALUE()\nValue: " + d.getVALUE());    
  }
}