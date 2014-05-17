package cse222_hw03_091044042;

import java.util.*;

/**
 * @author AAnilApaydin
 * @version 1.0
 * @param <E>
 */

// AbstractGITList class definition
// Some methods of GITList are implemented here
// (addAll,containAll,retainAll,removeAll)
public abstract class AbstractGITList<E> extends java.util.AbstractCollection 
                                         implements GITList<E> {
    
    @Override 
    public abstract void add(int index, E obj);
    
    @Override 
    public abstract void addFirst(E item);
    
    @Override 
    public abstract void addLast(E item);
    
    @Override 
    public abstract E get(int index);
   
    /**
     *
     * @return E
     */
    @Override
    public abstract E getFirst(); 

    /**
     *
     * @return E
     */
    @Override
    public abstract E getLast(); 

    @Override
    public abstract Iterator<E> iterator();

    /**
     *
     * @return E
     */
    @Override
    public abstract ListIterator<E> listIterator(); 
    
    @Override 
    public abstract ListIterator<E> listIterator(int index);
   
    // Overrided from GITList
    // It adds all elements of GITList<E> parameter
    @Override
    public boolean addAll(GITList l) { 
    	int tempSize = l.size(); 
        for(int i = 0 ; i < tempSize ; ++i){ 
            this.add(this.size(), (E)l.get(i));
        }
        return true;
    }
    // Overrided from GITList
    // It checks the all elements in the GITList<E> parameter 
    // are contained in the list object
    @Override
    public boolean containsAll(GITList l) {
        int count = 0;  
        for(int i = 0 ; i < l.size() ; ++i){  
            for(int j = 0 ; j < this.size() ; ++j){  
                if(l.get(i).equals(this.get(j))){
                    count++;
                    j=this.size(); 
                }
            }
        }
        return (count==l.size());
    }
    // Overrided from GITList
    // It removes the all elements in the list object  
    // that are not contained in the GITList<E> parameter
    @Override
    public boolean retainAll(GITList l){
        
        boolean containFlag = false;
     
        for(int i = 0 ; i < this.size() ; ++i){  
            for(int j = 0 ; j < l.size() ; ++j){  
                if((l.get(j).equals(this.get(i)))){
                    containFlag = true;
                }
            }
            if(!containFlag){
                this.remove(this.get(i));
                i--; 
            }
            containFlag=false;
        }
        return true;
    
    }
    // Overrided from GITList
    // It removes the all elements in the list object  
    // that are contained in the GITList<E> parameter
    @Override
    public boolean removeAll(GITList l) {
        
        boolean containFlag = true;
        for(int i = 0 ; i < l.size() ; ++i){  
            for(int j = 0 ; j < this.size() ; ++j){  
                if(l.get(i).equals(this.get(j))){
                    this.remove(this.get(j));
                    j = this.size(); 
                    containFlag=true;
                    --i; 
                }
                if(j == this.size()-1 && !(l.get(i).equals(this.get(j))))
                    containFlag=false;
            }
        }
        return true;
    }
  

}// End of AbstractGITList
