package view;

import model.Cell;
import model.Player;

public class ConsoleView implements View {
    @Override
    public void displayBoard(Cell[][] board) {
        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.print(cell.getRepresentation() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void showGameOver() {
        System.out.println("Game Over!");
    }

    @Override
    public void askPosRow() {
        System.out.println("Enter row position:");
    }

    @Override
    public void askPosCol() {
        System.out.println("Enter column position:");
    }

    @Override
    public void wrongInput() {
        System.out.println("Wrong input, try again.");
    }

    @Override
    public void cellIsNotFree() {
        System.out.println("Cell is not free, choose another.");
    }

    @Override
    public void aksGame() {
        System.out.println("Choose a game to play:");
    }

    @Override
    public void getPlayerType(String playerName) {
        System.out.println("Choose player type for " + playerName + ":");
    }

    @Override
    public void announceWinner(Player player) {
        System.out.println("Le joueur " + player + " a gagné !");
    }

    @Override
    public void announceDraw() {
        System.out.println("Match nul !");
    }

    @Override
    public void currentBoard() {
        System.out.println("Current Board:");
    }

    @Override
    public void cellSeparator() {
        System.out.println("|");
    }

    @Override
    public void jumpLineFormat() {
        System.out.println();
    }
} 