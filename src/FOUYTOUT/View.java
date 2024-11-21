package FOUYTOUT;

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
    public void jumpLineFormat2() {
        System.out.println();
    }
}
