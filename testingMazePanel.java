import java.awt.*;
import javax.swing.*;
import java.util.*;

public class testingMazePanel extends JPanel{
  private Color BROWN = new Color(97,80,73);
  private Color GREEN = new Color(170,230,135);
  
  
  public testingMazePanel(){
    setPreferredSize(new Dimension (780,780));
    setBackground(BROWN);
    
  }
  
  public void paintComponent (Graphics page){
    super.paintComponent(page);
    
    Maze maze1 = new Maze("completeMazeUnfilled.tgf");
    LinkedList<Paode> llMaze = maze1.getMaze();
    for (int i = 0 ; i < maze1.getSize(); i++){
      Paode current = llMaze.get(i);
      page.setColor(GREEN);
      page.fillRect( ((current.getXCoor()*60)-60),
                    ((current.getYCoor()*60)-60), 60,60);
    }
    
    Paode home = maze1.getHome();
    page.setColor(new Color (196,138,102));
    page.fillRect( ((home.getXCoor()*60)-60),
                    ((home.getYCoor()*60)-60), 60,60);
  }
}