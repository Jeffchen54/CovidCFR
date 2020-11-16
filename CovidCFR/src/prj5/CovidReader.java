/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - JC
 */

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Java Doc ....................................................................
/**
 * Reads the file containing CFR data for each state
 * 
 * @author Jeff Chen (chenjeff4840)
 * @version 11.16.2020
 */
public class CovidReader {

    // Fields ..................................................................
    private State[] states;

    // Constructor .............................................................
    /**
     * Reads from a file containing State CFR whose name matches the user's
     * input.
     * 
     * @param filename
     *            Name of the file containing State CFR information
     * @throws FileNotFoundException
     */
    public CovidReader(String filename) throws FileNotFoundException {
        states = readStateFile(filename);
        // TODO Calls the CovidGUI class.
    }

    // Methods .................................................................


    /**
     * Returns all of the States.
     * 
     * @return array containing all of the states.
     */
    public State[] getAllStates() {
        return states;
    }


    /**
     * Reads info from a file containing State CFRs and returns it. Hardcoded
     * to handle exactly 6 states from an input file with project specific
     * formatting. Throws FileNotFoundException if file matching filename
     * cannot be found.
     * 
     * @param filename
     *            Name of the states CFR file
     * @throws FileNotFoundException
     * @return info gathered from the CFR file.
     * @precondition File follows project spec of line 1 as a header followed
     *               by 6 lines representing State CFRs containing state name in
     *               the first
     *               column followed by 10 columns with case and death info.
     */
    private State[] readStateFile(String filename)
        throws FileNotFoundException {

        State[] inputStates = new State[6];
        Scanner file = new Scanner(new File(filename));

        file.nextLine();

        for (int i = 0; i < 6; i++) {

            String[] line = file.nextLine().split("\\s+");
            Race[] races = new Race[5];
            String[] raceNames = { "white", "black", "latinx", "asian",
                "other" };

            for (int n = 0; n < 5; n++) {
                races[n] = new Race(raceNames[n], convertInt(line[n + 1]),
                    convertInt(line[n + 6]));
            }

            inputStates[i] = new State(line[0], races);
        }

        file.close();
        return inputStates;
    }


    /**
     * Converts a string to an integer. If the string cannot be parsed into
     * an integer, a -1 is returned.
     * 
     * @param str
     *            String to parse into an integer
     * @return Integer parsed from str, -1 if cannot be parsed.
     */
    private int convertInt(String str) {
        try {
            int num = Integer.parseInt(str);
            return num;
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }
}
