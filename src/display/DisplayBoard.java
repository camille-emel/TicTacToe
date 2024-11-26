package display;

import games.Cell;

public class DisplayBoard {

    private Cell cell;
    private Cell[][] board;
    private int nbRow;
    private int nbCol;
    private View view;

    public DisplayBoard(int nbRows, int nbCols) {
        this.board = new Cell[nbRows][nbCols];
        this.nbRow = nbRows;
        this.nbCol = nbCols;

    }

    public DisplayBoard() {

    }

    public void initBoard() {
        board = new Cell[nbRow][nbCol];
        view = new View();
        for (int i = 0; i < nbRow; i++) {
            for (int j = 0; j < nbCol; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void display() {
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
