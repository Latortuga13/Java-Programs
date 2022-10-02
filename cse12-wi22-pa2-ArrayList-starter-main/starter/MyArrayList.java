import java.sql.DriverAction;

/**
 * TODO: Add your file header
 * Name:    Seth
 * ID:  A17075727   
 * Email:   schng@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This is my array list class, where i define multiple methods for my arraylists to do. Some examples are the get and set methods, which respectively get and set values in arrays.
 */

 /**
 * TODO: Add your implementation of MyArrayList here
 */
class MyArrayList<E> implements MyList{
    Object[] data;
    int size;
    public MyArrayList(){
        this.data=new Object[5];
        size=0;    
    }
    public MyArrayList(int initialcapacity){
        if(initialcapacity<0){
            throw new IllegalArgumentException("Invalid input");
        }
        this.data=new Object[initialcapacity];
        size=0;
    }
    public MyArrayList(E[] arr){
        if(arr==null){
            this.data=new Object[5];
            size=0;
        }
        else{
            this.data=arr;
            size=this.data.length;
        }
    }
    @Override
    public void expandCapacity (int requiredCapacity){
        if(requiredCapacity<data.length){
            throw new IllegalArgumentException("the required capacity is smaller than the initial");
        }
        int evaluatedCapacity=5;
        if(data.length==0){
            evaluatedCapacity=5;
        }
        else if(data.length!=0){
            evaluatedCapacity=data.length*2;
        }
        if(evaluatedCapacity<requiredCapacity){
            evaluatedCapacity=requiredCapacity;
        }
        Object[] newArray = new Object[evaluatedCapacity];
        for(int i=0;i<data.length;i++){
            newArray[i]=data[i];
        }
        data=newArray;
    }
    @Override
    public int getCapacity(){
        return data.length;
    }
    @Override
    public void insert(int index, Object element){
        if(index<0 || size<index){
            throw new IndexOutOfBoundsException("You are out of bounds");
        }
        size=size+1;
        if(size>=getCapacity()){
            expandCapacity(size);
        }
        int evaluatedCapacity=getCapacity();
        Object[] newArray = new Object[evaluatedCapacity];
        for(int i=0;i<index;i++){
            newArray[i]=data[i];
        }
        for(int i=index+1;i<size;i++){
            newArray[i]=data[i-1];
        }
        data=newArray;
        data[index]=element;
    }
    @Override
    public void append(Object element){
        if(size==getCapacity()){
            expandCapacity(size+1);
        }
        else if(size>getCapacity()){
            expandCapacity(size);
        }
        data[size]=element;
        size+=1;
    }
    @Override
    public void prepend(Object element){
        insert(0,element);
    }
    @Override
    public Object get(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("You tried to get an item out of bounds");
        }
        return data[index];
    }
    @Override
    public Object set(int index, Object element){
        Object var = null;
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("You tried to set an item out of bounds");
        }
        data[index]= var;
        data[index]=element;
        return var;
    }
    @Override
    public Object remove(int index){
        Object save=null;
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("You tried to remove an item out of bounds");
        }
        int evaluatedCapacity=getCapacity();
        Object[] newArray = new Object[evaluatedCapacity];
        for(int i=0;i<index;i++){
            newArray[i]=data[i];
        }
        for(int i=index+1;i<size;i++){
            newArray[i-1]=data[i];
        }
        data=newArray;
        size--;
        return save;
    }
    @Override
    public int size(){
        return size;
    }
}


 // Hint: the 'capacity' (length of data array) is not the same as the 'size'
 // Size is the number of elements in the ArrayList, i.e., the number of valid elements in the array
