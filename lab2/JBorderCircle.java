import java.awt.*;
import javax.swing.*;
/**
This will be a colored circle with a border of a different color around the outside. You will have to give it a new field (call it border) to store the color of the border, and then create an appropriate constructor, accessor, and manipulator. Then you should override the paintComponent method to add the border. (Does the order matter here?)
*/
class JBorderCircle extends JColorCircle {
    /** the color of the circle's border */
    private Color border;

    /**
     *  Creates a JBorderCircle of specified size and colors
     *
     *  @param r Specifies the circle's radius
     *  @param c Specifies the circle's color
     *  @param b Specifies the color of the circle's border
     */
    public JBorderCircle(int r, Color c, Color b) {
      	super(r,c);  // call JColorCircle constructor
        border = b;
    }

    /** Accessor for border color */
    public Color getBorderColor(){
      return border;
    }

    /** Manipulator for border color*/
    public void setBorderColor(Color b){
      border = b;
    }

    /**
     *  Draws circle and border in graphics window
     *
     *  @param g The graphics object to draw into
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // call parent's paintComponent method
        g.setColor(border);
        g.drawOval(0,0,getRadius()*2,getRadius()*2);

    }
}
