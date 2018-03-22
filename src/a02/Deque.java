/*
 * Stephen Reiter & Marty 
 * CS2420 
 * Randomly queues, samples, and deques objects ex. post its.
 */
package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;



/**
 * @author Stephen Reiter
 * This class is a demonstration of how to implement
 * a single linked list structure and it's methods
 * @param <Item>
 *
 */


public class Deque<Item> implements Iterable<Item> {
	private Node<Item> head;
	private Node<Item> tail;
	private int n; //Number of items in the list
	
	/**
	 * @author Stephen Reiter
	 * 
	 * Node of LinkedList that stores the data 
	 * and a single reference to the next node
	 *
	 */
	private class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	/**
         * @author Stephen Reiter
	 * returns the number of elements in the linked list
	 * @return primitive int
	 */
	public int size(){
		return n;
	}
	
	/**
         * @author Stephen Reiter
	 * Adds a node containing the new data at the end of the list
	 * 
	 * @param newItem
	 */
	public void enqueueEnd(Item newItem){
		// create new node based on the data provided by the client
		Node<Item> newNode = new Node();
		newNode.item = newItem;
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}else{
			tail.next = newNode;
			tail = newNode;
		}
		n++;
	}
	/**
         * @author Stephen Reiter
	 * Adds a node containing the new data at the front of the list
	 * 
	 * @param newItem
	 */
	public void enqueueFront(Item newItem){
		// create new node based on the data provided by the user
		Node newNode = new Node();
		newNode.item = newItem;
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
		n++;
	}
	
	/**
         * @author Stephen Reiter
	 * Checks to see if the linked is empty and if it is returns true
	 * @return boolean
	 */
	public boolean isEmpty(){
		return n == 0;
	}
	
	@Override
	public String toString() {
		return null;

	}
        
	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator<>(head);
	}
	
	private class DequeIterator<Item> implements Iterator<Item>{
		private Node<Item> currentPosition; 
		
		public DequeIterator(Node<Item> head){
			currentPosition = head;
		}

		@Override
		public boolean hasNext() {
			return currentPosition != null;			
		}

		@Override
		public Item next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Node<Item> tempNode;
			tempNode = currentPosition;
			currentPosition = currentPosition.next;
			return tempNode.item;
		}
	}

	/********  Test Client
     * @param args ******************************/
	public static void main(String[] args) {
		Deque list = new Deque();
		System.out.println("size: " + list.size());
		System.out.printf("The list %s empty.%n", list.isEmpty() ? "is" : "is not");
		
//		list.enqueueEnd(10);
//		list.enqueueEnd(20);
//		list.enqueueEnd(30);
//		list.enqueueFront(5);
                list.enqueueFront("yes");
                list.enqueueEnd("hi");
                list.enqueueEnd("hello");
                list.enqueueEnd("Help");
                list.enqueueFront("no");

                System.out.println("size: " + list.size());
		System.out.printf("The list %s empty.%n", list.isEmpty() ? "is" : "is not");
                
		System.out.println("list: " );
		
		for(Object el : list){
			System.out.print(el + "..");
		}		
//		Iterator<Item> it = list.iterator();
//		for(int i = 0; i < list.size(); i++){
//			System.out.print(it.next() + "_");
//		}
	}
}

