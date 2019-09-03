package com.tetris.proj.menu;

import com.tetris.proj.menu.controller.MenuController;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import com.tetris.proj.menu.view.MenuViewAdapter;
import com.tetris.proj.model.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameOverMenu extends MenuGeneralization {
    private int[] scores;
    private boolean multiplayer;

    public <T> GameOverMenu(T gui, int[] scores, boolean multiplayer) throws IOException {
        this.scores=scores;
        this.multiplayer=multiplayer;

        List<Option> options = new ArrayList<>();
        options.add(new Option("Game Over", true,5, 1, 0, 0, new int[] {0,0,0}, new int[] {0,0,0} ));
        options.add(new Option("Score Player 1: ", false,5, 3, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option( Integer.toString(scores[0]), false,5, 5, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        if(multiplayer)
        {
            options.add(new Option("Score Player 2 ", false,5, 7, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
            options.add(new Option( Integer.toString(scores[2]), false,5, 9, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
            options.add(new Option( "The winner is:", false,5, 11, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
            if(scores[1]==1)
                options.add(new Option( "Player 2", false,5, 13, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
            else
               options.add(new Option( "Player 1", false,5, 15, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        }
        options.add(new Option("To go Back to Main Menu now, press ENTER ", false,10, 18, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));

        model = new MenuModel(options);
        controller = new MenuController();
        view=new MenuViewAdapter(gui, controller, model);
        this.gui=gui;
    }

    public void doAction(Context context) throws IOException{
        this.run();
        context.setState(new MainMenu(gui));
    }
}
