import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.NoSuchElementException;
public class CustomTester {
    MyBST<Integer, Integer> completeTree;
    MyBST<Integer, Integer> completeeTree;
    MyBST<Integer, Integer> emptyTree;
    @Before
    public void setUp(){
    MyBST.MyBSTNode<Integer, Integer> root = 
            new MyBST.MyBSTNode(5, 1, null);
        MyBST.MyBSTNode<Integer, Integer> two = 
            new MyBST.MyBSTNode(2, 3, root);
        MyBST.MyBSTNode<Integer, Integer> seven = 
            new MyBST.MyBSTNode(7, 4, root);
        MyBST.MyBSTNode<Integer, Integer> one = 
            new MyBST.MyBSTNode(1, 5, two);
        MyBST.MyBSTNode<Integer, Integer> three = 
            new MyBST.MyBSTNode(3, 12, two);
        MyBST.MyBSTNode<Integer, Integer> six = 
            new MyBST.MyBSTNode(6, 51, seven);
        MyBST.MyBSTNode<Integer, Integer> root2 = 
            new MyBST.MyBSTNode(5, 2, null);
        MyBST.MyBSTNode<Integer, Integer> three2 = 
            new MyBST.MyBSTNode(3, 12, root2);
        MyBST.MyBSTNode<Integer, Integer> seven2 = 
            new MyBST.MyBSTNode(7, 4, root2);
        MyBST.MyBSTNode<Integer, Integer> one2 = 
            new MyBST.MyBSTNode(1, 5, three2);
        MyBST.MyBSTNode<Integer, Integer> six2 = 
            new MyBST.MyBSTNode(6, 51, seven2);
        this.completeTree = new MyBST();
        this.completeTree.root = root;
        root.setLeft(two);
        root.setRight(seven);
        two.setLeft(one);
        two.setRight(three);
        seven.setLeft(six);
        this.completeTree.size = 6;
        this.emptyTree = new MyBST<>();
        this.emptyTree.root = null;
        this.completeeTree = new MyBST();
        this.completeeTree.root = root2;
        root2.setLeft(three2);
        root2.setRight(seven2);
        three2.setLeft(one2);
        seven2.setLeft(six2);
    }
    // Test inserting a null key
    @Test
    public void testInsertNull(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        boolean thrown=false;
        try{
            completeTree.insert(null,20);
        }
        catch(NullPointerException iae){
            thrown = true;
            assertEquals(iae.getMessage(),"Null input detected");
        }
    }
    // Test inserting a node with the same key, but different value
    @Test
    public void testInsertReplace(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        completeTree.insert(2,20);
        assertEquals(root.getLeft().getValue(),(Integer)20);
    }
    // Test inserting a node in the middle of the bst
    @Test
    public void testInsertMiddle(){
        MyBST.MyBSTNode<Integer, Integer> root2 = completeeTree.root; 
        completeeTree.insert(3, 1);
        assertEquals((Integer)1, root2.getLeft().getValue());
    }
    // Test searching for a null and searching for a key
    // that doesnt exist
    @Test
    public void testSearchNull(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        assertEquals(completeTree.search(null),null);
    }
    // Test remove on a null key
    @Test
    public void testRemoveNull(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        assertEquals(completeTree.remove(null),null);
    }
    // Test remove twice in a row on two different nodes in same branch
    @Test
    public void testRemoveTwoCnSameBranch(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        assertEquals(completeTree.remove(2),(Integer)3);
        assertNull(root.getLeft().getRight());
        assertEquals((Integer)12, completeTree.remove(3));
        assertNull(root.getLeft().getLeft());
    }
    // Test inOrder in a empty tree
    @Test
    public void testInOrderIftreeIsempty(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        completeTree.remove(5);
        completeTree.remove(2);
        completeTree.remove(1);
        completeTree.remove(3);
        completeTree.remove(6);
        completeTree.remove(7);
        assertEquals(completeTree.inorder().size(),0);
    }
    // test Predecessor if called on the smallest node
    @Test
    public void testPredecessorOnSmallestNode(){
        MyBST.MyBSTNode<Integer, Integer> root = completeTree.root;
        assertEquals(root.getLeft().getLeft().predecessor(),null);
    }
    // test calender if try to book an illegal number
    @Test
    public void testCalenderException(){
        MyCalendar cal = new MyCalendar();
        boolean thrown = false;
        try{
            cal.book(-1, 2);
        }
        catch(IllegalArgumentException iae){
            thrown =true;
            assertEquals(iae.getMessage(),"illegal input detected");
        }
        assertTrue(thrown);
    }
    // test NextNode if the next node is null
    @Test
    public void testNextNode(){
        MyBSTIterator<Integer, Integer> iterTree = new MyBSTIterator();
        iterTree.root = emptyTree.root;
        MyBSTIterator<Integer, Integer>.MyBSTValueIterator vi = 
        iterTree.new MyBSTValueIterator(iterTree.root);
        boolean thrown = false;
        try{
            assertSame(iterTree.root, vi.next);
            assertNull(vi.lastVisited);
            assertSame(emptyTree.root, vi.nextNode());
            assertSame(completeTree.root, vi.lastVisited);
        }
        catch(NoSuchElementException iae){
            thrown = true;
            assertEquals(iae.getMessage(),"bad BST");
        }
    }
}

