package com.aor.refactoring.example5;

public class DirectionSouth extends Direction{
    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new DirectionWest());
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new DirectionEast());
    }

    @Override
    public void forward(Turtle turtle) {
        turtle.setRow(turtle.getRow()+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                   // are the references equal
        if (o == null) return false;                  // is the other object null
        if (getClass() != o.getClass()) return false; // both objects the same class
        return true;
    }
}
