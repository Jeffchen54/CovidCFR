/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - JC
 */

package prj5;

// Java Doc ....................................................................
/**
 * This is the interface for the LinkedList class
 * 
 * @author Jeff Chen (chenjeff4840)
 * @version 11.14.2020
 */

public interface ListInterface<T> {

    /**
     * Adds an entry at the end of the list
     * 
     * @param anEntry
     *            Entry to be added to the list
     */
    public void add(T anEntry);


    /**
     * Searches the list for the first entry matching anEntry and removes it
     * 
     * @param anEntry
     *            Entry to be removed from the list
     * @return true if entry was removed, false if not
     */
    public boolean remove(T anEntry);


    /**
     * Removes an entry from the list from the given position.
     * 
     * @param position
     *            Position of entry to remove, starts at 0
     * @return true if the entry was removed, false otherwise.
     */
    public boolean remove(int position);


    /**
     * Returns the position of the first entry matching anEntry
     * 
     * @param anEntry
     *            Entry in the list
     * @return position of the entry matching anEntry in the list starting at 0
     *         returns -1 if not found.
     */
    public int getPosition(T anEntry);


    /**
     * Returns the entry at the given position starting at 0. Throws an
     * IllegalArgumentException if position is invalid.
     * 
     * @param position
     *            Position in the list
     * @throws IllegalArgumentException
     * @return Entry's data at that position of the list.
     */
    public T getEntry(int position);


    /**
     * Checks if an Entry in the list matches anEntry
     * 
     * @param anEntry
     *            Entry to check
     * @return true if the list contains anEntry, false otherwise
     */
    public boolean contains(T anEntry);


    /**
     * Clears and resets the list
     */
    public void clear();


    /**
     * Checks if the list is empty
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty();


    /**
     * Returns the list as an array
     * 
     * @return list as an array
     */
    public T[] toArray();


    /**
     * Returns the first entry in the list as a node
     * 
     * @return First node of the list, null if list is empty.
     */
    public DLNode<T> getFront();


    /**
     * Returns the Node at the specified position starting at 0. Throws an
     * IllegalArgumentException if the position given is invalid.
     * 
     * @param position
     *            position of node in list to return
     * @throws IllegalArgumentException
     * @return node at specified position
     */
    public DLNode<T> getNodeAt(int position);


    /**
     * Adds an entry at the specified position, pushing later entries back.
     * 
     * @param anEntry
     *            Entry to add
     * @param position
     *            Position to add the entry to starting at 0.
     */
    public void add(int position, T anEntry);
}
