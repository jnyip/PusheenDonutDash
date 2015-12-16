import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class PusheenDonutDashPanel extends JPanel {
  
  private JLabel title;
  private JPanel countdown, points, stomach, maze;
  
  public PusheenDonutDashPanel() {
    
    title = new JLabel ("Pusheen Donut Dash");
    title.setFont(new Font("Comic Sans", Font.BOLD, 30));
    title.setForeground(new Color(61, 34, 8));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    points = new PointsPanel();
    points.setPreferredSize(new Dimension(250, 110));
    countdown = new CountdownPanel();
    countdown.setPreferredSize(new Dimension(250, 110));
    stomach = new StomachPanel();
    stomach.setPreferredSize(new Dimension(250, 180));
    maze = new MazePanel("completeMazeUnfilled.tgf"); // temporary
    maze.setPreferredSize(new Dimension(900, 900));
    // Right width = 300, Right height = 400 (not including label)
    // Total width = 1800, Total height = 1300 (not including label)
    
    Box rightBox = Box.createVerticalBox();
    rightBox.add(new Box.Filler(new Dimension(300, 10), new Dimension(300, 10), new Dimension(300, 10)));
    rightBox.add(title);
    rightBox.add(new Box.Filler(new Dimension(300, 100), new Dimension(300, 100), new Dimension(300, 100)));
    rightBox.add(countdown);
    rightBox.add(new Box.Filler(new Dimension(300, 5), new Dimension(300, 5), new Dimension(300, 5)));
    rightBox.add(points);
    rightBox.add(new Box.Filler(new Dimension(300, 5), new Dimension(300, 5), new Dimension(300, 5)));
    rightBox.add(stomach);
    rightBox.add(new Box.Filler(new Dimension(300, 200), new Dimension(300, 200), new Dimension(300, 200)));
//    rightBox.setPreferredSize(new Dimension(50, 150));
    
    Box bigBox = Box.createHorizontalBox();
    bigBox.add(maze);
    bigBox.add(new Box.Filler(new Dimension(100, 780), new Dimension(100, 780), new Dimension(150, 780)));
    bigBox.add(rightBox);
    bigBox.add(new Box.Filler(new Dimension(100, 780), new Dimension(100, 780), new Dimension(150, 780)));
    
    setLayout(new BorderLayout());
    add(bigBox, BorderLayout.CENTER);
    
    setPreferredSize(new Dimension(1250, 780));
    setBackground(new Color(250, 241, 227));
  }
}