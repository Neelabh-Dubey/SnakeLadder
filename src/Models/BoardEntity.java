package Models;

public abstract class BoardEntity {
    private BoardEntityType entityType;
    private int startPosition;
    private int endPosition;

    public BoardEntity(BoardEntityType entityType, int startPosition, int endPosition) {
        this.entityType = entityType;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public BoardEntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(BoardEntityType entityType) {
        this.entityType = entityType;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
