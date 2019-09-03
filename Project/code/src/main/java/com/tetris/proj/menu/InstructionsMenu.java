package com.tetris.proj.menu;

import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.view.MenuViewAdapter;
import com.tetris.proj.menu.controller.MenuController;
import com.tetris.proj.menu.model.Option;
import com.tetris.proj.model.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructionsMenu extends MenuGeneralization {

    public <T> InstructionsMenu(T gui) throws IOException {
        List<Option> options = new ArrayList<>();
        options.add(new Option("Player 1 /Single Player:", true,5, 1, 0, 0, new int[] {0,0,0}, new int[] {0,0,0} ));
        options.add(new Option("Left: 'A' ", false,5, 3, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Right: 'D' ", false,5, 5, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Down: 'S' ", false,5, 7, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Rotate Piece: 'W' ", false,5, 9, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Hold Piece: 'H' ", false,5, 11, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Drop Piece: SpaceBar ", false,5, 13, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Player 2: ", false,40, 1, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Left: Left Arrow ", false,40, 3, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Right: Right Arrow ", false,40, 5, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Down: Down Arrow ", false,40, 7, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Rotate Piece: Up Arrow ", false,40, 9, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Hold Piece: BackSpace ", false,40, 11, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Drop Piece: Enter ", false,40, 13, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("Pause/Unpause: 'P' ", false,20, 16, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));
        options.add(new Option("To go Back to Main Menu now, press ENTER ", false,10, 18, 0, 0, new int[] {0,0,0}, new int[] {0,0,0}));

        model = new MenuModel(options);
        controller = new MenuController();
        view = new MenuViewAdapter(gui, controller, model);
        this.gui=gui;
    }

    public void doAction(Context context) throws IOException{
        this.run();
        context.setState(new MainMenu(gui));
    }
}
