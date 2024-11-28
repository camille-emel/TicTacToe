package players;

import games.Cell;
import display.State;
import display.View;

import java.util.Scanner;



public class HumanPlayer extends Player {

    public HumanPlayer() {
        super();
    }

    public HumanPlayer(State state) {
        super(state);
    }

    @Override
    public int[] makeMove(Cell[][] board) {
        View view = new View();
        Scanner userInput = new Scanner(System.in);

        int[] positionPlayer = new int[2];
        int rowPos = -1;
        int colPos = -1;

        do {
            try {
                view.askPosRow();
                rowPos = Integer.parseInt(userInput.nextLine());
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
                colPos = Integer.parseInt(userInput.nextLine());
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
