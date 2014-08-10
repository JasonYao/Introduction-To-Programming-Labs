
/**
 * Class that finds a Jelly Bean in a tree
 * 
 * @author CS 273 Student
 * @version **** put the date of completion here ****
 */
public class BeanFinder {

    // the tree object we're searching
    private Tree tree;

    /**
     * constructor
     * 
     * @param tree
     *      the tree object to search
     */
    public BeanFinder(Tree tree) {
        this.tree = tree;
    }

    /**
     * traverses a tree, stopping at a jelly bean of, if not found, back at the
     * starting location
     */
    public void traverse() throws TreeException {
        if (tree.foundTarget())
        {
            return;
        }
        else
        {
            if (tree.canGoLeft())
            {
                tree.moveLeft();
                traverse();
                if (tree.foundTarget())
                {
                    return;
                }
                if(tree.canGoUp())
                {
                    tree.moveUp();
                }
                if(tree.canGoRight())
                {
                    tree.moveRight();
                }
                traverse();
                if (tree.foundTarget())
                {
                    return;
                }
                if(tree.canGoUp())
                {
                    tree.moveUp();
                }
            }
        }
        // this are some EXAMPLE CALLS to Tree methods

        //Recursive Case: If the finder can move left, move left. Then traverse again.
        //base Case: Otherwise, return.

        // CS 273 students should REPLACE these with actual calls

        // if I have found the jelly bean, return immediately so that 
        // we do not move
        //if (tree.foundTarget()) return;

        // move left/down if we can
        //if (tree.canGoLeft()) {
        //  tree.moveLeft();
        //}

        // move right/down if we can
        //         if (tree.canGoRight()) {
        //             tree.moveRight();
        //         }
        //         
        //         // move up if we can
        //         if (tree.canGoUp()) {
        //             tree.moveUp();
        //         }
    }

}
