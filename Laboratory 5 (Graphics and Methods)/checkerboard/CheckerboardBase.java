import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * class CheckerboardBase
 *
 * This class contains the basic window creation and paint functions for the
 * Checkerboard app.
 *
 * Students:  YOU MAY NOT EDIT THIS FILE
 *
 * @author Steve Vegdahl
 * @author Andrew Nuxoll
 *
 * Change Log:
 * Jan 2013: changed from applet to app (:AMN:)
 * Jan 2013: added to frame height so buttons would not be partially off bottom (vegdahl)
 * Feb 2013: increased FRAME_EXTRA_SPACE from 10 to 20, buttons still cut off (kw)
 */
public abstract class CheckerboardBase extends JPanel implements ActionListener {

    /** graphics canvas width and height */
    public static final int PANEL_SIZE = 500;

    /** height of the button box */
    public static final int BOX_SIZE = 50;
    
    /** extra space for the frame */
    public static final int FRAME_EXTRA_SPACE = 20;
    
    /** the number of squares along one side of the checkerboard */
    protected int numSquares = 1;

    /** button labels increase/decrease numSquares */
    public static final String moreButtonLabel = "More";
    public static final String lessButtonLabel = "Less";

    //ctor sets background color
    public CheckerboardBase() {
        super();
        setBackground(Color.white);
    }

    /**
     * a helper method for paint() that draws the checkerboard.  Students
     * implement this so the functionality is isolated.
     */
    public abstract void drawCheckerboard(Graphics g);
    
    /**
     * draws the window content
     */
    public void paint(Graphics g) 
    {
        super.paint(g);
        drawCheckerboard(g);
        
    }
    
    
    /**
     * when the user presses a button, increment/decrement numSquares
     * appropriately
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(moreButtonLabel))
        {
            numSquares = Math.min(30, numSquares + 1);
        }
        else if (e.getActionCommand().equals(lessButtonLabel))
        {
            numSquares = Math.max(1, numSquares - 1);
        }
        
        //update the display 
        repaint();
    }//actionPerformed


    /**
     * create the window and display to user
     */
    public static void main(String[] args)
    {
        //Create a window frame
        JFrame frame = new JFrame("Checkerboard");
        frame.setSize(PANEL_SIZE, PANEL_SIZE + BOX_SIZE + FRAME_EXTRA_SPACE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the panel for drawing the checkerboard
        Checkerboard panel = new Checkerboard();
        panel.setMinimumSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
        panel.setMaximumSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
        panel.setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));

        //Create a box for the more/less buttons
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.setMinimumSize(new Dimension(PANEL_SIZE, BOX_SIZE));
        buttonBox.setMaximumSize(new Dimension(PANEL_SIZE, BOX_SIZE));
        buttonBox.add(Box.createHorizontalGlue());
        JButton moreButton = new JButton(moreButtonLabel);
        JButton lessButton = new JButton(lessButtonLabel);
        buttonBox.add(moreButton);
        buttonBox.add(lessButton);

        //Set myself up as the listener for button presses
        moreButton.addActionListener(panel);
        lessButton.addActionListener(panel);
        

        //Place panel and buttons into the window frame
        Box mainBox = Box.createVerticalBox();
        mainBox.add(panel);
        mainBox.add(buttonBox);
        frame.add(mainBox);

        frame.setVisible(true);
        
    }//main

}//CheckerboardBase
