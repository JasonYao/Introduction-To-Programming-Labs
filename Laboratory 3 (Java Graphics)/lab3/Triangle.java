/** This program draws a Triangle
 *   @author CS273 Student
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class Triangle
 *
 * The important thing that we need to do in this class is finish the
 * 'paint' method.  
 */
public class Triangle extends JPanel
{

    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);
        
        // Sets background color to Yellow
        setBackground(Color.yellow);
        
        // Declares integers for polygon values
        int [] x = {20, 450, 900};
        int [] y = {10, 700, 10};
        
        // Draws the Polygon
        g.setColor(Color.green);
        g.fillPolygon(x, y, 3);

        
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
        Triangle myContent = new Triangle();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main


    
}//class Triangle
