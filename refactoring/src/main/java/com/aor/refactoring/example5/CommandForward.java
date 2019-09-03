package com.aor.refactoring.example5;

public class CommandForward extends Command{

    @Override
    public void execute(Turtle turtle) {
        turtle.getDirection().forward(turtle);
    }
}
