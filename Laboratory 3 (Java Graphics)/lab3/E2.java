/** This program draws a path in a window
 *   @author Steven R. Vegdahl
 *   @date 15 September 1998
 *   Converted to an application by Andrew Nuxoll  (26 Jan 2012)
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class E2
 *
 * The important thing that we need to do in this class is to override the
 * 'paint' method.  
 */
public class E2 extends JPanel
{

    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);

        // set the background to yellow
        setBackground(Color.yellow);

        // set the color for our lines
        
        g.setColor(Color.black);

        // Draw some connected lines that form a path
        g.drawLine(30,40,200,300);
        g.drawLine(200,300,400,210);
        g.drawLine(400,210,520,180);
        g.drawLine(520,180,500,90);
        g.drawLine(500,90,560,6);
        g.drawLine(560,6,554,330);
        g.drawLine(554,330,300,445);
        g.drawLine(300,445,25,200);
    }//paint


    /**
     * main
     *
     * All Java programs start with a method named main.  This class' main
     * method creates the window to display the path in.
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
        E2 myContent = new E2();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main
    
}//class E2
