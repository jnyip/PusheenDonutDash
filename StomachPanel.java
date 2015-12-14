import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class StomachPanel extends JPanel {
  private JPanel buttonPanel, leftPanel, midPanel, rightPanel;
  private JLabel textLabel;
  private JButton blueButton, pinkButton, brownButton;
  private Color leftColor, midColor, rightColor;
  private Color WHITE = new Color(255, 255, 255);
  private Color BLUE = new Color(181, 248, 255);
  private Color PINK = new Color(245, 91, 98);
  private Color BROWN = new Color(97, 80, 73);
  
  public StomachPanel() {
    
    textLabel = new JLabel ("Last 3 collected:");
    
    blueButton = new JButton ("Blue");
    blueButton.addActionListener (new ButtonListener());
    
    pinkButton = new JButton ("Pink");
    pinkButton.addActionListener (new ButtonListener());
    
    brownButton = new JButton ("Brown");
    brownButton.addActionListener (new ButtonListener());
    
    leftPanel = new JPanel();
    leftPanel.setPreferredSize (new Dimension (30, 30));
    leftColor = WHITE;
    leftPanel.setBackground (leftColor);
//    leftPanel.EmptyBorder(2, 2, 2, 2);
    
    midPanel = new JPanel();
    midPanel.setPreferredSize (new Dimension (30, 30));
    midColor = WHITE;
    midPanel.setBackground (midColor);
    
    rightPanel = new JPanel();
    rightPanel.setPreferredSize (new Dimension (30, 30));
    rightColor = WHITE;
    rightPanel.setBackground (rightColor);
    
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new BorderLayout());
    buttonPanel.add(blueButton, BorderLayout.WEST);
    buttonPanel.add(pinkButton, BorderLayout.CENTER);
    buttonPanel.add(brownButton, BorderLayout.EAST);
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.SOUTH);
    
    add(leftPanel, BorderLayout.WEST);
    add(midPanel, BorderLayout.CENTER);
    add(rightPanel, BorderLayout.EAST);
    
    setPreferredSize(new Dimension(300, 110));
    
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
  }
  
  
  
  //*****************************************************************
  //  Represents the listener
  //*****************************************************************
  private class ButtonListener implements ActionListener {
    //--------------------------------------------------------------
    //  Updates the counter and label when the button is pushed.
    //--------------------------------------------------------------
    
    public void actionPerformed (ActionEvent event)
    {
      leftColor = midColor;
      midColor = rightColor;
      
      if (event.getSource() == blueButton) {
        rightColor = BLUE;
      } else if (event.getSource() == pinkButton) {
        rightColor = PINK;
      } else {
        rightColor = BROWN;
      }
      
      leftPanel.setBackground(leftColor);
      midPanel.setBackground(midColor);
      rightPanel.setBackground(rightColor);
    }
  }
}