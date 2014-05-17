package cse222_hw03_091044042;

import java.util.*;

/**
 * @author AAnilApaydin
 * @version 1.0
 * @param <E>
 */
// GITLinkedList class definition
public class GITLinkedList<E> extends AbstractGITList<E>  
                              implements GITList<E> {

        // Member Variables definition
        private int size = 0;
	private KWLinkedList myKWLinkedList;

        /**
         * default constructor
         */
        // Default constructor
        public GITLinkedList(){
            this.myKWLinkedList = new KWLinkedList();
        }
        // Overrided from AbstractGITList
        // add method
        // it adds given item to given index
        @Override
        public void add(int index, E obj) {
             this.myKWLinkedList.add(index, obj);
             this.size++;
        }
        // Overrided from AbstractGITList
        // addFirst method
        // it adds given item to the first index
        @Override
        public void addFirst(E item) {
             this.myKWLinkedList.addFirst(item);
             this.size++;
        }
        // Overrided from AbstractGITList
        // addLast method
        // it adds given item to the last index
        @Override
        public void addLast(E item) {
             this.myKWLinkedList.addLast(item);
             this.size++;
        }
        // Overrided from AbstractGITList
        // get method
        // it get item at given index
        @Override
        public E get(int index) {
            return (E)this.myKWLinkedList.get(index);
        }
        /**
         *
         * @return E
         */
        // Overrided from AbstractGITList
        // getFirst method
        // it get item at first index
        @Override
        public E getFirst() {
            return (E)this.myKWLinkedList.getFirst();
        }

        /**
         *
         * @return E
         */
        // Overrided from AbstractGITList
        // get method
        // it get item at last index
        @Override
        public E getLast() {
            return (E)this.myKWLinkedList.getLast();
        }
        // Overrided from java.util.AbstractCollection
        // remove method
        // it removes given item in list
        @Override
        public boolean remove(Object o) {
            if(super.remove(o)){
                this.size--;
                return true;
            }
            return false;
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
        public Iterator<E> iterator() {
            return this.myKWLinkedList.iterator();
        }

        /**
         *
         * @return ListIterator<E>
         */
        // Overrided from AbstractGITList
        // ListIterator<E> constructor
        // it creates ListIterator<E> object in index 0
        @Override
        public ListIterator<E> listIterator() {
            return this.myKWLinkedList.listIterator();
        }
        /**
         * @param index
         * @return ListIterator<E>
         */
        // Overrided from AbstractGITList
        // ListIterator<E> constructor
        // it creates ListIterator<E> object at given index
        @Override
        public ListIterator<E> listIterator(int index) {
            return this.myKWLinkedList.listIterator(index);
        }
	
}