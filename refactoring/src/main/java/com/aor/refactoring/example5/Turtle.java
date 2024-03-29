package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private Direction direction;
    public Turtle(int row, int column, Direction direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {this.row=row;}

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {this.column=column;}

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {this.direction=direction;}

    public static void execute(Turtle turtle, Command command) {
        command.execute(turtle);
    }
}
