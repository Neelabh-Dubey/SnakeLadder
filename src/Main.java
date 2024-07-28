import Controllers.GameController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        GameController gameController = new GameController();
        gameController.createGame(100,6,2);
        gameController.addPlayer("Neelabh");
        gameController.addPlayer("Arvind");
        gameController.printBoardEntities();
        gameController.startGame();
        gameController.printPlayers();
        System.out.println("Debug");

    }
}