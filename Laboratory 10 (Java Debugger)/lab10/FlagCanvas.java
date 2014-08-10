import java.awt.*;

/**
 * A class onto which a Flag can be drawn
 * 
 * @author Steven R. Vegdahl 
 * @version 13 March 2003
 */
public class FlagCanvas extends Canvas
{
    // instance variable--the flag we draw
    public//private
        Flag f;
        
    ////////////////////////////////////////////////////////////////
    // FlagCanvas constructor - creates a FlagCanvas object
    // 
    // Calling sequence:
    //   aFlagCanvas = new FlagCanvas(flg);
    // 
    // Parameters:
    //   x - the flag we draw
    // 
    //  Side-effects:
    //    Initialzes the object.
    // 
    //  Bugs/anomalies:
    //    None known.
    // 
    ////////////////////////////////////////////////////////////////
    public FlagCanvas(Flag flg) {
        // initialize our instance variable
        f = flg;
        setBackground(Color.lightGray);
    }

    ////////////////////////////////////////////////////////////////
    // paint - paints the object
    // 
    // Calling sequence:
    //   aFlagCanvas.paint(g);
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
        // paint the flag
        f.paint(g);
    }
}
