package com.lld.snakeandladdergame;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int min = 1;
    int max = 6;

    public Dice() {
    }

    public int rollDice(int diceCount){
        int totalSum = 0;
        int diceUsed = 0;

        while(diceUsed < diceCount){

            totalSum += ThreadLocalRandom.current().nextInt(min,max+1);
            diceUsed++;
        }
        return totalSum;
    }
}
