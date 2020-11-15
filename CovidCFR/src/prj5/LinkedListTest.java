/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - JC
 */

package prj5;

import student.TestCase;

// Java Doc ....................................................................
/**
 * Tests the LinkedList class.
 *
 * @author Jeff Chen (chenjeff4840)
 * @version 11.14.2020
 */
public class LinkedListTest extends TestCase {

    // Fields ..................................................................
    private LinkedList<String> list;

    // Set Up ..................................................................
    /**
     * Creates an empty list before each test
     */
    public void setUp() {
        list = new LinkedList<>();
    }

    // Tests ...................................................................


    /**
     * Tests the add(T) method
     */
    public void testAdd() {
        list.add("Konnichiwa");
        assertEquals(1, list.getLength());
        assertEquals("[Konnichiwa]", list.toString());
        assertEquals("Konnichiwa", list.getEntry(0));

        list.add("Watashi No");
        assertEquals(2, list.getLength());
        assertEquals("[Konnichiwa, Watashi No]", list.toString());
        assertEquals("Watashi No", list.getEntry(1));

        list.add("Tomodachi");
        assertEquals(3, list.getLength());
        assertEquals("[Konnichiwa, Watashi No, Tomodachi]", list.toString());
        assertEquals("Tomodachi", list.getEntry(1));
    }


    /**
     * Tests the remove(T) method
     */
    public void testRemoveEntry() {
        assertFalse(list.remove("I don't exist in the list!"));

        list.add("Peanut Butter");
        assertTrue(list.remove("Peanut Butter"));
        assertEquals("[]", list.toString());
        assertEquals(0, list.getLength());

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("F");

        assertTrue(list.remove("F"));
        assertEquals("[A, B, C, D]", list.toString());
        assertEquals(4, list.getLength());

        assertTrue(list.remove("A"));
        assertEquals("[B, C, D]", list.toString());
        assertEquals(3, list.getLength());

        assertTrue(list.remove("C"));
        assertEquals("[B, D]", list.toString());
        assertEquals(2, list.getLength());

        assertFalse(list.remove("C"));
    }


    /**
     * Tests the remove(int) method
     */
    public void testRemovePosition() {
        assertFalse(list.remove(0));
        assertFalse(list.remove(-1));
        assertFalse(list.remove(1));

        list.add("Peanut Butter");
        assertTrue(list.remove(0));
        assertEquals("[]", list.toString());
        assertEquals(0, list.getLength());

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("F");

        assertTrue(list.remove(4));
        assertEquals("[A, B, C, D]", list.toString());
        assertEquals(4, list.getLength());

        assertTrue(list.remove(0));
        assertEquals("[B, C, D]", list.toString());
        assertEquals(3, list.getLength());

        assertTrue(list.remove(1));
        assertEquals("[B, D]", list.toString());
        assertEquals(2, list.getLength());

        assertFalse(list.remove(2));
    }


    /**
     * Tests the getPosition(T) method
     */
    public void testGetPosition() {
        assertEquals(-1, list.getPosition(""));

        list.add("A");
        assertEquals(0, list.getPosition("A"));

        list.add("B");
        list.add("A");
        list.add("Chimichimichimichuckitinabin");

        assertEquals(0, list.getPosition("A"));
        assertEquals(1, list.getPosition("B"));
        assertEquals(3, list.getPosition("Chimichimichimichuckitinabin"));
    }


    /**
     * Tests the getEntry(int) method
     */
    public void testGetEntry() {
        IllegalArgumentException exception = null;
        try {
            list.getEntry(0);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.getEntry(0));
        assertEquals("B", list.getEntry(1));
        assertEquals("C", list.getEntry(2));
    }


    /**
     * Tests the contains(T) method
     */
    public void testContains() {
        assertFalse(list.contains("My Passing Grades"));

        list.add("A");
        assertTrue(list.contains("A"));

        list.add("B");
        list.add("C");
        assertTrue(list.contains("B"));
        assertTrue(list.contains("C"));

        list.remove("C");
        assertFalse(list.contains("C"));
    }


    /**
     * Tests the clear() method
     */
    public void testClear() {
        list.clear();
        assertEquals("[]", list.toString());
        assertEquals(0, list.getLength());

        list.add("Ko");
        list.add("No");
        list.add("DIO");
        list.add("DA!!!");
        list.clear();
        assertEquals("[]", list.toString());
        assertEquals(0, list.getLength());
    }


    /**
     * Tests the getLength() method
     */
    public void testGetLength() {
        assertEquals(0, list.getLength());

        list.add("A");
        list.add("B");

        assertEquals(2, list.getLength());

        list.remove(1);
        assertEquals(1, list.getLength());

        list.remove(0);
        assertEquals(0, list.getLength());
    }


    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("Soemthign");
        assertFalse(list.isEmpty());

        list.remove(0);
        assertTrue(list.isEmpty());

        list.add("Something");
        list.add("Big");
        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * Tests the toArray() method
     */
    public void testToArray() {
        String[] array = new String[0];
        assertTrue(checkArrContents(list.toArray(), array));

        list.add("A");
        array = new String[] { "A" };
        assertTrue(checkArrContents(list.toArray(), array));

        list.add("B");
        list.add("C");
        array = new String[] { "A", "B", "C" };
        assertTrue(checkArrContents(list.toArray(), array));
    }


    /**
     * Tests the getFront() method
     */
    public void testGetFront() {
        assertNull(list.getFront());

        list.add("A");

        assertEquals("A", list.getFront().getData());

        list.add("B");
        list.add("C");
        assertEquals("A", list.getFront().getData());

        list.remove(0);
        assertEquals("B", list.getFront().getData());
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals("[]", list.toString());

        list.add("A");
        assertEquals("[A]", list.toString());

        list.add("B");
        list.add("C");
        assertEquals("[A, B, C]", list.toString());
    }


    /**
     * Helper method used to check the contents of 2 arrays.
     * 
     * @param arr1
     *            Array to check arr2 to
     * @param arr2
     *            Array to check arr1 to
     * @return true if arrays have the same content, false otherwise.
     */
    private boolean checkArrContents(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
