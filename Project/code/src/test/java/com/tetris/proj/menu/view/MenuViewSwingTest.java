package com.tetris.proj.menu.view;

import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class MenuViewSwingTest {

    private JFrame frame;
    private MenuViewSwing menuViewSwingUnderTest;

    @Before
    public void setUp() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800,300);
        frame.setVisible(true);
        try {
            menuViewSwingUnderTest = new MenuViewSwing(frame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDraw() {
        List<Option> options = new ArrayList<>();
        options.add( new Option("", false, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        final MenuModel model = new MenuModel(options);

        menuViewSwingUnderTest.draw(model);

    }

    @Test
    public void testClear() {
        menuViewSwingUnderTest.clear();
    }

    @Test
    public void testRemovePainter() {
        menuViewSwingUnderTest.RemovePainter();
    }
}
