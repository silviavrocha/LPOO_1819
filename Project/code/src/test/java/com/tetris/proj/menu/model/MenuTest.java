package com.tetris.proj.menu.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {

    private Menu menuUnderTest;

    @Before
    public void setUp() {
        List<Option> options = new ArrayList<>();
        options.add( new Option("", false, 1,1,5,5, new int[] {0,0,255}, new int[] {0,0,255}));
        menuUnderTest = new Menu(options);
    }

    @Test
    public void testSelected() {
        // Setup

        // Run the test
        Boolean result = menuUnderTest.selected();

        // Verify the results
        assertFalse(result);

        menuUnderTest.select();
        assertTrue(menuUnderTest.selected());
    }

    @Test
    public void testSelect() {
        // Setup

        // Run the test
        menuUnderTest.select();

        // Verify the results
    }

    @Test
    public void testSelectedOption() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = menuUnderTest.selectedOption();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNext() {
        // Setup

        // Run the test
        menuUnderTest.next();

        // Verify the results
    }

    @Test
    public void testPrevious() {
        // Setup

        // Run the test
        menuUnderTest.previous();

        // Verify the results
    }
}
