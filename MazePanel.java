//********************************************************************
// MazePanel.java
//
// Represents the primary display panel for the Maze program.
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazePanel extends JPanel {
  private final int WIDTH = 500, HEIGHT = 500;
  private final int JUMP = 121; // increment for image movement
  private final int IMAGE_SIZE = 31;
  private ImageIcon up, down, right, left, currentImage;
  private int x, y;
  
//-----------------------------------------------------------------
// Constructor: Sets up this panel and loads the images.
//-----------------------------------------------------------------
  public MazePanel() {
    addKeyListener (new MazeListener());
    x = WIDTH / 2;
    y = HEIGHT / 2;
    up = new ImageIcon ("images/arrowUp.gif");
    down = new ImageIcon ("images/arrowDown.gif");
    left = new ImageIcon ("images/arrowLeft.gif");
    right = new ImageIcon ("images/arrowRight.gif");
    currentImage = right;
//    setBackground (Color.black);
    setPreferredSize (new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
  }
  
  
//-----------------------------------------------------------------
// Draws the image in the current location.
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
    public void keyPressed (KeyEvent event) {
      switch (event.getKeyCode()) {
        case KeyEvent.VK_UP:
          currentImage = up;
          y -= JUMP;
          break;
        case KeyEvent.VK_DOWN:
          currentImage = down;
          y += JUMP;
          break;
        case KeyEvent.VK_LEFT:
          currentImage = left;
          x -= JUMP;
          break;
        case KeyEvent.VK_RIGHT:
          currentImage = right;
          x += JUMP;
          break;
      }
      repaint();
    }
    
//-----------------------------------------------------------------
// Provide empty definitions for unused event methods.
//-----------------------------------------------------------------
    public void keyTyped (KeyEvent event) {}
    public void keyReleased (KeyEvent event) {}
    
  }
  
}