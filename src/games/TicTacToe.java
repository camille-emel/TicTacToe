package games;

import core.State;
import core.UserInteraction;
import core.View;
import players.HumanPlayer;
import players.Player;


public class TicTacToe {
    private final int size = 5;
    private Cell[][] board;
    private Player player1;
    private Player player2;
    private View view;
    private UserInteraction userInteraction;


    public TicTacToe() {
        initBoard();
        initPlayers(new HumanPlayer(State.X), new HumanPlayer(State.X));
    }

    public TicTacToe(Player p1, Player p2) {
        initBoard();
        initPlayers(p1, p2);
    }

    public void initBoard() {
        board = new Cell[size][size];
        view = new View();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void initPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public void play() {
        boolean play = true;
        while (play) {
            display();
            for (int i = 0; i < (size * size); i++) {
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

    //TODO remonter la bouble des sous méthodes
    public boolean isOver(Player player) {
        for (int i = 0; i < size; i++) {
            if (oneColCheck(player, i) || oneRowCheck(player, i) || oneDiagDownCheck(player) || oneDiagUpCheck(player)) {
                return true;
            }
        }
        return false;
    }

    //TODO faire que fonction check col//row
    public boolean oneColCheck(Player player, int col) {
        for (int i = 0; i < size; i++) {
            if (board[i][col].getState() != player.getState()) {
                return false;
            }
        }
        return true;
    }

    public boolean oneRowCheck(Player player, int row) {
        for (int i = 0; i < size; i++) {
            if (board[row][i].getState() != player.getState()) {
                return false;
            }
        }
        return true;
    }

    public boolean oneDiagDownCheck(Player player) {
        for (int i = 0; i < size; i++) {
            if (board[i][i].getState() != player.getState()) {
                return false;
            }
        }
        return true;
    }

    public boolean oneDiagUpCheck(Player player) {
        for (int i = 0; i < size; i++) {
            if (board[size - i - 1][i].getState() !=  player.getState()) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < size - 1) {
                    view.cellSeparator();
                }
            }
            view.jumpLineFormat();
        }
    }

    public void setOwner(int[] positionPlayer, Player player) {
        board[positionPlayer[0]][positionPlayer[1]].setState(player.getState());
    }
}
