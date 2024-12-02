package controller;

import java.util.Scanner;
import model.*;
import view.ConsoleView;
import view.View;

public class Menu {
    private final Scanner scanner;
    private final View view;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.view = new ConsoleView();
    }

    public void askWhatToPlay() {
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
        
        GameController gameController = new GameController(game, view);
        gameController.play();
    }

    private Player createPlayer(String playerName) {
        view.getPlayerType(playerName);
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
