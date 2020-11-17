 /** “I have neither given nor received unauthorized
  *  assistance on this assignment.” - AA
  *  */
package prj5;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

/**
 * @author Andrew Albro aalbro
 * @version 2020.11.16
 *
 */
public class StateTest extends TestCase
{
    private Race races;
    private State state;
    
    /**
     * This tests the sortAlpha method.
     */
    public void testSortAlpha()
    {
        state.sortAlpha();
        assertEquals(state.getNumberOfEntries(), 5);
        assertEquals(state.getFront(), "asian");
    }
    
    /**
     * This tests the sortCFR method.
     */
    public void testSortCFR()
    {
        state.sortCFR();
        assertEquals(state.getNumberOfEntries(), 5);
        assertEquals(state.getFront(), "black");    
    }
    
    /**
     * This tests the toString method.
     */
    public void testToString()
    {
        races = new Race("VA", 100, 10);
        state = new State("VA", races);   
        assertEquals(state.toString(), "white" + ":" + " "
            + 100 + " " + "cases" + "," + " " + "10.0%" 
            + " " + "CFR");
    }
    

}
