package com.tetris.proj.menu.view;

import com.googlecode.lanterna.screen.Screen;
import com.tetris.proj.controller.Controller;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.model.Model;
import com.tetris.proj.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MenuViewAdapter implements View<MenuModel> {
    private boolean swing;
    private MenuViewSwing vs;
    private MenuViewLanterna vl;
    private KeyEventDispatcher keyEventDispatcher;

    public <T, C extends Controller, M extends Model> MenuViewAdapter(T gui, C controller, M model) throws IOException {
        if (gui instanceof JFrame) {
            swing = true;
            vs = new MenuViewSwing((JFrame) gui);
        }
        else {
            swing = false;
            vl = new MenuViewLanterna((Screen) gui);
        }

        keyEventDispatcher = new KeyEventDispatcher() {
            public MenuViewAdapter getOuter() {
                return MenuViewAdapter.this;
            }
            @Override
            public boolean dispatchKeyEvent(final KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED)
                    controller.processKey(model, e, getOuter());
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
    }

    public void removeKeyListener(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyEventDispatcher);
    }

    public void draw(MenuModel model){
        if (swing) {
            vs.draw(model);
        }
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
