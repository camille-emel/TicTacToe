package games;

import display.State;
import players.HumanPlayer;
import players.Player;


public class TicTacToe extends BoardGame {

    public TicTacToe() {

        initBoard(3,3,2);
    }

    public TicTacToe(Player p1, Player p2) {
//        initBoard(3,3,2);
        initPlayers(p1, p2);
    }

}
