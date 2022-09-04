package com.lld.snakeandladdergame;

import lombok.Data;

@Data
public class Jump {

    private int start;
    private int end;

    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
