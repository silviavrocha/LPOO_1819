package com.aor.refactoring.example5;

public class CommandRight extends Command {

    @Override
    public void execute(Turtle turtle) {
        turtle.getDirection().rotateRight(turtle);
    }

}
