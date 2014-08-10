/**
 * FileHandler.java - peforms file operations
 *
 * Author: Steven R. Vegdahl
 * Date: 5 November 2000
 * Updated:  06 April 2011 by Andrew Nuxoll - removed binary file I/O methods
 * Updated:  11 April 2012 by Andrew Nuxoll - added appendString method
 * Status: incomplete
 *
 */

import java.io.*;
import java.util.*;

/**
 *
 * class FileHandler - performs a number operations on file
 *
 * A FileHandler object peforms operations on files.  After each operation
 * the FileHandler keeps track of the result of the operations, which the
 * caller may query by invoking the 'getMessage' operation on the object.  The
 * 'getMessage' method returns a String.
 *
 * A FileHandler object performs the following operations:
 *   - createEmptyFile - creates an new (empty) file
 *   - deleteFile - deletes a file
 *   - countBytes - counts the number of bytes in the file.  The result of the
 *     'getMessage' will be a string that tells the number of bytes counted.
 *   - listContents: reads all the bytes in the file.  The result of a 'getMessage'
 *     after this operation is the String containing the contents of the file, where
 *     each byte in the file is treated as a char.
 *   - copyFile - copies the contents of one file to another.  The 'getMessage' string
 *     is an indictation as to whether the copying was successfully done.
 *   - appendString - appends a string to the file
 *
 */
public class FileHandler
{

    /** the message to give to the caller, if asked */
    private String lastMessage;

    /** machine-independent representation of newline character-sequence */
    private static String EOL = System.getProperty("line.separator");

    /**
     * FileHandler constructor - creates a new FileHandler object
     *
     * calling sequence:
     *   fh = new FileHandler();
     *
     * @return the new object
     *
     * side effects:
     *   initializes the object
     *
     * bugs/anomalies:
     *   none known
     *
     */
    public FileHandler()
    {
        lastMessage = "";
    }

    /**
     * getMessage - gives the message that resulted from the most recent
     *              file operation
     *
     * calling sequence:
     *   str - fh.getMessage();
     *
     * @return The object's message.
     *
     * side effects:
     *   none
     *
     * bugs/anomalies:
     *   none known
     *
     */
    public String getMessage() { return lastMessage; }

    /**
     * createEmptyFile - creates a file with no bytes in it.
     *
     * calling sequence:
     *   fh.createEmptyFile(outFileName);
     *
     * @param outFileName the name of the file to be created.
     *
     * side effects:
     *   The object's message-string is changed to reflect the operation's
     *   status.  If a file by that name already exists, it is deleted.
     *
     * bugs/anomalies:
     *   not yet implemented
     *
     */
    public void createEmptyFile(String fileName)
    {
        lastMessage = "";
        try
        {
            PrintWriter outputStream = new PrintWriter(fileName);
            //outputStream.println(lastMessage);
            lastMessage = "File was created successfully";
            outputStream.close();
        }
        catch (FileNotFoundException fnfe)
        {
            lastMessage = "File was not found, exception thrown, you suck.";
        }
        catch (Exception e)
        {
            lastMessage = "Unknown exception was caught, please re evaluate life choices.";
            System.exit(0);
        }
    }

    /**
     * deleteFile - deletes a file
     *
     * calling sequence:
     *   fh.deleteFile(outFileName);
     *
     * @param outFileName  the name of the file to be deleted.
     *
     * side effects:
     *   The object's message-string is changed to reflect the operation's
     *   status.
     *
     * bugs/anomalies:
     *   not yet implemented
     *
     */
    public void deleteFile(String fileName)
    {
        try
        {
            File myFile = new File (fileName);
            if(myFile.delete())
            {
                lastMessage = "Delete operation was done successfully";
            }
            else
            {
                lastMessage = "Delete operation failed.";
            }
        }
        catch (Exception e)
        {
            lastMessage = "Unknown exception was caught, please re evaluate life choices.";
            System.exit(0);
        }    
    }

    /**
     * countBytes - counts the number of bytes in a file
     *
     * calling sequence:
     *   fh.countBytes(inFileName);
     *
     * @param inFileName  the name of the file whose bytes are to be counted
     *
     * @return the number of bytes in the file, or -1 if there was an error
     *   in opening and/or reading the file.
     *
     * side effects:
     *   The object's message-string is changed to reflect the operation's
     *   status.
     *
     * bugs/anomalies:
     *   not yet implemented
     *
     */
    public int countBytes(String fileName)
    {
        int count = 0;
        try
        {
            FileInputStream myInputStream = new FileInputStream(fileName);
            while (myInputStream.available() != 0)
            {
                myInputStream.read();
                ++count;
            }
            lastMessage = Integer.toString(count);
            return count;
        }
        catch(Exception e)
        {
            lastMessage = "Unknown exception was caught, please re evaluate life choices.";
            return -1;
        }
    }

    /**
     * listContents - set's the object's message-string to character-contents
     *             of a file
     *
     * calling sequence:
     *   fh.listContents(inFileName);
     *
     * @param inFileName a string that denotes the file whose contents are to be
     *     examined
     *
     * side effects:
     *   The object's message-string is changed.  If the file-read was successful,
     *   then the message consists of the file's contents.  Otherwise it consists
     *   of a message that the file was not successfully read.
     *
     * bugs/anomalies:
     *   not yet implemented
     *
     */
    public void listContents(String fileName)
    {
        try
        {
            FileInputStream myInputStream = new FileInputStream(fileName);
            Scanner sc = new Scanner(myInputStream);
            while (sc.hasNextLine())
            {
                lastMessage = lastMessage + sc.nextLine() + EOL;
            }
        }
        catch(Exception e)
        {
            lastMessage = "Unknown exception was caught, please re evaluate life choices.";
        }
    }

    /**
     * copyFile - copies the contents of a file to a second file
     *
     * calling sequence:
     *   fh.copyFile(inFileName, outFileName);
     *
     * @param inFileName a string that denotes the file whose contents are to
     *     be copied
     * @param outFileName the file new file to be created
     *
     * side effects:
     *   The file whose name is given by 'outFileName' is created; the contents
     *   of the 'inFileName' file are copied into it.  The object's message-
     *   string is changed to reflect the status of the operation.  If a file
     *   already exists by that name, it is deleted.
     *
     * bugs/anomalies:
     *   not yet implemented
     *
     */
    public void copyFile(String srcName, String dstName)
    {
        lastMessage = "'copyFile' is not yet implemented";
    }

    /**
     * appendString - appends a UTF-format string to the end of a file
     *
     * calling sequence:
     *   fh.appendString(outFileName, aString);
     *
     * @param outFileName the name of the file onto which the number should
     *     be appended
     * @param aString the string to be appended.
     *
     * side effects:
     *   The object's message-string is changed to reflect the operation's
     *   status.  The file is modified by having some bytes appended to it.
     *
     * bugs/anomalies:
     *   not yet implemented
     *
     */
    public void appendString(String fileName, String str)
    {
        try
        {
            FileOutputStream myOutputStream = new FileOutputStream(fileName, true);
            PrintWriter pw = new PrintWriter(myOutputStream);
            char[] chararray = str.toCharArray();
            for (int i = 0; i < chararray.length; ++i)
            {
                pw.append(chararray[i]);
            }
            lastMessage = "The file has successfully been appended to.";
            pw.close();
            myOutputStream.close();
        }
        catch(Exception e)
        {
            lastMessage = "Unknown exception was caught, please re evaluate life choices.";
        }
    }

}//class FileHandler
