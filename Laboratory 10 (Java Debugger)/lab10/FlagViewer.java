////////////////////////////////////////////////////////////////
// FlagViewer.java - defines the FlagViewer class, which is a GUI
//   that displays a flag
//
// Author: Steven R. Vegdahl
// Date: November 1999
// Status: Debugged, but minimally commented
//
// Modified by: Steven R. Vegdahl
// Date: 25 October 2000
// Reason: Beef up the comments 
//
// Modified by: Steven R. Vegdahl
// Date: 7 January 2003
// Reason: Changed from an Applet class to a JFrame 
//
////////////////////////////////////////////////////////////////

// imports
import java.awt.*;
import javax.swing.*;

////////////////////////////////////////////////////////////////
// class FlagViewer - an GUI object that displays a flag
//
// This frame class that displays an American flag.  It is not
// interactive, and will therefore not respond to mouse-clicks, etc.
// 
////////////////////////////////////////////////////////////////
public class FlagViewer extends JFrame {

    /////////////////////////
    // instance variables
    ////////////////////////

    ////////////////////////////////////////////////////////////////
    // Constructor for FlagViewer
    // 
    // Calling sequence:
    //   aFlagViewer = new FlagViewer(Canv);
    //
    // Parameters:
    //   canv: the FlagCanvas object containing the flag we're displaying
    // 
    //  Side-effects:
    //    None.
    // 
    //  Bugs/anomalies:
    //    None known.
    // 
    ////////////////////////////////////////////////////////////////
    public FlagViewer(FlagCanvas canv) {
    
        // set background color to gray
        this.setBackground(Color.gray.brighter());
        
        // set the size and title
        setSize(400, 280);
        setTitle("A Flag");
        
        // add the canvas to the object
        this.getContentPane().add(canv);
    }
}
