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
public class OrderedLinkedList<T> implements PriorityQueue<T>{
  
    private ListNode<T> head;
        
    public OrderedLinkedList() {
        head = null;
    }
    
    /*
    * Returns name from head in the linked list. Head is always in the first position as the list is ordered, so no need to search through the list.
    */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            T name = head.getItem();
            return (name);           
        }
    }
        
    /*
    * Checks the list is empty, or if the priority of the object to be inserted is greater than the heads priority. If it is, the head is updated to the new ListNode.
    * If neither of these things are true, current is set to equal head and the list is searched through to find the correct position to insert the new object.
    * Once the correct position is found, the next and previous pointers are changed based on where they are in the list. For example, if it is inserted at the end of the list, 
    * only the previous pointer is added, and only the next pointer of the previous object is changed.
    */
    @Override
    public void add(T item, int priority) {
       ListNode current;
 
        if (isEmpty()) {
            head = new ListNode<>(item, priority, head, null);
        } else if (head.getPriority() < priority){
                head = new ListNode<>(item, priority, head, null);                
        } else {
            current = head;
            ListNode insert;
            /* Checks current isnt equal to null, and then that current.next isnt equal to null.
            * If next is equal to null, the object is inserted after the current object.
            * If priorities are equal, the new object is inserted next to the current object.
            * If none of this is true, current is changed to the next node in the list.
            */
            while (current!= null) {               
                if (current.next != null && current.priority > priority && current.next.priority < priority && current.priority != priority) {
                    insert = new ListNode<>(item, priority, current.next, current);
                    current.next = insert;
                    break; 
                } else if (current.next == null) {
                    insert = new ListNode<>(item, priority, current.next, current);
                    current.next = insert;                    
                    break;
                } else if (current.priority == priority){
                    insert = new ListNode<>(item, priority, current.next, current);
                    current.next = insert;
                    break;
                } else {
                    current=current.next;
                }   
            }
        }
    }
    
    
    /*
    * Checks queue is not empty. If it is, an UnderflowException is thrown
    * If not, the first object in the list is removed, and head is changed to the next item in the list.
    */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else { 
           head = head.next;
        } 
        
    }
    
    /*
    * Sets a node to head then searches through the list to get the number of objects in it.
    */
    private int getSize() {
        ListNode<T> node = head;
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
        for (ListNode<T> node = head; node != null; node = node.getNext()) {
            if (node != head) {
                result += "[";
            }
            result += node.getItem() + ", " + node.getPriority() + "]";
        }
        return result;
    }
    
    
}
