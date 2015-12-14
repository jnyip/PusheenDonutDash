import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Schedule a task that executes once every second.
 */

public class CountdownPanel extends JPanel {
  private Toolkit toolkit; // for the sound
  private Timer timer;
  private int COUNTDOWN_SECONDS = 5;
  private String time; // formatted time
  private JLabel textLabel, timeLabel;

  public CountdownPanel() {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    
    textLabel = new JLabel ("Time left:");
    timeLabel = new JLabel (time);
    
    timer.schedule(new RemindTask(), 0, //initial delay
        1 * 1000); //subsequent rate
    
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    timeLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(timeLabel, BorderLayout.SOUTH);
    
    setPreferredSize(new Dimension(300, 70));
    
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    timeLabel.setForeground(new Color(61, 34, 8));
  }

  class RemindTask extends TimerTask {
    int numWarningBeeps = COUNTDOWN_SECONDS;

    public void run() {
      if (numWarningBeeps > 0) {
//        toolkit.beep();
        
        // Formatting
        String minutes = String.valueOf(numWarningBeeps/60);
        String seconds = String.valueOf(numWarningBeeps%60);
        if (seconds.length() == 1) {
          seconds = "0" + seconds;
        }
        
        time = (minutes + ":" + seconds);
        timeLabel.setText(time);
        
//        System.out.println(time);
        numWarningBeeps--;
      } else {
        toolkit.beep();
        textLabel.setText("Time's up!");
        timeLabel.setText("0:00");
//        System.out.println(time);
        timer.cancel(); //Stops the timer, but is not necessary if we call System.exit
//        System.exit(0); //Stops the AWT thread (and everything else)
      }
    }
  }

  public static void main(String args[]) {
    System.out.println("Starting countdown.");
    new CountdownPanel();
  }
}   