package display;

import games.Connect4;
import games.Gomoku;
import games.TicTacToe;
import players.ArtificialPlayer;
import players.HumanPlayer;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public Menu() {

    }

    public void askWhatToPlay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a game to play : \n" +
                "1 : TicTacToe\n" +
                "2 : Connect 4 \n" +
                "3 : Gomoku");
        switch (sc.nextInt()) {

            case 1:
                TicTacToe ticTacToe = new  TicTacToe();
                String player1 = askHumanPlayerOrComputer();
                String player2 = askHumanPlayerOrComputer();
                if (Objects.equals(player1, "1") && Objects.equals(player2, "1")) {
                    ticTacToe.initPlayers(new HumanPlayer(State.X), new HumanPlayer(State.O));
                    ticTacToe.play();

                }
                if (Objects.equals(player1, "1") && Objects.equals(player2, "2")) {
                    ticTacToe.initPlayers(new HumanPlayer(State.X), new ArtificialPlayer(State.O));
                    ticTacToe.play();
                }
                if (Objects.equals(player1, "2") && Objects.equals(player2, "2")) {
                    ticTacToe.initPlayers(new ArtificialPlayer(State.X), new ArtificialPlayer(State.O));
                    ticTacToe.play();
                }

                break;
            case 2:
                Connect4 connect4 = new Connect4();
                connect4.play();
                break;
            case 3:
                Gomoku gomoku = new Gomoku();
                gomoku.play();
                break;
        }
    }

    public String askHumanPlayerOrComputer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Is player, 1 : human or  2 : computer? ");
        return sc.nextLine();
    }

}
