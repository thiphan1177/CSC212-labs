import java.awt.*;
import javax.swing.*;

/**
 *  A simple Java Swing component that draws a fractal dragon.
 *
 *  @author Nicholas R. Howe, Thao Phan
 *  @version CSC 212, 23 March 2017
 */
class JDragon extends JComponent {
    /** The rank of the dragon */
    protected int rank;

    /** The size of the window */
    public static final int DIM = 1200;

    /**
     *  Creates a JDragon of specified size
     *
     *  @param rank Specifies the rank of the dragon
     */
    JDragon(int rank) {
      	this.rank = rank;
      	Dimension winsize = new Dimension(DIM,3*DIM/4);
      	setPreferredSize(winsize);
      	setMinimumSize(winsize);
    }

    /**
     *  Draws a dragon of the given rank between the given points.
     *
     *  @param rank  The rank of the dragon
     *  @param p1    One endpoint of the dragon
     *  @param p2    The other endpoint of the dragon
     *  @param g     The graphics object to draw into
     */

    // WRITE THIS
    public void drawDragon( int rank, Point p1, Point p2, Graphics g ){

      if (rank == 0){
        int x1 = (int)p1.getX();
        int y1 = (int)p1.getY();
        int x2 = (int)p2.getX();
        int y2 = (int)p2.getY();

        g.drawLine( x1, y1, x2, y2 );

      } else{

        System.out.println("You're in the else clause.");

        int x1 = (int)p1.getX();
        int y1 = (int)p1.getY();
        int x2 = (int)p2.getX();
        int y2 = (int)p2.getY();

        int dx = x2-x1;
        int dy = y2-y1;

        Point p3 = p1 + (dx/2-dy/2, dx/2+dy/2);


      }

    }


    /**
     *  Draws the dragon in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
      	Point p1 = new Point(DIM/4,DIM/4);
      	Point p2 = new Point(3*DIM/4,DIM/4);
      	drawDragon(rank,p1,p2,g);
    }

    /** Create a window with a dragon in it */
    public static void createAndShowGUI(int rank) {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Fractal Dragon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      	// Add components
      	JDragon dragon = new JDragon(rank);
      	frame.getContentPane().add(dragon);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /** Call the window creation routine on the event thread */
    public static void main(String[] args) {
      	int rank;
      	if (args.length > 0) {
      	    rank = Integer.valueOf(args[0]);
      	} else {
      	    rank = 5;
      	}
	      createAndShowGUI(rank);
    }
}  // end of JDragon
