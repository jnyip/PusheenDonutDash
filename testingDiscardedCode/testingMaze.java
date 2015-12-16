import javax.swing.JFrame; 

public class testingMaze { 
  public static void main (String[] args)    {       
    JFrame frame = new JFrame ("testingMaze");       
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);      
    
    frame.getContentPane().add(new testingMazePanel());       
    frame.pack();       
    frame.setVisible(true);   
  }
}