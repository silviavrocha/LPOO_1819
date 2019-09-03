package com.tetris.proj.menu;

import com.tetris.proj.menu.controller.MenuController;
import com.tetris.proj.menu.view.MenuViewAdapter;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.model.State;

import java.io.IOException;

public abstract class MenuGeneralization<T> extends State<MenuModel, MenuViewAdapter, MenuController> {
    T gui;

    public int run() throws IOException {
        while (!model.selected()){
            view.draw(model);
        }
        view.clear();
        view.removeKeyListener();
        return model.getMenu().selectedOption();
    }
}
