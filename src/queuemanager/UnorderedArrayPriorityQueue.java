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
public class UnorderedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    private final Object[] Storage;
    
    private final int capacity;
    
    private int tailIndex;
    
    private int highestPriority = 0;
    
    private int startPosition = 0;
    
    private int headPosition = 0;
    
    public UnorderedArrayPriorityQueue(int size) {
        Storage = new Object[size];
        capacity = size;
        tailIndex = -1;             
    }
    
        @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i<= tailIndex; i++) {
                if (((PriorityItem<T>) Storage[i]).getPriority() > highestPriority) {
                    highestPriority = ((PriorityItem<T>) Storage[i]).getPriority();
                    headPosition = i;
                }    
            }
            highestPriority = 0;
            return ((PriorityItem<T>) Storage[headPosition]).getItem();           
        }
    }
    
        @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else { 
           for (int i = 0; i <= tailIndex; i++) {
                if (((PriorityItem<T>) Storage[i]).getPriority() > highestPriority) {
                    highestPriority = ((PriorityItem<T>) Storage[i]).getPriority();
                    startPosition = i;
                }               
            } 
           
           for (int x = startPosition; x < tailIndex; x++) {
               Storage[x] = Storage[x+1];
           } 
           highestPriority = 0;
           tailIndex = tailIndex - 1;
        } 
        
    }
    
        @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            Storage[tailIndex] = new PriorityItem<>(item,priority);
        }
    }
    
         @Override 
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    
        @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + Storage[i];
        }
        result = result + "]";
        return result;
    }
} 
