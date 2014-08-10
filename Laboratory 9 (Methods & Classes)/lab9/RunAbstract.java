// imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// class RunAbstract is the superclass for the Die-testing methogs
public abstract class RunAbstract extends JFrame implements ActionListener {

    // instance variables
    protected Button myButton; // "Roll" button
//     protected Die myDie; // the Die object
    protected int numRolls; // counter to keep track of number of rolls
    protected JPanel canvas;
    protected JTextField msgField;
  
    // constructor
    public RunAbstract() {
        
        // set up to exit application on window-close
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // set title and size
        this.setTitle("Die Rolling");
        this.setSize(450, 620);
        this.setPreferredSize(this.getSize());
        
        // create top-level panel
        JPanel topPanel = new JPanel();
        this.setContentPane(topPanel);
        
        // create canvas
        canvas = new JPanel() {
            public void paint(Graphics g) {
                super.paint(g);
                display(g);
            }
        };
        canvas.setSize(425,300);
        canvas.setPreferredSize(canvas.getSize());
        
        // create and activate the button
        myButton = new Button("Roll");
        topPanel.add(myButton);
        myButton.addActionListener(this);
        
        // set the background color to light gray
        canvas.setBackground(Color.lightGray);
        
        // add the dice
        addDice();
        
        // add button and canvas
        topPanel.add(myButton);
        topPanel.add(canvas);
        
        // add message fields; initialize them
        addMessageFields(topPanel);
        printMessages();
        
        // set number of rolls
        numRolls = 1;
        
        
    }
    
    // displays things on the canvas
    public void display(Graphics g) {
        printMessages(); // print the textual messages
    }
    
    // adds the message fields
    protected void addMessageFields(Container c) {
        msgField = new JTextField("", 25);
        msgField.setBackground(Color.lightGray);
        c.add(msgField);
    }        

    // This method gets executed anytime the button gets pressed
    public void actionPerformed(ActionEvent ae) {
        // If the activated object is our button, then reroll the dice
        Object src = ae.getSource(); // activated object
        if (src == myButton) { // if it's our button ...
            numRolls++;
            processRollButton();
            printMessages(); // print the textual messages
        }
    }
    
    // process button-press
    protected void processRollButton() {
    }

    // This method prints the textual messages on the frame
    protected void printMessages() {
        msgField.setText("Number of rolls: "+numRolls);
    }
    
    // method that adds the dice
    protected void addDice() {
    }
}
