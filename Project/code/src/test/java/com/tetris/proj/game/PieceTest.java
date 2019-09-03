package com.tetris.proj.game;

import com.tetris.proj.game.model.*;
import com.tetris.proj.model.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class      PieceTest {

    @Test
    public void getMinX() {
        Piece teewee = new TeeweePiece(20);

        assertEquals(9,  teewee.getMinX());

    }

    @Test
    public void getMaX() {
        Piece smashBoy = new SmashBoyPiece(20);

        assertEquals(11,  smashBoy.getMaxX());

    }

    @Test
    public void getMinY() {
        Piece rhodeIsland = new RhodeIslandZPiece(20);

        assertEquals(-2,  rhodeIsland.getMinY());

    }

    @Test
    public void getMaxY() {
        Piece orangeRicky = new OrangeRickyPiece(20);

        assertEquals(0,  orangeRicky.getMaxY());

    }

    @Test
    public void goDown() {
        Piece hero = new HeroPiece(20);
        int initial_y = hero.getMaxY();
        hero.goDown();
        assertEquals(initial_y+1,  hero.getMaxY());
    }

    @Test
    public void goUp() {
        Piece hero = new HeroPiece(20);
        int initial_y = hero.getMinY();
        hero.goUp();
        assertEquals(initial_y-1,  hero.getMinY());
    }

    @Test
    public void goRight() {
        Piece cleveland = new ClevelandZPiece(20);
        int initial_x = cleveland.getMaxX();
        cleveland.goRight();
        assertEquals(initial_x+1,  cleveland.getMaxX());
    }

    @Test
    public void goLeft() {
        Piece blueRicky = new BlueRickyPiece(20);
        int initial_x = blueRicky.getMinX();
        blueRicky.goLeft();
        assertEquals(initial_x-1, blueRicky.getMinX());
    }

    @Test
    public void heroRotate() {
        Piece hero = new HeroPiece(20);

        hero.rotate();
        assertEquals(9, hero.getPositions().get(0).getX());
        assertEquals(-2, hero.getPositions().get(0).getY());
        assertEquals(10, hero.getPositions().get(1).getX());
        assertEquals(-2, hero.getPositions().get(1).getY());
        assertEquals(11, hero.getPositions().get(2).getX());
        assertEquals(-2, hero.getPositions().get(2).getY());
        assertEquals(12, hero.getPositions().get(3).getX());
        assertEquals(-2, hero.getPositions().get(3).getY());

        hero.rotate();

        assertEquals(11, hero.getPositions().get(0).getX());
        assertEquals(-3, hero.getPositions().get(0).getY());
        assertEquals(11, hero.getPositions().get(1).getX());
        assertEquals(-2, hero.getPositions().get(1).getY());
        assertEquals(11, hero.getPositions().get(2).getX());
        assertEquals(-1, hero.getPositions().get(2).getY());
        assertEquals(11, hero.getPositions().get(3).getX());
        assertEquals(0, hero.getPositions().get(3).getY());

        hero.rotate();
        assertEquals(9, hero.getPositions().get(0).getX());
        assertEquals(-1, hero.getPositions().get(0).getY());
        assertEquals(10, hero.getPositions().get(1).getX());
        assertEquals(-1, hero.getPositions().get(1).getY());
        assertEquals(11, hero.getPositions().get(2).getX());
        assertEquals(-1, hero.getPositions().get(2).getY());
        assertEquals(12, hero.getPositions().get(3).getX());
        assertEquals(-1, hero.getPositions().get(3).getY());

        hero.rotate();
        assertEquals(10, hero.getPositions().get(0).getX());
        assertEquals(-3, hero.getPositions().get(0).getY());
        assertEquals(10, hero.getPositions().get(1).getX());
        assertEquals(-2, hero.getPositions().get(1).getY());
        assertEquals(10, hero.getPositions().get(2).getX());
        assertEquals(-1, hero.getPositions().get(2).getY());
        assertEquals(10, hero.getPositions().get(3).getX());
        assertEquals(0, hero.getPositions().get(3).getY());

    }

    @Test
    public void blueRickyRotate() {
        Piece blueRicky = new BlueRickyPiece(20);

        blueRicky.rotate();
        assertEquals(10, blueRicky.getPositions().get(0).getX());
        assertEquals(0, blueRicky.getPositions().get(0).getY());
        assertEquals(11, blueRicky.getPositions().get(1).getX());
        assertEquals(0, blueRicky.getPositions().get(1).getY());
        assertEquals(9, blueRicky.getPositions().get(2).getX());
        assertEquals(0, blueRicky.getPositions().get(2).getY());
        assertEquals(9, blueRicky.getPositions().get(3).getX());
        assertEquals(-1, blueRicky.getPositions().get(3).getY());

        blueRicky.rotate();
        assertEquals(10, blueRicky.getPositions().get(0).getX());
        assertEquals(-1, blueRicky.getPositions().get(0).getY());
        assertEquals(10, blueRicky.getPositions().get(1).getX());
        assertEquals(0, blueRicky.getPositions().get(1).getY());
        assertEquals(10, blueRicky.getPositions().get(2).getX());
        assertEquals(-2, blueRicky.getPositions().get(2).getY());
        assertEquals(11, blueRicky.getPositions().get(3).getX());
        assertEquals(-2, blueRicky.getPositions().get(3).getY());

        blueRicky.rotate();
        assertEquals(10, blueRicky.getPositions().get(0).getX());
        assertEquals(-1, blueRicky.getPositions().get(0).getY());
        assertEquals(9, blueRicky.getPositions().get(1).getX());
        assertEquals(-1, blueRicky.getPositions().get(1).getY());
        assertEquals(11, blueRicky.getPositions().get(2).getX());
        assertEquals(-1, blueRicky.getPositions().get(2).getY());
        assertEquals(11, blueRicky.getPositions().get(3).getX());
        assertEquals(0, blueRicky.getPositions().get(3).getY());

        blueRicky.rotate();
        assertEquals(10, blueRicky.getPositions().get(0).getX());
        assertEquals(-1, blueRicky.getPositions().get(0).getY());
        assertEquals(10, blueRicky.getPositions().get(1).getX());
        assertEquals(-2, blueRicky.getPositions().get(1).getY());
        assertEquals(10, blueRicky.getPositions().get(2).getX());
        assertEquals(0, blueRicky.getPositions().get(2).getY());
        assertEquals(9, blueRicky.getPositions().get(3).getX());
        assertEquals(0, blueRicky.getPositions().get(3).getY());
    }

    @Test
    public void orangeRickyRotate() {
        Piece orangeRicky = new OrangeRickyPiece(20);

        orangeRicky.rotate();
        assertEquals(10, orangeRicky.getPositions().get(0).getX());
        assertEquals(-1, orangeRicky.getPositions().get(0).getY());
        assertEquals(11, orangeRicky.getPositions().get(1).getX());
        assertEquals(-1, orangeRicky.getPositions().get(1).getY());
        assertEquals(9, orangeRicky.getPositions().get(2).getX());
        assertEquals(-1, orangeRicky.getPositions().get(2).getY());
        assertEquals(9, orangeRicky.getPositions().get(3).getX());
        assertEquals(0, orangeRicky.getPositions().get(3).getY());

        orangeRicky.rotate();
        assertEquals(10, orangeRicky.getPositions().get(0).getX());
        assertEquals(-1, orangeRicky.getPositions().get(0).getY());
        assertEquals(10, orangeRicky.getPositions().get(1).getX());
        assertEquals(0, orangeRicky.getPositions().get(1).getY());
        assertEquals(10, orangeRicky.getPositions().get(2).getX());
        assertEquals(-2, orangeRicky.getPositions().get(2).getY());
        assertEquals(9, orangeRicky.getPositions().get(3).getX());
        assertEquals(-2, orangeRicky.getPositions().get(3).getY());

        orangeRicky.rotate();
        assertEquals(10, orangeRicky.getPositions().get(0).getX());
        assertEquals(-1, orangeRicky.getPositions().get(0).getY());
        assertEquals(9, orangeRicky.getPositions().get(1).getX());
        assertEquals(-1, orangeRicky.getPositions().get(1).getY());
        assertEquals(11, orangeRicky.getPositions().get(2).getX());
        assertEquals(-1, orangeRicky.getPositions().get(2).getY());
        assertEquals(11, orangeRicky.getPositions().get(3).getX());
        assertEquals(-2, orangeRicky.getPositions().get(3).getY());

        orangeRicky.rotate();
        assertEquals(10, orangeRicky.getPositions().get(0).getX());
        assertEquals(-1, orangeRicky.getPositions().get(0).getY());
        assertEquals(10, orangeRicky.getPositions().get(1).getX());
        assertEquals(-2, orangeRicky.getPositions().get(1).getY());
        assertEquals(10, orangeRicky.getPositions().get(2).getX());
        assertEquals(0, orangeRicky.getPositions().get(2).getY());
        assertEquals(11, orangeRicky.getPositions().get(3).getX());
        assertEquals(0, orangeRicky.getPositions().get(3).getY());
    }

    @Test
    public void TeeWeeRotate() {
        Piece teewee = new TeeweePiece(20);

        teewee.rotate();
        assertEquals(10, teewee.getPositions().get(0).getX());
        assertEquals(-1, teewee.getPositions().get(0).getY());
        assertEquals(10, teewee.getPositions().get(1).getX());
        assertEquals(0, teewee.getPositions().get(1).getY());
        assertEquals(11, teewee.getPositions().get(2).getX());
        assertEquals(-1, teewee.getPositions().get(2).getY());
        assertEquals(10, teewee.getPositions().get(3).getX());
        assertEquals(-2, teewee.getPositions().get(3).getY());

        teewee.rotate();
        assertEquals(10, teewee.getPositions().get(0).getX());
        assertEquals(-1, teewee.getPositions().get(0).getY());
        assertEquals(11, teewee.getPositions().get(1).getX());
        assertEquals(-1, teewee.getPositions().get(1).getY());
        assertEquals(10, teewee.getPositions().get(2).getX());
        assertEquals(-2, teewee.getPositions().get(2).getY());
        assertEquals(9, teewee.getPositions().get(3).getX());
        assertEquals(-1, teewee.getPositions().get(3).getY());

        teewee.rotate();
        assertEquals(10, teewee.getPositions().get(0).getX());
        assertEquals(-1, teewee.getPositions().get(0).getY());
        assertEquals(10, teewee.getPositions().get(1).getX());
        assertEquals(-2, teewee.getPositions().get(1).getY());
        assertEquals(9, teewee.getPositions().get(2).getX());
        assertEquals(-1, teewee.getPositions().get(2).getY());
        assertEquals(10, teewee.getPositions().get(3).getX());
        assertEquals(0, teewee.getPositions().get(3).getY());

        teewee.rotate();
        assertEquals(10, teewee.getPositions().get(0).getX());
        assertEquals(-1, teewee.getPositions().get(0).getY());
        assertEquals(9, teewee.getPositions().get(1).getX());
        assertEquals(-1, teewee.getPositions().get(1).getY());
        assertEquals(10, teewee.getPositions().get(2).getX());
        assertEquals(0, teewee.getPositions().get(2).getY());
        assertEquals(11, teewee.getPositions().get(3).getX());
        assertEquals(-1, teewee.getPositions().get(3).getY());
    }

    @Test
    public void ClevelandZRotate() {
        Piece clevelandZ = new ClevelandZPiece(20);

        clevelandZ.rotate();
        assertEquals(10, clevelandZ.getPositions().get(0).getX());
        assertEquals(-1, clevelandZ.getPositions().get(0).getY());
        assertEquals(10, clevelandZ.getPositions().get(1).getX());
        assertEquals(0, clevelandZ.getPositions().get(1).getY());
        assertEquals(9, clevelandZ.getPositions().get(2).getX());
        assertEquals(-1, clevelandZ.getPositions().get(2).getY());
        assertEquals(11, clevelandZ.getPositions().get(3).getX());
        assertEquals(0, clevelandZ.getPositions().get(3).getY());

        clevelandZ.rotate();
        assertEquals(10, clevelandZ.getPositions().get(0).getX());
        assertEquals(-1, clevelandZ.getPositions().get(0).getY());
        assertEquals(10, clevelandZ.getPositions().get(1).getX());
        assertEquals(0, clevelandZ.getPositions().get(1).getY());
        assertEquals(11, clevelandZ.getPositions().get(2).getX());
        assertEquals(-1, clevelandZ.getPositions().get(2).getY());
        assertEquals(11, clevelandZ.getPositions().get(3).getX());
        assertEquals(-2, clevelandZ.getPositions().get(3).getY());
    }


    @Test
    public void RhodeIslandZRotate() {
        Piece rhodeIslandZ = new RhodeIslandZPiece(20);

        rhodeIslandZ.rotate();
        assertEquals(10, rhodeIslandZ.getPositions().get(0).getX());
        assertEquals(-1, rhodeIslandZ.getPositions().get(0).getY());
        assertEquals(10, rhodeIslandZ.getPositions().get(1).getX());
        assertEquals(0, rhodeIslandZ.getPositions().get(1).getY());
        assertEquals(11, rhodeIslandZ.getPositions().get(2).getX());
        assertEquals(-1, rhodeIslandZ.getPositions().get(2).getY());
        assertEquals(9, rhodeIslandZ.getPositions().get(3).getX());
        assertEquals(0, rhodeIslandZ.getPositions().get(3).getY());

        rhodeIslandZ.rotate();
        assertEquals(10, rhodeIslandZ.getPositions().get(0).getX());
        assertEquals(-1, rhodeIslandZ.getPositions().get(0).getY());
        assertEquals(10, rhodeIslandZ.getPositions().get(1).getX());
        assertEquals(0, rhodeIslandZ.getPositions().get(1).getY());
        assertEquals(9, rhodeIslandZ.getPositions().get(2).getX());
        assertEquals(-1, rhodeIslandZ.getPositions().get(2).getY());
        assertEquals(9, rhodeIslandZ.getPositions().get(3).getX());
        assertEquals(-2, rhodeIslandZ.getPositions().get(3).getY());
    }

    @Test
    public void SmashBoyRotate() {
        Piece smashBoy = new SmashBoyPiece(20);

        smashBoy.rotate();
        assertEquals(10, smashBoy.getPositions().get(0).getX());
        assertEquals(-1, smashBoy.getPositions().get(0).getY());
        assertEquals(11, smashBoy.getPositions().get(1).getX());
        assertEquals(-1, smashBoy.getPositions().get(1).getY());
        assertEquals(10, smashBoy.getPositions().get(2).getX());
        assertEquals(0, smashBoy.getPositions().get(2).getY());
        assertEquals(11, smashBoy.getPositions().get(3).getX());
        assertEquals(0, smashBoy.getPositions().get(3).getY());

    }
}