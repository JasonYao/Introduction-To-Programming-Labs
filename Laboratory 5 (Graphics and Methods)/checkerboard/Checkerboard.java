/*****************************************************************
 * Checkerboard.java - Defines a Java app that draws some boxes
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
 * class Checkerboard
 *
 * The class Checkerboard displays an NxN checkerboard on the screen. It extends
 * the CheckerboardBase class which handles all the mouse interactions.
 *
 * This class inherits the numSquares variable from CheckerboardBase.  That
 * variable specifies the number of squares along one side of the checkerboard.
 * So, for an NxN checkerboard, numSquares = N.  The CheckerboardBase class will
 * modify this variable in response to mouse-clicks.
 *
 *****************************************************************/
public class Checkerboard extends CheckerboardBase {

    /*****************************************************************
     * drawCheckerboard - paints the app's image on the graphics window
     *
     * calling sequence:
     *   drawCheckerboard(g); 
     *
     * parameters:
     *   g - the app's Graphics object
     *
     * side-effects:
     *   Paints the appropriate number of boxes
     *
     * anomalies:
     *   Presently, it does nothing
     *
     *****************************************************************/
    public void drawCheckerboard(Graphics g) {
        int rows;
        int columns;
        int count = numSquares;
        //g.setColor(Color.red);
        //g.fillRect(0,0,width,height);
        
        for (rows = 0; rows < numSquares; rows++)
        {
           for (columns = 0; columns < numSquares; columns++)
           {
                   if (columns%2 == 0)
               {
                   g.setColor(Color.black);
                   g.fillRect(0+(10*columns), 0+ (10*rows), 10, 10);
               }
               ++columns;
           }
           ++rows;
        }
        
        for (rows = 0; rows < numSquares; rows++)
        {
           for (columns = 0; columns < numSquares; columns++)
           {
                   if (columns%2 == 0)
               {
                   g.setColor(Color.red);
                   g.fillRect(0+(10*columns), 10+ (10*rows), 10, 10);
               }
               ++columns;
           }
           ++rows;
        }
        
        for (rows = 0; rows < numSquares; rows++)
        {
           for (columns = 0; columns < numSquares; columns++)
           {
                   if (columns%2 == 0)
               {
                   g.setColor(Color.red);
                   g.fillRect(10+(10*columns), 0+ (10*rows), 10, 10);
               }
               ++columns;
           }
           ++rows;
        }
        
        for (rows = 0; rows < numSquares; rows++)
        {
           for (columns = 0; columns < numSquares; columns++)
           {
                   if (columns%2 == 0)
               {
                   g.setColor(Color.black);
                   g.fillRect(10+(10*columns), 10+ (10*rows), 10, 10);
               }
               ++columns;
           }
           ++rows;
        }
        
        //               else if (count%2 == 0)
        //       {
        //           g.setColor(Color.red);
        //           g.fillRect(0+(10*columns), 0+ (10*rows), 10, 10);
        //       }
        
        
        
        
    }//drawCheckerboard
    
    //else
          // {
         //      g.setColor(Color.red);
         //      g.drawRect(30*height, 30*width, 15, 15);
          // }
          //  ++count;
    
    
        }//class Checkerboard
