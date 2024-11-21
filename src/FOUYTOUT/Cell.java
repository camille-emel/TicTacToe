package FOUYTOUT;

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
    State getState(){
        return this.state;
    }
    public String toString(){
        return getRepresentation();
    }
}
