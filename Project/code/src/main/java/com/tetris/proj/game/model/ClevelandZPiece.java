package com.tetris.proj.game.model;

import java.util.ArrayList;


public class ClevelandZPiece extends Piece {
    private Integer rotation;
    public ClevelandZPiece(int x_max)
    {
        color = new int[] {0, 255, 0};
        positions = new ArrayList<>();
        startingPosition(x_max);
    }

    public void startingPosition(int x_max){
        this.rotation=0;
        positions.clear();
        positions.add(new Position(x_max/2, -1,  color));
        positions.add(new Position(x_max/2, 0,  color));
        positions.add(new Position(x_max/2+1, -1, color));
        positions.add(new Position(x_max/2+1, -2, color));
    }

    public void rotate(){
        this.rotation=this.rotation%2;
        switch (rotation) {
            case 0:
                positions.get(2).incrementX(-2);
                positions.get(3).incrementY(2);
                break;
            case 1:
                positions.get(2).incrementX(2);
                positions.get(3).incrementY(-2);
                break;
            default:
                break;
        }
        this.rotation++;

    }
}
