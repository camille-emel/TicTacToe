package games;

import display.State;
import players.HumanPlayer;
import players.Player;

public class Connect4 extends BoardGame {
    public Connect4() {
        initBoard(6,7,4);
        initPlayers(new HumanPlayer(State.X), new HumanPlayer(State.X));
    }

    public Connect4(Player p1, Player p2) {
        initBoard(6,7,4);
        initPlayers(p1, p2);
    }
}
