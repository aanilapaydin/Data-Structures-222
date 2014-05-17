package cse222_hw03_091044042;

import java.util.*;

/**
 * @author AAnilApaydin
 * @version 1.0
 * @param <E>
 */
// GITArrayList definition
public class GITArrayList<E> extends AbstractGITList<E> 
                             implements GITList<E>{
        // Members definition
        private static final int INITIAL_CAPACITY = 10;
        private int size = 0;
        private int capacity = 0;
	private KWArrayList myKWArrayList;

        /**
         * constructor 
         */
        // Default constructor
        public GITArrayList(){
            this.myKWArrayList = new KWArrayList();
            this.capacity = INITIAL_CAPACITY;
            this.size = this.myKWArrayList.size();
        }
        // Overrided from Abstract GITList
        // add method with index
        // It add given item at geive index
        // and inserts items in list recursivly
        @Override
        public void add(int index, E obj) {
            if(index<0 || index>size)
                throw new ArrayIndexOutOfBoundsException(index);
            else if(index==0 && this.size!=0)
                this.addFirst(obj);
            else if(index==0 && this.size==0){
                this.myKWArrayList.add(obj);
                this.size = this.myKWArrayList.size();
            } 
            else if(index==size){
                this.myKWArrayList.add(obj);
                this.size = this.myKWArrayList.size();
                this.capacity *= 2; 
            }
            else{        
                E tempObj = this.set(index, obj);
                this.add(index+1, tempObj); 
            }  
        }
        // Overrided from AbstractGITList
        // addFirst method
        // it adds given item to the first index of list
        // and inserts item recursivly
        @Override
        public void addFirst(E item) {
            if(this.size==0){
                this.add(0, item);
            }    
            else {
                E tempObj = this.set(0, item);
                this.add(1, tempObj);
            }
        }
        // Overrided from AbstractGITList
        // addLast method
        // it adds given item to the last index of list
        @Override
        public void addLast(E item) {
            this.myKWArrayList.add(item);
            this.size=this.myKWArrayList.size();
        }
        // Overrided from AbstractGITList
        // get method
        // it gets item in given index
        @Override
        public E get(int index) {
            return (E)this.myKWArrayList.get(index);
        }

        /**
         *
         * @return E
         */
        // Overrided from AbstractGITList
        // getFirst method
        // it gets first item of list
        @Override
        public E getFirst() {
            return (E)this.myKWArrayList.get(0);
        }

        /**
         *
         * @return E
         */
        // Overrided from AbstractGITList
        // getLast method
        // it gets last item of list
        @Override
        public E getLast() {
            return (E)this.myKWArrayList.get(size-1);
        }

        /**
         *
         * @param index
         * @param newValue
         * @return E
         */
        // Delegated from KWArrayList
        // set method
        // it sets given item to given index
        // and returns old value
        public E set(int index, E newValue) {
            return (E)myKWArrayList.set(index, newValue);
        }

        /**
         *
         * @param index
         * @return E
         */
        // Delegated from KWArrayList
        // remove method with index
        // it remove the item in given index
        // and returns old value
        public E remove(int index) {
            if(index < 0 || index >= size)
                throw new ArrayIndexOutOfBoundsException(index);        

            E obj = (E)myKWArrayList.remove(index);
            size--; 

            return obj;

        }
        // Overrided from java.util.AbstractCollection
        // size method
        // it gets size of list
        @Override
        public int size() {
            return this.size;
        }
        // Overrided from AbstractGITList
        // Iterator<E> constructor
        // it creates Iterator<E> object
        @Override
        public Iterator <E> iterator() {
            return new GITArrayListIter(0);
        }

        /**
         *
         * @return E
         */
        // Overrided from AbstractGITList
        // ListIterator<E> constructor
        // it creates ListIterator<E> object in index 0
        @Override
        public ListIterator <E> listIterator() {
            return new GITArrayListIter(0);
        } 
        // Overrided from AbstractGITList
        // ListIterator<E> constructor
        // it creates ListIterator<E> object in given index 
        @Override
        public ListIterator <E> listIterator(int index) {
            return new GITArrayListIter(index);
        }  

        //Inner Iterator Class
        private class GITArrayListIter implements ListIterator < E > {
        
            // Members definition
            private int position;
            private int lastItemReturned;  //lastItemReturnedIndex
            
            //One-parameter constructor
            public GITArrayListIter(int index){
                if (index < 0 || index > size) {
                    throw new IndexOutOfBoundsException(
                                "Invalid index " + index);
                }
                lastItemReturned=-1;
                if(index==size){
                    position = size;
                }
                else {
                    position = index;
                }
                
            }
            // Overrided from java.util.ListIterator
            // has next method
            // returns false if no nextItem otherwise return true
            @Override
            public boolean hasNext() {
                 return position != myKWArrayList.size();
            }
            // Overrided from java.util.ListIterator
            // next method
            // it moves iterators positions
            @Override
            public E next() {
                if (!hasNext()) 
                    throw new NoSuchElementException();
                
                lastItemReturned = position;
                position++;
                return (E)myKWArrayList.get(lastItemReturned);
            }
            // Overrided from java.util.ListIterator
            // has previous method
            // returns false if no prevItem otherwise return true
            @Override
            public boolean hasPrevious() {
                return position!=0;
            }
            // Overrided from java.util.ListIterator
            // nextIndex method
            // returns nextItems index
            @Override
            public int nextIndex() {
                return position;
            }
            // Overrided from java.util.ListIterator
            // previousIndex method
            // returns prevItems index
            @Override
            public int previousIndex() {
                return position - 1;
            }
            // Overrided from java.util.ListIterator
            // previous method
            // it moves iterators positions back
            @Override
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                } 
                position--;
                lastItemReturned=position;
                return (E)myKWArrayList.get(lastItemReturned);   
            }
            // Overrided from java.util.ListIterator
            // add method
            // it add given item to iterators position
            @Override
            public void add(E obj) {
                try {
                     int i = position;
                     GITArrayList.this.add(i, obj);
                     position = i + 1;
                     lastItemReturned = -1;
                } 
                catch (IndexOutOfBoundsException ex) {
                     throw new ConcurrentModificationException();
                }
            }
            // Overrided from java.util.ListIterator
            // remove method
            // it removes item at iterators positions 
            @Override
            public void remove() {
                if (lastItemReturned < 0)
                    throw new IllegalStateException();
                try {
                    GITArrayList.this.remove(lastItemReturned);
                    position = lastItemReturned;
                    lastItemReturned = -1;
                } 
                catch (IndexOutOfBoundsException ex) {
                    throw new ConcurrentModificationException();
                }
            }
            // Overrided from java.util.ListIterator
            // set method
            // it sets item at iterators position
            @Override
            public void set(E item) {
              if (lastItemReturned == -1) {
                throw new IllegalStateException();
              }
              myKWArrayList.set(lastItemReturned, item);
            }
         
        } // End of class GITArrayListIter
           
} // End of GITArrayList class