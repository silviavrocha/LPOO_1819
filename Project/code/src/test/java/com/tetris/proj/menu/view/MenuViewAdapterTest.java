package com.tetris.proj.menu.view;

import com.tetris.proj.menu.controller.MenuController;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

public class MenuViewAdapterTest<T> {

    private JFrame frame;

    private MenuViewAdapter menuViewAdapterUnderTest;
    private   MenuModel model;
    @Before
    public void setUp() {
        frame = new JFrame();
        MenuController controller = new MenuController();
        List<Option> options = new ArrayList<>();
        options.add( new Option("", true, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        model = new MenuModel(options);
        initMocks(this);
        try {
            menuViewAdapterUnderTest = new MenuViewAdapter(frame, controller, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDraw() {
        // Setup

        // Run the test
        menuViewAdapterUnderTest.draw(model);


        // Verify the results
    }

    @Test
    public void testClear() {
        // Setup

        // Run the test
        menuViewAdapterUnderTest.clear();

        // Verify the results
    }
}
