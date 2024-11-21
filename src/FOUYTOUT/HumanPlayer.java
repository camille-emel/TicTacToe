package FOUYTOUT;

import java.util.Scanner;



public class HumanPlayer extends Player {
    View view;

    public HumanPlayer() {
        super();
    }

    public HumanPlayer(State state) {
        super(state);
    }

    @Override
    public int[] makeMove(Cell[][] board) {
        Scanner userInput = new Scanner(System.in);
        int[] positionPlayer = new int[2];
        int rowPos = -1;
        int colPos = -1;
        //TODO secure bad input
        do {
            view.askPosRow();
            //TODO move to userInterface
            rowPos = Integer.parseInt(userInput.nextLine());
        } while (rowPos < 0 || rowPos >= 3);
        do {
            view.askPosCol();
            //TODO move to userInterface
            colPos = Integer.parseInt(userInput.nextLine());
        } while (colPos < 0 || colPos >= 3);
        positionPlayer[0] = rowPos;
        positionPlayer[1] = colPos;
        if (board[rowPos][colPos].getState() != State.EMPTY) {
            view.cellIsNotFree();
            return makeMove(board);
        }
        return positionPlayer;
    }
}
