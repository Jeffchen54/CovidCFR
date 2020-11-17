/**
 * â€œI have neither given nor received unauthorized assistance on this
 * assignment.â€� - Aziz Abousam
 */

package prj5;

// Java Doc ....................................................................
/**
 * Reads the file containing CFR data for each state
 * 
 * @author Aziz Abousam (az1zabousam)
 * @version 11.16.2020
 */
public class Race {
    // Fields ..................................................................
    private double CFR;
    private String name;
    
    // Constructor .............................................................
    // Constructor .............................................................
    /**
     * Assigns state name and calls the helper method to calculate
     * the CFR for the race.
     * 
     * @param raceName
     *              Name representing the race.
     * @param cases
     *              Amount of COVID-19 cases in the state
     * @param fatality
     *              Amount of deaths due to COVID-19 in the state
     */
    public Race(String raceName, int cases, int fatality) {
        name = raceName;
        CFR = calcCFR(cases, fatality);
    }
    
    // Methods .................................................................
    
    /**
     * This private helper method will calculate the fatality
     * percentage of COVID-19 cases for the associated race
     *
     * @param cases
     *              Amount of COVID-19 cases for the race
     * @param fatality
     *              Amount of deaths due to COVID-19 for the race
     */
    private double calcCFR(int cases, int fatality) {
        if (cases == -1 || fatality == -1) {
            return -1;
        }
        return ( ((double)fatality / (double)cases) * 100 );
    }
    
    /**
     * This getter method will retrieve the string representing
     * the name of the race
     *
     * @return Name of the race
     */
    public String getName() {
        return name;
    }
    
    /**
     * This getter method will retrieve the percentage of COVID-19
     * cases resulting in fatality for the associated race
     *
     * @return CFR
     */
    public double getCFR() {
        return CFR;
    }
}