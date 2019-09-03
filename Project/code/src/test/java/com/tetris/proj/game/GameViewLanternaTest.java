package com.tetris.proj.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.tetris.proj.game.model.*;
import com.tetris.proj.game.view.GameViewLanterna;
import com.tetris.proj.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.MockitoAnnotations.initMocks;

public class GameViewLanternaTest {

    private Screen gui;

    private GameViewLanterna gameViewLanternaUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        TerminalSize terminalSize = new TerminalSize(80, 22);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            this.gui = new TerminalScreen(terminal);
            gameViewLanternaUnderTest = new GameViewLanterna(gui);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @Test
    public void testClear() {
        gameViewLanternaUnderTest.clear();

    }

    @Test
    public void testDraw() throws Exception {
        final GameModel model = new GameModel(false);

        gameViewLanternaUnderTest.draw(model);
    }

    @Test
    public void testDrawPosition() {
        // Setup
        final Position p = new Position(0,0, new int[] {0,0,255});
        final int starting_x = 0;
        final int starting_y = 0;

        // Run the test
        gameViewLanternaUnderTest.drawPosition(p, starting_x, starting_y);
    }

    @Test
    public void testDrawPiece() {
        // Setup
        final Piece p = new HeroPiece(20);
        final int starting_x = 0;
        final int starting_y = 0;

        // Run the test
        gameViewLanternaUnderTest.drawPiece(p, starting_x, starting_y);
    }

    @Test
    public void testDrawGameArea() {
        // Setup
        final GameArea g = new GameArea(10, 20);
        final int starting_x = 0;
        final int starting_y = 0;

        // Run the test
        gameViewLanternaUnderTest.drawGameArea(g, starting_x, starting_y);
    }

    @Test
    public void testDrawPoints() {
        // Setup
        final GameArea g = new GameArea(10,20);
        final TextGraphics textGraphics = gui.newTextGraphics();
        final int starting_x = 0;
        final int starting_y = 0;

        // Run the test
        gameViewLanternaUnderTest.drawPoints(g, textGraphics, starting_x, starting_y);

        // Verify the results
    }

    @Test
    public void testDrawFrame() {
        // Setup
        final TextGraphics textGraphics = gui.newTextGraphics();
        final GameArea g = new GameArea(10,20);
        final int starting_x = 0;
        final int starting_y = 0;

        // Run the test
        gameViewLanternaUnderTest.drawFrame(textGraphics, g, starting_x, starting_y);

        // Verify the results
    }
}
