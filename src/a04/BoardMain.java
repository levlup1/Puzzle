package a04;
/**
 * Stephen Max Reiter
 * 2420
 * Darrin Hunter
 * March 12th 2018
 * BoardMain.java
 * @author smaxreiter
 *
 */


public class BoardMain {

	public static void main(String[] args) {
		String filename = "/a04/puzzle1.txt";
		edu.princeton.cs.algs4.In in = new edu.princeton.cs.algs4.In(filename);
		int N = in.readInt();
		System.out.printf("NxN = %d x %d %n%n ", N,N);

		int[][] blocks = new int[N][N];

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				blocks[row][col] = in.readInt();
			}
		}

		Board board = new Board(blocks);
		edu.princeton.cs.algs4.StdOut.println(board.toString());

		System.out.println("board size: " + board.size());
		System.out.println("hamming: " + board.hamming());
		System.out.println("manhattan: " + board.manhattan());
		System.out.println("goal: " + board.isGoal());
		// System.out.println(board);
		System.out.println("");
		System.out.println("Neighbors: ");
		Iterable<Board> it = board.neighbors();

		for (Board b : it) {
			System.out.println(b);
		}

		System.out.println("\nTwin:" + board.twin());
		// System.out.println(board);
	}

}
