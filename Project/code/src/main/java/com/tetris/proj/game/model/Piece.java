package com.tetris.proj.game.model;

import java.util.List;

public abstract class Piece {
    protected List<Position> positions;
    protected int color[]=new int[3];

    public List<Position> getPositions() {
        return positions;
    }

    public int[] getColor(){
        return color;
    }

    public abstract void startingPosition(int x_max);

    public abstract void rotate();
    public int getMaxX(){
        int max=positions.get(0).getX();
        for (Position position:positions) {
            if (position.getX() > max)
                max = position.getX();
        }
        return max;
    }
    public int getMinX(){
        int min=positions.get(0).getX();
        for (Position position:positions) {
            if (position.getX() < min)
                min = position.getX();
        }
        return min;
    }
    public int getMaxY(){
        int max=positions.get(0).getY();
        for (Position position:positions) {
            if (position.getY() > max)
                max = position.getY();
        }
        return max;
    }
    public int getMinY(){
        int min=positions.get(0).getY();
        for (Position position:positions) {
            if (position.getY() < min)
                min = position.getY();
        }
        return min;
    }
    public void goDown(){
        for (Position position : positions)
            position.incrementY(1);
    }

    public void goUp(){
        for (Position position : positions)
            position.incrementY(-1);
    }
    public void goRight(){
        for (Position position : positions)
            position.incrementX(1);
    }
    public void goLeft(){
        for (Position position : positions)
            position.incrementX(-1);
    }
}
