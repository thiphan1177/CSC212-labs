import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *  Class that runs a keyboard handler GUI
 *
 *  @author Nicholas R. Howe, Thao phan
 *  @version CSC 212, 9 March 2017
 */
public class QueueGUI {
    /** Processes keys pressed */
    static private JKeyProcess handler;

    /** Keeps track of keys already processed */
    static private JLabel label;

    /** Non-static variable for GUI */
    public static QueueGUI GUI;

    /** Queue field: Used to store extra keystrokes, and feeds them to the processor when it is ready */
    private Queue<Character> queue;

    /** JQueue field: Displays contents of your queue */
    private JQueue jqueue;


    /** Constructor is empty. */
     public QueueGUI() {}

    /** Sets up GUI frame */
    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Example with No Queue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // Add components
	      createComponents(frame);


        // Display the window.
        frame.pack();
        frame.setVisible(true);

        // Route keystrokes to handler
	      handler.requestFocusInWindow();  // ensure that keystrokes are received
    }

    /** Allocates GUI components */
    public void createComponents(JFrame frame) {
	      Container pane = frame.getContentPane();
	      pane.setLayout(new BorderLayout());
        label = new JLabel("> ");
        pane.add(label,BorderLayout.SOUTH);
        handler = new JKeyProcess(label);
	      pane.add(handler,BorderLayout.CENTER);
	      handler.addKeyListener(new CharKeyListener());

        handler.addActionListener(new CheckListener());
        queue = new LinkedList<Character>();
        jqueue = new JQueue(queue);
        pane.add( jqueue, BorderLayout.EAST );
    }

    /** Runs the program on the event thread */
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
	      GUI = new QueueGUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		            GUI.createAndShowGUI();
		    }
	   });
    }

    /** Listener class to capture keyboard keys */
    private class CharKeyListener implements KeyListener {
      	/** Keyboard event handler */
      	public void keyPressed(KeyEvent e) {
          //System.out.println("keypress");
        }

      	/** Keyboard event handler */
      	public void keyReleased(KeyEvent e) {
          //System.out.println("keyrelease");
        }

      	/** Keyboard event handler */
      	public void keyTyped(KeyEvent e) {
          //System.out.println("Hello");
          if ( handler.isBusy() ){
              Character next = e.getKeyChar();
              queue.add(next);
              jqueue.repaint();
          }
          else{
              Character c = e.getKeyChar();
              queue.add(c);
              handler.process(c);
          }
	      }
    }

    /** Listener class to get keystrokes off queue and into the key processor when it is ready.   */
    private class CheckListener implements ActionListener{

      public void actionPerformed(ActionEvent e){
           if ( !handler.isBusy() ){
             Character keyAction = queue.remove();
             handler.process( keyAction );
             jqueue.repaint();
           }


     }
  }
}
