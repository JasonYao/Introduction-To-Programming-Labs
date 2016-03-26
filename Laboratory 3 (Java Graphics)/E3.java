/** This program draws some text in a window
 *   @author Steven R. Vegdahl
 *   @date 15 September 1998
 *   Converted to an application by Andrew Nuxoll  (26 Jan 2012)
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class E3
 *
 * The important thing that we need to do in this class is to override the
 * 'paint' method.  
 */
public class E3 extends JPanel
{

    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);

        // set the background to a blue
        setBackground(Color.blue);

        // Set the font
        G.setFont(new Font("SansSerif", 0, 18);

        // Draw some red text
        g.setColor(Color.red);
        g.drawString("This is a window.", 100, 100);

        // Draw some green text
        g.setColor(Color.green);
        g.drawString("Isn't it nice that we can draw some text, 200, 200);

        // Draw some yellow text
        g.setColor(Color.yellow);
        g.drawString("This is CS 273", 100, 500);
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
        E3 myContent = new E3();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main
    
}//class E3
