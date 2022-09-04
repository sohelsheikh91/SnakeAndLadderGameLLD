package com.lld.snakeandladdergame;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board gameBoard;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    public Game(){
        initializeGame();
    }

    public void initializeGame() {

        gameBoard = new Board(10);
        dice = new Dice();
        Player player1 = new Player("Sohel",0);
        Player player2 = new Player("Akshay",0);

        players.add(player1);
        players.add(player2);
        gameBoard.addSnakeLadder(5,5);
    }
    public void startGame(){
        while(winner == null){

            Player playerTurn = findPlayerTurn();
            int diceValue = dice.rollDice(1);

            System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);


            int playerCurrentPosition = playerTurn.getCurrentPosition();
            playerCurrentPosition += diceValue;

            if(playerCurrentPosition >=100) {

                System.out.println("Dice rolled - Player has Reached 100");
                winner = playerTurn;
                continue;
            }
            Cell newPosition = gameBoard.getCell(playerCurrentPosition);

            if(newPosition.jumpToCell != null && newPosition.jumpToCell.getStart() == playerCurrentPosition ){
                if(newPosition.jumpToCell.getEnd()< playerCurrentPosition )
                    System.out.println("Jump taken by Snake ");
                else
                    System.out.println("Jump taken by Ladder");

                playerTurn.currentPosition = newPosition.jumpToCell.getEnd();
                continue;
            }
            System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerCurrentPosition);

            playerTurn.currentPosition = playerCurrentPosition;

        }
        System.out.println("The Winner is :" + winner.getId());
    }
    public Player findPlayerTurn(){

        Player playerTurn = players.removeLast();
        players.addFirst(playerTurn);
        return playerTurn;
    }
}
