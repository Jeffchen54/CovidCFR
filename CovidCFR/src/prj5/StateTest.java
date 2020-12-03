/**
 * “I have neither given nor received unauthorized
 * assistance on this assignment.” - AA
 */
package prj5;

import student.TestCase;
import java.util.Iterator;

/**
 * Tests the State class.
 * 
 * @author Andrew Albro aalbro
 * @author Jeff Chen (chenjeff4840)
 * @version 2020.11.16
 *
 */
public class StateTest extends TestCase {
    private State state;

    /**
     * Creates a state with 5 races in random order before each test.
     */
    public void setUp() {
        Race[] races = new Race[5];
        races[4] = new Race("asian", 5407, 254);
        races[3] = new Race("black", 179563, 13365);
        races[0] = new Race("latino", 97118, 2269);
        races[1] = new Race("other", 108784, 170);
        races[2] = new Race("white", 70678, 1924);
        state = new State("DC", races);
    }


    /**
     * This tests the sortAlpha method and it's iterator and the toString 
     * method.
     */
    public void testSortAlphaToString() {
        Iterator<Race> iter = state.sortAlpha();
        assertEquals(state.getNumberOfEntries(), 5);
        assertEquals(state.toString(), "asian: 5407 cases, 4.7% CFR\n"
            + "black: 179563 cases, 7.4% CFR\nlatino: 97118 cases, 2.3% CFR\n"
            + "other: 108784 cases, 0.2% CFR\nwhite: 70678 cases, 2.7% CFR");

        assertTrue(iter.hasNext());

        assertEquals("asian", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("black", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("latino", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("other", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("white", iter.next().getName());
        assertFalse(iter.hasNext());

        assertNull(iter.next());
    }


    /**
     * This tests the sortCFR method and it's iterator. Also tests the toString
     * method.
     */
    public void testSortCFRToString() {
        Iterator<Race> iter = state.sortCFR();
        assertEquals(state.getNumberOfEntries(), 5);
        assertEquals(state.toString(), "black: 179563 cases, 7.4% CFR\n"
            + "asian: 5407 cases, 4.7% CFR\nwhite: 70678 cases, 2.7% CFR\n"
            + "latino: 97118 cases, 2.3% CFR\nother: 108784 cases, 0.2% CFR");

        assertTrue(iter.hasNext());

        assertEquals("black", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("asian", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("white", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("latino", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("other", iter.next().getName());
        assertFalse(iter.hasNext());

        assertNull(iter.next());
    }
    
    /**
     * Tests the getStateName() method
     */
    public void testGetStateName() {
        assertEquals("DC", state.getStateName());
    }
    
    /**
     * Tests the getIterator() method
     */
    public void testGetIterator() {
        Iterator<Race> iter = state.getIterator();
        
        assertTrue(iter.hasNext());

        assertEquals("latino", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("other", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("white", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("black", iter.next().getName());
        assertTrue(iter.hasNext());

        assertEquals("asian", iter.next().getName());
        assertFalse(iter.hasNext());

        assertNull(iter.next());
    }

}
