/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - AA
 */

package prj5;

import student.TestCase;

/**
 * Ensure methods within the Race class are working as intended
 * 
 * @author Aziz Abousam (az1zabousam)
 * @version 2020.16.11
 */
public class RaceTest extends TestCase {
    private Race race;
    
    /**
     * The setUp method is used to initialize initial
     * conditions and will run before every test method
     */
    public void setUp() {
        race = new Race("black", 179563, 13365);
    }
    
    /**
     * Ensure the private helper method calcCFR(int, int) used
     * within the constructor is correctly calculating and 
     * setting the CFR
     */
    public void testRace() {
        assertEquals(7.44, race.getCFR(), 0.01);
        race = new Race("black", 179563, -1);
        assertEquals(-1, race.getCFR(), 0.01);
        race = new Race("black", -1, 13365);
        assertEquals(-1, race.getCFR(), 0.01);
        race = new Race("black", -1, -1);
        assertEquals(-1, race.getCFR(), 0.01);
    }
    
    /**
     * Ensure getName() returns the correct name of the race
     */
    public void testGetName() {
        assertEquals("black", race.getName());
    }
    
    /**
     * Ensure getCFR() returns the CFR for the race
     */
    public void testGetCFR() {
        assertEquals(7.44, race.getCFR(), 0.01);
    }
}
