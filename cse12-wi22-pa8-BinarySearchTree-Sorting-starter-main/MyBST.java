import java.util.ArrayList;


public class MyBST<K extends Comparable<K>,V>{
    MyBSTNode<K,V> root = null;
    int size = 0;

    public int size(){
        return size;
    }
/**
         *
         * This method inserts a new node object.
         * 
         * @return the value replaced by the current node object
         */
    public V insert(K key, V value){
        // TODO
        if(key==null){
            throw new NullPointerException("Null input detected");
        }
        if(root==null){
            root = new MyBSTNode<K,V>(key, value, null);
        }
        else{
            boolean stillSearching=true;
            MyBSTNode<K,V> curr = root;
            while(stillSearching==true){
                if(key.compareTo(curr.key)<0){
                    if(curr.getLeft()==null){
                        MyBSTNode<K,V> insertNode = 
                        new MyBSTNode<K,V>(key, value, curr);
                        curr.setLeft(insertNode);
                        size=size+1;
                        stillSearching=false;
                    }
                    else{
                        curr = curr.getLeft();
                    }
                }
                else if(key.compareTo(curr.key)>0){
                    if(curr.getRight()==null){
                        MyBSTNode<K,V> insertNode = 
                        new MyBSTNode<K,V>(key, value, curr);
                        curr.setRight(insertNode);
                        size=size+1;
                        stillSearching=false;
                    }
                    else{
                        curr = curr.getRight();
                    }
                }
                else{
                    V toReturn = curr.value;
                    curr.setValue(value);
                    return toReturn;
                }
            }
        }
        return null;
    }
    /**
         *
         * This method searches for a specific value connected to the key 
         * the user inputs
         * @return the value of the specific key searched for
         */
    public V search(K key){
        // TODO
        if(key==null){
            return null;
        }
        MyBSTNode<K,V> curr = root;
        boolean stillSearching=true;
        while(stillSearching==true){
            if(key.compareTo(curr.key)==0){
                return curr.getValue();
            }
            else if(key.compareTo(curr.key)>0){
                if(curr.getRight()==null){
                    stillSearching=false;
                }
                curr = curr.getRight();
            }
            else{
                if(curr.getLeft()==null){
                    stillSearching=false;
                }
                curr=curr.getLeft();
            }
        }
        return null;
    }
    /**
         *
         * This method removes the object associated wth the inputted key
         * @return the value of the removed object
         */
    public V remove(K key){
        // TODO
        if(key==null){
            return null;
        }
        MyBSTNode<K,V> curr = root;
        boolean stillSearching=true;
        int check = 0;
        while(stillSearching==true){
            if(size==1){
                if(curr.parent!=null){
                    curr=curr.parent;
                }
                curr.parent=null;
                curr.setLeft(null);
                curr.setRight(null);
                curr=null;
                size=size-1;
                return null;
            }
            if(key.compareTo(curr.key)>0){
                if(curr.getRight()==null){
                    stillSearching=false;
                }
                curr = curr.getRight();
                check=1;
            }
            else if(key.compareTo(curr.key)<0){
                if(curr.getLeft()==null){
                    stillSearching=false;
                }
                curr=curr.getLeft();
                check=2;
            }
            else{
                V toReturn= curr.getValue();
                if(check==0){
                    curr.getRight().setLeft(curr.getLeft());
                    curr.getLeft().parent=curr.getRight();
                    curr.getRight().parent=null;
                    size=size-1;
                    return toReturn;
                }
                if(check==1){
                    if(size==1){
                        if(curr.parent!=null){
                            curr=curr.parent;
                        }
                        curr.parent=null;
                        curr.setLeft(null);
                        curr.setRight(null);
                    }
                    else if(curr.getLeft()!=null){
                        curr.parent.setRight(curr.getLeft());
                        curr.getLeft().parent=curr.parent;
                        curr.getLeft().setRight(curr.getRight());
                        if(curr.getRight()!=null){
                            curr.getRight().parent=curr.getLeft();
                        }
                    }
                    else if(curr.getRight()!=null){
                        curr.parent.setRight(curr.getRight());
                        curr.getRight().parent=curr.parent;
                    }
                    else{
                        curr.parent.setRight(null);
                    }
                    size=size-1;
                    return toReturn;
                }
                if(check==2){
                    if(size==1){
                        if(curr.parent!=null){
                            curr=curr.parent;
                        }
                        curr.parent=null;
                        curr.setLeft(null);
                        curr.setRight(null);
                    }
                    if(curr.getRight()!=null){
                        curr.parent.setLeft(curr.getRight());
                        curr.getRight().parent=curr.parent;
                        curr.getRight().setLeft(curr.getLeft());
                        if(curr.getLeft()!=null){
                            curr.getLeft().parent=curr.getRight();
                        }
                    }
                    else if(curr.getLeft()!=null){
                        curr.parent.setLeft(curr.getLeft());
                        curr.getLeft().parent=curr.parent;
                    }
                    else{
                        curr.parent.setLeft(null);
                    }
                    size=size-1;
                    return toReturn;
                }
            }
        }
        size=size-1;
        return null;
    }
    /**
         *
         * This method reorganizes the data in the BST and puts it into
         * an arraylist in increasing order
         * @return the reorganized array list
         */
    public ArrayList<MyBSTNode<K, V>> inorder(){
        // TODO
        ArrayList<MyBSTNode<K,V>> toReturn = 
        new ArrayList<MyBSTNode<K,V>>(0);
        if(size==0){
            return toReturn;
        }
        MyBSTNode<K,V> curr = root;
        while(curr.getLeft()!=null){
            curr=curr.getLeft();
        }
        for(int i=0;i<size;i++){
            toReturn.add(curr);
            curr=curr.successor();
        }
        return toReturn;
    }

    static class MyBSTNode<K,V>{
        private static final String TEMPLATE = "Key: %s, Value: %s";
        private static final String NULL_STR = "null";

        private K key;
        private V value;
        private MyBSTNode<K,V> parent;
        private MyBSTNode<K,V> left = null;
        private MyBSTNode<K,V> right = null;

        /**
         * Creates a MyBSTNode<K,V> storing specified data
         * @param key the key the MyBSTNode<K,V> will
         * @param value the data the MyBSTNode<K,V> will store
         * @param parent the parent of this node
         */
        public MyBSTNode(K key, V value, MyBSTNode<K, V> parent){
            this.key = key;
            this.value = value;
            this.parent = parent; 
        }

        /**
         * Return the key stored in the the MyBSTNode<K,V>
         * @return the key stored in the MyBSTNode<K,V>
         */
        public K getKey(){
            return key;
        }

        /**
         * Return data stored in the MyBSTNode<K,V>
         * @return the data stored in the MyBSTNode<K,V>
         */
        public V getValue(){
            return value;
        }

        /**
         * Return the parent
         * @return the parent
         */
        public MyBSTNode<K,V> getParent(){
            return parent;
        }

        /**
         * Return the left child 
         * @return left child
         */
        public MyBSTNode<K,V> getLeft(){
            return left;
        }

        /**
         * Return the right child 
         * @return right child
         */
        public MyBSTNode<K,V> getRight(){
            return right;
        }

        /**
         * Set the key stored in the MyBSTNode<K,V>
         * @param newKey the key to be stored
         */
        public void setKey(K newKey){
            this.key = newKey;
        }

        /**
         * Set the data stored in the MyBSTNode<K,V>
         * @param newValue the data to be stored
         */
        public void setValue(V newValue){
            this.value = newValue;
        }

        /**
         * Set the parent
         * @param newParent the parent
         */
        public void setParent(MyBSTNode<K,V> newParent){
            this.parent = newParent;
        }

        /**
         * Set the left child
         * @param newLeft the new left child
         */
        public void setLeft(MyBSTNode<K,V> newLeft){
            this.left = newLeft;
        }

        /**
         * Set the right child
         * @param newRight the new right child
         */
        public void setRight(MyBSTNode<K,V> newRight){
            this.right = newRight;
        }

        /**
         * TODO: add inline comments for this method to demonstrate your
         *   understanding of this method. The predecessor can be implemented
         *   in a similar way.
         *
         * This method returns the in order successor of current node object.
         * It can be served as a helper method when implementing inorder().
         * @return the successor of current node object
         */
        public MyBSTNode<K, V> successor(){
            //checks if the right value is null
            if(this.getRight() != null){
                MyBSTNode<K,V> curr = this.getRight();
                //gets to the smallest value of the right heap of the bst
                while(curr.getLeft() != null){
                    curr = curr.getLeft();
                }
                //return the smallest value of the right heap of the bst
                return curr;
            }
            //if there is noright value do this.
            else{
                MyBSTNode<K,V> parent = this.getParent();
                MyBSTNode<K,V> curr = this;
                //finds the smallest parent
                while(parent != null && curr == parent.getRight()){
                    curr = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }
        /**
         *
         * This method returns the in order predecessor of current node object.
         * It can be served as a helper method when implementing inorder().
         * @return the predecessor of current node object
         */
        public MyBSTNode<K, V> predecessor(){
            // TODO
            if(this.getLeft() !=null){
                MyBSTNode<K,V> curr = this.getLeft();
                while(curr.getRight() != null){
                    curr = curr.getRight();
                }
                return curr;
            }
            else{
                MyBSTNode<K,V> parent = this.getParent();
                MyBSTNode<K,V> curr = this; 
                while(parent != null && curr == parent.getLeft()){
                    curr = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }

        /** This method compares if two node objects are equal.
         * @param obj The target object that the currect object compares to.
         * @return Boolean value indicates if two node objects are equal
         */
        public boolean equals(Object obj){
            if (!(obj instanceof MyBSTNode))
                return false;

            MyBSTNode<K,V> comp = (MyBSTNode<K,V>)obj;
            
            return( (this.getKey() == null ? comp.getKey() == null : 
                this.getKey().equals(comp.getKey())) 
                && (this.getValue() == null ? comp.getValue() == null : 
                this.getValue().equals(comp.getValue())));
        }

        /**
         * This method gives a string representation of node object.
         * @return "Key:Value" that represents the node object
         */
        public String toString(){
            return String.format(
                    TEMPLATE,
                    this.getKey() == null ? NULL_STR : this.getKey(),
                    this.getValue() == null ? NULL_STR : this.getValue());
        }
    }

}