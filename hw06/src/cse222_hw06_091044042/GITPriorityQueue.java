/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse222_hw06_091044042;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 *
 * @author AAnılApaydın
 */
public class GITPriorityQueue<E> extends java.util.PriorityQueue<E>
                                    implements java.util.Queue<E>{
    private  final int INITIAL_CAPACITY = 10;

    /** Class to encapsulate a priority queue node. */
    protected static class Node < E >
      implements Serializable {
        // Data Fields
        protected E data;
        protected Node < E > left;
        protected Node < E > right;

        // Constructors
        public Node(){
            this.data = (E) new Object();
            left = null;
            right = null;
        }
        
        public Node(E data) {
          this.data = data;
          left = null;
          right = null;
        }

        // Methods
        public String toString() {
          return data.toString();
        }
    }
      
    private Node<E> theRoot;
    private Comparator<E> comparator;
    private int size;
    private int cap;
    
    public GITPriorityQueue() {
        theRoot = new Node<E>();
        theRoot.data=null;
        theRoot.left=null;
        theRoot.right=null;
        size = 0;
        cap = INITIAL_CAPACITY;
    }
    
    public GITPriorityQueue(Node<E> root, Comparator<E> comp) {
        theRoot = root;   //protected metod bu
        comparator = comp;
        size = 1;
        cap = INITIAL_CAPACITY;
    }
    
    public GITPriorityQueue(Node<E> root,int capacity, Comparator<E> comp) {
        theRoot = root;   //protected metod bu
        comparator = comp;
        size = 1;
        if(capacity<=0)
            System.err.println("Capacity is not valid");
        else
            cap=capacity;
    }
    
    private int compare(E left,E right){
        if (comparator != null) { // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else { // Use left's compareTo method.
            return ( (Comparable < E > ) left).compareTo(right);
        }
    }
    
    @Override
    public E remove() {
        E newValue = (E)(theRoot.data);
        if(theRoot.data!=null){
            theRoot = theRoot.left;
            size--;
            return newValue;
        }
        else{
            throw new NoSuchElementException("No Such element yet.");    //Throw element exception;
        }
     }

    @Override
    public E element() {
        E newValue = (E)(theRoot.data);
        if(theRoot.data!=null){
            return newValue;
        }
        else{
            throw new NoSuchElementException("No Such element yet.");    //Throw element exception;
        }
    }

    private boolean myAdd(Node<E> root,E e){
        if(root.data==null){
            root.data=e;
            size++;
            root.left = new Node<E>();
            root.left.data = null;
            return true;
        }
        else{
            if(size<cap){
                return myAdd(root.left,e);   
            }
            else
                return false;
        } 
    }
    
    @Override
    public boolean offer(E e) {
         return myAdd(theRoot,e);
    }

    @Override
    public E poll() {
        E newValue = (E)(theRoot.data);
        if(theRoot.data!=null){
            theRoot = theRoot.left;
            size--;
            return newValue;
        }
        else{
            return null;
        }
    }

    @Override
    public E peek() {
        E newValue = (E)(theRoot.data);
        if(theRoot.data!=null){
            return newValue;
        }
        else{
            return null;
        }
    }
    
    public int getSize(){
        return this.size;
    }
      
}
