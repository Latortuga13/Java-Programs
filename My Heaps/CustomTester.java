/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    
    /**
     * Test the constructor when something is null in the construction of the mini heap
     */
    @Test
    public void testMyMinHeapConstructor() {
        boolean thrown =false;
        Collection col = new ArrayList<>();
        col.add(null);
        try{
            MyMinHeap heaptest = new MyMinHeap(col);
        }
        catch(NullPointerException iae){
            thrown = true;
            assertEquals(iae.getMessage(),"Null input detected");
        }
        assertTrue(thrown);
    }

    /**
     * Test the getMinChildIdx method when the minChild is the left Child
     */
    @Test
    public void testGetMinChildIdx() {
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.data.add(2);
        heap.data.add(0);
        heap.data.add(1);
        assertEquals(heap.getMinChildIdx(0),1);
    }

    /**
     * Test the percolateUp method when trying to percolate up the same item
     */
    @Test
    public void testPercolateUp() {
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.data.add(2);
        heap.data.add(1);
        heap.data.add(2);
        heap.percolateUp(0);
        assertEquals(heap.data.get(0)+" "+heap.data.get(1)+" "+
        heap.data.get(2), 2+" "+1+" "+2);
    }

    /**
     * Test the percolateDown method when trying to percolate down the same item
     */
    @Test
    public void testPercolateDown() {
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.insert(2);
        heap.insert(2);
        heap.insert(2);
        heap.percolateDown(0);
        assertEquals(heap.data.get(0)+" "+heap.data.get(1)+" "+
        heap.data.get(2),2+" "+2+" "+2);
    }

    /**
     * Test the deleteIndex method when deleting the last Object
     */
    @Test
    public void testDeleteIndex() {
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.data.add(2);
        heap.data.add(0);
        heap.data.add(1);
        heap.data.add(3);
        heap.data.add(5);
        heap.deleteIndex(4);
        assertEquals(heap.data.get(0)+" "+heap.data.get(1)+" "+
        heap.data.get(2)+" "+heap.data.get(3),2+" "+0+" "+1+" "+3);
    }

    /**
     * Test the deleteIndex method when deleting in the middle of the array
     */
    @Test
    public void testDeleteIndex2() {
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.data.add(2);
        heap.data.add(0);
        heap.data.add(1);
        heap.data.add(3);
        heap.data.add(5);
        heap.deleteIndex(2);
        assertEquals(heap.data.get(0)+" "+heap.data.get(1)+" "+
        heap.data.get(2)+" "+heap.data.get(3),2+" "+0+" "+5+" "+3);
    }

    /**
     * Test the insert method when the array is empty
     */
    @Test
    public void testInsert(){
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.insert(2);
        heap.insert(1);
        heap.insert(0);
        assertEquals(heap.data.get(0)+" "+heap.data.get(1)+" "+
        heap.data.get(2)+" ",0+" "+2+" "+1+" ");
    }

    /**
     * Test the insert method when the value is a leaf node
     */
    @Test
    public void testInsert2(){
        MyMinHeap heap = new MyMinHeap<Integer>();
        heap.data.add(2);
        heap.data.add(0);
        heap.data.add(1);
        heap.insert(6);
        assertEquals(heap.data.get(0)+" "+heap.data.get(1)+" "+
        heap.data.get(2)+" "+heap.data.get(3),2+" "+0+" "+1+" "+6);
    }

   
    /**
     * Test remove when it is removing from an empty list
     */
    @Test
    public void testRemove(){
        MyMinHeap heap = new MyMinHeap<Integer>();
        assertEquals(heap.remove(),null);
    }

  
    /**
     * Test getMin when the list is empty
     */
    @Test
    public void testGetMin(){
        MyMinHeap heap = new MyMinHeap<Integer>();
        assertEquals(heap.getMin(),null);
    }
}