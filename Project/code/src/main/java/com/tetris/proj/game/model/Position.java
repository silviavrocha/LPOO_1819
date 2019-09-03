package com.tetris.proj.game.model;

public class Position {
    private int x;
    private int y;
    private char symbol;
    private int color[];

    public Position(int x, int y, int color[]) {
        this.x = x;
        this.y = y;
        this.symbol = 'O';
        this.color=color;
    }

    public int getX() {

        return x;
    }

    public int[] getColor(){
        return color;
    }

    public int getY() {
        return y;
    }
    public void incrementX(int value){
        x+=value;
    }
    public void incrementY(int value){
        y+=value;
    }

    public void setColor(int color[]){
        this.color=color;
    }

}
