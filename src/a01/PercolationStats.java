/*
 * Stephen Maxwell Reiter && Simeon Wallace
 * Darren Hunter
 * Data Type stats of running percolation with 
 * a NxN grid using static helper classes  
 */
package a01;

import a01.Percolation;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 
 * @author swalla28
 */
public class PercolationStats {


    private double[] percolationThreshold;
    

    public PercolationStats(int N, int T) {
    // Delclares and initializes variable that keeps track of threshold
        int openSiteCount = 0;
        percolationThreshold = new double[T];
       

        if (N <= 0 || T <= 0) 
            throw new IllegalArgumentException("Can't be zero or less than zero");
        
        /*
        
         */
        for (int i = 0; i <= T; i++) {
            Percolation perc1 = new Percolation(N);

            /*
            Opens random sites that are not already open
            Until it percolates
             */
            while (!perc1.percolates()) {

                int random = StdRandom.uniform(N);
                int random2 = StdRandom.uniform(N);

                if (!perc1.isOpen(random, random2)) {
                    perc1.open(random, random2);
                    openSiteCount++;
                }
                
            }
            percolationThreshold[i] = (double)openSiteCount/(N*N);
        }
        

    }

    public double mean() {
        return StdStats.mean(percolationThreshold);
    }

    public double stddev() {
        return StdStats.stddev(percolationThreshold);

    }

    public double confidenceLow() {
        return mean() - stddev();

    }

    public double confidenceHigh() {
        return mean() + stddev();

    }

}
