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

  // instance variables
  private String paodeNumber;
  private int color; // 1: pink, 2: brown, 3: blue
  private final int VALUE = 2; 
  
  // constructor 
  public Donut(String paodeNum){
    Random rand = new Random();
    paodeNumber = paodeNum;
    color = rand.nextInt(3)+1; 
  }
  
  // Getters
  /**
   * Returns the number associated with the color of the donut. 
   *
   * @param None
   * @return int Returns the number associated with the color  
   */
  public int getColor(){
    return color;
  }
  
  /**
   * Returns the paodeNumber where the donut is located on the maze. 
   *
   * @param None
   * @return String Returns the PaodeNumber  
   */
  public String getPaodeNumber(){
    return paodeNumber;
  }
  
  public int getVALUE(){
   return VALUE;
  }
  
  // Setters
  /**
   * Sets the color of the donut to the one given. 
   *
   * @param c This is the int associated with the desired color  
   * @return Nothing 
   */  
  public void setColor(int c){
    color = c;
  }
  
  /**
   * Returns a String representation of the donut 
   *
   * @return String Returns the String version of the donut  
   */  
  public String toString(){
    String s = "";
//    s += "Poade Number: " + paodeNumber;
//    s += "Color: ";
    if (color == 1)
      s += "Pink";
    if (color == 2)
      s += "Brown";
    if (color == 3)
      s += "Blue";
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
    Donut d = new Donut("3");
    System.out.println(d);
    System.out.println(d.getColor());
  }
}