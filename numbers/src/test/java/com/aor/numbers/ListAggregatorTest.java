package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    List<Integer> list;
    List<Integer> list2;
    List<Integer> list3;
    @Before
    public void helper()
    {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        list2= new ArrayList<>();
        list2.add(-5);
        list2.add(-4);
        list2.add(-1);
        list3= new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(4);
        list3.add(2);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void max2() {
        ListAggregator aggregator = new ListAggregator(list2);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }



    @Test
    public void distinct() {
        class StubDeduplicator implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                List<Integer> numbers = new ArrayList<>();
                numbers.add(1);
                numbers.add(2);
                numbers.add(4);
                numbers.add(5);
                return numbers;
            }
        }
       ListAggregator aggregator = new ListAggregator(list);
        //StubDeduplicator deduplicator = new StubDeduplicator();
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);

        Mockito.when(deduplicator.deduplicate(Mockito.any())).thenReturn(numbers);
        int distinct = aggregator.distinct(deduplicator);

        assertEquals(4, distinct);
    }

    @Test
    public void distinct2() {
        class StubDeduplicator implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter listSorter) {
                List<Integer> numbers = new ArrayList<>();
                numbers.add(1);
                numbers.add(2);
                numbers.add(4);
                return numbers;
            }
        }

        ListAggregator aggregator = new ListAggregator(list3);
        //StubDeduplicator deduplicator = new StubDeduplicator();

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);

        Mockito.when(deduplicator.deduplicate(Mockito.any())).thenReturn(numbers);
        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3, distinct);
    }
}