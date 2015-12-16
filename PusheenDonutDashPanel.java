import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class PusheenDonutDashPanel extends JPanel {
  
  private JLabel title;
  private JPanel countdown, points, stomach, maze;
  private Pusheen PusheenUser;
  
  public PusheenDonutDashPanel(Pusheen pusheenUser) {
    PusheenUser = pusheenUser;
    
    title = new JLabel ("Pusheen Donut Dash");
    title.setFont(new Font("Comic Sans", Font.BOLD, 30));
    title.setForeground(new Color(61, 34, 8));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    points = new PointsPanel(PusheenUser);
    points.setPreferredSize(new Dimension(300, 110));
    countdown = new CountdownPanel();
    countdown.setPreferredSize(new Dimension(300, 110));
    stomach = new StomachPanel(PusheenUser);
    stomach.setPreferredSize(new Dimension(300, 200));
    maze = new MazePanel("completeMazeUnfilled.tgf", pusheenUser); // temporary
    maze.setPreferredSize(new Dimension(450, 450));
    
    Box rightBox = Box.createVerticalBox();
    rightBox.add(new Box.Filler(new Dimension(300, 10), new Dimension(300, 10), new Dimension(300, 10)));
    rightBox.add(title);
    rightBox.add(new Box.Filler(new Dimension(300, 10), new Dimension(300, 10), new Dimension(300, 10)));
    rightBox.add(countdown);
    rightBox.add(new Box.Filler(new Dimension(300, 5), new Dimension(300, 5), new Dimension(300, 5)));
    rightBox.add(points);
    rightBox.add(new Box.Filler(new Dimension(300, 5), new Dimension(300, 5), new Dimension(300, 5)));
    rightBox.add(stomach);
    rightBox.add(new Box.Filler(new Dimension(300, 200), new Dimension(300, 200), new Dimension(300, 200)));
    rightBox.setPreferredSize(new Dimension(50, 150));
    
    Box bigBox = Box.createHorizontalBox();
    bigBox.add(maze);
    bigBox.add(new Box.Filler(new Dimension(50, 450), new Dimension(50, 450), new Dimension(50, 450)));
    bigBox.add(rightBox);
    bigBox.add(new Box.Filler(new Dimension(50, 450), new Dimension(50, 450), new Dimension(50, 450)));
    
    setLayout(new BorderLayout());
    add(bigBox, BorderLayout.CENTER);
    
    setPreferredSize(new Dimension(1000, 450));
    setBackground(new Color(250, 241, 227));
  }
}