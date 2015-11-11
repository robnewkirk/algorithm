package com.rnewkirk.Arrays.Sorting.Quick;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SorterTest {

    @Test
    public void testSort() throws Exception {
        Sorter sorter = new Sorter(new int[]{8, 6, 7, 5, 3, 0 , 9});
        assertEquals(sorter.sort(), new int[]{0, 3, 5, 6, 7, 8, 9});
    }
}