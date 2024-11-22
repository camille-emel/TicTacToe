//package display;
//
//import games.Cell;
//
//public class DisplayBoard {
//    DisplayBoard(){
//
//    }
//    public void initBoard() {
//        board = new Cell[nbLine][nbCol];
//        view = new View();
//        for (int i = 0; i < nbLine; i++) {
//            for (int j = 0; j < nbCol; j++) {
//                board[i][j] = new Cell();
//            }
//        }
//    }
//
//    public void display() {
//        for (int i = 0; i < nbLine; i++) {
//            for (int j = 0; j < nbCol; j++) {
//                System.out.print(board[i][j].getRepresentation());
//                if (j < nbCol - 1) {
//                    view.cellSeparator();
//                }
//            }
//            view.jumpLineFormat();
//        }
//    }
//}
