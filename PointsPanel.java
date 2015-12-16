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
  }
  
  public void setPoints(int p){
    points = p;
  }
  
  public void setPointsLabel(int p){
    points = p;
    pointsLabel.setText(String.valueOf(points));
  } 
}