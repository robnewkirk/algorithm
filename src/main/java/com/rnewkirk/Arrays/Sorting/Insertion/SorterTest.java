package com.rnewkirk.Arrays.Sorting.Insertion;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SorterTest {

    @Test
    public void testSort() throws Exception {

        Sorter sorter = new Sorter(new int[]{5, 8, 3, 2, 7, 1});
        assertEquals(sorter.sort(), new int[]{1, 2, 3, 5, 7, 8});

    }
}