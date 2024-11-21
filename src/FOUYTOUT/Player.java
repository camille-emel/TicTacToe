package FOUYTOUT;

public  class Player {
    State state;


    Player(State state) {
        this.state = state;
    }

    String getRepresentation() {

        return state.getValue();
    }

    State getState() {
        return state;
    }

    @Override
    public String toString() {
        return getRepresentation();
    }


    public void makeMove() {

    }

}
