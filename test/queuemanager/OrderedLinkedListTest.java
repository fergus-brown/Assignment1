/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author fergu
 */
public class OrderedLinkedListTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public OrderedLinkedListTest() {
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
     * Test of head method, of class OrderedLinkedList.
     * Tests head when one item is inserted into the list.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add("testHead", 3);
        Object expResult = "testHead";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of head method, of class OrderedLinkedList.
     * Tests head when nothing is inserted into the list, expects an exception to be thrown.
     */
    @Test
    public void testHeadEmpty() throws Exception {
        System.out.println("head");
        thrown.expect(QueueUnderflowException.class);
        thrown.expectMessage(is("Queue is empty"));
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.head();
    }

    /**
     * Test of head method, of class OrderedLinkedList.
     * Tests the head when multiple items are added into the list, to check it finds the correct one.
     */
    @Test
    public void testHeadMultiple() throws QueueUnderflowException {
        System.out.println("head");
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add("testHead", 3);
        instance.add("testHead2", 4);
        instance.add("testHead", 1);
        Object expResult = "testHead2";
        Object result = instance.head();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class OrderedLinkedList.
     * Test of add method with one PriorityQueue Object added.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object item = "test";
        int priority = 2;
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add(item, priority);
    }
    
     /**
     * Test of add method, of class OrderedLinkedList for multiple inputs.
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
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
    }
    
    /**
     * Test of add method, of class OrderedLinkedList for multiple inputs.
     * Testing with a larger number of items and priorities, as well as changing objects so multiple have the same priority.
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
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add(item1, priority);
        instance.add(item2, priority2);
        instance.add(item3, priority3);
        instance.add(item4, priority4);
        instance.add(item5, priority5);
    }

   /**
     * Test of remove method, of class OrderedLinkedList.
     * Tests the remove method with one object in the list.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add("testRemove", 3);
        instance.remove();
    }
    
    /**
     * Test of remove method, of class OrderedLinkedList for multiple objects.
     * Inserts 5 objects then removes all 5 of these from the array. Highest priority is consistently in a different place in the list.
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
        OrderedLinkedList instance = new OrderedLinkedList();
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
     * Test of remove method, of class OrderedLinkedList.
     * Tests the remove method on an empty list. Expects an exception to be thrown.
     */
    @Test
    public void testRemoveEmpty() throws Exception {
        System.out.println("remove");
        thrown.expect(QueueUnderflowException.class);
        thrown.expectMessage(is("Queue is empty"));
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.remove();
    }
    
    /**
     * Test of remove method, of class OrderedLinkedList for multiple objects.
     * Inserts 5 objects then removes all 5 of these from the array with multiple of the same priority.
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
        OrderedLinkedList instance = new OrderedLinkedList();
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
     * Test of isEmpty method, of class OrderedLinkedList.
     * Tests a list that is empty.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        UnorderedLinkedList instance = new UnorderedLinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmpty method, of class OrderedLinkedList.
     * Tests an list that is not empty.
     */
    @Test
    public void testIsNotEmpty() throws QueueOverflowException {
        System.out.println("isNotEmpty");
        Object item = "test";
        int priority = 3;
        OrderedLinkedList instance = new OrderedLinkedList();
        instance.add(item, priority);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class OrderedLinkedList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UnorderedLinkedList instance = new UnorderedLinkedList();
        String expResult = "[testToString, 3]";
        instance.add("testToString", 3);
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
