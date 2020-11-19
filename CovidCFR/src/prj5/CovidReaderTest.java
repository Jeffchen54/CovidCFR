package prj5;

import student.TestCase;
import java.io.FileNotFoundException;

// Java Doc ....................................................................
/**
 * Tests the CovidReader class
 * 
 * @author Jeff Chen (chenjeff4840)
 * @version 11.18.2020
 */
public class CovidReaderTest extends TestCase {

    // SetUp ...................................................................
    /**
     * Intentionally left empty as 2 separate csv files will be used
     * for testing.
     */
    public CovidReaderTest() {
        // Intentionally left empty
    }

    // Tests ...................................................................


    /**
     * Tests a csv files in the proper format. Tested using toString as
     * output must match project spec.
     */
    public void testNormalCase() {

        try {
            CovidReader contents = new CovidReader(
                "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv");

            State[] states = contents.getAllStates();
            assertEquals("DC", states[0].getStateName());
            states[0].sortAlpha();
            assertEquals("asian: 55264 cases, 16.8% CFR"
                + "\nblack: 38347 cases, 0.9% CFR"
                + "\nlatinx: 29945 cases, 15.3% CFR"
                + "\nother: 68227 cases, 8.5% CFR"
                + "\nwhite: 85454 cases, 0.3% CFR", states[0].toString());

            assertEquals("GA", states[1].getStateName());
            states[1].sortAlpha();
            assertEquals("asian: 55816 cases, 13.5% CFR"
                + "\nblack: 30341 cases, 9.6% CFR"
                + "\nlatinx: 11740 cases, 81.8% CFR"
                + "\nother: 56230 cases, 15.1% CFR"
                + "\nwhite: 56845 cases, 3.6% CFR", states[1].toString());

            assertEquals("MD", states[2].getStateName());
            states[2].sortAlpha();
            assertEquals("asian: 62800 cases, 14.5% CFR"
                + "\nblack: 24422 cases, 30.4% CFR"
                + "\nlatinx: 35777 cases, 1.9% CFR"
                + "\nother: 16290 cases, 38.6% CFR"
                + "\nwhite: 92158 cases, 0.5% CFR", states[2].toString());

            assertEquals("NC", states[3].getStateName());
            states[3].sortAlpha();
            assertEquals("asian: 80950 cases, 2.7% CFR"
                + "\nblack: 29158 cases, 0.9% CFR"
                + "\nlatinx: 55944 cases, 8.8% CFR"
                + "\nother: 58937 cases, 2.4% CFR"
                + "\nwhite: 78457 cases, 11.5% CFR", states[3].toString());

            assertEquals("TN", states[4].getStateName());
            states[4].sortAlpha();
            assertEquals("asian: 31972 cases, 8.4% CFR"
                + "\nblack: 72620 cases, 10.6% CFR"
                + "\nlatinx: 37223 cases, 4.3% CFR"
                + "\nother: 36822 cases, 5.8% CFR"
                + "\nwhite: 10350 cases, 52.7% CFR", states[4].toString());

            assertEquals("VA", states[5].getStateName());
            states[5].sortAlpha();
            assertEquals("asian: 37276 cases, 10.7% CFR"
                + "\nblack: 17344 cases, 56.6% CFR"
                + "\nlatinx: 36689 cases, 25% CFR"
                + "\nother: 60088 cases, 1.2% CFR"
                + "\nwhite: 85505 cases, 9.7% CFR", states[5].toString());

            assertEquals(6, states.length);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Tests a csv file containing NAs
     */
    public void testNAOutput() {

        try {
            CovidReader contents = new CovidReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

            State[] states = contents.getAllStates();
            assertEquals("DC", states[0].getStateName());
            states[0].sortCFR();
            assertEquals("black: 179563 cases, 7.4% CFR"
                + "\nasian: 5407 cases, 4.7% CFR"
                + "\nwhite: 70678 cases, 2.7% CFR"
                + "\nlatinx: 97118 cases, 2.3% CFR"
                + "\nother: 108784 cases, 0.2% CFR", states[0].toString());

            assertEquals("GA", states[1].getStateName());
            states[1].sortCFR();
            assertEquals("white: 1122398 cases, 4.5% CFR"
                + "\nblack: 1199125 cases, 4.2% CFR"
                + "\nasian: 60426 cases, 3.1% CFR"
                + "\nlatinx: 601778 cases, 1% CFR"
                + "\nother: 1542083 cases, 0.1% CFR", states[1].toString());

            assertEquals("MD", states[2].getStateName());
            states[2].sortCFR();
            assertEquals("asian: 47733 cases, 8.4% CFR"
                + "\nwhite: 534910 cases, 8.4% CFR"
                + "\nblack: 764514 cases, 5.6% CFR"
                + "\nlatinx: 635420 cases, 1.8% CFR"
                + "\nother: 539893 cases, 0.4% CFR", states[2].toString());

            assertEquals("NC", states[3].getStateName());
            states[3].sortCFR();
            assertEquals("black: 525056 cases, 3.2% CFR"
                + "\nwhite: 1202651 cases, 2.5% CFR"
                + "\nasian: 41305 cases, 1.8% CFR"
                + "\nother: 1192110 cases, 0.5% CFR"
                + "\nlatinx: 787616 cases, -1% CFR", states[3].toString());

            assertEquals("TN", states[4].getStateName());
            states[4].sortCFR();
            assertEquals("black: 491709 cases, 1.9% CFR"
                + "\nasian: 25846 cases, 1.6% CFR"
                + "\nwhite: 1140754 cases, 1.5% CFR"
                + "\nother: 847967 cases, 0.3% CFR"
                + "\nlatinx: 443364 cases, -1% CFR", states[4].toString());

            assertEquals("VA", states[5].getStateName());
            states[5].sortCFR();
            assertEquals("white: 616402 cases, 5.6% CFR"
                + "\nblack: 426362 cases, 3.4% CFR"
                + "\nother: 777332 cases, 0.7% CFR"
                + "\nasian: -1 cases, -1% CFR"
                + "\nlatinx: 738177 cases, -1% CFR", states[5].toString());

            assertEquals(6, states.length);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
