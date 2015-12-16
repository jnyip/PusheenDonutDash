//********************************************************************
// MazePanel.java
//
// Represents the primary display panel for the Maze program.
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MazePanel extends JPanel {
  private Pusheen user;
  private Maze maze;
  private LinkedList<Paode> llMaze;
  private final int WIDTH = 450, HEIGHT = 450;
  private final int JUMP = 30; // increment for image movement
  private final int IMAGE_SIZE = 30;
  private ImageIcon cat, currentImage;
  private int x, y;
  private CountdownPanel countdown;
  private Color BROWN = new Color(97,80,73);
  private Color GREEN = new Color(170,230,135);
  
//-----------------------------------------------------------------
// Constructor: Sets up this panel and loads the images.
//-----------------------------------------------------------------
  public MazePanel(String tgfFilename, Pusheen pusheenUser) {
    user = pusheenUser;
    maze = new Maze(tgfFilename);
    llMaze = maze.getMaze();
    Paode start = maze.getBeginning();
    user.setPaode(start);
    
    addKeyListener (new MazeListener());
    x = 30;
    y = 30;
    cat = new ImageIcon ("images/30pusheen.gif");
    currentImage = cat;
    setBackground (BROWN);
    setPreferredSize (new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    countdown = new CountdownPanel(user);
  }
  
  //-----------------------------------------------------------------     
  //  Draws the image in the current location.     
  //-----------------------------------------------------------------     
  public void paintComponent (Graphics page) {        
    super.paintComponent (page);        

    for (int i = 0 ; i < maze.getSize(); i++){
      Paode current = llMaze.get(i);
      page.setColor(GREEN);
      page.fillRect( ((current.getXCoor()*30)/*-60*/),
                    ((current.getYCoor()*30)/*-60*/), 30,30);
    }
    
    page.setColor(BROWN);
    page.fillRect( 0,0, 30,30);
    Paode home = maze.getHome();
    page.setColor(new Color (196,138,102));
    page.fillRect( ((home.getXCoor()*30)/*-30*/),
                    ((home.getYCoor()*30)/*-30/*/), 30,30);
    
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
      
      if (!user.getGameOver() && !user.getIsHome()) {
//        System.out.println("MazePanel says gameOver is: " + countdown.gameOver());
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
