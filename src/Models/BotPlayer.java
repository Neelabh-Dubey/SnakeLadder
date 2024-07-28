package Models;

public class BotPlayer extends Player{
    @Override
    public void move(Dice dice, Board board) {
        int x = dice.roll();
        System.out.println("Dice rolled- " + x);
        boolean moveFlag = false;
        if(x == 1 || x == 6){
            for(int i = 0; i < this.getPositions().size(); i++){
                int position = this.getPositions().get(i);
                if(position == 0) {
                    this.getPositions().set(i, x);
                    System.out.println(i + " " + position + " " + x);
                    return;
                }
            }
        }
        if(!moveFlag){
            for(int i = 0; i < this.getPositions().size(); i++){
                int position = this.getPositions().get(i);
                if(position + x == board.getSize()) {
                    this.getPositions().set(i, x + position);
                    moveFlag = true;
                    System.out.println(i + " " + position + " " + x+position);
                    break;
                }
            }
        }
        if(moveFlag)return;
        for(int i = 0; i < this.getPositions().size(); i++){
            int position = this.getPositions().get(i);
            if(position+x != board.getSize() && position != 0) {
                if(board.getBoardEntities().containsKey(position+x)){
                    this.getPositions().set(i, board.getBoardEntities().get(position+x).getEndPosition());
                    System.out.println(i + " " + position + " " + this.getPositions().get(i));
                    break;
                }
                else{
                    this.getPositions().set(i, position+x);
                    System.out.println(i + " " + position + " " + position+x);
                    break;
                }
            }
        }
    }
}
