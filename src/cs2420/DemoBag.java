/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2420;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

/**
 * Demonstrates how to use class Bag
 * @author smaxreiter
 *
 */
public class DemoBag {

	public static void main(String[] args) {
		String[] words = {"ape", "bee", "ell", "cow","dog","bee","dog"};
		
		Stack<String> stack1 = new Stack<>();
		Set<String> set1 = new HashSet<>();
		Bag<String> bag1 = new Bag<>();
		
		for(String w : words){
			bag1.add(w);
			set1.add(w);
			stack1.push(w);
		}
		System.out.println("stack1: "+stack1);
		System.out.println("set1: "+set1);
		
		System.out.println("bag1: "+bag1);
		
		System.out.print("bag1: ");
		Iterator<String> it = bag1.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+ " ");
			
		}
		System.out.println();
	}

}
