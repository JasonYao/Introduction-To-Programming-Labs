/** This program draws concentric Boxes
 *   @author CS273 Student
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class Boxes
 *
 * The important thing that we need to do in this class is finish the
 * 'paint' method.  
 */
public class Boxes extends JPanel
{
    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics canvas)
    {
        //This line is important, don't remove it!
        super.paint(canvas);
        
        // Makes Blue Reactangle
        canvas.setColor(Color.blue);
        canvas.fillRect(100, 50, 100, 50);
        
        //Makes Red Rectangle
        canvas.setColor(Color.red);
        canvas.fillRect(100, 50, 100, 50);
        
        // Makes Green Rectangle
        canvas.setColor(Color.green);
        canvas.fillRect();

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
        Boxes myContent = new Boxes();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main
}//class Boxes
