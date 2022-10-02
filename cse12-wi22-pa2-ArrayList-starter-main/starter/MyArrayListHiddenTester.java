/**
 * TODO: Add your file header
 * Name: Seth
 * ID:  A17075727
 * Email:   schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is the hidden tester class for my array list. I created tests using Junit in here, and tested things that were not tested in the public tester class given to me.
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.*;

public class MyArrayListHiddenTester {
    Object[] arr = new Object[15];
    String[] arrString = { "a", "b", "c","d","e", "f"};
    static final int DEFAULT_CAPACITY = 5;
    static final int MY_CAPACITY = 1;
    MyArrayList emptyList, defaultList, customCapacitylist, nullList, stringList;
    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        emptyList = new MyArrayList();
        defaultList = new MyArrayList(DEFAULT_CAPACITY);
        customCapacitylist = new MyArrayList(MY_CAPACITY);
        nullList = new MyArrayList(null);
        stringList = new MyArrayList<String>(arrString);
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        boolean thrown = false;
        try{
            new MyArrayList<Integer>(-1);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","Invalid input",iae.getMessage());
        }
        assertTrue(thrown);
    }
    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        assertEquals("Check if null argument is present", 0, nullList.size);
        assertEquals("Check if null argument is present", 5, nullList.data.length);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        stringList.append("g");
        assertEquals("Check size after appended arrayList", 7, stringList.size);
        assertEquals("Check capacity after appendation", 12, stringList.data.length);
        assertEquals("Check correct item after appendation", "g", stringList.data[6]);
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        stringList.prepend(null);
        assertEquals("Check size after prepended arrayList", 7, stringList.size);
        assertEquals("Check capacity after prepended arrayList", 12, stringList.data.length);
        assertEquals("Check prepended item", null, stringList.data[0]);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        boolean thrown = false;
        try{
            defaultList.insert(6, "oops");
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You are out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        for(int i=0;i<1000;i++){
            stringList.insert(i, "LALALALALALA");
        }
        assertEquals("Check size of array after multiple inserts", 1006, stringList.size);
        assertEquals("Check capacity of array after multiple inserts", 1536, stringList.data.length);
        assertEquals("Check capacity of array after multiple inserts", "f", stringList.data[1005]);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        boolean thrown = false;
        try{
            defaultList.get(6);
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You tried to get an item out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        boolean thrown = false;
        try{
            defaultList.set(6, "oops");
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You tried to set an item out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        boolean thrown = false;
        try{
            defaultList.remove(6);
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You tried to remove an item out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
        boolean thrown = false;
        try{
            stringList.expandCapacity(3);
        }
        catch(IllegalArgumentException iae){
            thrown = true;
            assertEquals("check if exception was thrown","the required capacity is smaller than the initial",iae.getMessage());
        }
        assertTrue(thrown);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        stringList.expandCapacity(50);
       nullList.expandCapacity(100);
       assertEquals("check updated capacity", 50, stringList.data.length);
       assertEquals("check updated capacity", 100, nullList.data.length);
    }

}
