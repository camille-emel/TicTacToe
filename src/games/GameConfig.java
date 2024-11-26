//package core;
//
//import display.Menu;
//import games.Game;
//import games.TicTacToe;
//import players.ArtificialPlayer;
//import players.HumanPlayer;
//import players.Player;
//
//public class GameConfig {
//    private Menu menu;
//
//    public GameConfig(Menu menu) {
//        this.menu = menu;
//    }
//
//    public Game setupGame() {
//        // Interagir avec le menu pour récupérer les choix de l'utilisateur
//        String gameChoice = menu.askWhatToPlay();
//        String playerType = menu.askHumanOrComputer();
//
//        // Créer le jeu basé sur le choix de l'utilisateur
//        Game game = createGame(gameChoice);
//
//        // Créer les joueurs
//        Player player1 = createPlayer(playerType);
//        Player player2 = createPlayer(playerType);
//
//        // Initialiser le jeu avec les joueurs configurés
//        game.initPlayers(player1, player2);
//        return game;
//    }
//
//    private Game createGame(String gameChoice) {
//        switch (gameChoice) {
//            case "TicTacToe":
//                return new TicTacToe();
//            // Ajouter d'autres jeux ici si nécessaire
//            default:
//                throw new IllegalArgumentException("Game not implemented: " + gameChoice);
//        }
//    }
//
//    private Player createPlayer(String playerType) {
//        if (playerType.equals("human")) {
//            return new HumanPlayer();
//        } else if (playerType.equals("computer")) {
//            return new ArtificialPlayer();
//        } else {
//            throw new IllegalArgumentException("Player type not recognized: " + playerType);
//        }
//    }
//}
