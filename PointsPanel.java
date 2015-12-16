/* PointsPanel.java
 * 
 * Written by: Jesslyn Tannady
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Brenda Ji
 * Last Modified: December 16, 2015
 * 
 * Purpose: Represents the primary display panel for the Points program.
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PointsPanel extends JPanel
{
  // Instance Variables 
  private int points;
  private JButton push;
  private JLabel textLabel, pointsLabel;
  private Pusheen user;
  

  /* Constructor: Creates the PointsPanel where the points collected will be 
   * displayed to the user. This panel must know about the same Pusheen object
   * that the other Panels know about so that they are all working according to
   * the same Pusheen 
   * 
   * @param pusheenUser The Pusheen that all the panels must know about 
   */
  public PointsPanel (Pusheen pusheenUser) {
    user = pusheenUser; // Set user to the given Pusheen 
    points = 0; // Initialize starting points to 0
    
    textLabel = new JLabel ("Points:");
    pointsLabel = new JLabel (String.valueOf(points));
    
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    pointsLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(pointsLabel, BorderLayout.CENTER);
    
    setPreferredSize(new Dimension(300, 110));
    
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    pointsLabel.setForeground(new Color(61, 34, 8));
//    pointsLabel.setFocusable(true);
  }
  
  /**
   * setPointsLabel()
   * Allows other panels to set the Label in this PointsPanel 
   *
   * @param p The number of points that Pusheen has collected
   * @return Nothing   
   */
  public void setPointsLabel(int p){
    points = p;
    pointsLabel.setText(String.valueOf(points));
  } 
}