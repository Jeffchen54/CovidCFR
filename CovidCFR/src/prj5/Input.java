/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - ARA, JC
 */
package prj5;

import java.io.FileNotFoundException;

import java.util.Iterator;

/**
 * Project runner for Project 5.
 * 
 * @author Andrew Albro aalbro
 * @author Jeff Chen (chenjeff4840)
 * @version 2020.11.18
 */
public class Input {

    /**
     * Reads a file containing States' CFR information and displays it from
     * greatest to least CFR order and alphabetical order based on state's
     * name. Hardcoded for 6 states only.
     * 
     * @param args
     *            String array containing the filename. If length is 1, args
     *            will be used for the filename; else, a default file will be
     *            used.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        if (args.length == 0) {
            fileName = "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv";
        }
        else {
            fileName = args[0];
        }

        CovidReader read = new CovidReader(fileName);
        State[] states = read.getAllStates();

        for (int i = 0; i < 6; i++) {
            System.out.println(states[i].getStateName());
            displayIterator(states[i].sortAlpha());
            System.out.println("====");
            displayIterator(states[i].sortCFR());
            System.out.println("====");
        }
    }


    /**
     * Displays the contents of an iterator using each item's toString method.
     * 
     * @param iter
     *            Iterator to be displayed.
     */
    private static void displayIterator(Iterator<Race> iter) {
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
