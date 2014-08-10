import java.awt.*;
import javax.swing.*;
import java.lang.Object;
import java.awt.event.*;
import javax.swing.JComponent.AccessibleJComponent;
import javax.swing.text.JTextComponent;

/**
 * Write a description of class JavaAPILabMain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JavaAPILabMain implements ActionListener
{
    // Instance Variables
    private String initialInput = "I love to eat fresh green beans!";
    private JTextArea textFieldStuff;

    public void actionPerformed(ActionEvent e)
    {
        // Clears the content of the JTextArea by setting it to an empty string
        if (e.getActionCommand().equals("Clear"))
        {
            textFieldStuff.setText("");
        }
        else
        {
            textFieldStuff.append(" Yumy!");
        }
    }
    
        // Constructor for the class
    public JavaAPILabMain ()
    {
        //Create and set up the window.
        JFrame labFrame = new JFrame("Fresh Green Beans");

        // Exits the program when clicked
        labFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the dimentions of the object
        labFrame.setSize(new Dimension(300,300));

        // Shifts the location of the fram 500 by 500, so I don't have to move it around all day
        labFrame.setLocation(500,500);
        labFrame.getLocation();

        //JFrame.setDefaultCloseAction(JFrame.EXIT_ON_CLOSE);
        layout(labFrame);
        labFrame.setVisible(true);
    }

    private void layout(JFrame frame)
    {
        // Sets the Layout manager
        JPanel panel = new JPanel(new BorderLayout());

        // Sets the internal content panes
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        // Creates the JTextField
        this.textFieldStuff = new JTextArea(initialInput);
        frame.add(textFieldStuff);

        // Creates the Edit Button
        JButton buttonEdit = new JButton("Edit");

        // Creates the Clear JButton
        JButton buttonClear = new JButton("Clear");

        // Implements an action listener for the clear button   
        buttonClear.addActionListener(this);
        buttonEdit.addActionListener(this);

        // Adds the buttons
        frame.add(buttonClear);
        frame.add(buttonEdit);
        
        frame.setVisible(true);
    }
    public static void main (String[] args)
    {
        JavaAPILabMain frameTest = new JavaAPILabMain();
    }
}
