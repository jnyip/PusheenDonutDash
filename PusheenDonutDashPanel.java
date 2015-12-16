import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class PusheenDonutDashPanel extends JPanel {
  
  private JLabel title;
  private JPanel countdown, maze, topSection;
  private PointsPanel points;
  private StomachPanel stomach;
  private EndTextPanel endText;
  private Pusheen PusheenUser;
  
  public PusheenDonutDashPanel(Pusheen pusheenUser) {
    PusheenUser = pusheenUser;
    
    title = new JLabel ("Pusheen Donut Dash");
    title.setFont(new Font("Comic Sans", Font.BOLD, 30));
    title.setForeground(new Color(61, 34, 8));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    countdown = new CountdownPanel(PusheenUser);
    countdown.setPreferredSize(new Dimension(20, 20));
    
    points = new PointsPanel(PusheenUser);
    points.setPreferredSize(new Dimension(300, 20));
    
    stomach = new StomachPanel(PusheenUser);
    stomach.setPreferredSize(new Dimension(300, 30));
    
    endText = new EndTextPanel(PusheenUser);
    countdown.setPreferredSize(new Dimension(300, 40));
    
    maze = new MazePanel("maze.tgf", PusheenUser, points, stomach, endText); // temporary
    maze.setPreferredSize(new Dimension(450, 450));
    
    Box topBox = Box.createHorizontalBox();
    topBox.add(countdown);
    topBox.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
    topBox.add(points);    
    
    Box rightBox = Box.createVerticalBox();
    rightBox.add(new Box.Filler(new Dimension(250, 10), new Dimension(250, 10), new Dimension(250, 10)));
    rightBox.add(title);
    rightBox.add(new Box.Filler(new Dimension(250, 20), new Dimension(250, 20), new Dimension(250, 20)));
    rightBox.add(topBox);
    rightBox.add(new Box.Filler(new Dimension(250, 20), new Dimension(250, 20), new Dimension(250, 20)));
    rightBox.add(stomach);
    rightBox.add(new Box.Filler(new Dimension(250, 20), new Dimension(250, 20), new Dimension(250, 20)));
    rightBox.add(endText);
    rightBox.add(new Box.Filler(new Dimension(250, 50), new Dimension(250, 50), new Dimension(250, 50)));   
    
    Box bigBox = Box.createHorizontalBox();
    bigBox.add(maze);
    bigBox.add(new Box.Filler(new Dimension(30, 450), new Dimension(30, 450), new Dimension(30, 450)));
    bigBox.add(rightBox);
    bigBox.add(new Box.Filler(new Dimension(30, 450), new Dimension(30, 450), new Dimension(30, 450)));
    
    setLayout(new BorderLayout());
    add(bigBox, BorderLayout.CENTER);
    
    setPreferredSize(new Dimension(1200, 450));
    setBackground(new Color(250, 241, 227));
  }
}