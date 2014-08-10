////////////////////////////////////////////////////////////////
// StarRect.java - defines the StarRect class, which is a rectangle that
//   contains stars
//
// Author: Steven R. Vegdahl
// Date: November 1999
// Status: Debugged, but minimally commented
//
// Modified by: Steven R. Vegdahl
// Date: 25 October 2000
// Reason: Beef up the comments 
//
////////////////////////////////////////////////////////////////

// imports
import java.awt.*;

////////////////////////////////////////////////////////////////
// class StarRect - a blue rectangle that contains stars
//
// This class defines a blue rectangle that that contains stars.
//
// In addition to a constructor, it provides a paint method that
// allows it to be painted on a graphics window.
// 
// A StarRect object is immutable--there are no public methods that
// change its state once it is created.
//
////////////////////////////////////////////////////////////////
public class StarRect {

    ///////////////////////////
    // Instance variables
    ///////////////////////////

    // The rows of stars
    public//private
      StarRow[] row;

    // The basic rectangle (with a color)
    public//private
      ColorRect rect;

    ////////////////////////////////////////////////////////////////
    // StarRect constructor - creates a StarRect object
    // 
    // Calling sequence:
    //   aStarRect = new StarRect(x, y);
    // 
    // Parameters:
    //   x - the horizontal position of the top-left corner
    //   y - the vertical position of the top-left corner
    // 
    //  Side-effects:
    //    Initialzes the object.
    // 
    //  Bugs/anomalies:
    //    None known.
    // 
    ////////////////////////////////////////////////////////////////
    public StarRect(int x, int y) {
    
        // create the array of StarRow objects
        row = new StarRow[9];

        // create rows of stars and fill in the array
        for (int i = 0; i < row.length; i+=2) {
            row[i] = new StarRow(6, x+8, y+6+(i*12));
        }
        for (int i = 1; i < row.length; i+=2) {
            row[i] = new StarRow(6, x+23, y+6+(i*12));
        }

        // creat rectangle
        rect = new ColorRect(x,y,174,7*17,Color.blue.darker().darker());
    }


    ////////////////////////////////////////////////////////////////
    // paint - paints the object
    // 
    // Calling sequence:
    //   aStarRect.paint(g);
    // 
    // Parameters:
    //   g - the Graphics object on which to paint
    // 
    //  Side-effects:
    //    Modifies the Graphics object by drawing on it.
    // 
    //  Bugs/anomalies:
    //    None known.
    // 
    ////////////////////////////////////////////////////////////////
    public void paint(Graphics g) {

        // paint rectangle
        rect.paint(g);

        // paint rows of stars
        for (int i = 0; i < row.length; i++) {
            row[i].paint(g);
        }

    }

}
