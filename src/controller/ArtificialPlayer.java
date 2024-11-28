package controller;

import model.Cell;
import view.State;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random;

    public ArtificialPlayer() {
        super();
        this.random = new Random();
    }

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
