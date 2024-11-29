package controller;

import model.*;

import view.State;
import view.View;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final View view;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.view = new View();
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int gameChoice = getValidInput(1, 4);

            if (gameChoice == 4) {
                System.out.println("Thanks for playing!");
                break;
            }

            // Get game mode
            displayGameModeMenu();
            int modeChoice = getValidInput(1, 3);

            // Create players based on mode
            Player player1, player2;
            switch (modeChoice) {
                case 1: // Human vs Human
                    player1 = new HumanPlayer(State.X);
                    player2 = new HumanPlayer(State.O);
                    break;
                case 2: // Human vs Bot
                    player1 = new HumanPlayer(State.X);
                    player2 = new ArtificialPlayer(State.O);
                    break;
                case 3: // Bot vs Bot
                    player1 = new ArtificialPlayer(State.X);
                    player2 = new ArtificialPlayer(State.O);
                    break;
                default:
                    continue;
            }

            // Start the selected game
            switch (gameChoice) {
                case 1:
                    new TicTacToe().play();
                    break;
                case 2:
                    new Connect4().play();
                    break;
                case 3:
                    new Gomoku().play();
                    break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n=== Board Game Menu ===");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Connect 4");
        System.out.println("3. Gomoku");
        System.out.println("4. Exit");
        System.out.print("Choose a game (1-4): ");
    }

    private void displayGameModeMenu() {
        System.out.println("\n=== Game Mode ===");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");
        System.out.print("Choose game mode (1-3): ");
    }

    private int getValidInput(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("Please enter a valid number between %d and %d: ", min, max);
            }
        }
    }
}

