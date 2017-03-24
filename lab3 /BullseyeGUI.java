import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Class that demonstrates a GUI manager that can run as either
 *  an applet or a stand-alone application.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, Septemrber 2009
 */
public class BullseyeGUI extends JApplet {
    /** The bullseye that will be displayed */
    private JBullseye bull;

    /** Used for animation of the bullseye colors */
    private Timer timer;

    /** Time between updates is half a second */
    private static final int TIMER_INTERVAL = 500;

    /**  state variable that records the current state or recent history of the GUI. If the user has not clicked on a ring, its value will be -1. */
    private int ring;

    /** Set up fields to default values */
    public BullseyeGUI() {
	     Color c[] =
	     {Color.white, Color.black, Color.blue, Color.red, Color.yellow};
       bull = new JBullseye(50,c);

       timer = new Timer(TIMER_INTERVAL, new CycleListener());

    }

    /**
     *  This method is called by the application version.
     */
    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Sample GUI Application");
        try { frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} catch (Exception e) {}

	// Add components
	createComponents(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     *  Both types of app call this to set up the GUI contents.
     *
     *  @param pane  The pane of the JFrame of JApplet
     */
    public void createComponents(Container pane) {
	     pane.setLayout(new FlowLayout());
	     pane.add(bull);

	     JButton cycleButton = new JButton("Cycle");
	     pane.add(cycleButton);
       cycleButton.addActionListener(new CycleListener());

	     JButton invertButton = new JButton("Invert");
	     pane.add(invertButton);
       invertButton.addActionListener(new InvertListener());

       JButton startButton = new JButton("Start");
       pane.add(startButton);
       startButton.addActionListener(new StartListener());

       JButton stopButton = new JButton("Stop");
       pane.add(stopButton);
       stopButton.addActionListener(new StopListener());

       bull.addMouseListener(new SampleMouseListener());
       bull.addMouseMotionListener(new SampleMouseListener());

       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(2,2));
       panel.add(cycleButton);
       pane.add(cycleButton, BorderLayout.NORTH);
       panel.add(invertButton);
       pane.add(invertButton, BorderLayout.SOUTH);
       panel.add(startButton);
       pane.add(startButton, BorderLayout.WEST);
       panel.add(stopButton);
       pane.add(stopButton, BorderLayout.EAST);
       pane.add(panel);



    }

    /**
     *  This is the entry point for the applet version
     */
    public void init() {
	     //Execute a job on the event-dispatching thread:
	     //creating this applet's GUI.
	     try {
	        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
		            public void run() {
                // line below would create separate window
			          //gui.createAndShowGUI();

                // this line creates applet in browser window
                createComponents(getContentPane());
		        }
		      });
	} catch (Exception e) {
	    System.err.println("createGUI didn't successfully complete");
	}
}

    /**
     *  This is the entry point for the application version
     */
    public static void main(String[] args) {
        final BullseyeGUI GUI = new BullseyeGUI();
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		        public void run() {
		            GUI.createAndShowGUI();
		}
	    });
    }

    /** Event handler for Cycle button */
    class CycleListener implements ActionListener{

      /** Cycles the colors when button is pushed.
      * @param e  Holds info about the button push event.*/

      public void actionPerformed(ActionEvent e){
        bull.cycle(); // note the reference to the enclosing class's
                      //      private field.
      }
    }

    /** Event handler for Invert button */
    class InvertListener implements ActionListener{

      /** Inverts the colors when button is pushed.
      * @param e  Holds info about the button push event. */

      public void actionPerformed(ActionEvent e){
        bull.invert();
      }
    }

    /** Event handler for Start button */
    class StartListener implements ActionListener{
      /** starts timer when button is pushed*/
      public void actionPerformed(ActionEvent e){
        timer.start();
      }
    }

    /** Event handler for Stop button */
    class StopListener implements ActionListener{
      /** starts timer when button is pushed*/
      public void actionPerformed(ActionEvent e){
        timer.stop();
      }
    }

    /** Mouse event handlers */
    private class SampleMouseListener extends MouseAdapter{

      /** Click event handler prints a message with the event location */
      public void mouseClicked(MouseEvent e){
        System.out.println("Click event at ("+e.getX()+","+e.getY()+")");
        if (ring == -1) {
          ring = bull.ringID(e.getX(),e.getY());
        } else {
          bull.swapColors(ring,bull.ringID(e.getX(),e.getY()));
          ring = -1;

      }
    }

      /** Press event handler prints a message with the event location */
  	  public void mousePressed(MouseEvent e) {
  	     System.out.println("Press event at ("+e.getX()+","+e.getY()+")");
  	  }

      /** Release event handler prints a message with the event location */
      public void mouseReleased(MouseEvent e) {
        System.out.println("Release event at ("+e.getX()+","+e.getY()+")");
      }

      /** Enter event handler prints a message with the event location */
      public void mouseEntered(MouseEvent e) {
        System.out.println("Enter event at ("+e.getX()+","+e.getY()+")");
      }

      /** Exit event handler prints a message with the event location */
      public void mouseExited(MouseEvent e) {
        System.out.println("Exit event at ("+e.getX()+","+e.getY()+")");
      }

      /** Drag event handler prints a message with the event location */
      public void mouseDragged(MouseEvent e) {
        System.out.println("Drag event at ("+e.getX()+","+e.getY()+")");
      }

      /** Move event handler prints a message with the event location */
      public void mouseMoved(MouseEvent e) {
        System.out.println("Move event at ("+e.getX()+","+e.getY()+")");
      }

     }
}
