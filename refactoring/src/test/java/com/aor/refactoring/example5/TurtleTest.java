package com.aor.refactoring.example5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void testRotateLeft() {
        Turtle turtle = new Turtle(5, 5, new DirectionNorth());
        Turtle.execute(turtle, new CommandLeft()); assertEquals( new DirectionWest(), turtle.getDirection());
        Turtle.execute(turtle, new CommandLeft()); assertEquals( new DirectionSouth(), turtle.getDirection());
        Turtle.execute(turtle, new CommandLeft()); assertEquals( new DirectionEast(), turtle.getDirection());
        Turtle.execute(turtle, new CommandLeft()); assertEquals( new DirectionNorth(), turtle.getDirection());
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testRotateRight() {
        Turtle turtle = new Turtle(5, 5, new DirectionNorth());
        Turtle.execute(turtle, new CommandRight()); assertEquals( new DirectionEast(), turtle.getDirection());
        Turtle.execute(turtle, new CommandRight()); assertEquals( new DirectionSouth(), turtle.getDirection());
        Turtle.execute(turtle, new CommandRight()); assertEquals( new DirectionWest(), turtle.getDirection());
        Turtle.execute(turtle, new CommandRight()); assertEquals( new DirectionNorth(), turtle.getDirection());
        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testForward() {
        Turtle turtleN = new Turtle(5, 5, new DirectionNorth());

        Turtle.execute(turtleN,  new CommandForward());
        assertEquals(4, turtleN.getRow());
        assertEquals(5, turtleN.getColumn());

        Turtle turtleW = new Turtle(5, 5, new DirectionWest());

        Turtle.execute(turtleW,  new CommandForward());
        assertEquals(5, turtleW.getRow());
        assertEquals(4, turtleW.getColumn());

        Turtle turtleS = new Turtle(5, 5, new DirectionSouth());

        Turtle.execute(turtleS,  new CommandForward());
        assertEquals(6, turtleS.getRow());
        assertEquals(5, turtleS.getColumn());

        Turtle turtleE = new Turtle(5, 5, new DirectionEast());

        Turtle.execute(turtleE, new CommandForward());
        assertEquals(5, turtleE.getRow());
        assertEquals(6, turtleE.getColumn());
    }

}