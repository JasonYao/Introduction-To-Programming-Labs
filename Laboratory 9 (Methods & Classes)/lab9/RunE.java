
public class RunE extends RunD {

    private static String arg = null;
    
    public static void main(String[] args) {
        if (args.length > 0) {
            arg = args[0];
        }
        new RunE().setVisible(true);
    }

    public RunE() {
        super();
    }
    
    protected void addDice() {
        super.addDice();
        if (arg != null) {
            try {
                int val = Integer.parseInt(arg);
                if (val >= 10 && val <= 250) {
                    myDie2.setSize(val);
                    return;
                }
            }
            catch (NumberFormatException nfx) {
            }
        }
        
        if (Math.random() > 0.5) {
            myDie2.setSize(100);
        }
        else {
            myDie2.setSize(40);
        }
    }
}

// // imports
// import java.awt.*;
// import java.awt.event.*;
// import java.applet.*;
// 
// 
// // class RunE is a tester-applet for the Die classs
// public class RunE extends Applet implements ActionListener {
// 
//   // instance variables
//   Button myButton; // button on the applet, labeled "Roll"
//   Die myDie; // the first Die object
//   Die myDie2; // the second Die object
//   int numRolls = 1; // counter to keep track of number of rolls
//   int maxRoll = -1; // keeps track of maximum sum
//   int minRoll = 100; // keeps track of minimum sum
// 
//  // This method gets executed anytime the button gets pressed
//   public void actionPerformed(ActionEvent ae) {
//     // If the activated object is our button, then reroll the dice
//     Object src = ae.getSource(); // activated object
//     if (src == myButton) { // if it's our button ...
//         myDie.roll(); // reroll first die
//         myDie2.roll(); // reroll second die
//         numRolls++; // increment number of rolls
//         updateMinMax(); // recompute min and max
//         printMessages(); // print the textual messages
//     }
//   }
// 
//   // This method gets executed whenever the window needs to be repainted
//   public void paint(Graphics g) {
//     super.paint(g); // perform superclass' paint-operation
//     myDie.paint(); // paint the first die
//     myDie2.paint(); // paint the second die
//     printMessages(); // print the textual messages
//   }
// 
//   // This method initializes the applet
//   public void init() {
// 
//     // create and activate the button
//     myButton = new Button("Roll");
//     this.add(myButton);
//     myButton.addActionListener(this);
// 
//     // set the background color to light gray
//     setBackground(Color.gray.brighter());
// 
//     // create the die at 100,50 and 200,50
//     myDie = new Die(100, 50, this.getGraphics());
//     myDie2 = new Die(200, 50, this.getGraphics());
//     myDie2.setSize(100);
// 
//     // do the initial settings for min, max values
//     updateMinMax();
//   }
// 
//   // this method updates the variables that keep track of miniumum and maximum sums
//   private void updateMinMax() {
//     int sum = myDie.value() + myDie2.value(); // compute sum of dice
//     if (sum > maxRoll) maxRoll = sum; // if sum greater than current max, reset current max
//     if (sum < minRoll) minRoll = sum; // if sum less than current min, reset current min
//   }
// 
//   // This method prints the textual messages on the applet
//   private void printMessages() {
//     // get the applet's graphics object
//     Graphics g = getGraphics();
// 
//     // draw a rectangle of the background color that wipes out any previous messages
//     Color bColor = getBackground();
//     g.setColor(bColor);
//     g.fillRect(0, 175, 500, 200);
// 
//     // write the messages
//     g.setColor(Color.black); // set color to black
//     g.drawString("We have had "+numRolls+" rolls", 10, 185); // number of rolls
//     g.drawString("The minimum roll so far is "+minRoll, 10, 200); // minimum roll
//     g.drawString("The maximum roll so far is "+maxRoll, 10, 215); // maximum roll
//     g.drawString("The current dice values are "+myDie+" and "+myDie2, // current values
//                  10, 230);
//     if (myDie.equals(myDie2)) { // whether we have doubles
//         g.drawString("We have doubles", 10, 245);
//     }
//     else {
//         g.drawString("We don't have doubles", 10, 245);
//     }
//   }
// }
