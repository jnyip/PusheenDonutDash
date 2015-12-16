import javax.swing.JFrame;

public class Points
{

   //-----------------------------------------------------------------
   //  Creates and displays the main program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Points"); // The title of the window
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // by clicking the red "close window" button

      Pusheen user = new Pusheen();
      PointsPanel panel = new PointsPanel(user); // The Panel file only thing that needs to change
      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);
   }
}
