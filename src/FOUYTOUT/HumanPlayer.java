package FOUYTOUT;

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
        //TODO secure bad input
        do {
            view.askPosRow();
//            if (userInput.nextLine() != char && Number)
            //TODO move to userInterface
            rowPos = Integer.parseInt(userInput.nextLine());
        } while (rowPos < 0 || rowPos >= 5);
        do {
            view.askPosCol();
            //TODO move to userInterface
            colPos = Integer.parseInt(userInput.nextLine());
        } while (colPos < 0 || colPos >= 5);
        positionPlayer[0] = rowPos;
        positionPlayer[1] = colPos;
        if (board[rowPos][colPos].getState() != State.EMPTY) {
            view.cellIsNotFree();
            return makeMove(board);
        }
        return positionPlayer;
    }
}
