package Models;

import java.util.Random;

public class Dice{
    private final int size;
    Random randomNum;

    public Dice(int size){
        this.size = size;
        randomNum = new Random();
    }

    public int roll(){
        return 1 + randomNum.nextInt(size);
    }
}
