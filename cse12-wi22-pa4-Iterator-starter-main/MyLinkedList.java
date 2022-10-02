/**
 * TODO: Add your file header
 * Name:	Seth Chng	
 * Email:	schng@ucsd.edu
 * none
 * 
 * This is my linked list class. It has many different linked list methods. It also has an iterator.
 */

import java.util.AbstractList;
import java.util.NoSuchElementException;

import javax.swing.table.TableRowSorter;

import org.w3c.dom.ElementTraversal;

/** 
 * TODO: Add class header here 
 */

public class MyLinkedList<E> extends AbstractList<E> {
	private MyLinkedList listLen1, listLen2;
    private MyLinkedList.MyListIterator listLen1Iter, listLen2Iter;
	int size;
	Node head;
	Node tail;
	interface ListIterator<E>{
		public boolean hasNext();
		public E next();
		public boolean hasPrevious();
		public E previous();
		public int nextIndex();
		public int previousIndex();
		public void add(E element);
		public void set(E element);
		public void remove();
	}

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class MyListIterator implements ListIterator<E> {

        // class variables here
		Node left;
		Node right;
		int idx;
        boolean forward;
		boolean canRemoveOrSet;
        // MyListIterator methods
		public MyListIterator(){
			left=head;
			right=head.next;
			forward=true;
			canRemoveOrSet=false;
			idx=0;
		}
		public boolean hasNext() {
			if(right!=tail){
				return true;
			}
			return false;
        }
		public E next(){
			if(right==tail){
				throw new NoSuchElementException("You put a null input in for the list");
			}
			E toReturn = right.data;
			left=right;
			right=right.next;
			idx=idx+1;
			forward=true;
			canRemoveOrSet=true;
			return toReturn;
		}
		public boolean hasPrevious(){
			if(left!=head){
				return true;
			}
			return false;
		}
		public E previous(){
			if(left==head){
				throw new NoSuchElementException("You put a null input in for the list");
			}
			E toReturn = left.data;
			right=left;
			left=left.prev;
			idx=idx-1;
			forward=false;
			canRemoveOrSet=true;
			return toReturn;
		}
		public int nextIndex(){
			try{
				next();
			}
			catch(NoSuchElementException iae){
				return idx;
			}
			return idx-1;
		}
		public int previousIndex(){
			try{
				previous();
			}
			catch(NoSuchElementException iae){
				return -1;
			}
			return idx;
		}
		public void add(E element){
			Node toAdd = new Node(element);
			if(element==null){
				throw new NullPointerException("input null addition");
			}
			idx=idx+1;
			right.setPrev(toAdd);
			toAdd.setPrev(left);
			toAdd.setNext(right);
			left=toAdd;
			canRemoveOrSet=false;
		}
		public void set(E element){
			if(element==null){
				throw new NullPointerException("You put a null input in for element");
			}
			if(canRemoveOrSet=false || (left==head && right==head.next)){
				throw new IllegalStateException();
			}
			if(forward==false){
				right.setElement(element);
			}
			else{
				left.setElement(element);
			}
			canRemoveOrSet=false;
		}
		public void remove(){
			if(canRemoveOrSet==false ||(left==head && right==head.next)){
				throw new IllegalStateException("cannot remove right after set or add call");
			}
			if(forward==false){
				Node bye =right.next;
				bye.next=right.prev;
				bye.prev=right.next.next;
				right=bye;
			}
			else{
				Node bye =left.prev;
				bye.next=left.next;
				bye.prev=left.prev.prev;
				left=bye;
				idx=idx-1;
			}
			canRemoveOrSet=false;
		}
        // more methods, etc.

}
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		head=new Node(null);
		tail=new Node(null);
		head.next=tail;
		tail.prev=head;
		size=0;
	}

	@Override
	public int size() {
		// need to implement the size method
		return size; // TODO
	}

	@Override
	public E get(int index) {
		int count=0;
		Node currentNode=head;
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
			if(count==index){
				return currentNode.data;
			}
			count++;
		}
		throw new IndexOutOfBoundsException("Your index for data is out of bounds");
}

	@Override
	public void add(int index, E data) {
		/* Add your implementation here */
		// TODO
		int count=0;
		Node currentNode=head;
		Node replaceNode= new Node(data);
		if(data==null){
			throw new NullPointerException("You put a null input in for data");
		}
		if(index==0){
			head.setNext(replaceNode);
			tail.setPrev(replaceNode);
			replaceNode.setPrev(head);
			replaceNode.setNext(tail);
		}
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
			if(count==size+1){
				replaceNode.setNext(tail);
				replaceNode.setPrev(tail.prev);
				tail.setPrev(replaceNode);
			}
			if(count==index){
				replaceNode.setPrev(currentNode.prev);
				replaceNode.setNext(currentNode);
				currentNode.setPrev(replaceNode);
				size=size+1;
				return;
			}
			count++;
		}
		throw new IndexOutOfBoundsException("Your index for data is out of bounds");
	}
	public boolean add(E data) {
		if(data==null){
			throw new NullPointerException("You put a null input in for data");
		}
		Node newTail=new Node(data);
		if(size==0){
			head.setNext(newTail);
			tail.setPrev(newTail);
			newTail.setPrev(head);
			newTail.setNext(tail);
			size=size+1;
			return true;
		}
		newTail.setNext(tail);
		newTail.setPrev(tail.prev);
		tail.prev.setNext(newTail);
		tail.setPrev(newTail);
		size=size+1;
		return true; // TODO
	}

	public E set(int index, E data) {
		int count=0;
		Node currentNode = head;
		Node replaceNode= new Node(data);
		if(data==null){
			throw new NullPointerException();
		}
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
			if(count==index){
				Node toReturn = currentNode;
				currentNode.next.setPrev(replaceNode);
				currentNode.prev.setNext(replaceNode);
				replaceNode.setNext(currentNode.next);
				replaceNode.setPrev(currentNode.prev);
				return toReturn.data;
			}
			count++;
		}
		throw new IndexOutOfBoundsException("Your index for data is out of bounds");
	}

	public E remove(int index) {
		int count=0;
		Node currentNode = head;
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
			if(count==index){
				E toReturn = currentNode.data;
				currentNode.next.setPrev(currentNode.prev);
				currentNode.prev.setNext(currentNode.next);
				System.out.println(toReturn);
				return toReturn;
			}
			count++;
		}
		throw new IndexOutOfBoundsException("Your index for data is out of bounds");
	}

	public void clear() {
		head.setNext(tail);
		tail.setPrev(head);
		size=0;
	}

	public boolean isEmpty() {
		if(head.getNext()==tail){
			return true;
		}
		return false;
	}

	protected Node getNth(int index) {
		int count=0;
		Node currentNode = head;
		while(currentNode.getNext()!=null){
			currentNode=currentNode.getNext();
			if(count==index){
				return currentNode;
			}
			count++;
	}
	throw new IndexOutOfBoundsException("Your index for data is out of bounds");
}
}