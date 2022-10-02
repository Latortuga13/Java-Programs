/**
* Name: Seth
* ID: A17075727
* Email: Schng@ucsd.edu
* Sources used: Put "None" if you did not have any external help
* Some example of sources used would be Tutors, Zybooks, and Lecture Slides
* 
* This is my deque class. 
* It is a data structure that has many methods I wrote.
*/
/**
 * This is a Deque class which is a data structure I 
 * implemented
 */
class MyDeque<E> implements DequeInterface<E>{
    Object[] data;
    int size;
    int rear;
    int front;
    public MyDeque(int initialCapacity){
        if(initialCapacity<0){
            throw new IllegalArgumentException("illegal argument input");
        }
        size=0;
        data = new Object[initialCapacity];
        rear=0;
        front=0;
    }
    public int size(){
        return size;
    }
    /**
     * Expands the capacity of the deque if the data structure is full
     */
    public void expandCapacity(){
        if(data.length==0){
            data=new Object[10];
            front=0;
            if(size>0){
                rear=size-1;
            }
            else{
              rear=size;
            }
            return;
        }
        Object[] toSave = new Object[data.length*2];
        int location=0;
        if(front<rear){
            for(int i=front; i<=rear;i++){
                toSave[location]=data[i];
                location++;  
            }
        }
        else if(front>rear){
            for(int i=front;i<data.length;i++){
                toSave[location]=data[i];
                location++;
            }
            for(int j=0;j<=rear;j++){
                toSave[location]=data[j];
                location++;
            }
        }
        data=toSave;
        front=0;
        if(size>0){
            rear=size-1;
        }
        else{
            rear=size;
        }
    }
    /**
     * Adds the specified element to the front of this MyDeque.
     * 
     * @param element the element to add to the queue
     */
    public void addFirst(E element){
        if(element==null){
            throw new NullPointerException("inserting bad element");
        }
        if(front==data.length){
            expandCapacity();
        }
        size=size+1;
        if(front==0){
            front=0;
        }
        else{
            front=front-1;
        }
        data[front]=element;
    }
    /**
     * Adds the specified element to the rear of this MyDeque.
     * 
     * @param element the element to add to the queue
     */
    public void addLast(E element){
        if(element==null){
            throw new NullPointerException("inserting bad element");
        }
        if(rear==data.length){
            expandCapacity();
        }
        size=size+1;
        rear=rear+1;
        data[rear]=element;
    }
    /**
     * remove the specified element from the front of this MyDeque. 
     * @return It also returns the element being removed
     * 
     */
    public E removeFirst(){
        if(size==0){
            return null;
        }
        E toReturn = (E)data[front];
        data[front]=null;
        if(data.length>front+1){
            front=front+1;
        }
        else{
            front =0;
        }
        size=size-1;
        return toReturn;
    }
    /**
     * removes the specified element from the rear of this MyDeque. 
     * @return It also returns the element being removed
     * 
     */
    public E removeLast(){
        if(size==0){
            return null;
        }
        E toReturn = (E)data[rear];
        data[rear]=null;
        if(rear-1>0){
            rear=rear-1;
        }
        else{
            rear=0;
        }
        size=size-1;
        return toReturn;
    }
    /**
     * Looks at the element at the front of the deque
     * @return returns the element at the front of the deque
     * 
     */
    public E peekFirst(){
        if(size==0){
            expandCapacity();
        }
        return (E)data[front];
    }
    /**
     * Looks at the element at the rear of the deque
     * @return returns the element at the rear of the deque
     * 
     */
    public E peekLast(){
        if(size==0){
            expandCapacity();
        }
        return (E)data[rear];
    }
}