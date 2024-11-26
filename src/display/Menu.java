package display;

import java.util.Scanner;

public class Menu {
    public Menu(){

    }
    public String askWhatToPlay(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a game to play : \n" +
                "1 : TicTacToe\n" +
                "2 : Connect 4 \n" +
                "3 : Gomoku");
        return sc.nextLine();
    }
    public String askHumanPlayerOrComputer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Is player, 1 : human or  2 : computer? ");
        return sc.nextLine();
    }
}
