////////////////////////////////////////////////////////////////
// ColorRect.java - defines the ColorRect class, which is a rectangle
//   that has a color
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
// class ColorRect - a rectangle with a color
//
// This class defines a rectangle that has a color.
//
// In addition to a constructor, it provides a paint method that
// allows it to be painted on a graphics window.
// 
// A ColorRect object is immutable--there are no public methods that
// change its state once it is created.
//
////////////////////////////////////////////////////////////////
public class ColorRect {

    /////////////////////////
    // instance variables
    ////////////////////////

    // a polygon that defines our rectangle
    public//private
      Polygon p;

    // the color
    public//private
      Color color;

    ////////////////////////////////////////////////////////////////
    // ColorRect constructor - creates a ColorRect object
    // 
    // Calling sequence:
    //   aColorRect = new ColorRect(x, y, w, h, c);
    // 
    // Parameters:
    //   x - the horizontal position of the top-left corner
    //   y - the vertical position of the top-left corner
    //   w - the rectangle's width, in pixels
    //   h - the rectangle's height, in pixels
    //   color - the rectangle's color
    // 
    //  Side-effects:
    //    Initialzes the object.
    // 
    //  Bugs/anomalies:
    //    No checking is done that the height and width are positive, or
    //    that the color is non-null.  It is therefore possible for the
    //    caller to create a ColorRect that is ill-formed.
    // 
    ////////////////////////////////////////////////////////////////
    public ColorRect(int x, int y, int w, int h, Color c) {

        // create polygon and with appropriate points
        p = new Polygon();
        p.addPoint(x,y);
        p.addPoint(x,y+h);
        p.addPoint(x+w,y+h);
        p.addPoint(x+w,y);

        // set color
        color = c;
    }

    ////////////////////////////////////////////////////////////////
    // paint - paints the object
    // 
    // Calling sequence:
    //   aColorRect.paint(g);
    // 
    // Parameters:
    //   g - the Graphics object on which to paint
    // 
    //  Side-effects:
    //    Modifies the Graphics object by drawing on it.
    // 
    //  Bugs/anomalies:
    //    No checking is done that ColorRect object is well-formed.  This
    //    method could therefore "bomb" under that condition.
    // 
    ////////////////////////////////////////////////////////////////
    public void paint(Graphics g) {

        // set graphics color
        g.setColor(color);

        // paint the filled polygon
        g.fillPolygon(p);

    }
    
    public void setColor(Color col) {
        color = col;
    }

}
