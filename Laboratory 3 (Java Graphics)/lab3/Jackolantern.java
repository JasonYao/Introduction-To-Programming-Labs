/** This program draws a jack-o-lantern
 *   @author CS273 Student
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class Jackolantern
 *
 * The important thing that we need to do in this class is finish the
 * 'paint' method.  
 */
public class Jackolantern extends JPanel
{

    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);

        // Sets background colour to black
        setBackground(Color.black);
        
        // Makes the Jack O Lantern basic shape (3 ovals)
        g.setColor(Color.orange);
        g.fillOval(300, 300, 125, 400);
        g.fillOval(375, 300, 125, 400);
        g.fillOval(450, 300, 125, 400);
        
        // Declares integers for polygon left eye values in an array
        int [] xLeftEye = {350, 375, 400};
        int [] yLeftEye = {450, 400, 450};
        
        // Draws the left eye (triangle) & colors it yellow
        g.setColor(Color.yellow);
        g.fillPolygon(xLeftEye, yLeftEye, 3);
        
        // Declares integers for polygon right eye values in an array
        int [] xRightEye = {500, 525, 550};
        int [] yRightEye = {450, 400, 450};
        
        // Draws the right eye (triangle)
        g.fillPolygon(xRightEye, yRightEye, 3);
        
        // Draws a smile (oval)
        g.fillOval(350, 550, 150, 20);
        
        // Draws the stem
        g.setColor(Color.green);
        int [] xStem = {445,410, 410, 470, 470};
        int [] yStem = {300,325, 200, 200, 325};
        
        g.fillPolygon(xStem, yStem, 5);
        
        
    }//paint

    /**
     * main
     *
     * All Java programs start with a method named main.  This class' main
     * method creates the window to display your Java drawing.
     *
     * IMPORTANT:  DO NOT MODIFY THIS METHOD
     */
    public static void main(String[] args)
    {
        //Create a window for this program
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600,600);
 
       
        //Put an instance of this class in the window frame
        Jackolantern myContent = new Jackolantern();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main


    
}//class Jackolantern
