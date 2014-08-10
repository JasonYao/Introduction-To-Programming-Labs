/*
 * Lab1.java - does simple text-interaction with user
 *
 * This program prints out a message to the user and then exits
 *
 * Modifications should be made per the instructions in the lab handout.
 *
 */

import java.util.*;   // let this program use the Scanner utility

/*
 * class Lab1 - our main class
 *
 * This is a simple class that defines our 'main' method.
 *
 */
public class Lab1 {
    /*
     * main - interacts with user
     *
     * Modifications should be made per the instructions in the lab handout.
     *
     */
    public static void main(String[] args) {
        // create a Scanner named keyboard to get the user's keyboard input
        Scanner keyboard = new Scanner(System.in);

        // prompt user (without going to a new line);
        System.out.print("What is your favorite colour? ");
        System.out.flush(); //forceoutput to be visible immediately
        
        // read a line of text, typed out by the user
        String answer = keyboard.nextLine();
        
        // Give a "canned response" that includes the user's answer in it
        System.out.print(answer); // Give a "canned response" that includes the user's answer in it
        System.out.print(", "); // Prints a comma and space
        System.out.print(answer); // Give a "canned response" that includes the user's answer in it
        System.out.print(", "); // Prints a comma and space
        System.out.print(answer); // Give a "canned response" that includes the user's answer in it
        System.out.print("."); // Prints a period.
        System.out.print("  All I ever hear from you is ");
        System.out.print(answer); //echo user's text, terminating line
        System.out.println("!");
        System.out.println(" can't you be a little more creative than to say ...");
        System.out.print("..."); //prints a ...
        System.out.println(answer); // Give a "canned response" that includes the user's answer in it
        System.out.print("..."); //prints a ...
        System.out.println(answer); // Give a "canned response" that includes the user's answer in it
        System.out.print("..."); //prints a ...
        System.out.print(answer); // Give a "canned response" that includes the user's answer in it
    }
}

