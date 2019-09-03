package com.tetris.proj.menu;

import com.tetris.proj.model.Context;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.mockito.MockitoAnnotations.initMocks;

public class MainMenuTest {

    private JFrame gui;

    private MainMenu mainMenuUnderTest;

    @Before
    public void setUp() {
        gui = new JFrame();
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(800,300);
        gui.setVisible(true);
        initMocks(this);
        try {
            mainMenuUnderTest = new MainMenu(gui);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDoAction() throws Exception {
        // Setup
        final Context context = new Context();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        // Run the test
        mainMenuUnderTest.doAction(context);

        // Verify the results
    }

}
