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
        int moveCount = 0;

        while (play && moveCount < maxMoves) {
            view.currentBoard();
            view.displayBoard(game.getStringBoard());
            
            currentPlayer = (moveCount % 2 == 0) ? game.getPlayer1() : game.getPlayer2();
            
            int[] move = currentPlayer.makeMove(game.getBoard());
            game.setOwner(move, currentPlayer);
            
            if (game.isOver(currentPlayer)) {
                view.displayBoard(game.getStringBoard());
                view.announceWinner(currentPlayer);
                play = false;
            } else if (moveCount == maxMoves - 1) {
                view.displayBoard(game.getStringBoard());
                view.announceDraw();
                play = false;
            }
            
            moveCount++;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
