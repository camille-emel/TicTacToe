package players;

import games.Cell;
import core.State;

public abstract class Player {
    State state;

    public Player() {
    }

    Player(State state) {
        this.state = state;
    }

    String getRepresentation() {

        return state.getValue();
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }


    // Méthode abstraite qui sera implémentée par les sous-classes
    public abstract int[] makeMove(Cell[][] board);

}
