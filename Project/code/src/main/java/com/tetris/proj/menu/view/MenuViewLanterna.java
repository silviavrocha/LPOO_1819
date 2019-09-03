package com.tetris.proj.menu.view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.tetris.proj.menu.model.Menu;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import com.tetris.proj.view.View;

import java.io.IOException;


public class MenuViewLanterna implements View<MenuModel> {
    private Screen screen;

    public MenuViewLanterna(Screen screen)  throws IOException {
        this.screen=screen;

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void clear(){
        screen.clear();
    }

    public void draw(MenuModel model){
        drawMenu(model.getMenu());
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMenu(Menu menu){
        for (Option option:menu.getOptions()){
            drawOption(option);
        }
    }

    public void drawOption(Option op){
        for (int i=0; i<op.getHeight(); i++)
        {
            for (int j=0; j<op.getLength(); j++)
            {
                if (op.getActive())
                    screen.setCharacter(op.getStarting_x()+j, op.getStarting_y()+i, new TextCharacter('o', new TextColor.RGB(op.getColor_active()[0], op.getColor_active()[1], op.getColor_active()[2]), new TextColor.RGB(op.getColor_active()[0], op.getColor_active()[1], op.getColor_active()[2])));
                else
                    screen.setCharacter(op.getStarting_x()+j, op.getStarting_y()+i, new TextCharacter('o', new TextColor.RGB(op.getColor_inactive()[0], op.getColor_inactive()[1], op.getColor_inactive()[2]), new TextColor.RGB(op.getColor_inactive()[0], op.getColor_inactive()[1], op.getColor_inactive()[2])));
            }
        }
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(new TextColor.RGB(255,255,255));
        if (op.getActive())
            textGraphics.setBackgroundColor(new TextColor.RGB(op.getColor_active()[0], op.getColor_active()[1], op.getColor_active()[2]));
        else
            textGraphics.setBackgroundColor(new TextColor.RGB(op.getColor_inactive()[0], op.getColor_inactive()[1], op.getColor_inactive()[2]));
        textGraphics.putString(op.getStarting_x()+1, op.getStarting_y()+op.getHeight()/2, op.getDescription());
    }
}
