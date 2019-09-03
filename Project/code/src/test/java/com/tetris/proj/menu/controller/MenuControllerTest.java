package com.tetris.proj.menu.controller;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import com.tetris.proj.menu.view.MenuViewAdapter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class MenuControllerTest {
    private MenuModel model;
    @Mock
    private MenuController menuControllerUnderTest;
    @Before
    public void setUp() {
        initMocks(this);
        List<Option> options = new ArrayList<>();
        options.add( new Option("", true, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        options.add( new Option("", false, 1,5,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        model = new MenuModel(options);
      //  menuControllerUnderTest = new MenuController();
    }

    @Test
    public void testProcessKey() {
        // Setup

        TerminalSize terminalSize = new TerminalSize(80, 22);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        MenuViewAdapter view = null;
        try {
           Terminal terminal = defaultTerminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);
            view = new MenuViewAdapter(screen, menuControllerUnderTest, model);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button a = new Button("click");
        KeyEvent e = new KeyEvent(a, 1, 10, 1, KeyEvent.VK_LEFT, 'l');
        menuControllerUnderTest.processKey(model, e, view);

        verify(menuControllerUnderTest, times(1)).processKey(model,e,view);
    }
}
