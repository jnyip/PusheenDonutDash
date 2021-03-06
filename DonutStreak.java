/* DonutStreak.java
 * DonutStreak implements a queue data structure that represents Pusheen's 
 * stomach and the order in which the user gathers donuts. 
 * 
 * Written by: Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * Last Modified: December 15, 2015
 * 
 * Purpose: To keep the order in which donuts are eaten to award points in the 
 * case that the user gathers three donuts of the same color in a row. It is a
 * representation of Pusheen's stomach.
 */ 

import javafoundations.ArrayQueue;

public class DonutStreak{
  
  // Constants
  private final int CCSIZE = 3; // number of colors
  
  // Instance Variables
  private ArrayQueue<Donut> donutQueue; // 1: pink, 2: brown, 3: blue
  private int[] colorCount; // [0]: pink [1]: brown [2]: blue 
  private boolean streak;
  
  /* Constructor: Create a queue of Donut objects and an array to keep track of
   * the number of the colors of the donuts that are eaten 
   * 
   * @param None
   */
  public DonutStreak(){
    donutQueue = new ArrayQueue<Donut>();
    colorCount = new int[CCSIZE];
  }
  
  /**
   * eatAndPoop()
   * Enqueues and dequeues donuts as the user gathers donuts during the game. 
   * When the size of the queue is still less than 3, a donut can simply be 
   * enqueued and it's color count in the colorCount array can be increased. If
   * the queue is full, then first the donut at the front of the queue gets 
   * dequeued and stored in order to decrease the count of that color donut. 
   * Then the new donut can be enqueued and its color count in the array can 
   * also be increased. 
   *
   * @param d The donut that is eaten and that will be added to the queue 
   * @return Nothing
   */

  public void eatAndPoop(Donut d){
    // Donut colors start at 1 so in the actual array they will be in 0th position 
    int color = d.getColor()-1; 
    System.out.println("Donut queue size: " + donutQueue.size());
    
    if (donutQueue.size() == 3){
      Donut dequeueDonut = donutQueue.dequeue();
      System.out.println(dequeueDonut.printColor() + " DONUT REMOVED");
      colorCount[dequeueDonut.getColor()-1]--;
      donutQueue.enqueue(d);
      colorCount[color]++;
      System.out.println(d.printColor() + " DONUT ADDED ( == 3)");
    }
    
    if (donutQueue.size() < 3){
      donutQueue.enqueue(d);
      colorCount[color]++;
      System.out.println(d.printColor() + " DONUT ADDED (< 3) --> Donut queue size: " + donutQueue.size() );
    }
  }
  
  /**
   * checkStreak()
   * Loops through the colorCount array and checks for any streaks. Returns true
   * if any position in the colorCount array is an int of 3.
   *
   * @param None
   * @return boolean Returns whether or not there is a streak
   */
  public boolean checkStreak(){
    System.out.println("Donut Queue Size before streak:  " + donutQueue.size());
    streak = false;
    for (int i = 0; i < colorCount.length; i++){
      if (colorCount[i] == 3)
        streak = true;
    }
    return streak;
  }
  
  
  
  /**
   * scared()
   * Dequeues the whole donut queue if the the user runs into a monster
   *
   * @param None
   * @return Nothing
   */
  public void scared(){
    while (!donutQueue.isEmpty()){
      Donut temp = donutQueue.dequeue();
    }
    // make all the color counts 0 
    colorCount[0] = 0; colorCount[1] = 0; colorCount[2] = 0; 
//    System.out.println("SCARED METHOD FROM DONUTSTREAK");
//    System.out.println(this);
  }
 
  /* toString() 
   * Gives the color count of each donut currently in the queue, but cannot give
   * order of the queue without ruining it . 
   * 
   * @return String version of Object
   */
  public String toString(){
    String s = "Donut Queue: \n";
    ArrayQueue<Donut> temp = new ArrayQueue<Donut>();
    
    // add donuts to a temp array for testing purposes
    Donut[] donuts = new Donut[3];
    int i = 0;
    while(!donutQueue.isEmpty()){
      Donut currentDonut = donutQueue.dequeue();
      s += ((currentDonut != null) ? ((i+1)+". " + currentDonut.printColor() + "\n") : ((i+1) + ". ----- \n"));
      i++;
      temp.enqueue(currentDonut);
    }
    
    if (donutQueue.isEmpty()) s+= ("Empty!");
    
    donutQueue = temp;
    
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
    System.out.println("d1 color: " + d1.printColor());
    donuts.eatAndPoop(d2);
    System.out.println("d2 color: " + d2.printColor());
    donuts.eatAndPoop(d3);  
    System.out.println("d3 color: " + d3.printColor());
    System.out.println("\n*************\n" + donuts + "*************\n");

    System.out.println("Streak? " + donuts.checkStreak());
    System.out.println("\n*************\n" + donuts + "*************\n");
    
    System.out.println("Eat another donut: " + d4 + "\n");
    donuts.eatAndPoop(d4);
    System.out.println("\n*************\n" + donuts + "*************\n");
    
    donuts.scared();
    System.out.println("!!!!!Monster scare!!!!! \n" + donuts);
  }
  
}