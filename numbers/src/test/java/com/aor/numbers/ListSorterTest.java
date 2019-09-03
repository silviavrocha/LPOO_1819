package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListSorterTest {
    private List<Integer> list;
    private List<Integer> expected;
    private List<Integer> list2;
    private List<Integer> expected2;

    @Before
    public void helper()
    {
        list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);

        expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        list2= new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(2);
        expected2 = new ArrayList<>();
        expected2.add(1);
        expected2.add(2);
        expected2.add(2);
        expected2.add(4);
    }
    @Test
    public void sort() {
        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();
        assertEquals(expected, sorted);
    }

    @Test
    public void sort2() {
        ListSorter sorter = new ListSorter(list2);
        List<Integer> sorted = sorter.sort();
        assertEquals(expected2, sorted);
    }
}