import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * class BoxesBase
 *
 * This class contains the basic window creation and paint functions for the
 * Boxes app.
 *
 * Students:  YOU MAY NOT EDIT THIS FILE
 *
 * @author Steve Vegdahl
 * @author Andrew Nuxoll
 *
 * Change Log:
 * Jan 2013: changed from applet to app (:AMN:)
 * Jan 2013: added to frame height so buttons would not be partially off bottom (vegdahl)
 */
public abstract class BoxesBase extends JPanel implements ActionListener {

    /** graphics canvas width and height */
    public static final int PANEL_SIZE = 500;

    /** height of the button box */
    public static final int BOX_SIZE = 50;
    
    /** extra space for the frame */
    public static final int FRAME_EXTRA_SPACE = 10;
    
    /** how many boxes to draw */
    protected int numBoxes = 1;

    /** button labels increase/decrease numBoxes */
    public static final String moreButtonLabel = "More";
    public static final String lessButtonLabel = "Less";

    //ctor sets background color
    public BoxesBase() {
        super();
        setBackground(Color.white);
    }

    /**
     * a helper method for paint() that draws the boxes.  Students implement
     * this so the funcitonality is isolated.
     */
    public abstract void drawBoxes(Graphics g);
    
    /**
     * draws the window content
     */
    public void paint(Graphics g) 
    {
        super.paint(g);
        drawBoxes(g);
        
    }
    
    
    /**
     * when the user presses a button, increment/decrement numBoxes
     * appropriately
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(moreButtonLabel))
        {
            numBoxes = Math.min(30, numBoxes + 1);
        }
        else if (e.getActionCommand().equals(lessButtonLabel))
        {
            numBoxes = Math.max(1, numBoxes - 1);
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
        JFrame frame = new JFrame("Concentric Boxes");
        frame.setSize(PANEL_SIZE, PANEL_SIZE + BOX_SIZE + FRAME_EXTRA_SPACE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the panel for drawing the boxes
        Boxes panel = new Boxes();
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

}//BoxesBase
