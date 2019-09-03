package com.tetris.proj.game;

import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.game.view.GameViewSwing;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.swing.*;

import java.io.IOException;

import static org.mockito.MockitoAnnotations.initMocks;

public class GameViewSwingTest {

    @Mock
    private JFrame mockFrame;

    private GameViewSwing gameViewSwingUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        mockFrame = new JFrame();
        mockFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mockFrame.setSize(800,300);
        mockFrame.setVisible(true);
        try {
            gameViewSwingUnderTest = new GameViewSwing(mockFrame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClear() {
        // Setup
        // Run the test
        gameViewSwingUnderTest.clear();

        // Verify the results
    }

    @Test
    public void testDraw() {
        // Setup
        final GameModel model = new GameModel(true);

        // Run the test
        gameViewSwingUnderTest.draw(model);

        // Verify the results
    }

    @Test
    public void testDrawGameArea() {
        // Setup
        final GameModel model = new GameModel(false);

        // Run the test
        gameViewSwingUnderTest.drawGameArea(model);

        // Verify the results
    }
}
