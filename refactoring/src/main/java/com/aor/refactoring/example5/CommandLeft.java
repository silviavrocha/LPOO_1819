package com.aor.refactoring.example5;

public class CommandLeft extends Command{

    @Override
    public void execute(Turtle turtle) {
        turtle.getDirection().rotateLeft(turtle);
    }
}
