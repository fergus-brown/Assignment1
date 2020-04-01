/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author fergu
 * mkyong. (2009) JUnit- Expected Exceptions Test, mkyong, Available from 
 * https://www.google.com/search?client=firefox-b-d&q=%40test%28expected%29
 * [30/04/2020]
 */
public class UnorderedArrayPriorityQueueTest {
    
    //(mkyong, 2009)
    @Rule
    public ExpectedException thrown = ExpectedException.none();
            
    public UnorderedArrayPriorityQueueTest() {
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
     * Test of head method, of class UnorderedArrayPriorityQueue.
     * Tests head when one item is inserted into the array.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add("testHead", 3);
        Object expResult = "testHead";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of head method, of class UnorderedArrayPriorityQueue.
     * Tests head when array is empty.
     */
    @Test
    public void testHeadEmpty() throws Exception {
        System.out.println("head");
        //(mkyong, 2009)
        thrown.expect(QueueUnderflowException.class);
        thrown.expectMessage(is("Queue is empty"));
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.head();
    }
    
    /**
     * Test of head method, of class UnorderedArrayPriorityQueue.
     * Tests head when multiple items are inserted into the array.
     */
    @Test
    public void testHeadMultiple() throws Exception {
        System.out.println("head");
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add("testHead", 3);
        instance.add("testHead2", 4);
        instance.add("testHead", 1);
        Object expResult = "testHead2";
        Object result = instance.head();
        assertEquals(expResult, result);
    }


    /**
     * Test of add method, of class UnorderedArrayPriorityQueue.
     * Tests head when one item is inserted into the array.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = "test";
        int priority = 2;
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add(item, priority);
    }
    
    /**
     * Test of add method, of class UnorderedArrayPriorityQueue for multiple inputs.
     * Testing with a larger number of items and priorities, as well as changing the priorities to be both higher and lower than the previous
     */
    @Test
    public void testAddMultiple() throws Exception {
        System.out.println("add multiple");
        Object item1 = "firstItem";
        int priority = 2;
        Object item2 = "secondItem";
        int priority2 = 3;
        Object item3 = "thirdItem";
        int priority3 = 1;
        Object item4 = "fourthItem";
        int priority4 = 5;
        Object item5 = "fifthItem";
        int priority5 = 4;
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
    }
    
     /**
     * Test of add method, of class UnorderedArrayPriorityQueue for multiple inputs.
     * Testing with a larger number of items and priorities, with multiple objects having the same priority
     */
    @Test
    public void testAddSame() throws Exception {
        System.out.println("add multiple");
        Object item1 = "firstItem";
        int priority = 2;
        Object item2 = "secondItem";
        int priority2 = 2;
        Object item3 = "thirdItem";
        int priority3 = 3;
        Object item4 = "fourthItem";
        int priority4 = 3;
        Object item5 = "fifthItem";
        int priority5 = 3;
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
    }
    
     /**
     * Test of add method, of class UnorderedArrayPriorityQueue for multiple inputs.
     * Tests inserting into an array with more objects than the size allows. Expects an overflow exception.
     */
    @Test
    public void testAddOverflow() throws Exception {
        System.out.println("add multiple");
        Object item1 = "firstItem";
        int priority = 2;
        Object item2 = "secondItem";
        int priority2 = 3;
        Object item3 = "thirdItem";
        int priority3 = 1;
        Object item4 = "fourthItem";
        int priority4 = 5;
        Object item5 = "fifthItem";
        int priority5 = 4;
        //(mkyong, 2009)
        thrown.expect(QueueOverflowException.class);
        thrown.expectMessage(is("Queue is full"));
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(4);
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
    }

     /**
     * Test of remove method, of class SortedArrayPriorityQueue for multiple objects.
     * Inserts 5 objects then removes all 5 of these from the array.
     */
    @Test
    public void testRemoveMultiple() throws Exception {
        System.out.println("remove");
        Object item1 = "firstItem";
        int priority = 2;
        Object item2 = "secondItem";
        int priority2 = 3;
        Object item3 = "thirdItem";
        int priority3 = 1;
        Object item4 = "fourthItem";
        int priority4 = 5;
        Object item5 = "fifthItem";
        int priority5 = 4;
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
        instance.remove();
        instance.remove();
        instance.remove();
        instance.remove();
        instance.remove();
    }
    
    /**
     * Test of remove method, of class UnorderedArrayPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove multiple");
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add("testRemove", 3);
        instance.remove();
    }
    
     /* Test of remove method, of class SortedArrayPriorityQueue for multiple objects.
     * Inserts 5 objects with some having the same priorities, then removes all 5 of these from the array.
     */
    @Test
    public void testRemoveMultipleSame() throws Exception {
        System.out.println("remove");
        Object item1 = "firstItem";
        int priority = 2;
        Object item2 = "secondItem";
        int priority2 = 2;
        Object item3 = "thirdItem";
        int priority3 = 3;
        Object item4 = "fourthItem";
        int priority4 = 3;
        Object item5 = "fifthItem";
        int priority5 = 3;
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
        instance.remove();
        instance.remove();
        instance.remove();
        instance.remove();
        instance.remove();
    }
    
     /**
     * Test of remove method, of class UnorderedLinkedList.
     * Tests removal from an empty list. Expects underflow exception.
     */
    @Test
    public void testRemoveEmpty() throws Exception {
        System.out.println("remove");
        //(mkyong, 2009)
        thrown.expect(QueueUnderflowException.class);
        thrown.expectMessage(is("Queue is empty"));
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue(8);
        instance.remove();
    }

     /**
     * Test of isEmpty method, of class UnorderedArrayPriorityQueue.
     * Tests an array that is empty.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of isEmpty method, of class UnorderedArrayPriorityQueue.
     * Tests an array that is not empty.
     */
    @Test
    public void testIsNotEmpty() throws QueueOverflowException {
        System.out.println("isNotEmpty");
        Object item = "test";
        int priority = 3;
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add(item, priority);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SortedArrayPriorityQueue.
     */
    @Test
    public void testToString() throws QueueOverflowException {
        System.out.println("toString");
        UnorderedArrayPriorityQueue instance = new UnorderedArrayPriorityQueue<>(8);
        instance.add("testToString", 3);
        String expResult = "[(testToString, 3)]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
