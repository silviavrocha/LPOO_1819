package com.tetris.proj.game;

import com.tetris.proj.game.model.GameArea;
import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.game.model.Piece;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GameAreaTest {

    @Test
    public void createGameArea() {
        GameArea area = new GameArea(10,20);

        assertEquals(10, area.getLength());
        assertEquals(20, area.getHeight());
        assertEquals(true, area.getActivePiece() instanceof Piece);
        assertEquals(true, area.getNextPiece() instanceof Piece);
        assertEquals(true, area.getHoldPiece() instanceof Piece);
    }

    @Test
    public void changeHoldPiece() {
        GameArea area = new GameArea(10,20);
        Piece initialActive = area.getActivePiece();
        Piece initialHold = area.getHoldPiece();
        area.changeHoldPiece();
        assertEquals(initialActive, area.getHoldPiece());
        assertEquals(initialHold, area.getActivePiece());
    }

    @Test
    public void receiveLine(){
    GameArea area = new GameArea(10, 20);
    area.receiveLine();
    for(int i=0; i<10;i++)
        assertTrue(Arrays.equals(new int[] {128, 128, 128},area.getMatrix()[area.getHeight()-1][i].getColor()));
    }

    @Test
    public void setPiece(){
        GameArea area = new GameArea(10, 20);
        area.setPiece();
        assertEquals(0, area.getPoints());
        assertEquals(0, area.getSendLines());

        for(int i=0; i<10;i++){
            area.getMatrix()[area.getHeight()-1][i].setColor(new int[] {32, 45, 66});
            area.getMatrix()[area.getHeight()-2][i].setColor(new int[] {32, 45, 66});
            area.getMatrix()[area.getHeight()-3][i].setColor(new int[] {32, 45, 66});
        }

        area.setPiece();
        assertEquals(3, area.getPoints());
        assertEquals(1, area.getSendLines());
    }

    @Test
    public void gameOver(){
        GameModel model = new GameModel(true);
        model.getArea().setPiece();
        assertTrue(model.getArea().gameEnded());
        assertTrue(model.GameOver());
    }
}