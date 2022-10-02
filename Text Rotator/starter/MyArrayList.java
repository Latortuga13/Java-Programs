/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */

/**
 * TODO: Add class header
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;

    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * TODO: Method header comment here
	 */
    public void reverseRegion(int fromIndex, int toIndex){
       /**
        * TODO: Add your solution here
        */
        if(fromIndex>size || toIndex>size){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex>=toIndex){
            return;
        }
        else{
            Object[] reorganize=new Object[1+toIndex-fromIndex];
            Object[] reorganize2 = new Object[1+toIndex-fromIndex];
            for(int i=fromIndex;i<=toIndex;i++){
                reorganize[i-fromIndex]= data[i];
            }
            for(int j=0;j<reorganize.length;j++){
                reorganize2[j]=reorganize[reorganize.length-j-1];
                System.out.println(reorganize2[j]);
            }
            for(int k=fromIndex;k<=toIndex;k++){
                data[k]=reorganize2[k-fromIndex];

            }
            
        }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
