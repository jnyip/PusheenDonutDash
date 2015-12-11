/* Monster.java
 * Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 

// DO WE NEED MAIN METHODS/TESTING CASES?
import javafoundations.LinkedQueue;

public class Monster { 

  // instance variables
  private int paodeNumber;
  private LinkedQueue donuts;
  
  // constructor -- should know about arrayQueue??
  public Monster(int paodeNum, LinkedQueue donutQueue){
    paodeNumber = paodeNum;
    donuts = donutQueue;
  }
  
  // getters
  public int getPaodeNum(){
    return paodeNumber;
  }
  
  public void scare(){
    while (!donuts.isEmpty()){
      donuts.dequeue();
    }
  }
  
  public String toString(){
    String s = "";
    s += "Paode Number: " + paodeNumber;
    return s;
  }
  
  public static void main(String[] args){
    Monster m = Monster()
  }
}