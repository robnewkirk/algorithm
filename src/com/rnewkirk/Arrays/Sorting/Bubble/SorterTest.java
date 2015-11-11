package com.rnewkirk.Arrays.Sorting.Bubble;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SorterTest {

    @Test
    public void testSort() throws Exception {

        Sorter sorter = new Sorter(new int[]{10, 5, 6, 14, 3, 1, 2});
        assertEquals(sorter.sort(), new int[]{1, 2, 3, 5, 6, 10, 14});
    }
}