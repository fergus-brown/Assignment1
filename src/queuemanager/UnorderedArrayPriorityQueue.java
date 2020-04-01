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
    
    /*
    * Searches forwards through the array from position 0 to the size.
    * highestPriority initialised at 0, if the priority at the current position is higher than the highest priority, headPosition is equal to the position of the current object.
    * Once the for loop is completed, highestPriority is set back to 0 and the object at headPosition is returned.
    */
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
    
    /*
    *Searches forwards through the array comparing the priority of the current object to the highest priority so far. 
    *If higher than the stored highestPriority, highestPriority variable is updated and startPosition is set to the position of the current object.
    *For loop moves everything in the storage after the position of the highest priority item down by one until tailIndex is reached
    *Modified from the add() in SortedArrayPriorityQueue class, as they follow similar logic.
    */
    
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
    
    /*
    * Increases the tailIndex by one, then checks that the tailIndex is not greater than or equal to capacity
    * If so, tailIndex is taken back to its original value and an overflow exception is thrown to the user stating the queue is full.
    * If not, the storage at the tailIndex position is set to a new PriorityItem with given parameters.
    */
        @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            Storage[tailIndex] = new PriorityItem<>(item,priority);
        }
    }
    
    /*
    * Returns true if tailIndex is less than 0 (it initialises at -1)
    */
         @Override 
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    
    /*
    * For loop runs from 0 to the tailIndex, inserting the result from storage at position i.
    */
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
