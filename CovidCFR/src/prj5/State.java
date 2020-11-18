/**
 * “I have neither given nor received unauthorized
 * assistance on this assignment.” - AA
 */
package prj5;

import java.util.Iterator;

/**
 * @author Andrew Albro aalbro
 * @version 2020.11.15
 *
 */
public class State extends LinkedList<Race> {
    private String stateName;
    private DLNode<Race> head;

    /**
     * This is the constructor for the State class.
     * 
     * @param name
     *            the name of the state.
     * @param races
     *            array of races for the state.
     */
    public State(String name, Race[] races) {
        this.stateName = name;
        for (int i = 0; i < 5; i++) {
            this.add(races[i]);
        }

        head = super.getFront();
    }
    
    /**
     * Returns the state's name
     * 
     * @return name of the state.
     */
    public String getStateName() {
        return stateName;
    }


    /**
     * This method sorts the races
     * into alphabetical order.
     */
    public void sortAlpha() {
        for (int i = 1; i < super.getNumberOfEntries(); i++) {
            alphaSort(i);
        }
    }


    /**
     * Provides the sorting functionality for the sortAlpha method. Uses the
     * sorted and unsorted linkedchain method.
     * 
     * @param startingIndex
     *            Index to sort and index where the unsorted portion
     *            begins.
     * @return iterator of the alphabetically sorted list.
     * @author Jeff Chen (chenjeff4848)
     */
    private StateIterator alphaSort(int startingIndex) {
        Race alpha = super.getNodeAt(startingIndex).getData();
        DLNode<Race> otherNode = head;
        boolean found = false;

        for (int i = 0; i < startingIndex && !found; i++) {
            if (alpha.getName().compareTo(otherNode.getData().getName()) < 0) {
                found = true;
                super.remove(startingIndex);
                super.add(i, alpha);
            }

            otherNode = otherNode.getNextNode();
        }
        return new StateIterator();
    }


    /**
     * This sorts the CFR in order.
     * 
     * @param start
     *            the start of the
     *            index.
     * @return iterator of the greatest to least CFR list.
     */
    private StateIterator CFRSort(int start) {
        Race race = super.getNodeAt(start).getData();
        DLNode<Race> node2 = super.getFront();
        boolean flag = false;
        int i = 0;
        while (i < start && !flag) {
            if (race.getCFR() > node2.getData().getCFR()) {
                flag = true;
                this.remove(start);
                this.add(i, race);
            }
            i++;
            node2 = node2.getNextNode();
        }
        return new StateIterator();
    }


    /**
     * This method sorts the races by greatest to least by CFR.
     */
    public void sortCFR() {
        for (int i = 1; i < super.getNumberOfEntries(); i++) {
            this.CFRSort(i);
        }
    }


    /**
     * This method returns a string form of the information of a state.
     * 
     * @return the states information as a string.
     */
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(this.getEntry(0));
        build.append("\n" + this.getEntry(1));
        build.append("\n" + this.getEntry(2));
        build.append("\n" + this.getEntry(3));
        build.append("\n" + this.getEntry(4));
        return build.toString();
    }

    /**
     * Iterator which iteratates starting from the beginning of the list to
     * the end.
     * 
     * @author Jeff Chen (chenjeff4840)
     * @version 11.18.2020
     */
    private class StateIterator implements Iterator<Race> {

        private DLNode<Race> cursor;

        /**
         * Initializes the iterator by setting the cursor to the first node.
         */
        public StateIterator() {
            cursor = head;
        }


        /** {@inheritDoc} */
        @Override
        public boolean hasNext() {

            return cursor == null;
        }


        /** {@inheritDoc} */
        @Override
        public Race next() {
            if (!hasNext()) {
                return null;
            }

            Race data = cursor.getData();
            cursor = cursor.getNextNode();
            return data;
        }

    }
}
