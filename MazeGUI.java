//********************************************************************
// Maze.java Java Foundations
//
// Demonstrates key events.
//********************************************************************
import javax.swing.JFrame;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class MazeGUI
{
//-----------------------------------------------------------------
// Creates and displays the application frame.
//-----------------------------------------------------------------
  public static void main (String[] args)
  {
    JFrame frame = new JFrame ("Maze");
    
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
    frame.getContentPane().add (new MazePanel("completeMazeUnfilled.tgf"));
    
    frame.setResizable(true);
    frame.pack();
    frame.setVisible(true);
  }
}