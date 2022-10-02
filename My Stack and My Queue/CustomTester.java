/**
 * TODO: Add your file header
 * Name: Seth
 * ID: A17075727
 * Email: Schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is my tester for my deque interface. It also will check things in myStack and myQueue classes.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initial capacity is less then zero
     */
    @Test
    public void testMyDequeConstructor() {
        boolean thrown = false;
        try{
            MyDeque test = new MyDeque(-1);
        }
        catch(IllegalArgumentException iae){
            assertEquals("illegal argument input", iae.getMessage());
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Test the expandCapacity method when the capacity is 0
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque test = new MyDeque(1);
        test.data=new Object[0];
        test.expandCapacity();
        assertEquals(test.data.length,10);
    
    }

    /**
     * Test the addFirst method when the element is null
     */
    @Test
    public void testAddFirst() {
        MyDeque test = new MyDeque(5);
        boolean thrown = false;
        try{
            test.addFirst(null);
        }
        catch(NullPointerException iae){
            assertEquals("inserting bad element", iae.getMessage());
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Test the addLast method when the element is null
     */
    @Test
    public void testAddLast() {
        MyDeque test = new MyDeque(6);
        boolean thrown = false;
        try{
            test.addLast(null);
        }
        catch(NullPointerException iae){
            assertEquals("inserting bad element", iae.getMessage());
            thrown = true;
        }
        assertTrue(thrown);
    }

    /**
     * Test the removeFirst method when the array is empty
     */
    @Test
    public void testRemoveFirst() {
        MyDeque test = new MyDeque(0);
        assertEquals(test.removeFirst(), null);
    }

    /**
     * Test the removeLast method when the array is empty
     */
    @Test
    public void testRemoveLast() {
        MyDeque test = new MyDeque(0);
        assertEquals(test.removeLast(), null);
    }

    /**
     * Test the peekFirst method when the front is not 0
     */
    @Test
    public void testPeekFirst(){
        Object[] test = new Object[]{null,null,1,2,4,5,null};
        MyDeque testPeek=new MyDeque(0);
        testPeek.data=test;
        testPeek.size=4;
        testPeek.front=2;
        testPeek.rear=5;
        assertEquals(1,testPeek.peekFirst());
    }

    /**
     * Test the peekLast method when the rear is null     */
    @Test
    public void testPeekLast(){
        MyDeque testPeek=new MyDeque(0);
        assertEquals(testPeek.peekLast(),null);
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack.empty() when the list is not empty
     */
    @Test
    public void testMyStack(){
        // You can test any method from MyStack or a combination of methods
        MyStack testEmpty = new MyStack(0);
        testEmpty.theStack.addFirst(1);
        assertEquals(false, testEmpty.empty());
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when [TODO]
     */
    @Test
    public void testMyQueue(){
        // You can test any method from MyQueue or a combination of methods
        MyQueue testEmpty = new MyQueue(0);
        testEmpty.theQueue.addFirst(1);
        assertEquals(false, testEmpty.empty());
    }
}
