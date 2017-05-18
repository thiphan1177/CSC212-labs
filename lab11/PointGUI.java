import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*  Implements a GUI for inputting points.
*
*  @author  Nicholas R. Howe
*  @version CSC 112, 18 April 2006
*/
public class PointGUI {
  /** The graph to be displayed */
  private PointCanvas canvas;

  /** Label for the input mode instructions */
  private JLabel instr;

  /** The input mode */
  InputMode mode = InputMode.ADD_POINTS;

  /** Remembers point where last mousedown event occurred */
  Point pointUnderMouse;

  /**
  *  Schedules a job for the event-dispatching thread
  *  creating and showing this application's GUI.
  */
  public static void main(String[] args) {
    final PointGUI GUI = new PointGUI();
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        GUI.createAndShowGUI();
      }
    });
  }

  /** Sets up the GUI window */
  public void createAndShowGUI() {
    // Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);

    // Create and set up the window.
    JFrame frame = new JFrame("Graph GUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add components
    createComponents(frame);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  /** Puts content in the GUI window */
  public void createComponents(JFrame frame) {
    // graph display
    Container pane = frame.getContentPane();
    pane.setLayout(new FlowLayout());
    JPanel panel1 = new JPanel();
    panel1.setLayout(new BorderLayout());
    canvas = new PointCanvas();
    PointMouseListener pml = new PointMouseListener();
    canvas.addMouseListener(pml);
    canvas.addMouseMotionListener(pml);
    panel1.add(canvas);
    instr = new JLabel("Click to add new points; drag to move.");
    panel1.add(instr,BorderLayout.NORTH);
    pane.add(panel1);

    // controls
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(2,1));
    JButton addPointButton = new JButton("Add/Move Points");
    panel2.add(addPointButton);
    addPointButton.addActionListener(new AddPointListener());
    JButton rmvPointButton = new JButton("Remove Points");
    panel2.add(rmvPointButton);
    rmvPointButton.addActionListener(new RmvPointListener());
    pane.add(panel2);
  }


    /** method to add point to a canvas */
    public void addPoint(Point e){
      canvas.points.add(e);

    }


  /**
  * Returns a point found within the drawing radius of the given location,
  * or null if none
  *
  *  @param x  the x coordinate of the location
  *  @param y  the y coordinate of the location
  *  @return  a point from the canvas if there is one covering this location,
  *  or a null reference if not
  */
  public Point findNearbyPoint(int x, int y) {
    // FILL IN:
    // Loop over all points in the canvas and see if any of them
    // overlap with the location specified.  You may wish to use
    // the .distance() method of class Point.

    Point aPoint = null;
    for (Point p : canvas.points){
      int x1 = (int) p.x;
      int y1 = (int) p.y;

      if( p.distance(x, y) <= 5  ){
        //System.out.println("Hello");
        aPoint = p;
      }
    }
    return aPoint;

  }

  /** Constants for recording the input mode */
  enum InputMode {
    ADD_POINTS, RMV_POINTS
  }

  /** Listener for AddPoint button */
  private class AddPointListener implements ActionListener {
    /** Event handler for AddPoint button */
    public void actionPerformed(ActionEvent e) {
      mode = InputMode.ADD_POINTS;
      instr.setText("Click to add new points or change their location.");
    }
  }

  /** Listener for RmvPoint button */
  private class RmvPointListener implements ActionListener {
    /** Event handler for RmvPoint button */
    public void actionPerformed(ActionEvent e) {
      // FILL IN:
      // Model on the AddPointListener above.  Should change both mode and label text.
      mode = InputMode.RMV_POINTS;
      instr.setText("Click to remove new points");

    }
  }

  /** Mouse listener for PointCanvas element */
  private class PointMouseListener extends MouseAdapter
  implements MouseMotionListener {

    /** Responds to click event depending on mode */
    public void mouseClicked(MouseEvent e) {
      switch (mode) {
        case ADD_POINTS:
        // FILL IN
        // If the click is not on top of an existing point, create a new one and add it to the canvas.
        if (findNearbyPoint(e.getX(), e.getY()) == null){
          Point newPoint = new Point(e.getX(), e.getY());
          canvas.points.add(newPoint);

        } else {
          Toolkit.getDefaultToolkit().beep();
        }
        // Otherwise, emit a beep, as shown below:
        //Toolkit.getDefaultToolkit().beep();
        break;
        case RMV_POINTS:
        // FILL IN
        // If the click is on top of an existing point, remove it from the canvas's list of points.
        if ( findNearbyPoint( e.getX(), e.getY() ) != null){

          canvas.points.remove( findNearbyPoint( e.getX(), e.getY() ) );

        } else {
          // Otherwise, emit a beep.
          Toolkit.getDefaultToolkit().beep();
        }
        break;
      }
      canvas.repaint();
    }

    /** Records point under mousedown event in anticipation of possible drag */
    public void mousePressed(MouseEvent e) {
      // FILL IN:  Record point under mouse, if any
      pointUnderMouse = findNearbyPoint( e.getX(), e.getY() );
    }

    /** Responds to mouseup event */
    public void mouseReleased(MouseEvent e) {
      // FILL IN:  Clear record of point under mouse, if any

      pointUnderMouse = null;
    }

    /** Responds to mouse drag event */
    public void mouseDragged(MouseEvent e) {
      // FILL IN:
      // If mode allows point motion, and there is a point under the mouse,
      // then change its coordinates to the current mouse coordinates & update display

      if ( (mode == InputMode.ADD_POINTS) && (pointUnderMouse  != null) ) {
        //pointUnderMouse = mousePressed(e);
        pointUnderMouse.setLocation( e.getX(), e.getY() );
        canvas.repaint();
      }



    }

    // Empty but necessary to comply with MouseMotionListener interface.
    public void mouseMoved(MouseEvent e) {}
    }
  }
