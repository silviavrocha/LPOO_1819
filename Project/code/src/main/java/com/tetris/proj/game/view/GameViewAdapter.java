package com.tetris.proj.game.view;

import com.googlecode.lanterna.screen.Screen;
import com.tetris.proj.game.controller.GameController;
import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameViewAdapter implements View<GameModel> {
    private boolean swing;
    private GameViewSwing vs;
    private GameViewLanterna vl;
    KeyEventDispatcher keyEventDispatcher;

    public <T>GameViewAdapter(T gui, GameController controller, GameModel model) throws IOException {
        if (gui instanceof JFrame)
        {
            swing=true;
            vs= new GameViewSwing((JFrame) gui);
        }
        else {
            swing = false;
            vl = new GameViewLanterna((Screen) gui);
        }

        keyEventDispatcher = new KeyEventDispatcher() {
            public GameViewAdapter getOuter() {
                return GameViewAdapter.this;
            }
            @Override
            public boolean dispatchKeyEvent(final KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED)
                    controller.processKey(model,e, this.getOuter());
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
    }

    public void removeKeyListener(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyEventDispatcher);
    }

    public void draw(GameModel model){
        if (swing)
            vs.draw(model);
        else
            vl.draw(model);
    }

    public void clear(){
        if (swing)
            vs.clear();
        else
            vl.clear();
    }
}
