/*****************************************************************
 * Boxes.java - Defines a Java program that draws some boxes
 *
 * Name: ****PUT YOUR NAME HERE****
 * Date: ****PUT THE DATE OF COMPLETTION HERE****
 * Status: incomplete
 *
 *****************************************************************/

// import the appropriate packages
import java.awt.*;
import javax.swing.*;

/*****************************************************************
 * class Boxes
 *
 * The class Boxes displays concentric rectangles on the screen in alternating
 * colors. It extends the BoxesBase class which handles all the mouse
 * interactions.
 *
 * This class inherits the numBoxes variables from BoxesBase.  That variable
 * specifies the number of boxes to be drawn.  The BoxesBase class will modify
 * this variable in response to mouse-clicks.
 *
 *****************************************************************/
public class Boxes extends BoxesBase {

    /*****************************************************************
     * drawBoxes - paints the image on the graphics window
     *
     * calling sequence:
     *   drawBoxes(g); // called after certain mouse operations
     *
     * parameters:
     *   g - a Graphics object
     *
     * side-effects:
     *   Paints the appropriate number of boxes.
     *
     * anomalies:
     *   Presently, only one box is drawn.
     *
     *****************************************************************/
    public void drawBoxes(Graphics g) {
       int count = numBoxes;
       //while (numBoxes >= count)
       //{
       //    ++count;
       //    g.setColor(Color.red);
       //    g.fillRect(245-5*numBoxes,245-5*numBoxes,10+10*numBoxes,10+10*numBoxes);
       //}
       int height = 10;
       int width = 10;
       //height + 10*numboxes, width + 10*numBoxes
       
       //if ((count == 2) || (count == 4) || (count == 6) || (count == 8))
       //{
       //    g.setColor(Color.black);
       //}
       //if ((count == 1) || (count == 3) || (count == 5) || (count == 7))
       //{
        //   g.setColor(Color.black);
       //}
       while (count <= numBoxes)
       {
           if (count%2 == 0)
           {
               g.setColor(Color.black);
               
           }
           else
           {
               g.setColor(Color.red);
           }
           //g.fillRect(245+ 5*count,245 + 5*count, 500- 10*count, 500- 10*count);
           g.fillRect(245-5*count,245-5*count, width+ 10*count, height+ 10*count);
           --numBoxes;
       }
       
       
        //else
        //{
        //    ++count;
         //  g.setColor(Color.black);
          // g.fillRect(245-5*numBoxes,245-5*numBoxes, height + 10*numBoxes, width + 10*numBoxes);
        //}
        
       //while (count <= numBoxes)
       //{
          // ++count;
           //g.setColor(Color.black);
           //g.fillRect(245-5*numBoxes,245-5*numBoxes, height + 10*numBoxes, width + 10*numBoxes);
        //}
       
       
       
       // for now, draw a black 10x10 box, centered at (250,250)
       g.setColor(Color.black);
       g.fillRect(245,245,10,10);
    }//drawBoxes
    
}//class Boxes
