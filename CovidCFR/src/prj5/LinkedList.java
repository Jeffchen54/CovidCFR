/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - JC
 */

package prj5;

// Java Doc ................................................................
/**
 * Constructs and manages a List of Doubly-Linked nodes
 * 
 * @author Jeff Chen (chenjeff4840)
 * @version 11.14.2020
 */
public class LinkedList<T> implements ListInterface<T> {

    // Fields ..................................................................
    private int size;
    private DLNode<T> head;

    // Methods .................................................................
    /**
     * TODO Add description
     */
    public LinkedList() {
        // TODO Auto-generated constructor stub
    }


    /** {@inheritDoc} */
    @Override
    public void add(T anEntry) {
        // TODO Auto-generated method stub

    }


    /** {@inheritDoc} */
    @Override
    public boolean remove(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }


    /** {@inheritDoc} */
    @Override
    public boolean remove(int position) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public int getPosition(T anEntry) {
        // TODO Auto-generated method stub
        return 0;
    }


    /** {@inheritDoc} */
    @Override
    public T getEntry(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    /** {@inheritDoc} */
    @Override
    public boolean contains(T anEntry) {
        // TODO Auto-generated method stub
        return false;
    }


    /** {@inheritDoc} */
    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        return 0;
    }


    /** {@inheritDoc} */
    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }


    /** {@inheritDoc} */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }


    /** {@inheritDoc} */
    @Override
    public T[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }


    /** {@inheritDoc} */
    @Override
    public DLNode<T> getFront() {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * Returns the content the list in the format of an brackets enclosing
     * the contents of the list separated by commas. For example, a list
     * with the contents A, B, C (in order) returns "[A, B, C]" without
     * quotations.
     * 
     * @return Contents of the list in String format.
     */
    @Override
    public String toString() {
        // TODO to be implemented
        return null;
    }

}
