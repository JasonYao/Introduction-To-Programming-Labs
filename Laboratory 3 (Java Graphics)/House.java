/** This program draws a house
 *   @author CS273 Student
 */

// Import a couple of library-packages
import java.awt.*;
import javax.swing.*;

/** class House
 *
 * The important thing that we need to do in this class is finish the
 * 'paint' method.  
 */
public class House extends JPanel
{
    /** the "paint" method, that specifies what to draw on the screen
     *
     * This method contains errors!
     */
    public void paint(Graphics g)
    {
        //This line is important, don't remove it!
        super.paint(g);
        
        // Sets background color to purple
        setBackground(Color.cyan);
        
        // Declares integers for polygon house values in an array
        int [] xHouse = {500, 500, 1500, 1500};
        int [] yHouse = {400, 800, 800, 400};
        
        // Draws the house (rectangle) & colors it red
        g.setColor(Color.red);
        g.fillPolygon(xHouse, yHouse, 4);
        
        // Declares integers for polygon roof values in an array
        int [] xRoof = {200, 1000, 1800};
        int [] yRoof = {400, 100, 400};
        
        // Draws the roof (rectangle) & colors it yellow
        g.setColor(Color.yellow);
        g.fillPolygon(xRoof, yRoof, 3);
        
        // Declares integers for polygon door values in an array
        int [] xDoor = {900, 900, 1200, 1200};
        int [] yDoor = {500, 800, 800, 500};
        
        // Draws the door (rectangle) & colors it green
        g.setColor(Color.green);
        g.fillPolygon(xDoor, yDoor, 4);
        

        // Draws the window panes
        g.setColor(Color.yellow);
        g.fillRect(600, 500, 40, 40);
        
        g.fillRect(650, 500, 40, 40);
        
        g.fillRect(600, 550, 40, 40);
        
        g.fillRect(650, 550, 40, 40);
        
        // Declares integers for polygon chimney values in an array
        int [] xChimney = {1200, 1200, 1300, 1300};
        int [] yChimney = {174, 25, 25, 215};
        
        // Draws the door (rectangle) & colors it green
        g.setColor(Color.green);
        g.fillPolygon(xChimney, yChimney, 4);
        
        // Builds the pool as a polygon (since it has to add depth)
        g.setColor(Color.blue);
        int [] xPool = {1800, 1830, 2470, 2500};
        int [] yPool = {650, 300, 300, 650};
        g.fillPolygon(xPool, yPool, 4);
        
        // Draws diving board
        g.setColor(Color.black);
        int [] xBoard = {1800, 1850, 1850, 1800};
        int [] yBoard = {600, 600, 575, 575};
        g.fillPolygon(xBoard, yBoard, 4);
        
        // Draws swimmer 1
        g.drawOval(1900, 500, 50, 50);
        g.drawLine(1900, 500, 1950, 75);
        
        // Draws swimmer 2
        g.drawOval(2200, 400, 50, 50);
        g.drawLine(2200, 400, 22, 75);
        
        
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
        House myContent = new House();
        myFrame.setContentPane(myContent);
        myFrame.setVisible(true);
        
    }//main


    
}//class House
