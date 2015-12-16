/* Countdown.java
 * Main method that makes the actual GUI of CountdownPanel 
 * 
 * Written by: Jesslyn Tannady
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Brenda Ji
 * Last Modified: December 13, 2015
 * Purpose: Test CountdownPanel before adding it to the main GUI
 */ 

import javax.swing.JFrame;

public class Countdown
{
  //-----------------------------------------------------------------
  //  Creates and displays the main program frame.
  //-----------------------------------------------------------------
  public static void main (String[] args)
  {
    Pusheen PusheenUser = new Pusheen();
    JFrame frame = new JFrame ("Countdown Tester"); // The title of the window
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // by clicking the red "close window" button
    
    CountdownPanel panel = new CountdownPanel(PusheenUser); // The Panel file only thing that needs to change
    frame.getContentPane().add(panel);
    
    frame.pack();
    frame.setVisible(true);
  }
}
