import java.awt.*;
import javax.swing.*;

/**
 *  Class that demonstrates a very simple window application
 *
 *  @author Nicholas R. Howe, Thao Phan
 *  @version CSC 212, 24 March 2017
 */
public class ManyWindows {
    /** This keeps track of how many windows have been opened */
    private static int count = 0;

    /**
     *  This creates a set of windows with objects displayed inside
     */
    public static void makeWindows() {
      	// This creates a JCircle object and sticks it in a window
      	putInWindow(new JCircle(40));

      	// We can also keep a reference to the circle for later use
      	JCircle circle2 = new JCircle(50);
      	putInWindow(circle2);

      	// This example needs two arguments for the constructor
      	putInWindow(new JColorCircle(40,Color.RED));

      	// Add further window experiments below as you work on the lab:
      	// FILL IN HERE
        // add another JCircle Here
        JCircle circle3 = new JCircle(200);
        putInWindow(circle3);

        // add 2 more JColorCircle windows
        // one with predefined color
        JColorCircle circle4 = new JColorCircle(50,Color.CYAN);
        putInWindow(circle4);
        // one with color you created
        JColorCircle circle5 = new JColorCircle(100,new Color(80, 192, 247));
        putInWindow(circle5);

        // use setRadius method to change size of circle2
        /** Does it matter if you do this before or after
            adding it to the window? Why?
        Answer: If you setRadius after adding it to the window, the window will still be the size of circle2's original size. It won't resize to fit it's new radius. Thus, if you set the radius to something really big and the original window was small, when new circle2 is drawn on the screen, you won't be able to see all of it cus the window its in isn't big enough.
        Also, something to note is that the original circle2 disappears in its old window. Oddly, the old window is still there, but circle2 is redrawn in a different window*/
        circle2.setRadius(300);
        putInWindow(circle2);

        /**Use the setColor method to change the color of one of the colored circles.
        Does it matter if you do this before or after adding it to the window? Why?
        Answer: Like with setRadius, circle4 disappears in its original window
        and appears, newly colored, in its new window.
        */
        circle4.setColor(Color.MAGENTA);
        putInWindow(circle4);

        // add at least one JBorderCircle window.
        JBorderCircle circle6 = new JBorderCircle(100, Color.YELLOW, Color.CYAN);
        putInWindow(circle6);
        JBorderCircle circle7 = new JBorderCircle(300, Color.MAGENTA, Color.BLUE);
        putInWindow(circle7);
        JFace circle8 = new JFace(100, Color.GREEN, Color.BLUE, Color.WHITE);
        putInWindow(circle8);




    }

    /**
     *  This method creates a window and puts the supplied JComponent into it
     */
    public static void putInWindow(JComponent jc) {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Window #"+(++count));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

      	// Add component
      	frame.getContentPane().add(jc);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     *  This is the entry point for the application version
     */
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        		public void run() {
        		    makeWindows();
        		}
	    });
    }
}
