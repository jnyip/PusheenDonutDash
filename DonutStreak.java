/* DonutStreak.java
 * Brenda Ji 
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Jesslyn Tannady
 * December 9, 2015
 */ 

import javafoundations.ArrayQueue;

public class DonutStreak{
  
  // instance variables
  private ArrayQueue<Donut> donutQueue;
  private int[] colorCount; // 3 colors right? 0: blue, 1: red, 2: brown
  private final int CCSIZE = 3;
  
  public DonutStreak(){
    donutQueue = new ArrayQueue<Donut>();
    colorCount = new int[CCSIZE];
  }
  
  public void eatAndPoop(Donut d){
    int color = d.getColor();
//    System.out.println(color);
    if (donutQueue.size() < 3){
      donutQueue.enqueue(d);
      colorCount[color]++;
    }
    //peek and stuff
    if (donutQueue.size() == 3){
      Donut temp = donutQueue.dequeue();
      colorCount[temp.getColor()]--;
      donutQueue.enqueue(d);
      colorCount[color]++;
    }
  }
  
  public boolean checkStreak(){
    for (int i = 0; i < colorCount.length; i++){
      if (colorCount[i] == 3)
        return true;
    }
    return false;
  }
  
  public void scared(){
    while (!donutQueue.isEmpty()){
      Donut temp = donutQueue.dequeue();
      colorCount[temp.getColor()]--;
    }
  }
  
  
  public String toString(){
    String s = "";
    s += "Donut Queue: \n";
    for (int i = 0; i < CCSIZE; i++){
      if (i == 0)
        s += "blue: " + colorCount[i] + "\n";
      if (i == 1)
        s += "pink: " + colorCount[i] + "\n";
      if (i == 2)
        s += "brown: " + colorCount[i] + "\n"; 
    }
    return s;
  }
  
  public static void main(String[] args){
    DonutStreak donuts = new DonutStreak();
    Donut d1 = new Donut("1");
    Donut d2 = new Donut("2");
    Donut d3 = new Donut("3");
    Donut d4 = new Donut("4");
    
    donuts.eatAndPoop(d1);
    donuts.eatAndPoop(d2);
    donuts.eatAndPoop(d3);  
    System.out.println(donuts);
    System.out.println("Streak? " + donuts.checkStreak());
    
    donuts.scared();
    System.out.println("Donut scare! \n" + donuts);
  }
  
}