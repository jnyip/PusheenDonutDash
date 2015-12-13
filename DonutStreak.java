/* DonutStreak.java
 * DonutStreak implements a queue data structure in order to keep track of the
 * order in which donuts are eaten by Pusheen. Essentially we want to keep the 
 * order to award points in the case that Pusheen gathers three donuts of the 
 * same color in a row. It is a representation of Pusheen's stomach and 
 * 
 * Written by: Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 

import javafoundations.ArrayQueue;

public class DonutStreak{
  
  // instance variables
  private ArrayQueue<Donut> donutQueue; // 1: pink, 2: brown, 3: blue
  private int[] colorCount; // [0]: pink [1]: brown [2]: blue  
  private final int CCSIZE = 3; 
  
  public DonutStreak(){
    donutQueue = new ArrayQueue<Donut>();
    colorCount = new int[CCSIZE];
  }
  
  /**
   * Enqueues and dequeues donuts as the user gathers donuts during the game. 
   *
   * @param Donut The donut that is eaten and to be added to the queue 
   * @return Nothing
   */
  // should we clear the queue when there are three donuts in a row?
  public void eatAndPoop(Donut d){
    int color = d.getColor()-1;
//    System.out.println("Given donut color: " + color);
//    System.out.println("Donut Queue size: " + donutQueue.size());
    if (donutQueue.size() < 3){
      donutQueue.enqueue(d);
      colorCount[color]++;
    }
    //peek and stuff
    else if (donutQueue.size() == 3){
      Donut temp = donutQueue.dequeue();
//      System.out.println("Temp donut color: " + temp.getColor());
      colorCount[temp.getColor()-1]--;
      donutQueue.enqueue(d);
      colorCount[color]++;
    }
  }
  
  /**
   * Loops through the colorCount array and checks for any streaks. Returns true
   * if there are 3 donuts of the same color in a row)
   *
   * @param None
   * @return boolean Returns whether or not there is a streak
   */
  public boolean checkStreak(){
    for (int i = 0; i < colorCount.length; i++){
      if (colorCount[i] == 3)
        return true;
    }
    return false;
  }
  
  /**
   * Dequeues the whole donut queue if the the user runs into a monster
   *
   * @param NOne
   * @return Nothing
   */
  public void scared(){
    while (!donutQueue.isEmpty()){
      Donut temp = donutQueue.dequeue();
//      int color = temp.getColor()-1;
//      colorCount[color]--;
    }
    colorCount[0] = 0; colorCount[1] = 0; colorCount[2] = 0;
  }
  
  
  public String toString(){
    String s = "";
    s += "Donut Queue: \n";
    for (int i = 0; i < CCSIZE; i++){
      if (i == 0)
        s += "Pink: " + colorCount[i] + "\n";
      if (i == 1)
        s += "Brown: " + colorCount[i] + "\n";
      if (i == 2)
        s += "Blue: " + colorCount[i] + "\n"; 
    }
    return s;
  }
  
  /**
   * The main method that tests the creation of a donut queue and the 
   * eatAndPoop() method, the checkStreak() method and the scared() method. 
   * 
   * @param args Unused
   * @return Nothing   
   */
  public static void main(String[] args){
    DonutStreak donuts = new DonutStreak();
    Donut d1 = new Donut("1");
    Donut d2 = new Donut("2");
    Donut d3 = new Donut("3");
    Donut d4 = new Donut("4");
    
    donuts.eatAndPoop(d1);
    System.out.println("d1 color: " + d1.getColor());
    donuts.eatAndPoop(d2);
    System.out.println("d2 color: " + d2.getColor());
    donuts.eatAndPoop(d3);  
    System.out.println("d3 color: " + d3.getColor());
    System.out.println("*************\n" + donuts + "\n****************");
    System.out.println("Streak? " + donuts.checkStreak());
    
    System.out.println("Eat another donut: " + d4 + "\n");
    donuts.eatAndPoop(d4);
    System.out.println(donuts);
    
    donuts.scared();
    System.out.println("Donut scare! \n" + donuts);
  }
  
}