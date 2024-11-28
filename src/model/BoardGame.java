package model;

import view.DisplayBoard;

public abstract class BoardGame {
    private int nbLine;
    private int nbCol;
    private Cell[][] board;
    private Player player1;
    private Player player2;
    private DisplayBoard displayBoard;
    private int align;

    public void setNbLine(int nbLine) {
        this.nbLine = nbLine;
    }

    public void setNbCol(int nbCol) {
        this.nbCol = nbCol;
    }
    public void setAlign(int align) {
        this.align = align;
    }

    public void initPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public void initBoard(int row, int col, int align) {
        setNbCol(col);
        setNbLine(row);
        setAlign(align);
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
        System.out.println("Game over");
    }


    //Solution formateur
    /*public boolean isOver() {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < sizeLine; i++) {
            for(int j = 0; j < sizeColumn; j++) {
                if (checkDirection(i, j, 0, 1,currentState)
                    || checkDirection(i, j, 1, 0,currentState)
                    || checkDirection(i, j, 1, 1,currentState)
                    || checkDirection(i, j, 1, -1,currentState)) return true;
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int u, int v, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i+u*k, j + v*k)){
                return false;
            }
            if (board[i+u*k][j + v*k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }*/
    //Conditions de victoire
    public boolean isOver(Player player) {
        for (int i = 0; i < nbLine; i++) {
            if (oneRowCheck(player, i, align) ||oneDiagDownCheck(player,i ,align) || oneDiagUpCheck(player, i, align)) {
                return true;
            }
        }
        for (int i = 0; i < nbCol; i++) {
            if (oneColCheck(player, i, align)) {
                return true;
            }
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

    public boolean oneDiagDownCheck(Player player, int row, int alignToWin) {
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

    public boolean oneDiagUpCheck(Player player, int row, int alignToWin) {
        int count = 0;
        for (int j = 0; j < nbCol; j++) {
            if (board[row][nbCol - j - 1].getState() == player.getState()) {
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
