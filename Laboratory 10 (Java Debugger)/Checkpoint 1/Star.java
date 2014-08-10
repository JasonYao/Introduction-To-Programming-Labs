/***********************************************************************
 * CS 273 students - this class may contain some concepts (e.g.,
 * superclass constructors) that we have not studied yet.  Don't worry if
 * you don't understand all the code herein, especially that inside the
 * constructor.
 ***********************************************************************/

////////////////////////////////////////////////////////////////
// Star.java - defines the Star class, which is a polygon in the
//   shape of a star.
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
// class Star - a Polygon in the shape of a star
//
// This class defines a star-shaped object, in addition to a standard
// points (as with a normal Polygon), a Star also has a color.  (The
// present implementation, however only provides a constructor that
// allows a white star to be created.)
//
// In addition to a constructor, it provides a paint method that
// allows it to be painted on a graphics window.
// 
// A Star object is mutable because it inherits some destructive
// methods from Polygon.
//
////////////////////////////////////////////////////////////////
public class Star extends Polygon {

    //////////////////
    // instance variables
    //////////////////

    // the star's color
    public//private
      Color color;

    //////////////////
    // class variables
    //////////////////

    // the respective x- and y- coordinates for the point in the star
    public//private
      static final int[] starXs = {4, 5, 8, 6, 7, 4, 1, 2, 0, 3};
    public//private
      static final int[] starYs = {0, 4, 4, 6, 10, 7, 10, 6, 4, 4};

    ////////////////////////////////////////////////////////////////
    // Star constructor - creates a star
    // 
    // Calling sequence:
    //   aStar = new Star(x, y)
    // 
    // Parameters:
    //   x - the horizontal position of the top-left corner of a bounding-
    //       box for the star
    //   y - the vertical position of the top-left corner of a bounding-
    //       box for the star
    // 
    //  Side-effects:
    //    Initialzes the object.
    // 
    //  Bugs/anomalies:
    //    This constructor creates a white star.  In order to allow
    //    colored stars to be created, it would be necessary to provide
    //    an additional constructor.
    // 
    ////////////////////////////////////////////////////////////////
    public Star(int x, int y) {

        // Invoke the superclass's (Polygon) constructor
        super();

        // add points to our object
        int idx = 0;
        int limit = Math.min(starXs.length, starYs.length);
        while (idx < limit) {
            this.addPoint(x+starXs[idx], y+starYs[idx]);
            idx++;
        }

        // set the hcolor
        color = Color.white;
    }


    ////////////////////////////////////////////////////////////////
    // paint - paints the object
    // 
    // Calling sequence:
    //   aStar.paint(g);
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

        // set Graphics color to our color
        g.setColor(color);

        // paint the object
        g.fillPolygon(this);

    }
    
    public void setColor(Color c) {
        color = c;
    }

}
