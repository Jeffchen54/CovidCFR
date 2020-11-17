 /** “I have neither given nor received unauthorized
  *  assistance on this assignment.” - AA
 */
package prj5;

import java.lang.reflect.Array;

/**
 * @author Andrew Albro aalbro
 * @version 2020.11.15
 *
 */
public class State extends LinkedList<Race>
{
    private String stateName;
    
    /**
     * This is the constructor
     * for the State class.
     * @param name the name of the state.
     * @param races array of races for the
     * state.
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
     * This class calculates the CFR
     * for the state.
     * @param deaths the deaths from COVID.
     * @param cases the number of cases of COVID.
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
        super.getEntry(0).equals("asian");
        super.getEntry(1).equals("black");
        super.getEntry(2).equals("latino");
        super.getEntry(3).equals("other");
        super.getEntry(4).equals("white");
    }
    
    /**
     * This method sorts the races 
     * by greatest to least by CFR.
     */
    public void sortCFR()
    {
        
    }
    
    /**
     * This method returns a string
     * form of the information of a state.
     */
    public String toString()
    {
        return this.stateName + ":" + " " 
            + "cases" + "," + " " + this.calcCFR(getNumberOfEntries(),
            getNumberOfEntries()) + " " + "CFR";
    }
}
