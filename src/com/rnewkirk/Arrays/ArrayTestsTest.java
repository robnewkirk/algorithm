package com.rnewkirk.Arrays;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayTestsTest {

    private int[][] matrix;

    @BeforeClass
    public void setUp() {
        // Create 4x4 matrix
        matrix = new int[4][4];
        int count = 0;
        int inner = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                matrix[i][j] = inner;
                inner++;
            }
            count++;
        }
    }


    @Test
    public void testRotate90Clockwise() throws Exception {
        ArrayTests.Rotate90Clockwise(matrix, 3);
        System.out.println(matrix);
    }
}