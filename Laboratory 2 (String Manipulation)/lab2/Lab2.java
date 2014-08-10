// Java utils
import java.text.*;
import java.util.*;
/*
 * Lab2.java - defines some methods that perform various string operations
 *
 * For each operation (e.g., op0, op1), the variable 'input' is the string typed in by the user; the
 * string 'result' is the string that is displayed on the corresponding output field.
 *
 * Your last statement in each method will therefore typically be of the form:
 *   result = ... ;
 *
 * The way that data is passed back and forth to/from the user is not the best programming style.
 * It's done this way to try to make life simple for you.
 *
 */

/*
 * class Lab2 - performs string manipulations
 *
 */
public class Lab2 {

    // instance variables to hold the input and result
    //   *** DON'T WORRY IF YOU DON'T UNDERSTAND WHY THEY'RE HERE ***
    public String input;  // input typed in from user
    public String result; // result we pass back to user

    // constructor for the 'Lab2' object.
    //   *** DON'T WORRY IF YOU DON'T UNDERSTAND WHY THIS IS HERE ***
    public Lab2() {
        input = "";
        result = "";
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    // You should modify each of the following operations by replacing the line
    //   result = input;
    // with one or more statements that perform the appropriate task.
    //
    ///////////////////////////////////////////////////////////////////////////

    // just trimmed
    public void op0() {
        result = input.trim();
    }

    // trimmed, with three '!' appended to end
    public void op1() {
        String trimmed;
        trimmed = input.trim();
        result = trimmed + "!!!";
    }

    // trimmed, with '-' inserted after first character and also after second
    public void op2() {
        String trimmed;
        trimmed = input.trim();
        int length = trimmed.length();
        if (length >= 2)
        {
            String last;
            last = trimmed.substring(0,1) + "-" + trimmed.substring(1,2) + "-" + trimmed.substring(2);
            result = last;
        }
        else
        {
            result = trimmed;
        }
    }

    // converted to upper case
    public void op3() {
        String trimmed;
        trimmed = input.trim();
        String last;
        last = trimmed.toUpperCase();
        result = last;
    }

    // trimmed, with first 10 characters removed
    public void op4() {
       String trimmed;
       trimmed = input.trim();
       if (trimmed.length() < 10)
        {
            result = "";
        }
        else
        {
            result = trimmed.substring(10);
        }
    }

    // trimmed, with last 10 characters removed
    public void op5() {
        String trimmed;
        int index;
        int startOfString;
        trimmed = input.trim();
        index = trimmed.length();
        startOfString = index - 10;
        if (trimmed.length() < 10)
        {
            result = trimmed;
        }
        else
        {
            result = trimmed.substring(0,startOfString);
        }
    }

    // trimmed, with '...' inserted right in the middle (or slightly to the
    // right if odd number of characters
    public void op6() {
       String trimmed;
       trimmed = input.trim();
       int length = trimmed.length();
       double lengthDouble = (double) length;
       double halfDouble = (length+0.5)/2;
       int half = (int) halfDouble;
       String last = trimmed.substring(0,half) + "..." + trimmed.substring(half, length);
       result = last;
    }

    // first word only
    public void op7() {
        String trimmed;
        trimmed = input.trim();
        int change = trimmed.indexOf(" ");
        if (change == -1 )
        {
            result = trimmed;
        }
        else
        {
             int index = trimmed.indexOf(" ");
             String last = trimmed.substring (0, index);
             result = last;
        }
    }

    // trimmed, with everything except last word converted to lower case
    public void op8() {
        String trimmed;
        trimmed = input.trim();
        
        //turns everything to lowercase
        String lower = trimmed.toLowerCase();
        
        int find = lower.lastIndexOf(" ");
        int index = lower.length();
        
        String lastWord = trimmed.substring(find, index);
        String otherWords = lower.substring(0,find);
        
        String last = otherWords + lastWord;
        result = last;
    }

    // trimmed, with each '.' character changed to '?'
    public void op9() {
        String trimmed;
        trimmed = input.trim();
        String last = trimmed.replace(".","?");
        result = last;
        
    }

    // first 3/4 of the string (or slighly more than that if length is not
    // an exact multiple of 4).  THIS ONE IS OPTIONAL.
    public void op10() {
        String trimmed;
        trimmed = input.trim();
        
        // converts an integer into a double, multiplies by 3/4, then 
        int number = trimmed.length();
        double divided = (double)number*3/4;
        double roundedDouble = (divided +0.5);
        int roundedInt = (int) divided;

        String last = trimmed.substring(0,roundedInt);
        result = last;
    }

    // all but the second-to-last word.  THIS ONE IS OPTIONAL.
    public void op11() {
        String trimmed;
        trimmed = input.trim();
        
        // kill off last word
        int lastWordEnd = trimmed.length();
        int lastWordStart = trimmed.lastIndexOf(" ");
        String lastWord = trimmed.substring(lastWordStart, lastWordEnd);
        
        // Everything except last word
        String everythingButLast = trimmed.substring(0, lastWordStart);
        
        // Finds if the first and last " " indexii
        int firstSpace = everythingButLast.indexOf(" ");
        int lastSpace = everythingButLast.lastIndexOf(" ");
        
        // Finds index of of trimmed string
        int length = trimmed.length();
        
        // Finds if the first " "'s index matches the last " "'s index, in order to make sure there is at least 3 words
        if (firstSpace == -1)
        {
            result = trimmed;
        }
        else
        {
            //capture second to last word
            int secondWordEnd = everythingButLast.length() -1;
            int secondWordStart = everythingButLast.lastIndexOf(" ");
        
            //keep the part in front of the second to last word
            String startToLastTwo = everythingButLast.substring(0,secondWordStart);
            String endFromLastTwo = everythingButLast.substring(secondWordEnd,length);
        
            //add the part with the last word
            String last = startToLastTwo + endFromLastTwo;
            result=last;
        }
    }
    public static void main(String[] args)
    {
        Lab2App.main2(args);
    }

}
