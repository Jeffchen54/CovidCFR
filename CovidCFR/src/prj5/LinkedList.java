/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - JC
 */

package prj5;

// Java Doc ................................................................
/**
 * Constructs and manages a List of Doubly-Linked nodes
 * 
 * @param <T>
 *            Type of data to be stored in the LinkedList.
 * @author Jeff Chen (chenjeff4840)
 * @version 11.14.2020
 */
public class LinkedList<T> implements ListInterface<T> {

    // Fields ..................................................................
    private int numberOfEntries;
    private DLNode<T> head;

    // Constructor .............................................................
    /**
     * Constructs an empty LinkedList
     */
    public LinkedList() {
        numberOfEntries = 0;
        head = null;
    }

    // Methods .................................................................


    /** {@inheritDoc} */
    @Override
    public void add(T anEntry) {
        add(numberOfEntries, anEntry);
    }


    /** {@inheritDoc} */
    @Override
    public void add(int position, T anEntry) {
        if (position >= 0 && position <= numberOfEntries) {
            DLNode<T> newNode = new DLNode<>(anEntry);

            if (isEmpty()) {
                head = newNode;
            }
            else if (position == 0) {
                newNode.setNextNode(head);
                head.setPrevNode(newNode);
                head = newNode;
            }
            else if (position == numberOfEntries) {
                DLNode<T> before = getNodeAt(position - 1);
                before.setNextNode(newNode);
            }

            else {
                DLNode<T> before = getNodeAt(position - 1);
                DLNode<T> current = getNodeAt(position);

                newNode.setPrevNode(before);
                before.setNextNode(newNode);

                newNode.setNextNode(current);
                current.setPrevNode(newNode);
            }

            numberOfEntries++;
        }
    }


    /** {@inheritDoc} */
    @Override
    public boolean remove(T anEntry) {
        if (!contains(anEntry)) {
            return false;
        }

        return remove(getPosition(anEntry));
    }


    /** {@inheritDoc} */
    @Override
    public boolean remove(int position) {

        if ((position >= 0) && (position < numberOfEntries)) {

            if (position == 0) {
                head = head.getNextNode();
            }
            else if (position == numberOfEntries - 1) {
                DLNode<T> before = getNodeAt(position - 1);
                before.setNextNode(null);
            }
            else {
                DLNode<T> before = getNodeAt(position - 1);
                DLNode<T> after = before.getNextNode().getNextNode();

                before.setNextNode(after);
                after.setPrevNode(before);
            }
        }
        else {
            return false;
        }

        numberOfEntries--;
        return true;
    }


    /** {@inheritDoc} */
    @Override
    public int getPosition(T anEntry) {
        DLNode<T> search = head;

        for (int i = 0; search != null; i++) {
            if (search.getData().equals(anEntry)) {
                return i;
            }
            search = search.getNextNode();
        }
        return -1;

    }


    /** {@inheritDoc} */
    @Override
    public T getEntry(int position) {
        if ((position < 0) || (position >= numberOfEntries)) {
            throw new IllegalArgumentException();
        }

        DLNode<T> search = head;
        for (int i = 0; i < position; i++) {
            search = search.getNextNode();
        }
        return search.getData();
    }


    /** {@inheritDoc} */
    @Override
    public boolean contains(T anEntry) {

        DLNode<T> search = head;
        while (search != null) {
            if (search.getData().equals(anEntry)) {
                return true;
            }
            search = search.getNextNode();
        }
        return false;
    }


    /** {@inheritDoc} */
    @Override
    public void clear() {
        head = null;
        numberOfEntries = 0;

    }


    /** {@inheritDoc} */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] array = (T[])(new Object[numberOfEntries]);

        DLNode<T> search = head;
        for (int i = 0; i < numberOfEntries; i++) {
            array[i] = search.getData();
            search = search.getNextNode();
        }
        return array;
    }


    /** {@inheritDoc} */
    @Override
    public DLNode<T> getFront() {
        return head;
    }


    /** {@inheritDoc} */
    public DLNode<T> getNodeAt(int position) {
        if ((position < 0) || (position >= numberOfEntries)) {
            throw new IllegalArgumentException();
        }

        DLNode<T> search = head;
        for (int i = 0; i < position; i++) {
            search = search.getNextNode();
        }

        return (DLNode<T>)search;
    }

    // Unique Methods ..........................................................


    /**
     * Returns the number of entries in the list
     * 
     * @return number of entries in the list
     */
    public int getNumberOfEntries() {
        return numberOfEntries;

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
        StringBuilder contents = new StringBuilder();

        contents.append("[");
        DLNode<T> search = head;

        while (search != null) {
            if (search.getNextNode() == null) {
                contents.append(search.getData());
            }
            else {
                contents.append(search.getData() + ", ");
            }
            search = search.getNextNode();
        }

        contents.append("]");
        return contents.toString();
    }
}
