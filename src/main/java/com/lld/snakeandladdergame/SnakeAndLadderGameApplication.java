package com.lld.snakeandladdergame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnakeAndLadderGameApplication {

    public static void main(String[] args) {

        Game newGame = new Game();
        newGame.startGame();
        //SpringApplication.run(SnakeAndLadderGameApplication.class, args);
    }

}
