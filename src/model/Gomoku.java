package model;

import view.State;

public class Gomoku extends BoardGame {
    public Gomoku() {

        initBoard(15,15,5);
        initPlayers(new HumanPlayer(State.X), new HumanPlayer(State.X));
    }

    public Gomoku(Player p1, Player p2) {
        initBoard(15,15,5);
        initPlayers(p1, p2);
    }
}
