package com.tetris.proj.game.model;

import java.util.ArrayList;

public class SmashBoyPiece extends Piece {
    public SmashBoyPiece(int x_max){
        color = new int[] {255, 255, 0};
        positions = new ArrayList<>();
        startingPosition(x_max);
    }

    public void startingPosition(int x_max){
        positions.clear();
        positions.add(new Position(x_max/2, -1,  color));
        positions.add(new Position(x_max/2 + 1, -1, color));
        positions.add(new Position(x_max/2, 0, color));
        positions.add(new Position(x_max/2 + 1, 0, color));
    }

    public void rotate(){}
}
