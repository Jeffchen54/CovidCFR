/**
 * "I have neither given nor received unauthorized assistance on this
 * assignment." - Aziz Abousam, JC
 */

package prj5;

import java.text.DecimalFormat;

/**
 * Reads the file containing CFR data for each state
 * 
 * @author Aziz Abousam (az1zabousam)
 * @version 11.16.2020
 */
public class Race {

    private double CFR;
    private String name;
    private int cases;

    /**
     * Assigns state name and calls the helper method to calculate
     * the CFR for the race.
     * 
     * @param raceName
     *            Name representing the race.
     * @param cases
     *            Amount of COVID-19 cases in the state
     * @param fatality
     *            Amount of deaths due to COVID-19 in the state
     */
    public Race(String raceName, int cases, int fatality) {
        name = raceName;
        this.cases = cases;
        CFR = calcCFR(cases, fatality);
    }


    /**
     * This private helper method will calculate the fatality
     * percentage of COVID-19 cases for the associated race
     *
     * @param cases
     *            Amount of COVID-19 cases for the race
     * @param fatality
     *            Amount of deaths due to COVID-19 for the race
     * @return CFR calculated using the parameters cases and fatality.
     */
    private double calcCFR(int cases, int fatality) {
        if (cases == -1 || fatality == -1) {
            return -1;
        }
        return (((double)fatality / (double)cases) * 100);
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


    /**
     * Returns the Race in the format "Race: x cases, x.x% CFR" with no
     * quotations and numbers instead of x. Only 1 decimal place.
     * 
     * @author Jeff Chen (chenjeff4848)
     * @return race name, number of cases, and CFR.
     */
    @Override
    public String toString() {
        StringBuilder contents = new StringBuilder();
        contents.append(name + ": ");
        contents.append(cases + " cases, ");

        DecimalFormat df = new DecimalFormat("0.#");
        contents.append(df.format(CFR) + "% CFR");
        return contents.toString();
    }
}
