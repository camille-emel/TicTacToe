package FOUYTOUT;

import java.util.Objects;
import java.util.Scanner;


public class TicTacToe {
    private final int size = 3;
    private Cell[][] board;
    private Player player1;
    private Player player2;
    private View view;
    private UserInteraction userInteraction;


    public TicTacToe() {
        initBoard();
        initPlayers();
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

    public void initPlayers() {
        player1 = new Player("X");
        player2 = new Player("O");
    }

    public void play() {
        boolean play = true;
        while (play) {
            display();
            for (int i = 0; i < (size * size); i++) {
                //TODO refac doublon
                if (i % 2 == 0) {
                    setOwner(getMoveFromPlayer(), player1);
                    if (isOver(player1)) {
                        play = false;
                        display();
                        break;
                    }
                } else {
                    setOwner(getMoveFromPlayer(), player2);
                    if (isOver(player2)) {
                        play = false;
                        display();
                        break;
                    }
                }display();
            }
        }
        view.gameOver();
    }

    public int[] getMoveFromPlayer() {
        //TODO move to userInterface
        Scanner userInput = new Scanner(System.in);
        int[] positionPlayer = new int[2];
        int rowPos = -1;
        int colPos = -1;
        //TODO secure bad input
        do {
            view.askPosRow();
            //TODO move to userInterface
            rowPos = Integer.parseInt(userInput.nextLine());
        } while (rowPos < 0 || rowPos >= size);
        do {
            view.askPosCol();
            //TODO move to userInterface
            colPos = Integer.parseInt(userInput.nextLine());
        } while (colPos < 0 || colPos >= size);
        positionPlayer[0] = rowPos;
        positionPlayer[1] = colPos;
        if (!board[rowPos][colPos].isEmpty()) {
            view.cellIsNotFree();
            return getMoveFromPlayer();
        }
        return positionPlayer;
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
            if (!Objects.equals(board[i][col].getRepresentation(), player.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

    public boolean oneRowCheck(Player player, int row) {
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(board[row][i].getRepresentation(), player.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

    public boolean oneDiagDownCheck(Player player) {
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(board[i][i].getRepresentation(), player.getRepresentation())) {
                return false;
            }
        }
        return true;
    }

    public boolean oneDiagUpCheck(Player player) {
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(board[size - i - 1][i].getRepresentation(), player.getRepresentation())) {
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
        board[positionPlayer[0]][positionPlayer[1]].setRepresentation(player.getRepresentation());
    }
}
