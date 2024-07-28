package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final Random random = new Random();
    private List<Player> players;
    private Dice dice;
    private Board board;
    private List<Player> winners;
    private int numOfButtonsPerPlayer;
    private GameStatus gameStatus;

    private int playerId = 1;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getWinners() {
        return winners;
    }

    public void setWinners(List<Player> winners) {
        this.winners = winners;
    }

    public int getNumOfButtonsPerPlayer() {
        return numOfButtonsPerPlayer;
    }

    public void setNumOfButtonsPerPlayer(int numOfButtonsPerPlayer) {
        this.numOfButtonsPerPlayer = numOfButtonsPerPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void createGame(int boardSize, int diceSize, int numOfButtonsPerPlayer){
        this.board = new Board(boardSize);
        this.dice = new Dice(diceSize);
        this.numOfButtonsPerPlayer = numOfButtonsPerPlayer;
        this.players = new ArrayList<>();
        this.gameStatus = GameStatus.NOTSTARTED;


        int numOfSnakes = 3 + random.nextInt(3);
        int numOfLadders = 3 + random.nextInt(3);
        this.board.addSnakesAndLadders(numOfSnakes, numOfLadders);

    }

    public void addPlayer(String name, PlayerType playerType){
        Player player1 = playerType == PlayerType.HUMAN ? new HumanPlayer() : new BotPlayer();
        player1.setName(name);
        player1.setId(playerId);
        player1.setPlayerType(playerType);
        playerId++;
        List<Integer>positions = new ArrayList<>();
        for(int i = 0; i < numOfButtonsPerPlayer; i++)positions.add(0);
        player1.setPositions(positions);
        players.add(player1);
    }

}
