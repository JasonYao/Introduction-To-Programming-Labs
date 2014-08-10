//////////////////////////////////////////////////////////////////
// GoFrame.java - implements certain aspects of the game of "Go"
//////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////
// class GoFrame - an Frame that represents/displays a Go board
//////////////////////////////////////////////////////////////////
public class GoFrame extends GoBaseFrame {

    // symbolic constants, representing stones on the board
    public static final int WHITE = 0;
    public static final int BLACK = 1;
    public static final int EMPTY = 2;
    public static final int WHITEINPERIL = 3;
    public static final int BLACKINPERIL = 4;

    //////////////////////////////////////////////////////////////////
    // clearBoard method - clears the board of all stones
    // 
    // status: dummied up
    // 
    //////////////////////////////////////////////////////////////////
    protected void clearBoard() {
        for (int j = 0; j < board.length; ++j)
        {
            for(int i = 0; i < board.length; ++i)
            {
                board[j][i] = EMPTY;
            }
        }
    }

    //////////////////////////////////////////////////////////////////
    // pressedOnSpace method - if col,row is a legal location on the board
    //   modifies the location by either changing the stone's color, or
    //   by adding or removing a stone
    //
    // parameters:
    //   col - the horizontal position of the spot on the board, with 0
    //       representing the left of the board
    //   row - the vertical position of the spot on the board, with 0
    //       representing the top of the board
    // 
    // status: dummied up
    //
    //////////////////////////////////////////////////////////////////
    protected void pressedOnSpace(int col, int row)
    {
        // at this point, col contains the column-coordinate denoting the square
        // that was pressed, and row contains the row-coordinate
        if ((row < 0) || (row >= board.length))
        {
            // Don't do anything, all accoding to plan
        }
        else if ((col < 0) || (col >= board[row].length) )
        {
            // Don't do anything, all according to plan
        }
        else
        {
            if ((board[row][col] == WHITE))
            {
                board[row][col] = BLACK;
            }
            else if (board[row][col] == BLACK)
            {
                board[row][col] = EMPTY;
            }
            else if (board[row][col] == EMPTY)
            {
                board[row][col] = WHITE;
            }
        }
    }

    //////////////////////////////////////////////////////////////////
    // randomizeBoard method - places stones randomly on the board, with
    //   approximately 20% of the spaces blank, 40% black, 40% white
    // 
    // status: dummied up
    //
    //////////////////////////////////////////////////////////////////
    protected void randomizeBoard()
    {
        // Randomizes the colors of the pieces on the board.
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[i].length;++j)
            {
                double rand = Math.random();
                if ((rand >= 0.0) && (rand < 0.2))
                {
                    board[i][j] = EMPTY;
                }
                else if ((rand >= 0.2) && (rand < 0.6))
                {
                    board[i][j] = BLACK;
                }
                else
                {
                    board[i][j] = WHITE;
                }
            }
        }

    }

    //////////////////////////////////////////////////////////////////
    // removeCapturedStones method - Determine which stones are
    //   captured and remove them from the board
    //
    // status: dummied up
    //
    //////////////////////////////////////////////////////////////////
    protected void removeCapturedStones() {
        // Iterates through the board, changing everything to WHITEINPERIL if it is white
        // Iterates through the rows
        for (int row = 0; row < board.length; ++row)
        {
            //Iterates through the columns
            for (int col = 0; col < board[row].length; ++ col)
            {
                // Turns all the white stones to in peril
                if (board[row][col] == WHITE)
                {
                    board[row][col] = WHITEINPERIL;
                }
                
                // Turns all the black stones to in peril
                if (board[row][col] == BLACK)
                {
                    board[row][col] = BLACKINPERIL;
                }
            }
        }
        
        
        // Change boolean
        boolean change = false;
        
        while (change == false)
        {
            change = true;
            // Iterates through the board again, turning the WHITEINPERIL pieces next to an empty space into WHITE
            for (int i = 0; i < board.length; ++ i)
            {
                for (int j = 0; j < board[i].length; ++j)
                {
                    // If one of the surrounding spaces showed WHITE or EMPTY, sets the core colour to WHITE
                    if (board[i][j] == WHITEINPERIL)
                    {
                        if (checkSpace(i, j, WHITE) == true)
                        {
                            board[i][j] = WHITE;
                            change = false;
                        }
                    }
                    
                    // If one of the surrounding spaces showed BLACK or EMPTY, sets the core colour to BLACK
                    if (board[i][j] == BLACKINPERIL)
                    {
                        if (checkSpace(i, j, BLACK) == true)
                        {
                            board[i][j] = BLACK;
                            change = false;
                        }
                    }
                }
            }
        } // End while loop
        
        for (int i = 0; i < board.length; ++i)
        {
            for (int j = 0; j < board[i].length; ++j)
            {
                if (board[i][j] == WHITEINPERIL)
                {
                    board[i][j] = EMPTY;
                }
                
                if (board[i][j] == BLACKINPERIL)
                {
                    board[i][j] = EMPTY;
                }
            }
        }
    }

    /**
     * Helper method: used to check that the row and column sent in is a valid place to check- if it is valid, returns true
     * @param row
     * @param col
     */
    private boolean isValid(int row, int col)
    {
        if ((row < 0) || (row >= board.length) || (col < 0) || (col >= board[row].length))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Helper Method: Checks the surrounding areas if there is an empty space, returns true if there is, returns false if no
     */
    private boolean checkSpace(int i, int j, int colour)
    {
        // Checks the top validity
        if (isValid(i - 1, j))
        {
            // Checks the top for empty or same colour pieces
            if ((board[i - 1][j] == colour) || (board[i - 1][j] == EMPTY))
            {
                return true;
            }
        }

        // Checks the Left validity
        if (isValid(i, j - 1))
        {
            // Checks the left for empty or same colour pieces
            if ((board[i][j - 1] == colour) || (board[i][j - 1] == EMPTY))
            {
                return true;
            }
        }

        // Checks the bottom validity
        if (isValid(i + 1, j))
        {
            // Checks the bottom for empty or same colour pieces
            if ((board[i + 1][j] == colour) || (board[i + 1][j] == EMPTY))
            {
                return true;
            }
        }

        // Checks the Right validity
        if (isValid(i, j + 1))
        {
            // Checks the right for empty or same colour pieces
            if ((board[i][j + 1] == colour) || (board[i][j + 1] == EMPTY))
            {
                return true;
            }
        }
        else
        {
            return false;
        }
        return false;
    }
    ///////////////////////////////////////////////////////////////////
    //*****************************************************************
    //**CS 273 students should not need to modify anything below here**
    //*****************************************************************
    ///////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////
    // main method - creates and displays frame
    //
    // status: complete
    //
    //////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        (new GoFrame()).setVisible(true);
    }

}
