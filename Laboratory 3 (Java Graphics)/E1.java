/** This program draws boxes in a window
 *   @author Steven R. Vegdahl
 *   @date 15 September 1998
 *   Converted to an application by Andrew Nuxoll  (26 Jan 2012)
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class E1
 *
 * The important thing that we need to do in this class is to override the
 * 'paint' method.  
 */
public class E1 extends JPanel
{

    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);
        
        // set the background to red
        setBackground(Color.red);

        // Draw some squares of various colors
        g.setColor(Color.blue);
        g.drawRect(20,20,100,100); // blue square, outline
        g.fillRect(50,50, 200,200); // blue square, filled
        g.setColor(Color.orange);
        g.fillRect(300,10,40,40); // orange square, filled
        g.fillRect(400,200,6,6); // small orange square, filled
        g.setColor(Color.black);
        g.drawRect(5,5,500,500); // large black square, outline
        g.fillRect(40,500,30,30); // black square, filled
        g.setColor(Color.yellow);
        g.fillRect(270,270,60,60); // yellow square, filled
    }//paint



    /**
     * main
     *
     * All Java programs start with a method named main.  This class' main
     * method creates the window to display the boxes in.
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
        E1 myContent = new E1();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main


    
}//class E1
