package cse222_hw03_091044042;

import java.util.*;

/**
 * @author AAnilApaydin
 * @version 1.0
 * @param <E>
 */

// GITList interface definition
public interface GITList<E> extends java.util.Collection{

	/**
	 * 
	 * @param index
	 * @param obj
	 */
	public void add(int index, E obj);

	/**
	 * 
	 * @param item
	 */
	public void addFirst(E item);

	/**
	 * 
	 * @param item
	 */
	public void addLast(E item);

	/**
	 * 
	 * @param index
         * @return E
	 */
	public E get(int index);

    /**
     *
     * @return E
     */
    public E getFirst();

    /**
     *
     * @return E
     */
    public E getLast();

    @Override
    public Iterator<E> iterator();

    /**
     *
     * @return ListIterator<E>
     */
    public ListIterator<E> listIterator();

    /**
     * 
     * @param index
     * @return ListIterator<E>
     */
    public ListIterator<E> listIterator(int index);

    /**
     * 
     * @param l
     * @return boolean
     */
    public boolean addAll(GITList<E> l);

    /**
     * 
     * @param l
     * @return boolean
     */
    public boolean containsAll(GITList<E> l);

    /**
     * 
     * @param l
     * @return boolean
     */
    public boolean removeAll(GITList<E> l);

    /**
     * 
     * @param l
     * @return boolean
     */
    public boolean retainAll(GITList<E> l);

}// End of GITList interface