package com.tetris.proj.game;

import com.tetris.proj.model.Context;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class GameTest {

    private JFrame gui;

    private Game gameUnderTest;

    @Before
    public void setUp() {
        gui = new JFrame();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(800,300);
        gui.setVisible(true);
        try {
            gameUnderTest = new Game(false, gui);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRun() {
        // Setup
        final int[] expectedResult = new int[]{0, 1};

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Run the test
        final int[] result = gameUnderTest.run();

        // Verify the results
        assertArrayEquals(expectedResult, result);
     }

    @Test
    public void testDoAction() throws Exception {

        final Context context = new Context();

        Robot robot = new Robot();
        for(int i=0; i< 10 ; i++){
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
        }

        gameUnderTest.doAction(context);
    }

}
