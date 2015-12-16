//********************************************************************
// MazePanel.java
//
// Represents the primary display panel for the Maze program.
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazePanel extends JPanel {
  private Pusheen user;
  private Maze maze;
  private final int WIDTH = 900, HEIGHT = 900;
  private final int JUMP = 60; // increment for image movement
  private final int IMAGE_SIZE = 60;
  private ImageIcon cat, currentImage;
  private int x, y;
  private CountdownPanel countdown;
  
//-----------------------------------------------------------------
// Constructor: Sets up this panel and loads the images.
//-----------------------------------------------------------------
  public MazePanel(String tgfFilename, Pusheen push) {
    user = push;
    maze = new Maze(tgfFilename);
    Paode start = maze.getBeginning();
    user.setPaode(start);
    
    addKeyListener (new MazeListener());
    x = 30;
    y = 30;
    cat = new ImageIcon ("images/pusheen.gif");
    currentImage = cat;
//    setBackground (Color.black);
    setPreferredSize (new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    countdown = new CountdownPanel();
  }
  
  //-----------------------------------------------------------------     
  //  Draws the image in the current location.     
  //-----------------------------------------------------------------     
  public void paintComponent (Graphics page) {        
    super.paintComponent (page);        
    currentImage.paintIcon (this, page, x, y); 
  }
  
//*****************************************************************
// Represents the listener for keyboard activity.
//*****************************************************************
  private class MazeListener implements KeyListener {
    
//-----------------------------------------------------------------
// Responds to the user pressing arrow keys by adjusting the
// image and image location accordingly.
//-----------------------------------------------------------------
    // instance variable 
    Paode p;
    boolean moved;
    
    public void keyPressed (KeyEvent event){
      // ONLY GOES THROUGH IF...
      // gameOver == false
      // getIsHome == false
      // if one of these are false (aka true) then we can keep moving
      
      // If condition1 == true OR condition2 == true...
      if (!countdown.gameOver() && !user.getIsHome()) {
        System.out.println("MazePanel says gameOver is: " + countdown.gameOver());
        switch (event.getKeyCode()){
          case KeyEvent.VK_UP:
            p = user.getPaode().getTop();
            moved = user.move(p);
            if (moved) {
              currentImage = cat;
              y -= JUMP;
            }
            break;
          case KeyEvent.VK_DOWN:
            p = user.getPaode().getBottom();
            moved = user.move(p);
            if (moved){
              currentImage = cat;
              y += JUMP;
            }
            break;  
          case KeyEvent.VK_LEFT:
            p = user.getPaode().getLeft();
            moved = user.move(p);
            if (moved){
              currentImage = cat;
              x -= JUMP;
            }
            break;
          case KeyEvent.VK_RIGHT:
            p = user.getPaode().getRight();
            moved = user.move(p);
            if (moved){
              currentImage = cat;
              x += JUMP;
            }
            break;
        }
        repaint();
      }
    }
    
    
//-----------------------------------------------------------------
// Provide empty definitions for unused event methods.
//-----------------------------------------------------------------
    public void keyTyped (KeyEvent event) {}
    public void keyReleased (KeyEvent event) {}
  }
}
