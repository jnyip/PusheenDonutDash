/* Donut.java
 * Brenda Ji 
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
  
  // getters
  public int getColor(){
    return color;
  }
  
  public String getPaodeNum(){
    return paodeNumber;
  }
  
  // setters
  public void setColor(int c){
    color = c;
  }
  
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
  
  public static void main(String[] args){
    Donut d = new Donut("3");
    System.out.println(d);
  }
}