/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” -AA
 */

package prj5;

// Java Doc ....................................................................
/**
 * Interface for the DLNode class.
 * 
 * @author Andrew Albro (aalbro)
 * @version 2020.11.16
 * @param <T>
 *            Type of data stored in objects implementing this interface.
 */

public interface DLNodeInterface<T> {

    /**
     * This returns the data of the node.
     * 
     * @return the data of the node.
     */
    public T getData();


    /**
     * This gets the next node.
     * 
     * @return the next node.
     */
    public DLNode<T> getNextNode();


    /**
     * Sets the next node
     * 
     * @param node
     *            the parameter to
     *            set the next node too.
     */
    public void setNextNode(DLNode<T> node);


    /**
     * Sets the previous node 
     * 
     * @param newNode
     *              node to set previous
     */
    public void setPrevNode(DLNode<T> newNode);


    /**
     * This gets the previous node
     * and returns it.
     * 
     * @return the previous node.
     */
    public DLNode<T> getPrevNode();
}
