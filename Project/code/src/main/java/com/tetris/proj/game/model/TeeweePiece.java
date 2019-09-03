package com.tetris.proj.game.model;

import java.util.ArrayList;


public class TeeweePiece extends Piece {
    private Integer rotation;
    public TeeweePiece(int x_max)
    {
        color = new int[] {255, 0, 255};
        positions = new ArrayList<>();
        startingPosition(x_max);
    }

    public void startingPosition(int x_max){
        this.rotation=0;
        positions.clear();
        positions.add(new Position(x_max/2, -1, color));
        positions.add(new Position(x_max/2-1, -1,  color));
        positions.add(new Position(x_max/2, 0,  color));
        positions.add(new Position(x_max/2+1, -1,  color));
    }

    public void rotate(){
        //falta verificação
        this.rotation=this.rotation%4;
        Position p = positions.remove(1);
        switch (rotation) {
            case 0:
                p.incrementX(1);
                p.incrementY(-1);
                positions.add(p);
                break;
            case 1:
                p.incrementX(-1);
                p.incrementY(-1);
                positions.add(p);
                break;
            case 2:
                p.incrementX(-1);
                p.incrementY(1);
                positions.add(p);
                break;
            case 3:
                p.incrementX(1);
                p.incrementY(1);
                positions.add(p);
                break;
            default:
                break;
        }
        this.rotation++;

    }
}
