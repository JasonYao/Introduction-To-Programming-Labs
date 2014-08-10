// imports
import java.awt.*;
import javax.swing.*;

// class RunD is a tester-applet for the Die classs
public class RunD extends RunC {

    protected JTextField doublesMsgField;

    public static void main(String[] args) {
        new RunD().setVisible(true);
    }
    
    public RunD() {
        super();
    }
    
    protected void addMessageFields(Container c) {
        super.addMessageFields(c);
        doublesMsgField = new JTextField("", 25);
        doublesMsgField.setBackground(Color.lightGray);
        c.add(doublesMsgField);
    }
//     
//     // process button-press
//     protected void processRollButton() {
// //         super.processRollButton();
// //         if (myDie.equals(myDie2)) {
// //             doublesMsgField.setText("We have doubles");
// //         }
// //         else {
// //             doublesMsgField.setText("We don't have doubles");
// //         }
//     }
    
    // This method prints the textual messages on the frame
    protected void printMessages() {
        super.printMessages();
        if (myDie.equals(myDie2)) {
            doublesMsgField.setBackground(Color.red);
            doublesMsgField.setForeground(Color.white);
            doublesMsgField.setText("We have doubles");
        }
        else {
            doublesMsgField.setBackground(Color.lightGray);
            doublesMsgField.setForeground(Color.black);
            doublesMsgField.setText("We don't have doubles");
        }
    }
}
