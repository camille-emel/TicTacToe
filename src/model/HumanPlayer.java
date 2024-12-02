package model;

import java.util.Scanner;
import view.View;



public class HumanPlayer extends Player {
    private final View view;
    private final Scanner scanner;

    public HumanPlayer(State state, View view) {
        super(state);
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] makeMove(Cell[][] board) {
        int[] positionPlayer = new int[2];
        int rowPos = -1;
        int colPos = -1;

        do {
            try {
                view.askPosRow();
                rowPos = Integer.parseInt(scanner.nextLine());
                if (rowPos < 0 || rowPos >= board.length) {
                    view.wrongInput();
                }
            } catch (NumberFormatException e) {
                view.wrongInput();
            }
        } while (rowPos < 0 || rowPos >= board.length);
        do {
            try {
                view.askPosCol();
                colPos = Integer.parseInt(scanner.nextLine());
                if (colPos < 0 || colPos >= board[0].length) {
                    view.wrongInput();
                }
            } catch (NumberFormatException e) {
                view.wrongInput();
            }
        } while (colPos < 0 || colPos >= board[0].length);

        if (board[rowPos][colPos].getState() != State.EMPTY) {
            view.cellIsNotFree();
            return makeMove(board);
        }

        positionPlayer[0] = rowPos;
        positionPlayer[1] = colPos;

        return positionPlayer;
    }
}
