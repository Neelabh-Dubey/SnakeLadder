package Models;

import java.util.*;

public class Board {
    private Map<Integer, BoardEntity> boardEntities;
    private Random random = new Random();

    public Map<Integer, BoardEntity> getBoardEntities() {
        return boardEntities;
    }

    public void setBoardEntities(Map<Integer, BoardEntity> boardEntities) {
        this.boardEntities = boardEntities;
    }

    private final int size;

    public int getSize() {
        return size;
    }

    public Board(int size){
        this.size = size;
        this.boardEntities = new HashMap<>();
    }

    public void addSnakesAndLadders(int n1, int n2){
        int snakes = 0;
        int ladders = 0;
        Set<Integer> invalidPositions = new HashSet<>();
        for(BoardEntity entity : boardEntities.values()){
            invalidPositions.add(entity.getEndPosition());
            invalidPositions.add(entity.getStartPosition());
            if(entity.getEntityType() == BoardEntityType.SNAKE)snakes++;
            else ladders++;
        }
        while(snakes < n1){
            int start = 3 + random.nextInt(size-3);
            if(invalidPositions.contains(start))continue;
            int end = 2 + random.nextInt(start-2);
            if(invalidPositions.contains(end))continue;
            invalidPositions.add(start);
            invalidPositions.add(end);
            boardEntities.put(start, new Snake(BoardEntityType.SNAKE, start, end));
            snakes++;
        }
        while(ladders < n2){
            int end = 3 + random.nextInt(size-3);
            if(invalidPositions.contains(end))continue;
            int start = 2 + random.nextInt(end-2);
            if(invalidPositions.contains(end))continue;
            invalidPositions.add(start);
            invalidPositions.add(end);
            boardEntities.put(start, new Ladder(BoardEntityType.LADDER, start, end));
            ladders++;
        }
    }


}
