/* PusheenDonutDashPanel.java
 * 
 * Written by: Jesslyn Tannady
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Brenda Ji
 * Last Modified: December 16, 2015
 * 
 * Purpose: Brings ALL the panels together into one cohesive GUI 
 */ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class PusheenDonutDashPanel extends JPanel {
  
  // Instance Variables 
  private JLabel title;
  private JPanel countdown, maze;
  private PointsPanel points;
  private StomachPanel stomach;
  private Pusheen PusheenUser;
  
  /* Constructor: Creates a Panel that holds the MazePanel, StomachPanel, 
   * PointsPanel and CountdownPanel 
   * 
   * This panel must also know about the "master" Pusheen 
   * 
   * @param tgfFilename The file that stores all the maze components
   * @param pusheenUser The Pusheen that all the panels must know about 
   * @param pp The PointsPanel that must be updated as the user plays the game
   * @param sp The StomachPanel that also must be updated when the user collects
   *           donuts
   */
  public PusheenDonutDashPanel(Pusheen pusheenUser) {
    PusheenUser = pusheenUser;
    
    title = new JLabel ("Pusheen Donut Dash");
    title.setFont(new Font("Comic Sans", Font.BOLD, 30));
    title.setForeground(new Color(61, 34, 8));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    
    points = new PointsPanel(PusheenUser);
    points.setPreferredSize(new Dimension(300, 110));
    
    countdown = new CountdownPanel(PusheenUser);
    countdown.setPreferredSize(new Dimension(300, 110));
    
    stomach = new StomachPanel(PusheenUser);
    stomach.setPreferredSize(new Dimension(300, 200));
    
    maze = new MazePanel("completeMazeUnfilled.tgf", PusheenUser, points, stomach); // temporary
    maze.setPreferredSize(new Dimension(450, 450));
    
    
    Box rightBox = Box.createVerticalBox();
    rightBox.add(new Box.Filler(new Dimension(300, 10), new Dimension(300, 10), new Dimension(300, 10)));
    rightBox.add(title);
    rightBox.add(new Box.Filler(new Dimension(300, 50), new Dimension(300, 50), new Dimension(300, 50)));
    rightBox.add(countdown);
    rightBox.add(new Box.Filler(new Dimension(300, 20), new Dimension(300, 20), new Dimension(300, 20)));
    rightBox.add(points);
    rightBox.add(new Box.Filler(new Dimension(300, 20), new Dimension(300, 20), new Dimension(300, 20)));
    rightBox.add(stomach);
    rightBox.add(new Box.Filler(new Dimension(300, 200), new Dimension(300, 200), new Dimension(300, 200)));
    rightBox.setPreferredSize(new Dimension(50, 150));
    
    Box bigBox = Box.createHorizontalBox();
    bigBox.add(maze);
    bigBox.add(new Box.Filler(new Dimension(50, 450), new Dimension(50, 450), new Dimension(50, 450)));
    bigBox.add(rightBox);
    bigBox.add(new Box.Filler(new Dimension(50, 450), new Dimension(50, 450), new Dimension(50, 450)));
    
    setLayout(new BorderLayout());
    add(bigBox, BorderLayout.CENTER);
    
    setPreferredSize(new Dimension(1000, 450));
    setBackground(new Color(250, 241, 227));
  }
}