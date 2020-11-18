/**
 * “I have neither given nor received unauthorized
 * assistance on this assignment.” - AA
 */
package prj5;

import student.TestCase;
import java.util.Iterator;

/**
 * @author Andrew Albro aalbro
 * @author Jeff Chen (chenjeff4840)
 * @version 2020.11.16
 *
 */
public class StateTest extends TestCase {
    private Race[] races;
    private State state;

    public void setUp() {
        races = new Race[5];
        races[4] = new Race("asian", 5407, 254);
        races[3] = new Race("black", 179563, 13365);
        races[0] = new Race("latino", 97118, 2269);
        races[1] = new Race("other", 108784, 170);
        races[2] = new Race("white", 70678, 1924);
        state = new State("DC", races);
    }


    /**
     * This tests the sortAlpha method and it's iterator.
     */
    public void testSortAlpha() {
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

    }


    /**
     * This tests the sortCFR method and it's iterator.
     */
    public void testSortCFR() {
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
    }

}
