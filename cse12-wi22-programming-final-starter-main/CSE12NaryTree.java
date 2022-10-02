/**
 * TODO: Add file header
 * Name: Seth Chng  
 * ID: A17075727
 * Email: schng@ucsd.edu
 * File description: 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This the CSE12NaryTree class, which i will be writing my code for
 * my cse12 final in.
 */
public class CSE12NaryTree<E extends Comparable<E>> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    
    Node root;
    int size;
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }
    /**
     * This is my add method, which adds an element to my nary data structure.
     */
    public void add(E element) {
        if(element==null){
            throw new NullPointerException("wrong input");
        }
        Node toAdd = new Node(element);
        Node curr = root;
        Node child = null;
        Node parent = null;
        if(this.root==null){
            this.root=toAdd;
            size=size+1;
            return;
        }
        while(parent==null){
            //if only root node has no full children
            if(curr.getChildren().size()<N){
                parent=curr;
            }
            else{
                //finds parent with not full children
                for(int i=0;i<curr.children.size();i++){
                    child=curr.getChildren().get(i);
                    if(child.getChildren().size()<N){
                        parent=child;
                        break;
                    }
                }
                if(parent==null){
                    curr=curr.getChildren().get(0);
                }
            }
        }
        parent.addChild(toAdd);
        size=size+1;
    }
    /**
     * This is my contains method, which looks for a specific element in my 
     * nary data structure
     */
    public boolean contains(E element) {
        if(element==null){
            throw new NullPointerException("wrong input");
        }
        Queue<Node> myQueue=new LinkedList<>();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            Node tempNode = myQueue.poll();
            if(tempNode.data==element){
                return true;
            }
            if (!tempNode.getChildren().isEmpty()) {
                for(Node e:tempNode.getChildren()){
                    myQueue.add(e);
                }
            }
        }
        return false;
    }
    
    /**
     * This is my sortTree method, which will sort out the tree, and get an
     * ordered arrayList
     * @return a ordered arrayList of all the data
     */
    public ArrayList<E> sortTree(){
        Queue<E> toReturn=new PriorityQueue<>();
        ArrayList<E> toReturn2 = new ArrayList<>(0);
        if(size==0){
            return toReturn2;
        }
        Queue<Node> myQueue=new LinkedList<>();
        myQueue.add(root);
        toReturn.add(root.data);
        while (!myQueue.isEmpty()) {
            Node tempNode = myQueue.poll();
            if (!tempNode.getChildren().isEmpty()) {
                for(Node e:tempNode.getChildren()){
                    myQueue.add(e);
                    toReturn.add(e.data);
                }
            }
        }
        while(!toReturn.isEmpty()){
            toReturn2.add(toReturn.poll());
        }
        return toReturn2;
    }
}
