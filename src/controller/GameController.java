package controller;

import model.BoardGame;
import model.Player;
import view.View;

public class GameController {
    private final BoardGame game;
    private final View view;
    private Player currentPlayer;

    public GameController(BoardGame game, View view) {
        this.game = game;
        this.view = view;
    }

    public void play() {
        boolean play = true;
        int maxMoves = game.getNbLine() * game.getNbCol();

        while (play) {
            view.displayBoard(game.getBoard());

            for (int i = 0; i < maxMoves; i++) {
                // Déterminer le joueur courant
                currentPlayer = (i % 2 == 0) ? game.getPlayer1() : game.getPlayer2();

                // Obtenir le coup du joueur
                int[] move = currentPlayer.makeMove(game.getBoard());

                // Appliquer le coup
                game.setOwner(move, currentPlayer);

                // Vérifier si le jeu est terminé
                if (game.isOver(currentPlayer)) {
                    play = false;
                    view.displayBoard(game.getBoard());
                    view.announceWinner(currentPlayer);
                    break;
                }

                // Si on arrive au dernier coup sans gagnant
                if (i == maxMoves - 1) {
                    play = false;
                    view.displayBoard(game.getBoard());
                    view.announceDraw();
                }

                view.displayBoard(game.getBoard());
            }
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
