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
  private int COUNTDOWN_SECONDS = 15;
  private String time; // formatted time
  private JLabel textLabel, timeLabel;
  private JButton push;
  private boolean gameOver;
  
  public CountdownPanel() {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    
    textLabel = new JLabel ("Time left:");
    timeLabel = new JLabel (time);
    
    push = new JButton ("Reset timer");
    push.addActionListener (new ButtonListener());
    
    timer.schedule(new RemindTask(), 0, //initial delay
                   1 * 1000); //subsequent rate
    
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    timeLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
    
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(timeLabel, BorderLayout.CENTER);
    add(push, BorderLayout.SOUTH);
    
    setPreferredSize(new Dimension(300, 110));
    
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    timeLabel.setForeground(new Color(61, 34, 8));
  }
  
  //*****************************************************************
  //  Represents a listener for button push (action) events.
  //*****************************************************************
  private class ButtonListener implements ActionListener {
    //--------------------------------------------------------------
    //  Updates the counter and label when the button is pushed.
    //--------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
      new CountdownPanel();
      
      int numWarningBeeps = COUNTDOWN_SECONDS;
      
      String minutes = String.valueOf(numWarningBeeps/60);
      String seconds = String.valueOf(numWarningBeeps%60);
      if (seconds.length() == 1) {
        seconds = "0" + seconds;
      }
      
      time = (minutes + ":" + seconds);
      
//      timeLabel = String.valueOf(time); // When ANY button is clicked! (If there were more...)
      textLabel.setText("Time left:");
      timeLabel.setText(String.valueOf(time));
      
      timer = new Timer();
      timer.schedule(new RemindTask(), 0, //initial delay
                   1 * 1000);
    }
  }
  
  
  class RemindTask extends TimerTask {
    int numWarningBeeps = COUNTDOWN_SECONDS;
    
    public void run() {
      if (numWarningBeeps > 0) {
//        toolkit.beep();
        
        gameOver = false;
        System.out.println("CountdownPanel says gameOver is: " + gameOver);
        // Formatting
        String minutes = String.valueOf(numWarningBeeps/60);
        String seconds = String.valueOf(numWarningBeeps%60);
        if (seconds.length() == 1) {
          seconds = "0" + seconds;
        }
        
        time = (minutes + ":" + seconds);
        timeLabel.setText(time);
        
        numWarningBeeps--;
        push.setEnabled(false);
      } else {
        toolkit.beep();
        textLabel.setText("Time's up!");
        timeLabel.setText("0:00");
        gameOver = true;
        System.out.println("CountdownPanel says gameOver is: " + gameOver);
//        System.out.println(time);
        timer.cancel(); //Stops the timer, but is not necessary if we call System.exit
//        System.exit(0); //Stops the AWT thread (and everything else)
        push.setEnabled(true);
      }
    }
  }
  
  public boolean gameOver(){
    return gameOver;
  }
  
  public static void main(String args[]) {
    System.out.println("Starting countdown.");
    new CountdownPanel();
  }
}