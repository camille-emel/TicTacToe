package view;

public class View {
    public View() {
    }

    public void gameOver() {
        System.out.println("Game Over");
    }

    public void askPosRow() {
        System.out.println("Enter pos, row : ");
    }

    public void askPosCol() {
        System.out.println("Enter pos, col : ");
    }

    public void cellIsNotFree() {
        System.out.println("Cell is use, choose another position.");
    }

    public void cellSeparator() {
        System.out.print(" | ");
    }

    public void jumpLineFormat() {
        System.out.println();
    }
    public void wrongInput() {
        System.out.println("Wrong input.");
    }
    public void currentBoard() {
        System.out.println("Current board: : ");
    }
    public void aksGame(){
        System.out.println("Choose a game to play:\n" +
                "1: TicTacToe\n" +
                "2: Connect 4\n" +
                "3: Gomoku");
    }



}
