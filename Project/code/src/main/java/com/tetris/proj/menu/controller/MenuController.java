package com.tetris.proj.menu.controller;

import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.view.MenuViewAdapter;
import com.tetris.proj.controller.Controller;

import java.awt.event.KeyEvent;

public class MenuController implements Controller<MenuModel, MenuViewAdapter> {

    public void processKey(MenuModel model, KeyEvent key, MenuViewAdapter view)
    {
        switch (key.getKeyCode()){
            case KeyEvent.VK_DOWN:
                model.getMenu().next();
                break;
            case KeyEvent.VK_UP:
                model.getMenu().previous();
                break;
            case KeyEvent.VK_LEFT:
                model.getMenu().next();
                model.getMenu().select();
                break;
            case KeyEvent.VK_RIGHT:
                model.getMenu().previous();
                break;
            case KeyEvent.VK_ENTER:
                model.getMenu().select();
                break;
            default:
                break;
        }
    }
}
