/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

/**
 *
 * @author fergu
 * Modified from the provided notes on brightspace on linked lists
 * Wilson, G (2020), Stack Implementation, 18 Feb 2020, Available from
 * https://github.com/mo04gw/Stack-Master [27 03 2020]
 */
public class ListNode<T> {
    public T item;
    public final int priority;
    public ListNode<T> next;
    public ListNode<T> prev;
    
    //Sets passed parameters to the list nodes properties
    public ListNode(T item, int priority, ListNode<T> next, ListNode<T> prev) {
        this.item = item;
        this.priority = priority;
        this.next = next;
        this.prev = prev;
    }
    
    //Gets the item from the current node
    public T getItem() {
        return item;
    }
    
    //Gets the priority from the current node
    public int getPriority() {
        return priority;
    }
    
    //Sets the pointer to the next node
    public void setNext(ListNode<T> next) {
        this.next = next;
    }
    
    //Sets the pointer to the previous node
    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }
    
    //Gets the pointer to the next node
    public ListNode<T> getNext() {
        return next;
    }
    
    //Gets the pointer to the previous node
    public ListNode<T> getPrev() {
        return prev;
    }
}
