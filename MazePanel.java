/* MazePanel.java
 * 
 * Written by: Jesslyn Tannady
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Brenda Ji
 * Last Modified: December 16, 2015
 * 
 * Purpose: Represents the primary display panel for the Maze program.
 */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MazePanel extends JPanel {
  
  // Instance Variables 
  private Pusheen user;
  private Maze maze;
  private LinkedList<Paode> llMaze;
  private final int WIDTH = 450, HEIGHT = 450;
  private final int JUMP = 30; // increment for image movement
  private final int IMAGE_SIZE = 30;
  private ImageIcon cat, monster, pinkDonut, brownDonut, blueDonut;
  private int x, y;
  private CountdownPanel countdown;
  private Color BROWN = new Color(97,80,73); // Final colors for our maze
  private Color GREEN = new Color(170,230,135);
  private PointsPanel pointsPanel;
  private StomachPanel stomachPanel;
  
 
  /* Constructor: Creates a MazePanel that takes in a maze tgf file, a Pusheen, 
   * and two panels that must know about the actions that the user takes in this 
   * panel.
   * 
   * Since the game is controlled by the user pressing the arrow keys the 
   * KeyListener event handler is centralized to the maze panel. So the
   * MazePanel must know about all the other panels that must be connected 
   * to Pusheen and the user's action while playing the game.
   * 
   * @param tgfFilename The file that stores all the maze components
   * @param pusheenUser The Pusheen that all the panels must know about 
   * @param pp The PointsPanel that must be updated as the user plays the game
   * @param sp The StomachPanel that also must be updated when the user collects
   *           donuts
   */
  public MazePanel(String tgfFilename, Pusheen pusheenUser, PointsPanel pp, StomachPanel sp) {
    user = pusheenUser;
    maze = new Maze(tgfFilename);
    pointsPanel = pp;
    stomachPanel = sp;
    llMaze = maze.getMaze(); //Linked list of the maze 
    Paode start = maze.getBeginning(); // Set the user to the start of the maze
    user.setPaode(start);
    
    addKeyListener (new MazeListener());
    x = 30; // beginning position of the maze 
    y = 30;
    
    // Images that must be added to the maze 
    cat = new ImageIcon ("images/30pusheen.gif");
    monster = new ImageIcon("images/30monster.gif");
    pinkDonut = new ImageIcon("images/30dpink.gif");
    brownDonut = new ImageIcon("images/30dbrown.gif");
    blueDonut = new ImageIcon("images/30dblue.gif");
    // Formatting Maze panel 
    setBackground (BROWN);
    setPreferredSize (new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    countdown = new CountdownPanel(user);
  }
  
  /**
   * paintComponent()
   * Sets up the maze and adds the Donuts and Monsters to the page. Also adds 
   * Pusheen to the maze. 
   * 
   * @param page The Graphics that must be taken in order to draw the images and
   *             rectangles to create the maze 
   * @return Nothing  
   */
  public void paintComponent (Graphics page) {        
    super.paintComponent (page);        

    // loop through the maze, places where the user can go is colored green
    for (int i = 0 ; i < maze.getSize(); i++){
      Paode current = llMaze.get(i);
      page.setColor(GREEN);
      page.fillRect( ((current.getXCoor()*30)),
                    ((current.getYCoor()*30)), 30,30);
      // adding monsters
      if (current.getMonster())
        monster.paintIcon (this, page, (current.getXCoor()*30), 
                           (current.getYCoor()*30)); 
      
      // adding donuts according to color
      if (current.getDonut() != null){
        if (current.getDonut().getColor() == 1)
         pinkDonut.paintIcon (this, page, (current.getXCoor()*30), 
                           (current.getYCoor()*30));
        if (current.getDonut().getColor() == 2)
         brownDonut.paintIcon (this, page, (current.getXCoor()*30), 
                           (current.getYCoor()*30));
        if (current.getDonut().getColor() == 3)
         blueDonut.paintIcon (this, page, (current.getXCoor()*30), 
                           (current.getYCoor()*30));
      } 
    }
    
    page.setColor(BROWN); // background color 
    page.fillRect( 0,0, 30,30);
    Paode home = maze.getHome();
    page.setColor(new Color (196,138,102));
    page.fillRect( ((home.getXCoor()*30)),
                    ((home.getYCoor()*30)), 30,30);
    
    // add Pusheen 
    cat.paintIcon (this, page, x, y); 
  }
  
//*****************************************************************
// Represents the listener for keyboard activity.
//*****************************************************************
  private class MazeListener implements KeyListener {
    
//-----------------------------------------------------------------
// Responds to the user pressing arrow keys by adjusting the
// image and image location accordingly.
//-----------------------------------------------------------------
    // instance variables 
    Paode p; 
    boolean moved;
    int points;
    Donut donut;
    
    public void keyPressed (KeyEvent event){
      
      // getDonut() if the Paode at which the user is a donut
      donut = user.getPaode().getDonut(); 
      // Only execute keyPressed events if these conditionals are both false
      if (!user.getGameOver() && !user.getIsHome()) { 
        
        switch (event.getKeyCode()){
          case KeyEvent.VK_UP: // UP key
            // only move if there is a Paode in the direction that the user wants to go
            p = user.getPaode().getTop();
            moved = user.move(p);
            if (moved) {
              y -= JUMP; // moving Pusheen
              points = user.getPoints();
              pointsPanel.setPointsLabel(points); // Update PointsPanel 
              stomachPanel.eatDonuts(); // Update StomachPanel
            }
            break;
          case KeyEvent.VK_DOWN: // DOWN key 
            // only move if there is a paode in the direction that the user wants to go
            p = user.getPaode().getBottom();
            moved = user.move(p);
            if (moved){
              y += JUMP; // moving Pusheen
              points = user.getPoints();
              pointsPanel.setPointsLabel(points); // Update PointsPanel 
              stomachPanel.eatDonuts(); // Update StomachPanel
            }
            break;  
          case KeyEvent.VK_LEFT: // LEFT key
            // only move if there is a paode in the direction that the user wants to go
            p = user.getPaode().getLeft();
            moved = user.move(p);
            if (moved){
              x -= JUMP; // moving Pusheen
              points = user.getPoints();
              pointsPanel.setPointsLabel(points); // Update PointsPanel 
              stomachPanel.eatDonuts(); // Update StomachPanel
            }
            break;
          case KeyEvent.VK_RIGHT: // RIGHT key
            // only move if there is a paode in the direction that the user wants to go
            p = user.getPaode().getRight();
            moved = user.move(p);
            if (moved){  
              x += JUMP; // moving Pusheen
              points = user.getPoints();
              pointsPanel.setPointsLabel(points); // Update PointsPanel 
              stomachPanel.eatDonuts(); // Update StomachPanel
            }
            break;
        }
        repaint(); // repainting every time a key is called 
      }
    }
    
    
//-----------------------------------------------------------------
// Provide empty definitions for unused event methods.
//-----------------------------------------------------------------
    public void keyTyped (KeyEvent event) {}
    public void keyReleased (KeyEvent event) {}
  }
}
