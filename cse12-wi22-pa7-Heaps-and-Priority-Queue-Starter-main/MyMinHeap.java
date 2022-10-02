import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * TODO: Add your file header
 * Name: Seth
 * ID: A17075727
 * Email:   schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * none
 * 
 * This is my minheap class. It organizes data in an array to be 
 * a heap that goes up the smaller the values are. 
 */

// Your import statements

/**
 * TODO: Add class header
 */
public class MyMinHeap<E extends Comparable<E>> 
    implements MinHeapInterface <E>{
    public ArrayList<E> data;
    public MyMinHeap(){
        data = new ArrayList<E>(0);
    }
    public MyMinHeap(Collection<? extends E> collection){
        data = new ArrayList<E>(collection);
        for(int i=data.size()-1;i>=0;i--){
            if(data.get(i)==null){
                throw new NullPointerException("Null input detected");
            }
            percolateDown(i);
            System.out.println(i+" :"+data);
        }
    }
    protected void swap(int from, int to){
        E fromTo = data.get(from);
        E toFrom = data.get(to);
        data.set(from, toFrom);
        data.set(to, fromTo);

    }
    protected int getParentIdx(int index){
        int newIndex;
        if(index==0){
            newIndex=0;
        }
        newIndex = (index-1)/2;
        return newIndex;
    }
    protected int getLeftChildIdx(int index){
        //System.out.println("Left Child");
        int newIndex = 2*(index+1)-1;
        return newIndex;
    }
    protected int getRightChildIdx(int index){
        //System.out.println("RightChild");
        int newIndex = 2*(index+1);
        return newIndex;
    }
    protected int getMinChildIdx(int index){
        if(2*(index+1)>data.size()){
            return -1;
        }
        int right = getRightChildIdx(index);
        int left = getLeftChildIdx(index);
        if(right<data.size()){
            if(data.get(right).compareTo(data.get(left))<0){
                return right;
            }
        }
        return left;
    }
    protected void percolateUp(int index){
        while(data.get(getParentIdx(index)).compareTo(data.get(index))>0){
            int to = getParentIdx(index);
            swap(index,to);
            index=to;
        }
    }
    protected void percolateDown(int index){
        if(getMinChildIdx(index)<0){
            return;
        }
        while(data.get(getMinChildIdx(index)).compareTo(data.get(index))<0){
            int to = getMinChildIdx(index);
            swap(index,to);
            index=to;
            if(getMinChildIdx(index)<0){
                return;
            }
        }
    }
    protected E deleteIndex(int index){
        E toReturn = data.get(index);
        if(index==data.size()-1){
            data.remove(index);
            return toReturn;
        }
        else{
            swap(index,data.size()-1);
            data.remove(data.size()-1);
        }
        percolateDown(index);
        percolateUp(index);
        return toReturn; 
    }
    public void insert(E element){
        if(element==null){
            throw new NullPointerException();
        }
        data.add(element);
        percolateUp(data.size()-1);
    }
    public E getMin(){
        if(data.size()==0){
            return null;
        }
        E toReturn = data.get(0);
        for(int i=0;i<data.size()-1;i++){
            if (data.get(i).compareTo(data.get(i+1))>0){
                toReturn=data.get(i+1);
            }
        }
        return toReturn;
    }
    public E remove(){
        if(data.size()==0){
            return null;
        }
        return deleteIndex(0);
    }
    public int size(){
        return data.size();
    }
    public void clear(){
        data.clear();
    }
}