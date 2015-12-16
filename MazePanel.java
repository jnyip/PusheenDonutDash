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
  private ImageIcon cat, monster, pinkDonut, brownDonut, blueDonut;
  private int x, y;
  private CountdownPanel countdown;
  private Color BROWN = new Color(97,80,73);
  private Color GREEN = new Color(170,230,135);
  private PointsPanel pointsPanel;
  private StomachPanel stomachPanel;
  private EndTextPanel endText;
  
//-----------------------------------------------------------------
// Constructor: Sets up this panel and loads the images.
//-----------------------------------------------------------------
  public MazePanel(String tgfFilename, Pusheen pusheenUser, PointsPanel pp, StomachPanel sp, EndTextPanel et) {
    user = pusheenUser;
    maze = new Maze(tgfFilename);
    pointsPanel = pp;
    stomachPanel = sp;
    endText = et;
    llMaze = maze.getMaze();
    Paode start = maze.getBeginning();
    user.setPaode(start);
    
    addKeyListener (new MazeListener());
    x = 30;
    y = 30;
    cat = new ImageIcon ("images/30pusheen.gif");
    monster = new ImageIcon("images/30monster.gif");
    pinkDonut = new ImageIcon("images/30dpink.gif");
    brownDonut = new ImageIcon("images/30dbrown.gif");
    blueDonut = new ImageIcon("images/30dblue.gif");
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
      page.fillRect( ((current.getXCoor()*30)),
                    ((current.getYCoor()*30)), 30,30);
      if (current.getMonster())
        monster.paintIcon (this, page, (current.getXCoor()*30), 
                           (current.getYCoor()*30)); 
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
    
    page.setColor(BROWN);
    page.fillRect( 0,0, 30,30);
    Paode home = maze.getHome();
    page.setColor(new Color (196,138,102));
    page.fillRect( ((home.getXCoor()*30)),
                    ((home.getYCoor()*30)), 30,30);
    
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
    // instance variable 
    Paode p;
    boolean moved;
    int points;
    Donut donut;
    Color leftColor, midColor, rightColor;
    private Color WHITE = new Color(255, 255, 255);
    private Color BLUE = new Color(181, 248, 255);
    private Color PINK = new Color(245, 91, 98);
    private Color BROWN = new Color(97, 80, 73);
    
    public void keyPressed (KeyEvent event){
      

      donut = user.getPaode().getDonut();
      if (!user.getGameOver() && !user.getIsHome()) {
        switch (event.getKeyCode()){
          
          case KeyEvent.VK_UP:
            p = user.getPaode().getTop();
            moved = user.move(p);
            if (moved) {
              y -= JUMP;     
              points = user.getPoints();
              pointsPanel.setPointsLabel(points);
              stomachPanel.eatDonuts();
              endText.setText();
            }
            break;
            
          case KeyEvent.VK_DOWN:
            p = user.getPaode().getBottom();
            moved = user.move(p);
            if (moved){
              y += JUMP;
              points = user.getPoints();
              pointsPanel.setPointsLabel(points);
              stomachPanel.eatDonuts();
              endText.setText();
            }
            break;  
            
          case KeyEvent.VK_LEFT:
            p = user.getPaode().getLeft();
            moved = user.move(p);
            if (moved){
              x -= JUMP;
              points = user.getPoints();
              pointsPanel.setPointsLabel(points);
              stomachPanel.eatDonuts();
              endText.setText();
            }
            break;
            
          case KeyEvent.VK_RIGHT:
            p = user.getPaode().getRight();
            moved = user.move(p);
            if (moved){
              x += JUMP;
              points = user.getPoints();
              pointsPanel.setPointsLabel(points);
              stomachPanel.eatDonuts();
              endText.setText();
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
