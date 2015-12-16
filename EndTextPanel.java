import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EndTextPanel extends JPanel
{
  private JLabel textLabel;
  private Pusheen user;
  
  //-----------------------------------------------------------------
  //  Constructor: Sets up the GUI.
  //-----------------------------------------------------------------
  public EndTextPanel (Pusheen pusheenUser) {
    user = pusheenUser;
    
    textLabel = new JLabel ("");
  
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
    
    add (textLabel);
    
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    setPreferredSize(new Dimension(300, 40));
  }
  
  public void setText () {
    if (user.getIsHome()) {
      System.out.println("YOU WON!");
      textLabel.setText("YOU WON!");
    } else {
      textLabel.setText(" ");
    }
  }
}