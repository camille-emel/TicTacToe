package games;

import core.State;

public class Cell {
    State state;

    Cell(){
        this.state = State.EMPTY;
    }
    public void setState(State state){
        this.state = state;
    }
    public String getRepresentation(){
        return this.state.getValue();
    }
    public State getState(){
        return this.state;
    }
    public String toString(){
        return getRepresentation();
    }
}
