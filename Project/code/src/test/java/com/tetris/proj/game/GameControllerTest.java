package com.tetris.proj.game;

import com.tetris.proj.game.controller.GameController;
import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.game.model.Piece;
import com.tetris.proj.game.view.GameViewAdapter;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.verify;

public class GameControllerTest {

    GameModel model;
    GameController controller;
    GameViewAdapter view;
    JFrame gui;
    @Before
    public void helper(){
        gui = new JFrame();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(800,300);
        gui.setVisible(true);
        model = new GameModel(false);
        controller = new GameController();
        try {
            view = new GameViewAdapter(gui, controller, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void processKey() {
        int initial_maxX = model.getArea().getActivePiece().getMaxX();

        Button a = new Button("click");
        KeyEvent e = new KeyEvent(a, 1, 10, 1, KeyEvent.VK_D, 'd');
        controller.processKey(model, e, view);

        assertEquals(initial_maxX+1, model.getArea().getActivePiece().getMaxX());

    }

    @Test
    public void Down(){
        int initial_maxY = model.getArea().getActivePiece().getMaxY();
        controller.Down(model.getArea());

        assertEquals(initial_maxY+1, model.getArea().getActivePiece().getMaxY());
    }

    @Test
    public void Left(){
        int initial_minX = model.getArea().getActivePiece().getMinX();
        controller.Left(model.getArea());
        assertEquals(initial_minX-1, model.getArea().getActivePiece().getMinX());
    }

    @Test
    public void Right(){
        int initial_maxX = model.getArea().getActivePiece().getMaxX();
        controller.Right(model.getArea());
        assertEquals(initial_maxX+1, model.getArea().getActivePiece().getMaxX());
    }

    @Test
    public void Drop(){
        Piece piece = model.getArea().getActivePiece();
        controller.Drop(model.getArea());
        assertEquals(model.getArea().getHeight()-1, piece.getMaxY());
    }

    @Test
    public void checkDown(){
        assertTrue(controller.checkDown(model.getArea()));
        for(int i=0; i<model.getArea().getHeight()-1;i++)
            controller.Down(model.getArea());

        assertFalse(controller.checkDown((model.getArea())));
    }

    @Test
    public void checkLeft(){
        assertTrue(controller.checkLeft(model.getArea()));
        for(int i=0; i<model.getArea().getLength()/2; i++)
             controller.Left(model.getArea());

        assertFalse(controller.checkLeft((model.getArea())));
    }

    @Test
    public void checkRight(){
        assertTrue(controller.checkRight(model.getArea()));
        for(int i=0; i<model.getArea().getLength()/2; i++)
            controller.Right(model.getArea());

        assertFalse(controller.checkRight((model.getArea())));
    }

    @Test
    public void checkUp(){
        assertFalse(controller.checkUp(model.getArea()));
        controller.Down(model.getArea());
        controller.Down(model.getArea());
        controller.Down(model.getArea());
        controller.Down(model.getArea());
        controller.Down(model.getArea());
        assertTrue(controller.checkUp(model.getArea()));
    }
}