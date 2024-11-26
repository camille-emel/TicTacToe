package games;

import display.State;
import players.HumanPlayer;
import players.Player;


public class TicTacToe extends BoardGame {

    public TicTacToe() {

        initBoard();
        initPlayers(new HumanPlayer(State.X), new HumanPlayer(State.X));
    }

    public TicTacToe(Player p1, Player p2) {
        initBoard();
        initPlayers(p1, p2);
    }

}
