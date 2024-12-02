package model;

//import view.DisplayBoard;

public abstract class BoardGame {
    private int nbLine;
    private int nbCol;
    private Cell[][] board;
    private Player player1;
    private Player player2;
//    private DisplayBoard displayBoard;
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
//        displayBoard = new DisplayBoard(nbLine, nbCol);
    }



//    public void displayBoard() {
//        displayBoard.display(board);
//    }

    public void setOwner(int[] positionPlayer, Player player) {
        board[positionPlayer[0]][positionPlayer[1]].setState(player.getState());
    }
    //TODO remonter ds controller

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

    // Ajoutons quelques getters utiles pour le controller
    public int getNbLine() {
        return nbLine;
    }

    public int getNbCol() {
        return nbCol;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public String[][] getStringBoard(){
        String[][] stringBoard = new String[nbLine][nbCol];
        for (int i = 0; i < nbLine; i++) {
            for (int j = 0; j < nbCol; j++) {
                stringBoard[i][j] = board[i][j].getRepresentation();
            }
        }
        return stringBoard;
    }
}
