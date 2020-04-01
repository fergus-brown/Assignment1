/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;


/**
 *
 * @author fergu
 */
public class UnorderedLinkedList<T> implements PriorityQueue<T> {
    
    private ListNode<T> head;
    private ListNode<T> start;
    private ListNode<T> current;
    int highestPriority = 0;
        
    public UnorderedLinkedList() {
        head = null;
        start = null;
    }
    
    /*
    * Moves through the list from position 0 to the size.
    * highestPriority initialised at 0, if the priority at the current position is higher than the highest priority, head is equal to the current object.
    * Once the for loop is completed, highestPriority is set back to 0 and the name from head is returned, and head is set back to start.
    */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            current = head;
            for (int i = 0; i < getSize(); i++) {
                if (current.getPriority() > highestPriority) {
                    head = current;
                    highestPriority = head.getPriority();
                }
                current = current.next;
            }
            T name = head.getItem();
            head = start;
            highestPriority = 0;
            return (name);           
        }
    }
        
    /*
    * Checks list is not empty. If it is, a new item is created and assigned as the head.
    * If not, the head is assigned as the new ListNode, and the next objects previous pointer is set to head.
    * Sets the start position to the head node
    */
    @Override
    public void add(T item, int priority) {
       if (isEmpty()) {
           head = new ListNode(item, priority, head, null);
       } else {
           head = new ListNode(item, priority, head, null);
           head.next.prev = head;          
       }
        start = head;
    }
    
    /*
    * Removes the highest priority item in the list. Searches frowards through the list to the size.
    * Compares the current objects priority to the max priority. If it is greated, the head is set to the current object.
    * Checks that the next item in the list exists, then updates current to this item. If it does not exist, it breaks from the loop.
    * Then multiple conditions are checked to see where the object should be inserted. 
    * If the size of the list is 1, start is set to null.
    * If it is the first item in the list (head.prev == null), the previous counter of the next object is set to null.
    * If it is the last item in the list (head.next == null), the next counter of the previous object is set to null.
    * If it is inserted elsewhere in the list, both the previous objects next point and the next objects previous pointers
    * are changed to the current object.
    * Head is set to start.
    */
    @Override
    public void remove() throws QueueUnderflowException {
        current=head;
        int max = 0;
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else { 
           for ( int i = 1; i <= getSize(); i++) {
               if (current.getPriority() > max) {
                   max = current.getPriority();
                   head = current;
               }
               if (current.next != null) {
                   current = current.next;
               } else {
                   break;
               }
           }
        /*
            * If the size of the list is 1, start is set to null.
            * If it is the first item in the list (head.prev == null), the previous counter of the next object is set to null.
            * If it is the last item in the list (head.next == null), the next counter of the previous object is set to null.
            * If it is inserted elsewhere in the list, both the previous objects next point and the next objects previous pointers
            * are changed to the current object.
            * Head is set to start.
        */             
           if (getSize() == 1) {
               start = null;
           } else if (head.prev == null) {
               head.next.prev = null;
           } else if (head.next == null) {
               head.prev.next = null;
           } else {
               head.next.prev = head.prev;
               head.prev.next = head.next;
           }
        } 
        head = start;
    }
    
    /*
    * Sets a node to start then searches through the list to get the number of objects in it.
    */
    private int getSize() {
        ListNode<T> node = start;
        int result = 0;
        while (node != null) {
            result = result + 1;
            node = node.getNext();
        }
        return result;
    }

     @Override 
    public boolean isEmpty() {
        int empty = getSize();
        return empty == 0;
    }
    
     @Override
    public String toString() {
        String result = "[";
        for (ListNode<T> node = start; node != null; node = node.getNext()) {
            if (node != start) {
                result += "[";
            }
            result += node.getItem() + ", " + node.getPriority() + "]";
        }
        return result;
    }
}
