import java.awt.*;
import javax.swing.*;

/**
 *  A simple Java Swing component that draws a colored circle.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 212, September 2015
 */
class JColorCircle extends JCircle {
    /** The color of the circle */
    private Color color;

    /**
     *  Creates a JColorCircle of specified size and color
     *
     *  @param r Specifies the radius of the circle
     *  @param c Specifies the color of the circle
     */
    public JColorCircle(int r, Color c) {
      	super(r);  // call JCircle constructor
      	color = c;
    }

    /** Accessor for color */
    public Color getColor() {
	     return color;
    }

    /** Manipulator for color */
    public void setColor(Color c) {
	     color = c;
    }

    /**
     *  Draws the circle in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
      	g.setColor(color);
      	super.paintComponent(g);  // call parent's paintComponent method
    }
}  // end of JColorCircle
