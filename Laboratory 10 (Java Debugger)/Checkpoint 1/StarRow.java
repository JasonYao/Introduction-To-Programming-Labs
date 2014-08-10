////////////////////////////////////////////////////////////////
// StarRow.java - defines the StarRow class, which is a horizontal row
//   of stars
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
// class StarRow - a horizontal row of up to 6 stars
//
// This class a defines a horizontal row of up to 6 stars
//
// In addition to a constructor, it provides a paint method that
// allows it to be painted on a graphics window.
// 
// A StarRow object is immutable--there are no public methods that
// change its state once it is created.
//
////////////////////////////////////////////////////////////////
public class StarRow {

    ////////////////////////
    // instance variables
    ////////////////////////

    // the stars in our tow
    public//private
      Star[] star;

    ////////////////////////////////////////////////////////////////
    // StarRow constructor - creates a StarRow object
    // 
    // Calling sequence:
    //   aStarRow = new StarRow(numStars, x, y);
    // 
    // Parameters:
    //   numStars - the number of stars in the row
    //   x - the horizontal position of the top-left corner of the leftmost
    //       star
    //   y - the vertical position of the top-left corner of the leftmost star
    // 
    //  Side-effects:
    //    Initialzes the object.
    // 
    //  Bugs/anomalies:
    //    If 'numRows' is greater than 6, a row is 6 stars will be
    //    created.  If 'numRows' is less than 1, a (degenerate) row containing
    //    no stars will be created.
    // 
    ////////////////////////////////////////////////////////////////
    public StarRow(int numStars, int x, int y) {
    
        // create the array of stars
        star = new Star[(Math.max(0,(numStars/2)) )];
        
        // fill in the array with stars acros a row
        for (int i = 0; i < star.length; ++i) {
            star[i] = new Star(x+(i*60), y);
        }

    }

    ////////////////////////////////////////////////////////////////
    // paint - paints the object
    // 
    // Calling sequence:
    //   aStarRow.paint(g);
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
    //  Implementation note:
    //    Some of the stars may not exist (i.e., might be null), so we
    //    need to check each before we draw it.
    // 
    ////////////////////////////////////////////////////////////////
    public void paint(Graphics g) {

        // paint any star that is not null
        for (int i = 0; i < star.length; i++) {
            star[i].paint(g);
        }

    }

}
