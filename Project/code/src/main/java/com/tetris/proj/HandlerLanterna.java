package com.tetris.proj;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.tetris.proj.Handler;

import java.io.IOException;

public class HandlerLanterna extends Handler<Screen> {

    public HandlerLanterna() throws IOException {
        TerminalSize terminalSize = new TerminalSize(80, 22);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = defaultTerminalFactory.createTerminal();
        this.gui = new TerminalScreen(terminal);
        super.createContext();
    }

    public void closeWindow(){
        try {
            this.gui.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
