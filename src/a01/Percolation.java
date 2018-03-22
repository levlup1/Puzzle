/*
 * Stephen Maxwell Reiter && Simeon Wallace
 * Darren Hunter
 * Data Type Percolation uses Weighted Quick Union to check 
 * if connected and in the same connected component.
 * Demonstrates use of Algorithm in linear time for anything 
 * pourous.
 */
package a01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author Stephen Max Reiter
 */
public class Percolation {

    private boolean[][] grid;
    private int bottomNode, topNode, size, n;
    WeightedQuickUnionUF wuf;

    public Percolation(int N) {

        n = N;
        size = N * N;

        grid = new boolean[size][size];

        topNode = size;
        bottomNode = (size) + 1;

        wuf = new WeightedQuickUnionUF(size + 2);
    }

    /*
        Opening neighbors of indices (i,j)
    union() to the top at indice (i,j)
    wuf.union(to1D(i,j-1));
     */
    public void open(int i, int j) {

        if ((i > 0 && j > 0) && isOpen(i - 1, j)) {//connects to left indice
            wuf.union(toOneDimension(i - 1, j), toOneDimension(i, j));
        }
        if ((i < n - 1) && isOpen(i + 1, j)) {//connects to right indice
            wuf.union(toOneDimension(i + 1, j), toOneDimension(i, j));
        }
        if ((j > 0) && isOpen(i, j - 1)) {//connects to top indice
            wuf.union(toOneDimension(i, j), toOneDimension(i, j - 1));
        }
        if ((i < n - 1) && isOpen(i, j + 1)) {//connects bottom indice
            wuf.union(toOneDimension(i, j), toOneDimension(i, j + 1));
        }

    }

    /*
    
     */
    public boolean isOpen(int i, int j) {

        try {
            return grid[i][j];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an exception");
        }
        return false;
    }
    
    
    public boolean isFull(int i, int j) {

        try {
            if (grid[i][j] && wuf.connected(toOneDimension(i, j), topNode)) {
                return grid[i][j];
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught an exception");
        }
        return false;

    }
    
    /*
    checks if the indices are in the same connected component
    */
    public boolean percolates() {
        return wuf.connected(topNode, bottomNode);
    }
    
    

    /*
    toOneDimension() returns k
    (i-1)* n + j)= k
    k is my index to my array
    
    also checks if its out of index
     */
    
    private int toOneDimension(int i, int j) {

        if (i <= 0 || i > n) {
            throw new IndexOutOfBoundsException("bad value for i");
        }
        if (j <= 0 || j > n) {
            throw new IndexOutOfBoundsException("bad value for j");
        }

        return (i) * n + j;

    }

}
