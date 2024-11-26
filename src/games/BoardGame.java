package games;

import display.DisplayBoard;
import players.Player;

public abstract class BoardGame {
    private int nbLine;
    private int nbCol;
    private Cell[][] board;
    private Player player1;
    private Player player2;
    private DisplayBoard displayBoard;

    public void setNbLine(int nbLine) {
        this.nbLine = nbLine;
    }

    public void setNbCol(int nbCol) {
        this.nbCol = nbCol;
    }

    public void initPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public void initBoard() {
        board = new Cell[nbLine][nbCol];
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbCol; j++) {
                board[i][j] = new Cell();
            }
        }
        displayBoard = new DisplayBoard(nbLine, nbCol);
    }



    public void display() {
        displayBoard.display(board);
    }

    public void setOwner(int[] positionPlayer, Player player) {
        board[positionPlayer[0]][positionPlayer[1]].setState(player.getState());
    }

    public void play() {
        boolean play = true;

        while (play) {
            displayBoard.display(board);

            for (int i = 0; i < (nbLine * nbCol); i++) {
                Player currentPlayer = (i % 2 == 0) ? player1 : player2;

                int[] move = currentPlayer.makeMove(board);

                setOwner(move, currentPlayer);

                if (isOver(currentPlayer)) {
                    play = false;
                    displayBoard.display(board);
                    break;
                }

                displayBoard.display(board);
            }
        }
    }



    //Conditions de victoire
    public boolean isOver(Player player) {
        for (int i = 0; i < nbLine; i++) {
            if (oneRowCheck(player, i, 2)) {
                return true;
            }
        }
        for (int i = 0; i < nbCol; i++) {
            if (oneColCheck(player, i, 2)) {
                return true;
            }
        }if (oneDiagDownCheck(player, 2) || oneDiagUpCheck(player, 2)){
            return true;
        }
        return false;
    }

    public boolean oneRowCheck(Player player, int row, int alignToWin) {
        int count = 0;
        for (int j = 0; j < nbCol; j++) {
            if (board[row][j].getState() == player.getState()) {
                count++;
                if (count == alignToWin) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean oneColCheck(Player player, int col, int alignToWin) {
        int count = 0;
        for (int i = 0; i < nbLine; i++) {
            if (board[i][col].getState() == player.getState()) {
                count++;
                if (count == alignToWin) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean oneDiagDownCheck(Player player, int alignToWin) {
        int count = 0;
        for (int j = 0; j < nbCol; j++) {
            if (board[j][j].getState() == player.getState()) {
                count++;
                if (count == alignToWin) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean oneDiagUpCheck(Player player, int alignToWin) {
        int count = 0;
        for (int j = 0; j < nbCol; j++) {
            if (board[j][nbCol - j - 1].getState() == player.getState()) {
                count++;
                if (count == alignToWin) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
