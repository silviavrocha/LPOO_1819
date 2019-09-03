package com.tetris.proj;

import com.tetris.proj.Handler;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class HandlerSwing extends Handler<JFrame> {

    public HandlerSwing() throws IOException {
        gui = new JFrame();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(800,300);
        gui.setVisible(true);
        super.createContext();
    }

    public void closeWindow(){
        gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
    }
}