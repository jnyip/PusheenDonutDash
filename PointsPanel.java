import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PointsPanel extends JPanel
{
  private int points;
  private JButton push;
  private JLabel textLabel, pointsLabel;
  private Pusheen user;
  
  //-----------------------------------------------------------------
  //  Constructor: Sets up the GUI.
  //-----------------------------------------------------------------
  public PointsPanel (Pusheen pusheenUser) {
    user = pusheenUser;
//    points = user.getPoints();
    points = 0;
    
    
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
    pointsLabel.setFocusable(true);
    
    pointsLabel.addKeyListener (new DirectionListener());
  }
  
  //*****************************************************************
  //  Represents a listener for button push (action) events.
  //*****************************************************************
  private class DirectionListener implements KeyListener {
    //--------------------------------------------------------------
    //  Updates the counter and label when the button is pushed.
    //--------------------------------------------------------------
    public void keyPressed (KeyEvent event) {
      switch (event.getKeyCode())    {
        case KeyEvent.VK_UP: case KeyEvent.VK_DOWN:
        case KeyEvent.VK_LEFT: case KeyEvent.VK_RIGHT:          
          System.out.println("Hit UP key");
          points = user.getPoints();
          pointsLabel.setText(String.valueOf(points));
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