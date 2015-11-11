package com.rnewkirk.Arrays.Sorting.Quick;

public class Sorter {
    private int[] array;

    public Sorter(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        quickSort(array, 0, array.length -1);
        return array;
    }

    private int[] quickSort(int[] array, int leftIndex, int rightIndex) {

        if(array.length > 1){
            int pivotIndex = partition(array, leftIndex, rightIndex);

            if(leftIndex < pivotIndex -1){
                quickSort(array, leftIndex, pivotIndex -1);
            }

            if(pivotIndex < rightIndex){
                quickSort(array, pivotIndex, rightIndex);
            }

        }

        return array;

    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private int partition(int[] array, int leftIndex, int rightIndex) {

        int pivotValue = array[(leftIndex + rightIndex) / 2];

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivotValue) leftIndex++;
            while (array[rightIndex] > pivotValue) rightIndex--;

            if (leftIndex <= rightIndex) {
                swap(leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }

        }

        return leftIndex;
    }

    // This method is used to swap the values between the two given index
    public void swap(int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}
