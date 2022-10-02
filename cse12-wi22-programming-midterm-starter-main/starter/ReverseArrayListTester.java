/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Assert;
//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */

public class ReverseArrayListTester {
    String[] arrEmpty, arrFive;
    MyArrayList arrListEmpty, arrListFive;
    MyLinkedList linkedListEmpty, linkedListFive;
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        arrEmpty=new String[0];
        arrFive=new String[] {"hi","bye","these","hair","life"};
        arrListEmpty = new MyArrayList<>(arrEmpty);
        arrListFive = new MyArrayList<>(arrFive);
        linkedListEmpty = new MyLinkedList<>(arrEmpty);
        linkedListFive = new MyLinkedList<>(arrFive);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        boolean thrown;
        int x=0;
        try{
            linkedListFive.reverseRegion(0, 7);
        }
        catch(IndexOutOfBoundsException iae){
            x=x+1;
        } 
        try{
            arrListFive.reverseRegion(0, 7);
        }
        catch(IndexOutOfBoundsException iae){
            x=x+1;
        } 
        try{
            linkedListEmpty.reverseRegion(2, 4);
        }
        catch(IndexOutOfBoundsException iae){
            x=x+1;
        }
        if(x==3){
            thrown =true;
        }
        else{
            thrown=false;
        }
        assertEquals("test linkedlist", thrown,true);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        //TODO: Add your test case
        String[] answer =  new String[] {"hi","bye","these","hair","life"};
        MyLinkedList linkedTest = new MyLinkedList<>(answer);
        MyArrayList arrTest = new MyArrayList<>(answer);
        linkedListFive.reverseRegion(2, 1);
        arrListFive.reverseRegion(2, 1);
        assertEquals("test linkedlist",linkedListFive.get(0), linkedTest.get(0));
        assertEquals("test linkedlist",arrListFive.get(2), arrTest.get(2));

    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        String[] answer =  new String[] {"hi","bye","life","hair","these"};
        MyLinkedList linkedTest = new MyLinkedList<>(answer);
        MyArrayList arrTest = new MyArrayList<>(answer);
        linkedListFive.reverseRegion(2, 4);
        arrListFive.reverseRegion(2, 4);
        //TODO: Add your test case
        assertEquals("test linkedlist",linkedListFive.get(3),linkedTest.get(3));
        assertEquals("test linkedlist",arrListFive.get(2),arrTest.get(2));
    }

    /**
     * Custom test
    */
    @Test
    public void testReverseCustom(){
        //TODO: Add your test case
        String[] answer =  new String[] {"hi","bye","these","hair","life"};
        MyLinkedList linkedTest = new MyLinkedList<>(answer);
        MyArrayList arrTest = new MyArrayList<>(answer);
        linkedListFive.reverseRegion(2, 4);
        linkedListFive.reverseRegion(2, 4);
        arrListFive.reverseRegion(2, 4);
        arrListFive.reverseRegion(2, 4);
        //TODO: Add your test case
        assertEquals("test linkedlist",linkedListFive.get(3),linkedTest.get(3));
        assertEquals("test linkedlist",arrListFive.get(2),arrTest.get(2));
    }


}
