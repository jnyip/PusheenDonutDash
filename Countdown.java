import javax.swing.JFrame;

public class Countdown
{
   //-----------------------------------------------------------------
   //  Creates and displays the main program frame.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Countdown Tester"); // The title of the window
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // by clicking the red "close window" button

      CountdownPanel panel = new CountdownPanel(); // The Panel file only thing that needs to change
      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);
   }
}
