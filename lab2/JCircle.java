import java.awt.*;
import javax.swing.*;

/**
 *  A simple Java Swing component that draws a circle.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 7 February 2006
 */
class JCircle extends JComponent {
    /** The diameter of the circle */
    private int diameter;

    /**
     *  Creates a JCircle of specified size
     *
     *  @param r Specifies the radius of the circle
     */
    public JCircle(int r) {
      	super();
      	diameter = 2*r;
      	setMinimumSize(new Dimension(diameter,diameter));
      	setPreferredSize(new Dimension(diameter,diameter));
    }

    /** Accessor for radius */
    public int getRadius() {
	      return diameter/2;
    }

    /** Manipulator for radius */
    public void setRadius(int r) {
	      diameter = 2*r;
    }

    /**
     *  Draws the circle in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
	      g.fillOval(0,0,diameter,diameter);
    }
}  // end of JCircle
