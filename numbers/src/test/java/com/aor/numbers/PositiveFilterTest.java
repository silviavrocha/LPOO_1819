package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositiveFilterTest {

    @Test
    public void accept() {
        PositveFilter filter = new PositveFilter();
        assertEquals(true, filter.accept(1));
        assertEquals(false, filter.accept(-1));
        assertEquals(false, filter.accept(0));
    }

}