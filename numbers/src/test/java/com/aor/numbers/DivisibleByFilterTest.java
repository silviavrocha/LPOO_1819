package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisibleByFilterTest {


    @Test
    public void accept() {
        DivisibleByFilter filter= new DivisibleByFilter(2);
        assertEquals(true, filter.accept(2));
        assertEquals(true, filter.accept(200));
        assertEquals(false, filter.accept(1));
        assertEquals(true, filter.accept(0));
    }

}