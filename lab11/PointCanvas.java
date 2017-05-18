import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
*  Implements a graphical canvas that displays a list of points.
*
*  @author  Nicholas R. Howe
*  @version CSC 112, 18 April 2006
*/
class PointCanvas extends JComponent {
  /** The points */
  LinkedList<Point> points;

  /** Constructor */
  public PointCanvas() {
    points = new LinkedList<Point>();
  }

  /**
  *  Paints a red circle ten pixels in diameter at each point.
  *
  *  @param g The graphics object to draw with
  */
  public void paintComponent(Graphics g) {
    // FILL IN

    for (Point p: points){
      g.setColor(Color.RED);
      int x = (int) p.x;   // can also do p.x instead of p.getX()
      int y = (int) p.y;   // same with y
      g.drawOval(x-5, y-5, 10, 10);
    }
  }


  /**
  *  The component will look bad if it is sized smaller than this
  *
  *  @returns The minimum dimension
  */
  public Dimension getMinimumSize() {
    return new Dimension(500,300);
  }

  /**
  *  The component will look best at this size
  *
  *  @returns The preferred dimension
  */
  public Dimension getPreferredSize() {
    return new Dimension(500,300);
  }
}
