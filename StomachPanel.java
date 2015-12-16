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
  private Pusheen user;
  
  public StomachPanel(Pusheen pusheenUser) {
    
    user = pusheenUser;
    textLabel = new JLabel ("Last 3 collected:");
    
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
    panelBox.add(new Box.Filler(new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20)));
    panelBox.add(leftPanel);
    panelBox.add(new Box.Filler(new Dimension(10, 20), new Dimension(10, 20), new Dimension(10, 20)));
    panelBox.add(midPanel);
    panelBox.add(new Box.Filler(new Dimension(10, 20), new Dimension(10, 20), new Dimension(10, 20)));
    panelBox.add(rightPanel);
    panelBox.add(new Box.Filler(new Dimension(20, 20), new Dimension(20, 20), new Dimension(20, 20)));
    
    Box bigPanel = Box.createVerticalBox();
    bigPanel.add(panelBox);
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(bigPanel, BorderLayout.SOUTH);
    
    setPreferredSize(new Dimension(100, 100));
    
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    
    leftPanel.setFocusable(true);
    midPanel.setFocusable(true);
    rightPanel.setFocusable(true);
    
  }
  
  public void eatDonuts(){
    Paode p = user.getPaode();
    Donut donut = p.getDonut();
    if (donut != null){
      leftColor = midColor;
      midColor = rightColor;
      System.out.println("I ATE A DONUT!!!!!!");
      if (donut.getColor() == 1){
        rightColor = PINK;
        System.out.println("THE DONUT WAS PINK");
      }
      else if (donut.getColor() == 2){
        rightColor = BROWN;
        System.out.println("THE DONUT WAS BROWN");
      }
      else{
        rightColor = BLUE;
        System.out.println("THE DONUT WAS BLUE");
      }
      leftPanel.setBackground(leftColor);
      midPanel.setBackground(midColor);
      rightPanel.setBackground(rightColor);
      p.setDonut(0);
    }
  }
}