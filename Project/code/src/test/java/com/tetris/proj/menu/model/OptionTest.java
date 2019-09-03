package com.tetris.proj.menu.model;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class OptionTest {

    private Option optionUnderTest;

    @Before
    public void setUp() {
        optionUnderTest = new Option("description", false, 0, 0, 0, 0, new int[]{}, new int[]{});
    }

    @Test
    public void testGetActive() {
        // Setup

        // Run the test
        final boolean result = optionUnderTest.getActive();

        // Verify the results
        assertFalse(result);
    }

    @Test
    public void testGetColor_active() {
        // Setup
        final int[] expectedResult = new int[]{};

        // Run the test
        final int[] result = optionUnderTest.getColor_active();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testGetColor_inactive() {
        // Setup
        final int[] expectedResult = new int[]{};

        // Run the test
        final int[] result = optionUnderTest.getColor_inactive();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testChangeActive() {
        // Setup

        // Run the test
        optionUnderTest.changeActive();

        // Verify the results
    }
}
