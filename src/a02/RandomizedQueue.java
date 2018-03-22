/*
 * Stephen Reiter & Marty
 * CS2420 
 * Randomly queues, samples, and deques objects ex. post its.
 * Resizeable Array implementation. 
 */
package a02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Stephen Reiter This class is a demonstration of how to implement a
 * resizing array 
 * @param <Item>
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int START_SIZE = 20;
    private int size = 0;
    private Item[] array;
    private int n; //Number of items in the list
    
    /**
     * @author Stephen Reiter
     * 
     */
    private Item[] newArray(int newSize) {
        Item[] newArray = (Item[]) new Object[newSize];
        int oldSize = array.length;

        int j = 0;
        for (int i = 0; i < oldSize; i++) {
            if (j == newSize) {
                break;
            }
            if (this.array[i] != null) {
                newArray[j++] = this.array[i];
            }
        }
        return newArray;
    }
    
    /**
     * @author Stephen Reiter 
     * Constructor
     * 
     */
    public RandomizedQueue(){
        size= 0;
        n = RandomizedQueue.START_SIZE;
        array = (Item[]) new Object[n];
    }

    /**
     * @author Stephen Reiter 
     * Checks to see if it's empty and if it is
     * returns true
     * @return boolean
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * @author Stephen Reiter 
     * returns the number of elements
     * @return primitive int
     */
    public int size() {
        return n;
    }

    /**
     * @author Stephen Reiter 
     * Adds a element containing the new item randomly
     * @param item
     */
    public void enqueue(Item item) {

        if (item == null) {
            throw new NullPointerException("The item can't be null");
        }

        if (size == (n * (3 / 4))) {
            n = n * 2;
            array = newArray(n);
        }
        array[size++] = item;
    }
    /**
     * @author Stephen Reiter 
     * Deletes and returns a random item
     * @return 
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("there are no elements");
        }
        int rand = StdRandom.uniform(size);
        while (array[rand] == null) {
            rand = StdRandom.uniform(n);
        }

        Item remove = array[rand];
        array[rand] = null;
        size--;

        if (size == (n * (1 / 4))) {
            n = n / 2;
            array = newArray(n);
        }
        return remove;
    }

    /**
     * @author Stephen Reiter 
     * Checks at random where the array contains an Item
     * @param item
     * @return
     */
    public Item sample() {

        if (isEmpty()) {
            throw new NoSuchElementException("Nothing in here");
        }
        return array[StdRandom.uniform(size)];
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] temp;
        private int tempSize;

        public RandomizedQueueIterator() {
            temp = (Item[]) new Object[n];
            newIterator();
            tempSize = n;
        }
        
        @Override
	public String toString() {
            StringBuilder s = new StringBuilder();
            for(Item item : this.temp)
                s.append(item).append(" ");
                    return s.toString();

	}

        /**
         * @author Stephen Reiter
         *
         * Constructs Iterator
         */
        private void newIterator() {
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (j == size) {
                    break;
                }

                if (array[i] != null) {
                    this.temp[j++] = array[i];
                }
            }
        }

        @Override
        public boolean hasNext() {
            return tempSize != 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();

            } else {
                int rand = StdRandom.uniform(temp.length);

                while (temp[rand] == null) {
                    rand = StdRandom.uniform(temp.length);
                }

                Item el = temp[rand];
                temp[rand] = null;
                tempSize--;
                return el;
            }
        }
    }

    /**
     * ****** Test Client *****************************
     * @param args
     */
    public static void main(String[] args) {
        RandomizedQueue<Object> list = new RandomizedQueue<>();
        
        StdOut.println("size before dequeue/enqueue: " + list.size());
        StdOut.printf("The list %s empty.%n", list.isEmpty() ? "is" : "is not");

        list.enqueue("Star Trek");
        list.enqueue("Data");
        list.enqueue("Picard");
        Object dequeue = list.dequeue();
        Object sample = list.sample();
        StdOut.print(sample);
        StdOut.print(dequeue);
        
       
        
        
        StdOut.println("size after dequeue/enqueue: " + list.size());
        StdOut.printf("The list %s empty.%n", list.isEmpty() ? "is" : "is not");

        StdOut.println("list: ");
        
        
        for (Object el : list) {
            StdOut.print(el + "..");
        }

    }
}
