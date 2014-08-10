/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* FrameDemo.java requires no other files. */
public class FrameDemo {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Initializes a base input that can be changed later on
        String inputValue = "I love to eat fresh green beans";

        // Returns an int value that is either of value YES_OPTION, NO_OPTION, or CLOSED_OPTION
        int returnValue;

        // Calls the JOptionPane creation method
        returnValue = createPane(inputValue);

        // Creates a boolean value to continuously run through the loop- exits only upon CLOSED_OPTION
        boolean change = true;
        
        // Begining of the loop, so the user can click either of the buttons indefinitely
        while (change == true)
        {
            // Checks first to see if the exit value has been returned, exits upon receiving value
            if (returnValue == JOptionPane.CLOSED_OPTION)
            {
                System.exit(0);
            }
            // Next checks whether the edit button was pressed
            else if (returnValue == JOptionPane.YES_OPTION)
            {
                // Initializes the text inside with user input via JOptionPane's showInputDialog
                inputValue = JOptionPane.showInputDialog("Whatever you want to type here: ");
                
                // Re-runs creating the object with the next string
                returnValue = createPane(inputValue);
            }
            // All that's left is the clear button
            else
            {
                // Initializes the text inside to an empty character value (which is still valid)
                inputValue = "";
                
                // Re-runs creating the object with the new string
                returnValue = createPane(inputValue);
            } // Ends if statement
        } // Ends loop
    }

    /**
     * Helper method: Creates the JOptionPane Object
     */
    private static int createPane(String inputText)
    {
        // Create and set up the window.
        JFrame frame = new JFrame("Fresh Green Beans");
        
        // Creates the button options, format from Java's Oracle API template, with slight modifications
        Object[] options = {"Edit", "Clear"};
        
        // Initializes a return value that is either YES_OPTION, NO_OPTION, or CLOSED_OPTION
        int returnValue = JOptionPane.showOptionDialog(frame,
        
        // Sticks the new text input into the text field
        inputText,
                
        // Creates the title of the optionPane
        "Fresh Green Beans",
                
        // Tells which values it will return based upon which buttons were pressed
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[0]); //default button title
        
        // Returns the button code telling which button was pressed
        return returnValue;
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable()
            {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
} // Ends FrameDemo