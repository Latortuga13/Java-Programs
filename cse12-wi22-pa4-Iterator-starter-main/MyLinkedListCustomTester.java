
/**
 * TODO: Add your file header
 * Name: Seth
 * ID: A17075727
 * Email: schng@ucsd.edu
 * None
 * 
 * My own custom tester for the linked list.
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
    private MyLinkedList list1, list2, list3;
    private MyLinkedList.MyListIterator listLen1Iterator, listLen2Iterator, listlen3Iterator;
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        list1 = new MyLinkedList();
        list1.add("Christine");
        listLen1Iterator = list1.new MyListIterator();

        list2 = new MyLinkedList();
        list2.add("Paul");
        list2.add("Cao");
        listLen2Iterator = list2.new MyListIterator();

        list3 = new MyLinkedList<>();
        listlen3Iterator = list3.new MyListIterator();
    }

    /**
     * TODO: test the hasNext method when the list is empty
     */
    @Test
    public void testHasNext() {
        assertEquals("check if empty list returns false", false, listlen3Iterator.hasNext());
    }

    /**
     * TODO: test the next method when the list is empty
     */
    @Test
    public void testNext() {
        boolean thrown = false;
        try{
            listlen3Iterator.next();
        }
        catch(NoSuchElementException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put a null input in for the list",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * TODO: test the hasPrevious method when the list is empty
     */
    @Test
    public void testHasPrevious() {
        assertEquals("check if empty list returns false", false, listlen3Iterator.hasPrevious());
    }

    /**
     * TODO: test the previous method when the list is empty
     */
    @Test
    public void testPrevious() {
        boolean thrown = false;
        try{
            listlen3Iterator.previous();
        }
        catch(NoSuchElementException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put a null input in for the list",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * TODO: test the nextIndex method when the list is empty
     */
    @Test
    public void testNextIndex() {
        assertEquals("return size",0,listlen3Iterator.nextIndex());
    }

    /**
     * TODO: test the previousIndex method when the list is empty
     */
    @Test
    public void testPreviousIndex() {
        assertEquals("return size",0,listlen3Iterator.nextIndex());
    }

    /**
     * TODO: test the set method when setting an empty list
     */
    @Test
    public void testSet() {
        boolean thrown = false;
        try{
            listlen3Iterator.set(null);
        }
        catch(NullPointerException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put a null input in for element",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * TODO: test the remove method when set or add have been used beforehand.
     */
    @Test
    public void testRemoveTestOne() {
        boolean thrown = false;
        try{
            listlen3Iterator.add("hi");
            listlen3Iterator.remove();
        }
        catch(IllegalStateException iae){
            thrown = true;
            assertEquals("check if exception was thrown","cannot remove right after set or add call",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * TODO: test the remove method when next or previous havent been called
     */
    @Test
    public void testRemoveTestTwo() {
        boolean notthrown = true;
        try{
            listLen2Iterator.next();
            listLen2Iterator.remove();
        }
        catch(IllegalStateException iae){
            notthrown = false;
        }
        assertTrue(notthrown);
    }

    /**
     * TODO: test the add method when [...]
     */
    @Test
    public void testAdd() {
        boolean thrown = false;
        try{
            listlen3Iterator.add(null);
        }
        catch(NullPointerException iae){
            thrown = true;
            assertEquals("check if exception was thrown","input null addition",iae.getMessage());
        }
        assertTrue(thrown);
    }

}