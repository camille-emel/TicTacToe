package games;

import display.UserInteraction;
import display.View;
import players.Player;

public abstract class BoardGame {
    private int nbLine=4;
    private int nbCol=3;
    private Cell[][] board;
    private Player player1;
    private Player player2;
    private View view;
    private UserInteraction userInteraction;

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
        view = new View();
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbCol; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void display() {
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbCol; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < nbCol - 1) {
                    view.cellSeparator();
                }
            }
            view.jumpLineFormat();
        }
    }

    public void setOwner(int[] positionPlayer, Player player) {
        board[positionPlayer[0]][positionPlayer[1]].setState(player.getState());
    }

    public void play() {
        boolean play = true;
        while (play) {
            display();
            for (int i = 0; i < (nbLine * nbCol); i++) {
                //switch player
                Player currentPlayer = (i % 2 == 0) ? player1 : player2;

                int[] move = currentPlayer.makeMove(board);
                setOwner(move, currentPlayer);

                if (isOver(currentPlayer)) {
                    play = false;
                    display();
                    break;
                }
                display();
            }
        }
        view.gameOver();
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
