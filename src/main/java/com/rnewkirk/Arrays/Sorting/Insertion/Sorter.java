package com.rnewkirk.Arrays.Sorting.Insertion;

public class Sorter {
    private int[] array;

    public Sorter(int[] array) {
        this.array = array;
    }


    public int[] sort() {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i - 1; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }

        return array;
    }
}
