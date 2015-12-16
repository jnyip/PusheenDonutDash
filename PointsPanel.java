import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PointsPanel extends JPanel
{
  private int points;
  private JButton push;
  private JLabel textLabel, pointsLabel;
  private Pusheen user;
  
  //-----------------------------------------------------------------
  //  Constructor: Sets up the GUI.
  //-----------------------------------------------------------------
  public PointsPanel (Pusheen push) {
    user = push;
    points = 0;
    
    push = new JButton ("Add points");
    push.addActionListener (new ButtonListener());
    
    textLabel = new JLabel ("Points:");
    pointsLabel = new JLabel (String.valueOf(points));
    
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    pointsLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(pointsLabel, BorderLayout.CENTER);
    add(push, BorderLayout.SOUTH);
    
    setPreferredSize(new Dimension(300, 110));
    
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    pointsLabel.setForeground(new Color(61, 34, 8));
  }
  
  //*****************************************************************
  //  Represents a listener for button push (action) events.
  //*****************************************************************
  private class ButtonListener implements ActionListener {
    //--------------------------------------------------------------
    //  Updates the counter and label when the button is pushed.
    //--------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
      points++; // When ANY button is clicked! (If there were more...)
      pointsLabel.setText(String.valueOf(points));
    }
  }
}
