package com.tetris.proj.game.model;

import java.util.ArrayList;

public class HeroPiece extends Piece {
    private Integer rotation;
    public HeroPiece(int x_max)
    {
        color=new int[] {51, 255, 255};
        positions = new ArrayList<>();
        startingPosition(x_max);
    }

    public void startingPosition(int x_max) {
        this.rotation=0;
        positions.clear();
        positions.add(new Position(x_max/2, -3, color));
        positions.add(new Position(x_max/2, -2, color));
        positions.add(new Position(x_max/2, -1, color));
        positions.add(new Position(x_max/2, 0,  color));
    }

    public void rotate(){
        //falta verificação

        this.rotation=this.rotation%4;
        switch (this.rotation) {
            case 0:
                positions.get(0).incrementX(-1);
                positions.get(0).incrementY(1);
                positions.get(2).incrementX(1);
                positions.get(2).incrementY(-1);
                positions.get(3).incrementX(2);
                positions.get(3).incrementY(-2);
                break;
            case 1:
                positions.get(0).incrementX(2);
                positions.get(0).incrementY(-1);
                positions.get(1).incrementX(1);
                positions.get(2).incrementY(1);
                positions.get(3).incrementX(-1);
                positions.get(3).incrementY(2);
                break;
            case 2:
                positions.get(0).incrementX(-2);
                positions.get(0).incrementY(2);
                positions.get(1).incrementX(-1);
                positions.get(1).incrementY(1);
                positions.get(3).incrementX(1);
                positions.get(3).incrementY(-1);
                break;
            case 3:
                positions.get(0).incrementX(1);
                positions.get(0).incrementY(-2);
                positions.get(1).incrementY(-1);
                positions.get(2).incrementX(-1);
                positions.get(3).incrementX(-2);
                positions.get(3).incrementY(1);
                break;
            default:
                break;
        }
        this.rotation++;
    }
}
