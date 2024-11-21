package players;

import games.Cell;
import core.State;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random;

    // Constructeur sans paramètre
    public ArtificialPlayer() {
        super();
        this.random = new Random();
    }

    // Constructeur avec state
    public ArtificialPlayer(State state) {
        super(state);
        this.random = new Random();
    }

    @Override
    public int[] makeMove(Cell[][] board) {
        int size = board.length;
        int row, col;

        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (board[row][col].getState() != State.EMPTY);

        return new int[]{row, col};
    }
}
