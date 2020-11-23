/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” -AA
 */

package prj5;

// Java Doc ....................................................................
/**
 * TODO Fill the blanks and add initials to honor code
 * 
 * @author Andrew Albro (aalbro)
 * @version 2020.11.23
 * @param <T>
 *            Type of data stored in objects implementing this interface.
 * @version 11.14.2020
 */

public interface DLNodeInterface<T> {
    
    /**
     * This returns the data of the node.
     * @return the data of the node.
     * @Override
     */
    public T getData();
    
    /**
     * This gets the next node.
     * @return the next node.
     * @Override
     */
    public DLNode<T> getNextNode();
    
    /**
     * This sets the next node
     * of the list.
     * @param node the parameter to 
     * set the next node too.
     */
    public void setNextNode(DLNode<T> node);
    
    /**
     * This sets the current node to
     * the previous node.
     * @return the previous node.
     * @Override
     */
    public DLNode<T> setPrevNode();
    
    /**
     * This gets the previous node 
     * and returns it.
     * @return the previous node.
     */
    public DLNode<T> getPrevNode();
}
