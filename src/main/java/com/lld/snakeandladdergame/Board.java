package com.lld.snakeandladdergame;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    int size;
    Cell[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        initializeTheBoard();
    }
    public void initializeTheBoard(){

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){

                Cell curr = new Cell();
                board[i][j] = curr;
            }
        }
    }
    public void addSnakeLadder(int numberOfSnakes, int numberOfLadders){

        while(numberOfSnakes> 0){

            int lastCell = board.length * board.length-1;
            int snakeHead = ThreadLocalRandom.current().nextInt(1, lastCell+1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, lastCell+1);

            if(snakeTail>=snakeHead){
                continue;
            }

            Jump snake = new Snake(snakeHead,snakeTail);
            Cell currCell = getCell(snakeHead);
            currCell.jumpToCell = snake;

            numberOfSnakes--;
        }
        while(numberOfLadders> 0){

            int lastCell = board.length * board[0].length-1;
            int ladderStart = ThreadLocalRandom.current().nextInt(1, lastCell+1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, lastCell+1);

            if(ladderStart >= ladderEnd){
                continue;
            }

            Jump ladder = new Ladder(ladderStart, ladderEnd);
            Cell currCell = getCell(ladderStart);
            currCell.jumpToCell = ladder;

            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition) {

        int rowCell = playerPosition / board.length;
        int colCell = playerPosition % board.length;
        try {

            return board[rowCell][colCell];

        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println("The Player Position exception: " + playerPosition);
            System.exit(1);
        }
        return board[10][colCell];
    }
}
