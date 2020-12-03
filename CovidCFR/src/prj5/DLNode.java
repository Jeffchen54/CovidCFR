/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - AA
 */

package prj5;

// Java Doc ....................................................................
/**
 * Represents a node containing data with reference to next
 * and previous nodes
 * 
 * @param <T>
 *            Type of data to be stored in the DLNode.
 * @author Aziz Abousam (az1zabousam)
 * @version 11.16.2020
 */
public class DLNode<T> implements DLNodeInterface<T>{

    // Fields ..................................................................
    private T data;
    private DLNode<T> next;
    private DLNode<T> previous;

    // Constructor .............................................................
    /**
     * Uses other constructor to create a doubly-linked node with no
     * next node
     * 
     * @param nodeData
     *            Node's data
     */
    public DLNode(T nodeData) {
        this(nodeData, null, null);
    }


    /**
     * Creates node with data and reference to next node
     * 
     * @param nodeData
     *            Node's data
     * @param prevNode
     *            Previous node in sequence
     * @param nextNode
     *            Next node in sequence
     */
    public DLNode(T nodeData, DLNode<T> prevNode, DLNode<T> nextNode) {
        data = nodeData;
        previous = prevNode;
        next = nextNode;
    }

    // Methods .................................................................


    /**
     * Getter method for data of node
     * 
     * @return Data for node
     */
    @Override
    public T getData() {
        return data;
    }


    /**
     * Getter method for next node in sequence
     * 
     * @return Next node
     */
    @Override
    public DLNode<T> getNextNode() {
        return next;
    }


    /**
     * Getter method for previous node in sequence
     * 
     * @return Previous node
     */
    @Override
    public DLNode<T> getPrevNode() {
        return previous;
    }


    /**
     * Setter method for next node in sequence
     * 
     * @param newNode
     *            New reference for next node
     */
    @Override
    public void setNextNode(DLNode<T> newNode) {
        next = newNode;
    }


    /**
     * Setter method for previous node in sequence
     * 
     * @param newNode
     *            New reference for previous node
     */
    @Override
    public void setPrevNode(DLNode<T> newNode) {
        previous = newNode;
    }
}
