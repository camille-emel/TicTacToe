package FOUYTOUT;

public class Cell {
    private Representation representation;

    // Enum définissant les différents états d'une cellule
    private enum Representation {
        EMPTY,
        X,
        O
    }

    // Constructeur par défaut : initialise la cellule comme vide
    public Cell() {
        this.representation = Representation.EMPTY;
    }

    // Retourne la représentation actuelle de la cellule sous forme de chaîne
    public String getRepresentation() {
        return representation == Representation.EMPTY ? " " : representation.name();
    }

    // Définit la représentation de la cellule en fonction d'une chaîne
    public void setRepresentation(String representation) {
        if (representation.equalsIgnoreCase("X")) {
            this.representation = Representation.X;
        } else if (representation.equalsIgnoreCase("O")) {
            this.representation = Representation.O;
        } else {
            this.representation = Representation.EMPTY;
        }
    }

    // Vérifie si la cellule est vide
    public boolean isEmpty() {
        return this.representation == Representation.EMPTY;
    }
}
