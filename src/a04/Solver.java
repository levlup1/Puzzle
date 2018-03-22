/**
 * ***************************************************
 * Stephen Max Reiter Travis Schnider 
 * 2420
 * Darrin Hunter
 * March 15th 2018
 * Solver.java
 *
 * @author smaxreiter *****************************************************
 */
package a04;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {

    private Move prevMove;

    /* Utilizing the A* algorithm
	 * Throws with exceptions
	 * 
     */
    public Solver(Board initial) {

        if (initial == null) {
            throw new NullPointerException();
        }
        if (!initial.isSolvable()) {
            throw new IllegalArgumentException();
        }

        MinPQ<Move> moves = new MinPQ<>();
        moves.insert(new Move(initial));

        MinPQ<Move> twinMoves = new MinPQ<>();
        twinMoves.insert(new Move(initial.twin()));

        while (true) {
            prevMove = expand(moves);
            if (prevMove != null || expand(twinMoves) != null) {
                return;
            }
        }
    }

    /* min number of moves to solve initial board */
    public int moves() {
        return isSolvable() ? prevMove.numMoves : -1;
    }

    private boolean isSolvable() {
        return (prevMove != null);

    }

    /* 
    sequence of boards in a shortest solution 
     */
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        }

        Stack<Board> moves = new Stack<>();
        while (prevMove != null) {
            moves.push(prevMove.board);
            prevMove = prevMove.previous;
        }

        return moves;
    }

    private Move expand(MinPQ<Move> moves) {
        if (moves.isEmpty()) {
            return null;
        }

        Move bestMove = moves.delMin();

        if (bestMove.board.isGoal()) {
            return bestMove;
        }
        for (Board neighbor : bestMove.board.neighbors()) {
            if (bestMove.previous == null || !neighbor.equals(bestMove.previous.board)) {
                moves.insert(new Move(neighbor, bestMove));
            }
        }
        return null;
    }

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private class Move implements Comparable<Move> {

        private Move previous;
        private Board board;
        private int numMoves = 0;

        public Move(Board board) {
            this.board = board;
        }

        public Move(Board board, Move previous) {
            this.board = board;
            this.previous = previous;
            this.numMoves = previous.numMoves + 1;
        }

        @Override
        public int compareTo(Move move) {
            return (this.board.manhattan() - move.board.manhattan()) + (this.numMoves - move.numMoves);
        }
    }

}
