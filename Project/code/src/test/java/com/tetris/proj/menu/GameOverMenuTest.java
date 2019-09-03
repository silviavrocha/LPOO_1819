package com.tetris.proj.menu;

import com.tetris.proj.model.Context;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.mockito.MockitoAnnotations.initMocks;

public class GameOverMenuTest{

    private JFrame mockGui;

    private GameOverMenu gameOverMenuUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        mockGui = new JFrame();
        mockGui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mockGui.setSize(800,300);
        mockGui.setVisible(true);

        try {
            gameOverMenuUnderTest = new GameOverMenu(mockGui, new int[]{0,0}, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDoAction() throws Exception {
        // Setup
        final Context context = new Context();

        // Run the test
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        gameOverMenuUnderTest.doAction(context);

        // Verify the results
    }

}
