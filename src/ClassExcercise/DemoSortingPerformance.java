/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassExcercise;
import java.util.Random;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DemoSortingPerformance 
{
	
	private static Integer[] randomIntegers(int n, int  numberOfDigits)
	{
		Integer[] list = new Integer[n];
		Random random = new Random();
		
		for (int i = 0; i < n; i++)
		{
			list[i] = random.nextInt(numberOfDigits);
		}
		return list;
	}
	
	public static void main(String[] args)
	{
		Integer[] theNumbers = randomIntegers(1000,10000);
		
		StdRandom.shuffle(theNumbers);
		long startTime = System.nanoTime();
		Quick.sort(theNumbers);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		StdOut.println("Quick: " + duration/1000000);
		
		
		
		StdRandom.shuffle(theNumbers);
		startTime = System.nanoTime();
		Selection.sort(theNumbers);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		StdOut.println("Selection: " + duration/1000000);
		
		
		
		StdRandom.shuffle(theNumbers);
		//insertion Sort
		startTime = System.nanoTime();
		Insertion.sort(theNumbers);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		StdOut.println("Insertion: " + duration/1000000);
	}
}
