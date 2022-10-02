/**
 * TODO: Add your file header
 * Name: Seth Chng
 * ID: A17075727
 * Email: schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * none
 * 
 * This is my Priority queue class. I added all the instance variables and 
 * it makes the class use myMinheap class.
 */

import java.util.Collection;
import java.util.HashMap;
/**
 * TODO: Add Class Header
 */
public class MyPriorityQueue<E extends Comparable<E>>
{

    //TODO: Add a public instance variable called "heap"
    //"heap" is of a generic MyMinHeap type
    MyMinHeap<E> heap;
    String ticketType;
    Long createdAt;
    HashMap<String, Integer> orderMap;
    /**
     * Constructor that creates an empty priority queue
     */
    public MyPriorityQueue(){
        heap = new MyMinHeap<E>();
    }

    /**
     * Constructor that creates a priority queue from a collection
     * @param collection The collection used to intialize priority queue
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        heap = new MyMinHeap<E>(collection);
    }
    /**
     * Comparator method that organizes heap.
     * @param other
     * @return
     */
    public int compareTo(Ticket other){
        return 1;
    }
    /**
     * Adds an element to the priority queue
     * @param element the element to be added
     */
    public void push(E element){
        heap.insert(element);
    }

    /**
     * Removes the element with the highest priority from the priority queue 
     * @return the element with the highest priority
     */
    public E pop(){
        return heap.remove();
    }

    /**
     * Sees the element with the highest priority from the priority queue
     * @return the element with the highest priority
     */
    public E peek(){
        return heap.getMin();
    }

    /**
     * Finds the number of elements in the priority queue
     * @return the number of elements in the priority queue
     */
    public int getLength(){
        return heap.size();
    }

    /**
     * Remove all the elements from the priority queue.
     */
    public void clear(){
        heap.clear();
    }
}