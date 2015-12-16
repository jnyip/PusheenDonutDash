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
    leftPanel.setPreferredSize (new Dimension (20, 20));
    leftColor = WHITE;
    leftPanel.setBackground (leftColor);
    
    midPanel = new JPanel();
    midPanel.setPreferredSize (new Dimension (20, 20));
    midColor = WHITE;
    midPanel.setBackground (midColor);
    
    rightPanel = new JPanel();
    rightPanel.setPreferredSize (new Dimension (20, 20));
    rightColor = WHITE;
    rightPanel.setBackground (rightColor);
   
    Box panelBox = Box.createHorizontalBox();
    panelBox.add(leftPanel);
    panelBox.add(new Box.Filler(new Dimension(5, 100), new Dimension(5, 100), new Dimension(110, 30)));
    panelBox.add(midPanel);
    panelBox.add(new Box.Filler(new Dimension(5, 100), new Dimension(5, 100), new Dimension(110, 30)));
    panelBox.add(rightPanel);
    
    Box buttonBox = Box.createHorizontalBox();
    buttonBox.add(blueButton);
    buttonBox.add(pinkButton);
    buttonBox.add(brownButton);
    
    Box bigPanel = Box.createVerticalBox();
    bigPanel.add(panelBox);
    bigPanel.add(buttonBox);
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(bigPanel, BorderLayout.SOUTH);
    
    setPreferredSize(new Dimension(300, 200));
    
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