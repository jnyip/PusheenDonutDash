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
  private final int WIDTH = 500, HEIGHT = 500;
  private final int JUMP = 121; // increment for image movement
  private final int IMAGE_SIZE = 31;
  private ImageIcon cat, currentImage;
  private int x, y;
  
//-----------------------------------------------------------------
// Constructor: Sets up this panel and loads the images.
//-----------------------------------------------------------------
  public MazePanel(String tgfFilename) {
    maze = new Maze(tgfFilename);
    Paode start = maze.getBeginning();
    user = new Pusheen(start);
    
    addKeyListener (new MazeListener());
    x = 30;
    y = 30;
    cat = new ImageIcon ("images/pusheen.gif");
    currentImage = cat;
//    setBackground (Color.black);
    setPreferredSize (new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
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
     
      switch (event.getKeyCode()){
        case KeyEvent.VK_UP:
          p = user.getTop();
          moved = user.move(p);
          if (moved){
            currentImage = cat;
            y -= JUMP;
          }
          break;
        case KeyEvent.VK_DOWN:
          p = user.getBottom();
          moved = user.move(p);
          if (moved){
            currentImage = cat;
            y += JUMP;
          }
          break;
        case KeyEvent.VK_LEFT:
          p = user.getLeft();
          moved = user.move(p);
          if (moved){
            currentImage = cat;
            x -= JUMP;
          }
          break;
        case KeyEvent.VK_RIGHT:
          p = user.getRight();
          moved = user.move(p);
          if (moved){
            currentImage = cat;
            x += JUMP;
          }
          break;
      }
    }
    
//-----------------------------------------------------------------
// Provide empty definitions for unused event methods.
//-----------------------------------------------------------------
    public void keyTyped (KeyEvent event) {}
    public void keyReleased (KeyEvent event) {}
    
  }
  
}