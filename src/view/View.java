package view;

import model.Cell;
import model.Player;

public interface View {
    void displayBoard(Cell[][] board);
    void showGameOver();
    void askPosRow();
    void askPosCol();
    void wrongInput();
    void cellIsNotFree();
    void aksGame();
    void getPlayerType(String playerName);
    void announceWinner(Player player);
    void announceDraw();
    void currentBoard();
    void cellSeparator();
    void jumpLineFormat();
}
