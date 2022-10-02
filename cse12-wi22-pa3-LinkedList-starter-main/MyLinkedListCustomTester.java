/**
 * TODO: Add your file header
 * Name: Seth Chng
 * Email:	schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * 
 * This is my custom tester class, where i created tests for my linked list class that were not specified in the public tester class.
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method headers and points are awarded 
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
	private MyLinkedList<Integer> emptyIntegerLinkedList;
	private MyLinkedList<String> fiveStringList;
	private String[] strData = {"PSE15", "Ciao", "Chris","joe","zyzyz"};
	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		emptyIntegerLinkedList = new MyLinkedList<Integer>();
		fiveStringList = new MyLinkedList<String>();
		MyLinkedList<String>.Node node0 =  
			this.fiveStringList.new Node(this.strData[0]);
		MyLinkedList<String>.Node node1 =  
			this.fiveStringList.new Node(this.strData[1]);
		MyLinkedList<String>.Node node2 =  
			this.fiveStringList.new Node(this.strData[2]);
		MyLinkedList<String>.Node node3 =  
			this.fiveStringList.new Node(this.strData[3]);
		MyLinkedList<String>.Node node4 =  
			this.fiveStringList.new Node(this.strData[4]);	

		this.fiveStringList.head.next = node0;
		node0.prev = this.fiveStringList.head;
		node0.next = node1;
		node1.prev = node0;
		node1.next = node2;
		node2.prev = node1;
		node2.next = node3;
		node3.prev = node2;
		node3.next = node4;
		node4.prev = node3;
		node4.next = this.fiveStringList.tail;
		this.fiveStringList.tail.prev = node2;
		this.fiveStringList.size = 5;
	}

	/**
	 * TODO: test the add method when data is null
	 */
	@Test
	public void testAdd() {
		boolean thrown = false;
        try{
            emptyIntegerLinkedList.add(null);
        }
        catch(NullPointerException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put a null input in for data",iae.getMessage());
        }
        assertTrue(thrown);
	}

	/**
	 * TODO: test the add with index method when the data of the new addition is null
	 */
	@Test
	public void testAddWithIndexTestOne() {
		boolean thrown = false;
        try{
            emptyIntegerLinkedList.add(0,null);
        }
        catch(NullPointerException iae){
            thrown = true;
            assertEquals("check if exception was thrown","You put a null input in for data",iae.getMessage());
        }
        assertTrue(thrown);
	}

	/**
	 * TODO: test the add with index method when the index is out of bounds
	 */	
	@Test
	public void testAddWithIndexTestTwo() {
		boolean thrown = false;
        try{
            fiveStringList.add(7,"hi");
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","Your index for data is out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
	}

	/**
	 * TODO: test the get method when the index is out of bounds;
	 */
	@Test
	public void testGet() {
		boolean thrown = false;
        try{
            fiveStringList.get(7);
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","Your index for data is out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
	}

	/**
	 * TODO: test the getNth method when asked to get a node out of bounds
	 */
	@Test
	public void testGetNth() {
		boolean thrown = false;
        try{
            fiveStringList.getNth(7);
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","Your index for data is out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
	}

	/**
	 * TODO: test the set method when user tries to set an object at a index not available
	 */
	@Test
	public void testSet() {
		boolean thrown = false;
        try{
            fiveStringList.set(7,"hi");
        }
        catch(IndexOutOfBoundsException iae){
            thrown = true;
            assertEquals("check if exception was thrown","Your index for data is out of bounds",iae.getMessage());
        }
        assertTrue(thrown);
	}

	/**
	 * TODO: test the remove method when user tires to remove object out of bounds
	 */
	@Test
	public void testRemoveTestOne() {
			boolean thrown = false;
			try{
				fiveStringList.remove(8);
			}
			catch(IndexOutOfBoundsException iae){
				thrown = true;
				assertEquals("check if exception was thrown","Your index for data is out of bounds",iae.getMessage());
			}
			assertTrue(thrown);
	}
	
	/**
	 * TODO: test the remove method to remove an object in the middle
	 */
	@Test
	public void testRemoveTestTwo() {
		assertEquals("check if the item at index 3 is removed","joe",fiveStringList.remove(3));
	}

	/**
	 * TODO: test the clear method in an empty list
	 */
	@Test
	public void testClear() {
		emptyIntegerLinkedList.clear();
		assertEquals("Size should be updated", 0, emptyIntegerLinkedList.size());
		assertTrue("LinkedList should be empty", emptyIntegerLinkedList.isEmpty());
	}

	/**
	 * TODO: test the size method when the list isn't empty
	 */
	@Test
	public void testSize() {
		assertEquals("size should be 5",5,fiveStringList.size());
	}
}