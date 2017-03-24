import java.awt.*;
import javax.swing.*;

/**
 *  A Java Swing component that draws a circle with a face
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 7 February 2006
 */
class JFace extends JBorderCircle {
    private Color eye;

    public JFace(int r, Color c, Color b, Color e){
      super(r,c,b);
      eye = e;

    }

    /** Getter for eye color*/
    public Color getEyeColor(){
      return eye;
    }

    /** Setter for eye color */
    public void setEyeColor(Color e){
      eye = e;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // call parent's paintComponent method
        g.setColor(eye);
        int x = getX();
        int y = getY();
        int diameter = getRadius()*2;
        int anEye = (diameter/3);
        int xOffSet = ((anEye/2)*-1)+10;

        // left eye
        g.fillOval(anEye+xOffSet, anEye, getRadius()/3,getRadius()/3);
        g.fillOval(anEye-xOffSet, anEye, getRadius()/3,getRadius()/3);

    }










}
