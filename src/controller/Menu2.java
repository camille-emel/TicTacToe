package controller;

import model.*;
import view.State;
import view.View;

import java.util.Scanner;

public class Menu2 {
    private final Scanner scanner;

    public Menu2() {
        this.scanner = new Scanner(System.in);
    }

    public void askWhatToPlay() {
        View view = new View();
        view.aksGame();

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        BoardGame game = switch (choice) {
            case 1 -> new TicTacToe();
            case 2 -> new Connect4();
            case 3 -> new Gomoku();
            default -> {
                view.wrongInput();
                yield null;
            }
        };

        if (game != null) {
            startGame(game);
        }
    }

    private void startGame(BoardGame game) {
        Player player1 = createPlayer("Player 1");
        Player player2 = createPlayer("Player 2");

        game.initPlayers(player1, player2);
        game.play();
    }

    private Player createPlayer(String playerName) {
        System.out.println(playerName + ": Is this player a (1) Human or (2) Computer?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        return switch (choice) {
            case 1 -> new HumanPlayer(getPlayerState(playerName));
            case 2 -> new ArtificialPlayer(getPlayerState(playerName));
            default -> throw new IllegalArgumentException("Invalid choice! Must be 1 or 2.");
        };
    }

    private State getPlayerState(String playerName) {
        // Custom logic to determine player state (e.g., X or O) based on game rules
        // Example: Alternating between X and O
        return playerName.equals("Player 1") ? State.X : State.O;
    }
}
