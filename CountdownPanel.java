/* CountdownPanel.java
 * 
 * Written by: Jesslyn Tannady
 * CS 230 Final Project: Pusheen Donut Dash
 * Partners: Jamie Yip and Brenda Ji
 * Last Modified: December 16, 2015
 * 
 * Purpose: Displays the time left to the user in the GUI 
 */ 

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CountdownPanel extends JPanel {
  
  // Instance Variables 
  private Toolkit toolkit; // for the sound
  private Timer timer; 
  private int COUNTDOWN_SECONDS = 90;
  private String time; // formatted time
  private JLabel textLabel, timeLabel;
  // May use button in the future, but not included for our purposes
  private JButton push; 
  private Pusheen user;
  
  /* Constructor: Creates the CountdownPanel where a task is scheduled and 
   * executed once every second. Time will be displayed to the user by this panel.
   * 
   * @param None
   */
  public CountdownPanel(Pusheen PusheenUser) {
    user = PusheenUser;
    
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    
    textLabel = new JLabel ("Time left:");
    timeLabel = new JLabel (time);
    
    // May use in the furture but not included for our current purposes
    push = new JButton ("Reset timer");
    push.addActionListener (new ButtonListener());
    
    timer.schedule(new RemindTask(), 0, //initial delay
                   1 * 1000); //subsequent rate
    

    // Setting the text label 
    textLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
    timeLabel.setFont(new Font("Comic Sans", Font.PLAIN, 25));

    
    // Border layout --> setting the format of the panels 
    setLayout(new BorderLayout());
    add(textLabel, BorderLayout.NORTH);
    add(timeLabel, BorderLayout.CENTER);
    
    // Coloring 
    setBackground(new Color(250, 241, 227));
    textLabel.setForeground(new Color(61, 34, 8));
    timeLabel.setForeground(new Color(61, 34, 8));
  }
  
  //*************************************************************************
  //  Represents a listener for button push (action) events.
  //  FOLLOWING NOT INCLUDED FOR OUR GAME PURPOSES --> MAY USE IN THE FUTURE
  //*************************************************************************
  private class ButtonListener implements ActionListener {
    //--------------------------------------------------------------
    //  Updates the counter and label when the button is pushed.
    //--------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
      new CountdownPanel(user);
      
      int numWarningBeeps = COUNTDOWN_SECONDS;
      
      String minutes = String.valueOf(numWarningBeeps/60);
      String seconds = String.valueOf(numWarningBeeps%60);
      if (seconds.length() == 1) {
        seconds = "0" + seconds;
      }
      
      time = (minutes + ":" + seconds);
      
      textLabel.setText("Time left:");
      timeLabel.setText(String.valueOf(time));
      
      timer = new Timer();
      timer.schedule(new RemindTask(), 0, //initial delay
                     1 * 1000);
    }
  }
  
 
  class RemindTask extends TimerTask {
    int numWarningBeeps = COUNTDOWN_SECONDS;
    
    /**
     * run()
     * Every second, the following code gets executed and updates the timer 
     *
     * @param None
     * @return Nothing   
     */
    public void run() {
      if (user.getIsHome() == false) { // Stopping the timer if the user is home
        if (numWarningBeeps > 0) {
          user.setGameOver(false); // Tell the user that the game is over 
          
          // Formatting
          String minutes = String.valueOf(numWarningBeeps/60);
          String seconds = String.valueOf(numWarningBeeps%60);
          if (seconds.length() == 1) {
            seconds = "0" + seconds; // formatting time display 
          }
          
          time = (minutes + ":" + seconds);
          timeLabel.setText(time);
          
          numWarningBeeps--;
          push.setEnabled(false);
        } else {
          toolkit.beep();
          textLabel.setText("Time's up!");
          timeLabel.setText("0:00");
          user.setGameOver(true);
          push.setEnabled(true); // button --> not used for our purposes
          timer.cancel(); // cancel timer when Pusheen is home 
        }
      } else {
        user.setGameOver(true); 
        push.setEnabled(true);
        timer.cancel();
      }
    }
  }
}