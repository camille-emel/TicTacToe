package model;

import controller.HumanPlayer;
import controller.Player;
import view.State;

public class Gomoku extends BoardGame {
    public Gomoku() {
        initBoard(15,15,5);
    }
}
