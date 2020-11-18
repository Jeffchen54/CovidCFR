/** “I have neither given nor received unauthorized
 *  assistance on this assignment.” - AA
 */
package prj5;

/**
 * @author Andrew Albro aalbro
 * @version 2020.11.15
 *
 */
public class State extends LinkedList<Race>
{
    private String stateName;

    /**
     * This is the constructor for the State class.
     * 
     * @param name  the name of the state.
     * @param races array of races for the state.
     */
    public State(String name, Race[] races)
    {
        this.stateName = name;
        for (int i = 0; i < 5; i++)
        {
            this.add(races[i]);
        }
    }

    /**
     * This class calculates the CFR for the state.
     * 
     * @param deaths the deaths from COVID.
     * @param cases  the number of cases of COVID.
     * @return the CFR of the state.
     */
    private double calcCFR(double deaths, double cases)
    {
        if ((deaths == -1 || cases == -1))
        {
            return -1.0;
        }
        return (deaths) / (cases) * 100;
    }

    /**
     * This method sorts the races
     * into alphabetical order.
     */
    public void sortAlpha()
    {
        for(int i = 1; i < super.getNumberOfEntries(); i++) {
            alphaSort(i);
        }
    }

    /**
     * Provides the sorting functionality for the sortAlpha method. Uses the
     * sorted and unsorted linkedchain method.
     * 
     * @param startingIndex
     *                  Index to sort and index where the unsorted portion
     *                  begins.
     * @author Jeff Chen (chenjeff4848)
     */
    private void alphaSort(int startingIndex) {
        Race alpha = super.getNodeAt(startingIndex).getData();
        DLNode<Race> otherNode = super.getFront();
        boolean found = false;

        for(int i = 0; i < startingIndex && !found; i++) { 
            if(alpha.getName().compareTo(otherNode.getData().getName()) < 0){
                found = true;
                super.remove(startingIndex);
                super.add(i, alpha);
            }

            otherNode = otherNode.getNextNode();
        }
    }
    
    /**
     * This sorts the CFR in order.
     * @param start the start of the 
     * index.
     */
    private void CFRSort(int start)
    {
        Race race = super.getNodeAt(start).getData();
        DLNode<Race> node2 = super.getFront();
        boolean flag = false;
        int i = 0;
        while (i < start && !flag)
        {
            if (race.getCFR() > node2.getData().getCFR())
            {
                flag = true;
                this.remove(start);
                this.add(i, race);
            }
            i++;
            node2 = node2.getNextNode();
        }
    }

    /**
     * This method sorts the races by greatest to least by CFR.
     */
    public void sortCFR()
    {
        for (int i = 1; i < super.getNumberOfEntries(); i++)
        {
            this.CFRSort(i);    
        }
    }

    /**
     * This method returns a string form of the information of a state.
     * @return the states information as a string.
     */
    public String toString()
    {
        StringBuilder build = new StringBuilder();
        build.append(this.getEntry(0));
        build.append("\n" + this.getEntry(1));
        build.append("\n" + this.getEntry(2));
        build.append("\n" + this.getEntry(3));
        build.append("\n" + this.getEntry(4));
        return build.toString();
    }
}
