package view;

import model.Cell;

public class DisplayBoard {
    private int nbRow;
    private int nbCol;
    private View view;

    public DisplayBoard(int nbRows, int nbCols) {
        this.nbRow = nbRows;
        this.nbCol = nbCols;
        this.view = new ConsoleView();
    }

    public void display(Cell[][] board) {
        view.currentBoard();
        for (int i = 0; i < nbRow; i++) {
            for (int j = 0; j < nbCol; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < nbCol - 1) {
                    view.cellSeparator();
                }
            }
            view.jumpLineFormat();
        }
    }
}
