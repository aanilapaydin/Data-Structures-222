/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse222_hw03_091044042;

import java.util.Iterator;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AAnılApaydın
 */
public class GITLinkedListTest {
    
    public GITLinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class GITLinkedList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int index = 0;
        Object obj = 5;
        GITLinkedList instance = new GITLinkedList();
        instance.add(index, obj);
        
        if(!instance.get(0).equals(5))
            fail("Wrong value in GITLinkedList add");
    }

    /**
     * Test of addFirst method, of class GITLinkedList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object item = 3;
        GITLinkedList instance = new GITLinkedList();
        instance.addFirst(item);
        
        if(!instance.get(0).equals(3))
            fail("Wrong value in GITLinkedList addfirst");
    }

    /**
     * Test of addLast method, of class GITLinkedList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object item = 5;
        GITLinkedList instance = new GITLinkedList();
        instance.addLast(item);
        // TODO review the generated test code and remove the default call to fail.
        if(!instance.get(instance.size()-1).equals(5))
            fail("Wrong value in GITLinkedList addlast");
    }

    /**
     * Test of get method, of class GITLinkedList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        GITLinkedList instance = new GITLinkedList();
        instance.add(0, 4);
        Object result = instance.get(index);
        if(!instance.get(index).equals(4))
            fail("Wrong value in GITLinkedList get");
    }

    /**
     * Test of getFirst method, of class GITLinkedList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        GITLinkedList instance = new GITLinkedList();
        instance.add(0, 4);
        if(!instance.getFirst().equals(4))
            fail("Wrong value in GITLinkedList getFirst");
    }

    /**
     * Test of getLast method, of class GITLinkedList.
     */
    @Test
    public void testGetLast() {
        System.out.println("getlast");
        GITLinkedList instance = new GITLinkedList();
        instance.add(0, 4);
        if(!instance.getLast().equals(4))
            fail("Wrong value in GITLinkedList getLast");
    }

    /**
     * Test of remove method, of class GITLinkedList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        GITLinkedList instance = new GITLinkedList();
        instance.add(0,1);
        instance.add(1,2);
        int oldSize = instance.size();  
        instance.remove(1);
        int newSize = instance.size();
 
        if(newSize!=oldSize-1)
            fail("Wrong value in GITLinkedList remove");
    }

    /**
     * Test of size method, of class GITLinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        GITLinkedList instance = new GITLinkedList();
        int expResult = 0;
        int result = instance.size();
        if(result!=expResult)
            fail("Wrong value in GITLinkedList size");
    }

    /**
     * Test of iterator method, of class GITLinkedList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        GITLinkedList instance = new GITLinkedList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        
        if(result.equals(expResult))
            fail("Wrong value in GITLinkedList iterator");
    }

    /**
     * Test of listIterator method, of class GITLinkedList.
     */
    @Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        GITLinkedList instance = new GITLinkedList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        if(result.equals(expResult))
            fail("Wrong value in GITLinkedList listiterator");
    }

    /**
     * Test of listIterator method, of class GITLinkedList.
     */
    @Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int index = 0;
        GITLinkedList instance = new GITLinkedList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator(index);
        if(result.equals(expResult))
            fail("Wrong value in GITLinkedList listiterator index");
    }
    
}
