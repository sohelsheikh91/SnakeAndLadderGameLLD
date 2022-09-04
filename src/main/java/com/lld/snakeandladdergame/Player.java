package com.lld.snakeandladdergame;

import lombok.Data;

@Data
public class Player {
    String id;
    int currentPosition;

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }
}
