package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    List<Integer> list;
    List<Integer> list2;
    List<Integer> expected;
    List<Integer> expected2;
    @Before
    public void helper()
    {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        list2= new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(2);
        expected2 = new ArrayList<>();
        expected2.add(1);
        expected2.add(2);
        expected2.add(4);
    }

    @Test
    public void deduplicate() {
        class StubSorter implements IListSorter {
            @Override
            public List<Integer> sort(){
                List<Integer> numbers = new ArrayList<>();
                numbers.add(1);
                numbers.add(2);
                numbers.add(2);
                numbers.add(4);
                numbers.add(5);
                return numbers;
            }
        }
        ListDeduplicator deduplicator = new ListDeduplicator(list);
        StubSorter sorted = new StubSorter();
        List<Integer> distinct = deduplicator.deduplicate(sorted);
        assertEquals(expected, distinct);
    }


    @Test
    public void deduplicate2() {

        class StubSorter implements IListSorter {
            @Override
            public List<Integer> sort(){
                List<Integer> numbers = new ArrayList<>();
                numbers.add(1);
                numbers.add(2);
                numbers.add(2);
                numbers.add(4);
                return numbers;
            }
        }
        ListDeduplicator deduplicator = new ListDeduplicator(list2);
        //StubSorter sorted = new StubSorter();


        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list2));
        assertEquals(expected2, distinct);
    }
}