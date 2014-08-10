import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//////// CS 273 STUDENTS SHOULD NOT MODIFY THIS CODE ////////

/**
 * A class that represents a full tree of a given level, with a "current node",
 * and "target node" (jelly bean). It is a subclass of JPanel, so it can be viewed,
 * and interacted with via some buttons. Its main method creates a JFrame that displays
 * the tree and contains the buttons.
 * 
 * @author Steven R. Vegdahl
 * @version 24 November 2013
 */
public class Tree extends JPanel implements ActionListener {

    // the amount of time (milliseconds) to delay after each tree movement
    private static final int TIME_DELAY = 150;
    
    // the color of the upper box: a somewhat light blue
    private static final Color upperBoxColor = new Color(180,180,255);
    
    // the color of the lower box: a quite light blue
    private static final Color lowerBoxColor = new Color(210,210,255);

    // number of levels in the tree (one greater than tree height)
    private int numLevels;
    
    // the current location, where column=x, row=y). The root is at location (0,0). The
    // one-deep nodes are (left-to-right) at (0,1) and (1,1). The next level's nodes
    // are (left-to-right) at (0,2), (1,2), (2,2) and (3,2), etc. The parent of a
    // non-root node (col,row) will be (col/2,row-1). The children of a non-leaf node
    // (col,row) will always be (col*2,row+1) and (col*2+1,row+1).
    private Point myLocation;
    
    // the location of the jelly bean
    private Point targetLocation;
    
    // contains an error message if non-cleared error message exists (null otherwise)
    private String errorStatus = null;
    
    // keeps track of whether serach is running
    private boolean running = false;
    
    // keeps track of whether the "Stop" button has just been pressed.
    private boolean interrupt = false;
    
    /**
     * main method:
     */
    public static void main(String[] args) {
        
        // create frame, setting title, etc.
        JFrame theFrame = new JFrame();
        theFrame.setTitle("Find the Jelly Bean");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create the top-level GUI structure:
        // - box for the buttons is on top
        // - panel for the tree-display is on bottom
        Box topBox = Box.createVerticalBox();
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.setOpaque(true);
        buttonBox.setBackground(upperBoxColor);
        topBox.add(buttonBox);
        Tree thePanel = new Tree();
        topBox.add(thePanel);
        theFrame.setContentPane(topBox);
        Dimension dim = thePanel.getSize();
        theFrame.setSize(dim.width, dim.height+100);
        
        // add the buttons to the button-box
        JButton goButton = new JButton("Go");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");
        JButton upButton = new JButton("Up");
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton moveTargetButton = new JButton("Move Target");
        buttonBox.add(Box.createHorizontalGlue());
        buttonBox.add(goButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,1)));
        buttonBox.add(stopButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,1)));
        buttonBox.add(upButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,1)));
        buttonBox.add(leftButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,1)));
        buttonBox.add(rightButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,1)));
        buttonBox.add(resetButton);
        buttonBox.add(Box.createRigidArea(new Dimension(20,1)));
        buttonBox.add(moveTargetButton);
        buttonBox.add(Box.createHorizontalGlue());
        
        // set the Tree as the listener to each button
        goButton.addActionListener(thePanel);
        stopButton.addActionListener(thePanel);
        upButton.addActionListener(thePanel);
        leftButton.addActionListener(thePanel);
        rightButton.addActionListener(thePanel);
        resetButton.addActionListener(thePanel);
        moveTargetButton.addActionListener(thePanel);
        
        // display the GUI
        theFrame.setVisible(true);
    }
    
    /**
     * constructor for Tree class
     */
    public Tree() {
        // set the size and background color
        this.setSize(800,800);
        this.setBackground(lowerBoxColor);
        
        // do a "reset", which set the tree's height randomly, etc.
        reset();
    }
    
    /**
     * reset's the tree's height, current location and target location; clears
     * error status
     */
    private void reset() {
        // set number of levels to a random value in the range 3-7
        this.setNumLevels(3+(int)(Math.random()*5));
        
        // set the current location to be a the top of the tree
        myLocation = new Point(0,0);
        
        // set the target location to be a random node
        targetLocation = randomNode();
        
        // clear any error status
        errorStatus = null;
    }
    
    /**
     * sets the tree's number of levels
     * 
     * @param n
     *      the number of levels to use
     */
    private void setNumLevels(int n) {
        numLevels = n;
    } 
    
    /**
     * callback method that paints the suface
     * 
     * @param g
     *      the Graphics object on which to paint
     */
    public void paint(Graphics g) {
        // perform superclass paint operations
        super.paint(g);
        
        // draw the entire tree (i.e., starting at row zero
        drawTree(0, g);
        
        // if the error status is set, draw a big black 'X'
        if (errorStatus != null) {
            // get height and width, and set drawing color
            int height = this.getHeight();
            int width = this.getWidth();
            g.setColor(Color.BLACK);
            
            // draw the slash from top-left to bottom-right
            Polygon p1 = new Polygon();
            p1.addPoint(width/10,0);
            p1.addPoint(width,height*9/10);
            p1.addPoint(width*9/10,height);
            p1.addPoint(0,height/10);
            g.fillPolygon(p1);
            
            // draw the slash from top-right to bottom-left
            Polygon p2 = new Polygon();
            p2.addPoint(width*9/10,0);
            p2.addPoint(width,height/10);
            p2.addPoint(width/10,height);
            p2.addPoint(0,height*9/10);
            g.fillPolygon(p2);
        }
    }

    /**
     * draws a (sub)tree on a graphics object
     * 
     * @param row
     *      the row to draw
     * @param g
     *      the Graphics object to draw on
     */
    private void drawTree(int row, Graphics g) {
        
        // if we've reached the number of tree levels, quit
        if (row >= numLevels) return;
            
        // recursively draw the lower levels of the tree
        drawTree(row+1, g);
        
        // determine the position number of the first node to draw at this level
        int skip = 1<<(numLevels-row-1);
        
        // determine the total number of nodes that will need to be drawn for
        // this tree
        int numAcross = 1<<(numLevels-1);
            
        // loop through and draw each circle for this row
        for (int i = 0; ; i++) {
            // get the box that will enclose this circle
            Rectangle box = boxFor(row, i);
            
            // if no such box exists, we're done with this row
            if (box == null) break;
            
            // draw the line from the parent to our circle
            Rectangle parentBox = boxFor(row-1,i/2);
            if (parentBox != null) { // null => top row
                Point p1 = rectCenter(parentBox);
                Point p2 = rectCenter(box);
                g.setColor(Color.black);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
            
            // draw the current circle, with color dependent on whether it
            // is the current location
            if (row == myLocation.y && i == myLocation.x) {
                g.setColor(Color.WHITE);
            }
            else {
                g.setColor(Color.BLACK);
            }
            g.fillOval(box.x,box.y,box.width,box.height);
            
            // if this is the target square, draw the jelly bean
            if (row == targetLocation.y && i == targetLocation.x) {
                g.setColor(Color.RED);
                g.fillOval(box.x,box.y+box.height/2,box.width,box.height/3);
                
            }
        }
    }
    
    /**
     * compute the box into which a given circle is to be drawn
     * 
     * @param row
     *      the row number of the node
     * @param col
     *      the column number of the node
     * @return
     *      a rectangle that denotes the box
     */
    private Rectangle boxFor(int row, int col) {
        // compute pixel-height and -width of drawing region
        int height = this.getHeight();
        int width = this.getWidth();
        
        // the number of nodes that will be drawn across the bottom level
        int totalNumAcross = 1<<(numLevels-1);
        
        // the number of nodes to draw in the given row
        int numAcross = 1<<row;
        
        // return null if the row or column is out of bounds
        if (row < 0 || row >= numLevels) return null;
        if (col < 0 || col >= numAcross) return null;
        
        // the horizontal pixel-offset of the column-zero eleement
        int offset = (1<<(numLevels-row-2))-1;
        if (row == numLevels-1) {
            // adjust if in last row: enire width is used, so start at 0
            offset = 0;
        }
        
        // this horizontal pixel-distance to skip from one node to the other
        // on this row
        int spread = (1<<(numLevels-row-1))-1;
        
        // compute top, bottom, left, right edges; also height and width of the 
        // rectangle
        int top = height*(row+1)/numLevels;
        int bottom = height*(row+2)/numLevels;
        int left = width*(col+offset+(col*spread)+1)/totalNumAcross;
        int right = width*(col+offset+(col*spread)+2)/totalNumAcross;
        int h = bottom-top;
        int w = right-left;
        
        // we want a square box, so compute box size, as minimum of height, width
        int boxSize = Math.min(h,w);
        left -= w-boxSize/2;
        top -= h-boxSize/2;
        
        // if we're at the bottom row, adjust left by half a box-width, so
        // both children are symmetric with parent
        if (row == numLevels-1) {
            left -= boxSize/2;
        }
        
        // return rectangle that is 90% of appropriate height and width, centered
        // in the original box's center
        left += boxSize/20;
        top += boxSize/20;
        boxSize = boxSize*9/10;
        return new Rectangle(left,top,boxSize,boxSize);
    }
    
    /**
     * computes the center of a rectangle
     * 
     * @param r
     *      the rectangle
     * @return
     *      a Point object that denotes the rectangle's center
     */
    private static Point rectCenter(Rectangle r) {
        return new Point(r.x+r.width/2, r.y+r.height/2);
    }
    
    /**
     * returns a random node in the tree
     * 
     * @return
     *      a Point object that denotes the column and row position of a random
     *      node in the tree
     */
    private Point randomNode() {
        // compute a random number that is in the range 0..N-1, where N is
        // the number of nodes in the tree
        int numNodes = (1<<numLevels)-1;
        int idx = (int)(Math.random()*numNodes);
        
        // loop through row-by-row (last first); if the random number is in the
        // range of the number of nodes in that row, return the corrsponding point;
        // otherwise, subtract the number of rows from the random number, and try
        // the next row
        for (int row = numLevels-1; ; row--) {
            int nodesOnLevel = 1<<row; // number of nodes on this level
            if (idx < nodesOnLevel) {
                // in range, return point
                return new Point(idx, row);
            }
            idx -= nodesOnLevel; // subtrace number of nodes on this level
        }
    }
        
    /**
     * callback method for button-presses
     * 
     * @param ae
     *      the action event
     */
    public void actionPerformed(ActionEvent ae) {
        // wrap everthing in a try-catch to catch TreeExceptions, which will cause an
        // 'X' to appear on the screen
        try {
            
            // get button text
            JButton button = (JButton)ae.getSource();
            String text = button.getText();
            
            // if we're running, ignore all buttons except 'Stop'
            if (running && !text.equals("Stop")) return;
            
            // if there is an outstanding error, ignore all buttons except
            // 'Reset'
            if (errorStatus != null && !text.equals("Reset")) {
                return;
            }
            
            // perform the action, depending on the button
            if (text.equals("Stop")) {
                // 'Stop': set interrupt flag to 'true'. This will cause an
                // exception the next time a location-movement occurs
                interrupt = true;
            }
            else if (text.equals("Reset")) {
                // 'Reset' button: reset the tree to be a new one; then repaint so
                // that tree is seen
                reset();
                repaint();
            } 
            else if (text.equals("Go")) {
                // 'Go' button: start new thread that calls user's traversal method
                Runnable r = new Runnable() {
                    public void run() {
                        try { // catch exceptions here, to handle errors
                            new BeanFinder(Tree.this).traverse();
                            running = false;
                        }
                        catch (TreeException te) {
                            handleError(te);
                        }
                    }
                };
                Thread t = new Thread(r);
                // mark as running, not interrupted
                running = true;
                interrupt = false;
                t.start();
            }
            else if (text.equals("Up")) {
                // 'Up' botton perform given method
                moveUp();
            }
            else if (text.equals("Left")) {
                // 'Left' botton perform given method
                moveLeft();
            }
            else if (text.equals("Right")) {
                // 'Right' botton perform given method
                moveRight();
            }
            else if (text.equals("Move Target")) {
                // 'Move Target' button: randomize target location and repaint so
                // that change is seen
                targetLocation = randomNode();
                repaint();
            }
        }
        catch (TreeException te) {
            // if we get an exception, handle the error
            handleError(te);
        }
    }
    
    /**
     * called when TreeException occurs. Sets error status to non-null, which does
     * causes a repaint() to occor, which will cause a big black 'X' to display,
     * unless the error status is "Interrupt"--in which the exception was thrown
     * simply to stop execution.
     * 
     * @param te
     *      the TreeException
     */
    private void handleError(TreeException te) {
        // get the error type, setting the error status
        errorStatus = te.getType();
        
        // mark as not running, not interrupted
        running = false;
        interrupt = false;
        
        // if the error status is "Interrupt", reset to null
        if (errorStatus.equals("Interrupt")) {
            errorStatus = null;
        }
        
        // repaint, which (usually) shows the 'X'
        repaint();
    }
    
    /**
     * causes the current node to move up the tree
     */
    public void moveUp() throws TreeException {
        // throw interrupt-exception if needed
        checkInterrupt();
        

        if (myLocation.y == 0) {
            // already at top of tree: record error
            error();
        }
        else {
            // not at top of tree: do the math to move to parent
            myLocation.y--;
            myLocation.x/=2;
            
            // repaint GUI and delay for a bit so user sees effect
            repaint();
            delay();
        }
    }
    
    /**
     * causes the current node to left (and down) the tree
     */    
    public void moveLeft() throws TreeException {
        // throw interrupt-exception if needed
        checkInterrupt();
        
        if (myLocation.y >= numLevels-1) {
            // already at bottom of tree: record error
            error();
        }
        else {
            // not at bottom of tree: do the math to move down and to the left 
            myLocation.y++;
            myLocation.x*=2;
            
            // repaint GUI and delay for a bit so user sees effect
            repaint();
            delay();
        }
    }

    /**
     * causes the current node to right (and down) the tree
     */        
    public void moveRight() throws TreeException {
        // throw interrupt-exception if needed
        checkInterrupt();
        
        if (myLocation.y >= numLevels-1) {
            // already at bottom of tree: record error
            error();
        }
        else {
            // not at bottom of tree: do the math to move down and to the left 
            myLocation.y++;
            myLocation.x*=2;
            myLocation.x++;
            
            // repaint GUI and delay for a bit so user sees effect
            repaint();
            delay();
        }
    }
    
    /**
     * tells whether current node can move left (and down) without going off the tree
     * 
     * @return
     *      whether the node can move down/left
     */
    public boolean canGoLeft() throws TreeException {
       // throw interrupt-exception if needed
        checkInterrupt();
        
        // tell whether we're at a level other than the bottom
        return myLocation.y < numLevels-1;
    }
    
    
    /**
     * tells whether current node can move right (and down) without going off the tree
     * 
     * @return
     *      whether the node can move down/right
     */
    public boolean canGoRight() throws TreeException {
        // throw interrupt-exception if needed
        checkInterrupt();
        
        // tell whether we're at a level other than the bottom
        return myLocation.y < numLevels-1;
    }
    
    /**
     * tells whether current node can move up without going off the tree
     * 
     * @return
     *      whether the node can move up
     */
    public boolean canGoUp() throws TreeException {
        // throw interrupt-exception if needed
        checkInterrupt();
        
        // tell whether we're at a level other than the top
        return myLocation.y > 0;
    }
    
    /**
     * tells whether the current node is at the target
     * 
     * @return
     *      whether the current node is at the target
     */
    public boolean foundTarget() throws TreeException {
        // throw interrupt-exception if needed
        checkInterrupt();
        
        // tell whether the target-location is equal to ours
        return myLocation.equals(targetLocation);
    }
    
    /**
     * registers an error by throwing a TreeException
     */
    private void error() throws TreeException {
        throw new TreeException("Error");
    }
    
    /**
     * if the interrupt-flag is set, throws a TreeException with
     * data "Interrupt"
     */
    private void checkInterrupt() throws TreeException {
        if (interrupt) {
            throw new TreeException("Interrupt");
        }
    }
    
    /**
     * delay for a short amount of time, so that the human user can see discrete
     * movements
     */
    private void delay() {
        // sleep for the denoted amount of time
        try {
            Thread.sleep(TIME_DELAY);
        }
        catch (InterruptedException ix) {
        }
    }
        
}
