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
  private JPanel countdown, maze, topSection;
  private PointsPanel points;
  private StomachPanel stomach;
  private EndTextPanel endText;
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
    
    // Sets up the title label on top
    title = new JLabel ("Pusheen Donut Dash");
    title.setFont(new Font("Comic Sans", Font.BOLD, 30));
    title.setForeground(new Color(61, 34, 8));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    // Sets up our various panels
    countdown = new CountdownPanel(PusheenUser);
    countdown.setPreferredSize(new Dimension(20, 20));
    
    points = new PointsPanel(PusheenUser);
    points.setPreferredSize(new Dimension(300, 20));
    
    stomach = new StomachPanel(PusheenUser);
    stomach.setPreferredSize(new Dimension(300, 30));
    
    endText = new EndTextPanel(PusheenUser);
    countdown.setPreferredSize(new Dimension(300, 40));
    
    maze = new MazePanel("maze.tgf", PusheenUser, points, stomach, endText);
    maze.setPreferredSize(new Dimension(450, 450));
    
    // Formats countdown and points so that they are next to each other
    Box topBox = Box.createHorizontalBox();
    topBox.add(countdown);
    topBox.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
    topBox.add(points);    
    
    // Formats countdown, points, stomach, and end text so that they are vertically aligned
    Box rightBox = Box.createVerticalBox();
    rightBox.add(new Box.Filler(new Dimension(250, 10), new Dimension(250, 10), new Dimension(250, 10)));
    rightBox.add(title);
    rightBox.add(new Box.Filler(new Dimension(250, 20), new Dimension(250, 20), new Dimension(250, 20)));
    rightBox.add(topBox);
    rightBox.add(new Box.Filler(new Dimension(250, 20), new Dimension(250, 20), new Dimension(250, 20)));
    rightBox.add(stomach);
    rightBox.add(new Box.Filler(new Dimension(250, 20), new Dimension(250, 20), new Dimension(250, 20)));
    rightBox.add(endText);
    rightBox.add(new Box.Filler(new Dimension(250, 50), new Dimension(250, 50), new Dimension(250, 50)));   
    
    // Formats the panel
    Box bigBox = Box.createHorizontalBox();
    bigBox.add(maze);
    bigBox.add(new Box.Filler(new Dimension(30, 450), new Dimension(30, 450), new Dimension(30, 450)));
    bigBox.add(rightBox);
    bigBox.add(new Box.Filler(new Dimension(30, 450), new Dimension(30, 450), new Dimension(30, 450)));
    
    setLayout(new BorderLayout());
    add(bigBox, BorderLayout.CENTER);
    
    setPreferredSize(new Dimension(1200, 450));
    setBackground(new Color(250, 241, 227));
  }
}