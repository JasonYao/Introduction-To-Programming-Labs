////////////////////////////////////////////////////////////////
// Flag.java - defines an "American flag" object
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
// class Flag - an American flag
//
// This class defines an object that represents an American flag.
// In addition to a constructor, it provides a paint method that
// allows it to be painted on a graphics window.
// 
// A Flag object is immutable--there are no public methods that
// change its state once it is created.
//
////////////////////////////////////////////////////////////////
public class Flag
{

    ///////////////////////
    // instance variables
    /////////////////////

    // the rectangle with stars
    public//private
    StarRect starRect;

    // the array of 13 stripes
    public//private
    ColorRect[] stripe;

    ///////////////////////
    // class varibles
    /////////////////////

    // our "red" color
    private static Color myRed = Color.red.darker();

    ////////////////////////////////////////////////////////////////
    // Flag constructor - creates a flag
    // 
    // Calling sequence:
    //   aFlag = new Flag(x, y);
    // 
    // Parameters:
    //   x - the horizontal position of the top-left corner of the flag
    //   y - the vertical position of the top-left corner of the flag
    // 
    //  Side-effects:
    //    Initialzes the object.
    // 
    //  Bugs/anomalies:
    //    None known.
    // 
    ////////////////////////////////////////////////////////////////
    public Flag() {
        this(5,5);
    }

    public Flag(int x, int y) {

        // create the array of stripes
        stripe = new ColorRect[13];

        // create the stripes, alternating red and white
        for (int i = 0; i < stripe.length; i += 2) {
                stripe[i] = new ColorRect(x,y+(17*i),375,17,myRed);            
        }
        for (int i = 1; i < stripe.length; i += 2) {
            stripe[i] = new ColorRect(x,y+(17*i),375,17,Color.white);
        }

        // create rectangle with stars
        starRect = new StarRect(x,y);

    }

    ////////////////////////////////////////////////////////////////
    // paint - paints the object
    // 
    // Calling sequence:
    //   aFlag.paint(g);
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

        // paint the stripes
        for (int i = 0; i < stripe.length; i++) {
            stripe[i].paint(g);
        }

        // paint the rectangle with stars
        starRect.paint(g);
    }

    public void view() {
        FlagCanvas canv = new FlagCanvas(this);
        FlagViewer fv = new FlagViewer(canv);
        fv.setVisible(true);
    }
}
