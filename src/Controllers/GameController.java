package Controllers;

import Models.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GameController {

    private final Game game;
    private Queue<Player> rotation;

    public GameController(){
        game = new Game();
    }
    public void createGame(int boardSize, int diceSize, int maxButtonPerPlayer){
        game.createGame(boardSize, diceSize, maxButtonPerPlayer);
    }

    public void addPlayer(String name){
        game.addPlayer(name, PlayerType.HUMAN);
    }

    public void startGame(){
        game.setGameStatus(GameStatus.INPROGRESS);
        game.setWinners(new ArrayList<>());
        game.addPlayer("Bot", PlayerType.BOT);
        rotation = new LinkedList<>(game.getPlayers());
        play();
    }
    public void printWinners(){
        for(Player player : game.getWinners()){
            System.out.println(player.getName() + " " + player.getPlayerType());
        }
    }

    public void printPlayers(){
        for(Player player : game.getPlayers()){
            System.out.println(player.getName() + " " + player.getPlayerType());
        }
    }

    public void printBoardEntities(){
        for(BoardEntity entity : game.getBoard().getBoardEntities().values()){
            System.out.println(entity.getStartPosition() + " " + entity.getEndPosition() + " " + entity.getEntityType());
        }
    }

    private void play(){
        while (rotation.size() > 1){
            Player player = rotation.poll();
            System.out.println(player.getName());
            player.move(game.getDice(), game.getBoard());
            int cnt = 0;
            for(int position : player.getPositions()){
                if(position == game.getBoard().getSize())cnt++;
            }
            if(cnt == game.getNumOfButtonsPerPlayer())game.getWinners().add(player);
            else rotation.offer(player);
        }
    }
}
