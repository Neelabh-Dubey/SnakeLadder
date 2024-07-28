package Models;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private final Scanner scanner = new Scanner(System.in);
    public void move(Dice dice, Board board) {
        int x = dice.roll();
        System.out.println("Dice rolled- " + x);
        System.out.print("Index of button- ");
        int i = scanner.nextInt();
        int position = this.getPositions().get(i);
        if(x == 1 || x == 6){
            for(int j = 0; j < this.getPositions().size(); j++){
                if(position == 0) {
                    this.getPositions().set(j, x);
                    System.out.println(j + " " + position + " " + x);
                    return;
                }
            }
        }
        if(board.getBoardEntities().containsKey(position+x)){
            this.getPositions().set(i, board.getBoardEntities().get(position+x).getEndPosition());
            System.out.println(i + " " + position + " " + this.getPositions().get(i));
            return;
        }
        this.getPositions().set(i, position+x);
        System.out.println(i + " " + position + " " + (position+x));
    }
}
