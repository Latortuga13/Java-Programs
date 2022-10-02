/**
 * TODO: Add file header
 * Name: Seth Chng
 * ID: A17075727
 * Email: schng@ucsd.edu
 * File description: This is my custom tester for my CSE12NaryTree. It will
 * test the code I wrote for my CSE12 final.
 */
 
import static org.junit.Assert.*;
import org.junit.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * This is my tester class, which will test all the methods within
 * my CSE12Nary.java file
 */
public class CSE12NaryTreeTester {
    CSE12NaryTree<Integer> myBinaryTree;
    CSE12NaryTree<Integer> my7Tree;
    CSE12NaryTree<Integer> my3Tree;
    @Before
    public void setup(){
       myBinaryTree=new CSE12NaryTree<>(2);
       my7Tree=new CSE12NaryTree<>(7);
       my3Tree=new CSE12NaryTree<>(3);
    }
    /**
     * This is my basic add test, which tests adding things to my narytree
     */
    @Test
    public void testAdd(){
        //tests adding 6 items into a binary tree
        myBinaryTree.add((Integer)1);
        myBinaryTree.add((Integer)2);
        myBinaryTree.add((Integer)3);
        myBinaryTree.add((Integer)4);
        myBinaryTree.add((Integer)5);
        myBinaryTree.add((Integer)7);
        int ans=myBinaryTree.root.children.get(0).getChildren().get(1).data;
        assertEquals(6, myBinaryTree.size);
        assertEquals((Integer)1, myBinaryTree.root.data);
        assertEquals((Integer)2, myBinaryTree.root.children.get(0).data);
        assertEquals(ans, 5);
        //tests adding into a 3 tree with multiple levels
        my3Tree.add((Integer)1);
        my3Tree.add((Integer)2);
        my3Tree.add((Integer)3);
        my3Tree.add((Integer)4);
        my3Tree.add((Integer)5);
        my3Tree.add((Integer)7);
        int ans1=my3Tree.root.getChildren().get(0).getChildren().get(1).data;
        assertEquals(6, my3Tree.size);
        assertEquals((Integer)1, my3Tree.root.data);
        assertEquals((Integer)2, my3Tree.root.children.get(0).data);
        assertEquals(ans1,7);
        //tests adding into a 7 tree where there is only one level
        my7Tree.add((Integer)1);
        my7Tree.add((Integer)2);
        my7Tree.add((Integer)3);
        my7Tree.add((Integer)4);
        my7Tree.add((Integer)5);
        my7Tree.add((Integer)7);
        my7Tree.add((Integer)6);
        assertEquals(7,my7Tree.size);
        assertEquals((Integer)1, my7Tree.root.data);
        assertEquals((Integer)6, my7Tree.root.children.get(5).data);
    }

    /**
     * This is the test for my contains method. it checks if my data structure
     * has the element requested in the method call.
     */
    @Test
    public void testContains(){
        //tests contains for a 2 level tree
        my7Tree.add((Integer)1);
        my7Tree.add((Integer)2);
        my7Tree.add((Integer)3);
        assertEquals(true,my7Tree.contains((Integer)1));
        assertEquals(true,my7Tree.contains((Integer)2));
        assertEquals(true,my7Tree.contains((Integer)3));
        assertEquals(false,my7Tree.contains((Integer)7));
        // tests contains for a multi level tree
        myBinaryTree.add((Integer)1);
        myBinaryTree.add((Integer)2);
        myBinaryTree.add((Integer)3);
        myBinaryTree.add((Integer)4);
        myBinaryTree.add((Integer)5);
        myBinaryTree.add((Integer)7);
        assertEquals(true,myBinaryTree.contains((Integer)7));
        assertEquals(true,myBinaryTree.contains((Integer)1));
        assertEquals(true,myBinaryTree.contains((Integer)4));
        assertEquals(false,myBinaryTree.contains((Integer)30));
    }

    /**
     * test the method I wrote to sort a tree. It takes in an unorganized
     * nary tree, and then sorts it into an arrayList in ascending
     * order
     */
    @Test
    public void testSortTree(){
        //test sort for a tree with multiple levels
        myBinaryTree.add((Integer)3);
        myBinaryTree.add((Integer)1);
        myBinaryTree.add((Integer)5);
        myBinaryTree.add((Integer)6);
        myBinaryTree.add((Integer)8);
        myBinaryTree.add((Integer)7);
        ArrayList test = new ArrayList<Integer>();
        test.add((Integer)1);
        test.add((Integer)3);
        test.add((Integer)5);
        test.add((Integer)6);
        test.add((Integer)7);
        test.add((Integer)8);
        assertEquals(test,myBinaryTree.sortTree());
        //test sort for a tree with only two levels
        my7Tree.add((Integer)2);
        my7Tree.add((Integer)1);
        my7Tree.add((Integer)6);
        my7Tree.add((Integer)4);
        my7Tree.add((Integer)5);
        my7Tree.add((Integer)7);
        my7Tree.add((Integer)3);
        ArrayList test2 = new ArrayList<Integer>();
        test2.add((Integer)1);
        test2.add((Integer)2);
        test2.add((Integer)3);
        test2.add((Integer)4);
        test2.add((Integer)5);
        test2.add((Integer)6);
        test2.add((Integer)7);
        assertEquals(test2,my7Tree.sortTree());
    }

    /**
     * This test will test the edge cases and
     * exceptions thrown in my code
     */
    @Test
    public void testCustom(){
        //test null in add
        boolean thrown=false;
        try{
            myBinaryTree.add(null);
        }
        catch(NullPointerException iae){
            thrown=true;
            assertEquals(iae.getMessage(),"wrong input");
        }
        assertTrue(thrown);
        //test null in contains
        boolean thrown1=false;
        try{
            myBinaryTree.contains(null);
        }
        catch(NullPointerException iae){
            thrown1=true;
            assertEquals(iae.getMessage(),"wrong input");
        }
        assertTrue(thrown1);
        //test sort on an empty tree
        ArrayList<Integer> test3 = new ArrayList<>(0);
        assertEquals(test3,my3Tree.sortTree());
    }
}
