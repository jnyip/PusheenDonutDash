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
    
    leftPanel.addKeyListener(new StomachListener());
    midPanel.addKeyListener(new StomachListener());
    rightPanel.addKeyListener(new StomachListener());
    
  }
  
  //*****************************************************************
  //  Represents the listener
  //*****************************************************************
  private class StomachListener implements KeyListener {
    //--------------------------------------------------------------
    //  Updates the counter and label when the button is pushed.
    //--------------------------------------------------------------
//    DonutQueue donuts = user.getDonuts();
    Donut donut;
    
    public void keyPressed (KeyEvent event)
    {
      donut = user.getPaode().getDonut();
      if (donut != null){
//        DonutQueue temp = donuts;
//        Donut tempDonut = donuts.dequeue();
        leftColor = midColor;
        midColor = rightColor;
        switch (event.getKeyCode()) {
          case KeyEvent.VK_UP: case KeyEvent.VK_DOWN:
          case KeyEvent.VK_LEFT: case KeyEvent.VK_RIGHT:          
            System.out.println("Hit UP key");
            if (donut.getColor() == 1){
              rightColor = PINK;
            }
            else if (donut.getColor() == 2){
              rightColor = BROWN;
            }
            else{
              rightColor = BLUE;
            }
            leftPanel.setBackground(leftColor);
            midPanel.setBackground(midColor);
            rightPanel.setBackground(rightColor);
            break;        
        }
      }

    }
    //-----------------------------------------------------------------
    //  Provide empty definitions for unused event methods.
    //-----------------------------------------------------------------
    public void keyTyped (KeyEvent event) {}
    public void keyReleased (KeyEvent event) {}
  }
}