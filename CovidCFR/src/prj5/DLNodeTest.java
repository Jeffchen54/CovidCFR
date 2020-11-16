/**
 * “I have neither given nor received unauthorized assistance on this
 * assignment.” - AA
 */

package prj5;

import student.TestCase;

/**
 * Ensure methods and constructors within DLNode class
 * are working as intended
 * @author Aziz Abousam (az1zabousam)
 * @version 2020.11.16
 */
public class DLNodeTest extends TestCase {
    private DLNode<String> node1;
    private DLNode<String> node2;
    private DLNode<String> node3;
    
    /**
     * The setUp method is used to initialize initial
     * conditions and will run before every test method
     */
    public void setUp() {
        node1 = new DLNode<String>("node1");
        node2 = new DLNode<String>("node2");
        node3 = new DLNode<String>("node3");
    }
    
    /**
     * Ensure getData() returns the correct data for the node
     */
    public void testGetData() {
        assertEquals("node1", node1.getData());
        assertEquals("node2", node2.getData());
        assertEquals("node3", node3.getData());
    }
    
    /**
     * Ensure getNextNode() returns the next node in sequence
     */
    public void testGetNextNode() {
        assertNull(node1.getNextNode());
        node1.setNextNode(node2);
        node2.setPrevNode(node1);
        assertEquals(node2, node1.getNextNode());
    }
    
    /**
     * Ensure setNextNode(DLNode) sets the next node in the sequence
     * to be the parameter
     */
    public void testSetNextNode() {
        node2.setNextNode(node3);
        assertEquals(node3, node2.getNextNode());
    }
    
    /**
     * Ensure getPrevNode() returns the previous node in the sequence
     */
    public void testGetPrevNode() {
        assertNull(node2.getPrevNode());
        node2.setPrevNode(node1);
        assertEquals(node1, node2.getPrevNode());
    }
    
    /**
     * Ensure setPrevNode(DLNode) sets the previous node in the 
     * sequence to be the parameter
     */
    public void testSetPrevNode() {
        node3.setPrevNode(node2);
        assertEquals(node2, node3.getPrevNode());
    }
}
