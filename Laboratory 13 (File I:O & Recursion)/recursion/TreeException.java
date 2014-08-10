//////// CS 273 STUDENTS SHOULD NOT MODIFY THIS CODE ////////

/**
 * Exception that occurs when a movement is made that is
 * off the tree.
 * 
 * @author Steven R. Vegdahl
 * @version 24 November 2013
 */
public class TreeException extends Exception {
    // stores the name (type) of the exception
    private String type;
    
    /**
     * constructor
     * 
     * @param type
     *      the type of the exception
     */
    public TreeException(String type) {
       this.type = type;
    }
    
    /**
     * getter-method for the type
     * 
     * @return
     *      the exception's type
     */
    public String getType() {
        return type;
    }
}
