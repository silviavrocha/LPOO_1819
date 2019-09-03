package com.tetris.proj;

import com.tetris.proj.menu.MainMenu;
import com.tetris.proj.model.Context;

import java.io.IOException;

public abstract class Handler<T> {
    T gui;
    Context context;

    public void createContext() throws IOException{
        context=new Context();
        context.setState(new MainMenu(gui));
    }

    public abstract void closeWindow();

    public <T> void run() throws IOException {
        while (context.getState()!=null)
        {
            context.getState().doAction(context);
        }
        closeWindow();
    }
}
