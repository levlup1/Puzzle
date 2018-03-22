/*****************************************************
 * Stephen Max Reiter
 * Travis Schnider
 * 2420
 * Darrin Hunter
 * March 15th 2018
 * SolverMain.java
 *  
 * @author smaxreiter
 ******************************************************
 */
package a04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author OWNER
 */
public class SolverMain {
      /* solve a slider puzzle (given below) */
    public static void main(String[] args){
        // create initial board from file
    	//String filename = "/puzzle/puzzle1.txt";
    	String filename = "/puzzle/unsolvable.txt";
        In in = new In(filename);
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        
        System.out.println("solvable?: " + initial.isSolvable());
        System.out.println(initial.toString());
        
        
        /*
        checks if puzzle is solvable
        */
        if (initial.isSolvable()) {
        	System.out.println("Hi");
            Solver solver = new Solver(initial);
            System.out.println(solver.toString());
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
       
        else {
            StdOut.println("Unsolvable puzzle");
        }
    }
  
}
