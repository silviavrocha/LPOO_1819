package com.tetris.proj.game.model;

import java.util.ArrayList;

public class OrangeRickyPiece extends Piece {
    private Integer rotation;
    public OrangeRickyPiece(Integer x_max)
    {
        color=new int[] {255, 128, 0};
        positions = new ArrayList<>();
        startingPosition(x_max);
    }

    public void startingPosition(int x_max){
        this.rotation=0;
        positions.clear();
        positions.add(new Position(x_max/2, -1, color));
        positions.add(new Position(x_max/2, -2, color));
        positions.add(new Position(x_max/2, 0,  color));
        positions.add(new Position(x_max/2+1, 0, color));
    }

    public void rotate(){
        //falta verificação
        this.rotation=this.rotation%4;
        switch (rotation) {
            case 0:
                positions.get(1).incrementY(1);
                positions.get(1).incrementX(1);
                positions.get(2).incrementX(-1);
                positions.get(2).incrementY(-1);
                positions.get(3).incrementX(-2);
                break;
            case 1:
                positions.get(1).incrementX(-1);
                positions.get(1).incrementY(1);
                positions.get(2).incrementX(1);
                positions.get(2).incrementY(-1);
                positions.get(3).incrementY(-2);
                break;
            case 2:
                positions.get(1).incrementX(-1);
                positions.get(1).incrementY(-1);
                positions.get(2).incrementX(1);
                positions.get(2).incrementY(1);
                positions.get(3).incrementX(2);
                break;
            case 3:
                positions.get(1).incrementX(1);
                positions.get(1).incrementY(-1);
                positions.get(2).incrementX(-1);
                positions.get(2).incrementY(1);
                positions.get(3).incrementY(2);
                break;
            default:
                break;
        }
        this.rotation++;

    }
}