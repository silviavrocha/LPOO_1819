package com.tetris.proj.menu.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.tetris.proj.menu.model.Menu;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class MenuViewLanternaTest {

    private Screen gui;

    private MenuViewLanterna menuViewLanternaUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        initMocks(this);
        TerminalSize terminalSize = new TerminalSize(80, 22);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            this.gui = new TerminalScreen(terminal);
            menuViewLanternaUnderTest = new MenuViewLanterna(gui);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClear() {
        menuViewLanternaUnderTest.clear();
    }

    @Test
    public void testDraw() throws Exception {
        List<Option> options = new ArrayList<>();
        options.add( new Option("", true, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        final MenuModel model = new MenuModel(options);

        menuViewLanternaUnderTest.draw(model);
    }

    @Test
    public void testDrawMenu() {
        List<Option> options = new ArrayList<>();
        options.add( new Option("", true, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        final Menu menu = new Menu(options);

        menuViewLanternaUnderTest.drawMenu(menu);
    }

    @Test
    public void testDrawOption() {
        final Option op = new  Option("", true, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255});

        menuViewLanternaUnderTest.drawOption(op);
    }
}
