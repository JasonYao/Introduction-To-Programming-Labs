import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

/**
 * Our main JFrame class for performing the "lunar lander" animation.
 * 
 * @author Neil Tuttle, minor modifications by Steven R. Vegdahl
 * @version 2005-09-16, modifications 2012-12-19
 *
 */
public class LanderFrame extends JFrame {
	
	// instance variable: our animator object
	private LanderAnimator animator;
	
	/**
	 * The main method.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		// create our frame object and make it visible
		LanderFrame main = new LanderFrame();
		main.setVisible(true);
	}
	
	/**
	 * Constructor for our frame object
	 *
	 */
	public LanderFrame() {
		
		// set application exits when when frame is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set size of window
		setSize(640,510);
		
		// get the top-level container
		Container top = getContentPane();
		
		// create animator object and animation canvas and add to GUI
		// structure; also create listener to listen to the mouse
		LanderProperties prop = new MyLanderProperties(); // create properties object
		prop.setTitle("Lunar Banana"); // set title
		prop.setGravity(-2.0); // set gravity
		setTitle(prop.getTitle()); // set window title to be same as lander title
		animator = new LanderAnimator(prop); // create animator
		AnimationCanvas canvas = new AnimationCanvas(animator); // create canvas
		top.add(canvas); // add canvas to frame
	}
}
