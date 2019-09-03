package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest {

    List<Integer> list;
    List<Integer> expected;
    List<Integer> expected2;

    @Before
    public void helper()
    {
        list= new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(0);
        list.add(-10);
        expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        expected2 = new ArrayList<>();
        expected2.add(2);
        expected2.add(0);
        expected2.add(-10);
    }
    @Test
    public void filterPositive() {
        class StubFilter implements IListFilter {
            @Override
            public boolean accept(Integer number) {
                switch (number)
                {
                    case 2:
                        return true;
                    case 5:
                        return true;
                    case 0:
                        return false;
                    case -10:
                        return false;
                    default:
                        return (number>0);
                }
            }
        }
        ListFilterer filterer = new ListFilterer(list);
        StubFilter filter = new StubFilter();
        assertEquals(expected,  filterer.filter(filter));


    }

    @Test
    public void filterDivisibleBy() {
        class StubFilter implements IListFilter {
            @Override
            public boolean accept(Integer number) {
                switch (number)
                {
                    case 2:
                        return true;
                    case 5:
                        return false;
                    case 0:
                        return true;
                    case -10:
                        return true;
                    default:
                        return (number%2 ==0);
                }
            }
        }
        ListFilterer filterer = new ListFilterer(list);
        StubFilter filter = new StubFilter();
        assertEquals(expected2,  filterer.filter(filter));


    }

}