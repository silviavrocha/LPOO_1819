package com.tetris.proj.menu;

import com.tetris.proj.game.Game;
import com.tetris.proj.menu.controller.MenuController;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import com.tetris.proj.menu.view.MenuViewAdapter;
import com.tetris.proj.model.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends MenuGeneralization{

    public <T> MainMenu(T gui) throws IOException {
        List<Option> options = new ArrayList<>();
        options.add(new Option("Start - One Player", true,3, 3, 3, 30, new int[] {0,0,255}, new int[] {100,100,100}));
        options.add(new Option("Start - Two Players", false, 3, 8, 3, 30, new int[] {0,0,255}, new int[] {100,100,100}));
        options.add(new Option("Instructions", false, 3, 13, 3, 30, new int[] {0,0,255}, new int[] {100,100,100}));
        options.add(new Option("Exit", false,  3, 18, 3, 30, new int[] {0,0,255}, new int[] {100,100,100}));
        model = new MenuModel(options);
        controller = new MenuController();
        view=new MenuViewAdapter(gui, controller, model);
        this.gui=gui;
    }

    public void doAction(Context context) throws IOException{
        int option=this.run();
        switch (option){
            case 0:
                context.setState(new Game(false, gui));
                break;
            case 1:
                context.setState(new Game(true, gui));
                break;
            case 2:
                context.setState(new InstructionsMenu(gui));
                break;
            case 3:
                context.setState(null);
        }
    }
}
