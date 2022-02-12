package sorting;

import java.util.Arrays;

public class QuickSortV2 {

    public static void main(String[] args) {

        int[] array = {5,7,9,0,3,1,6,2,4,8};

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = array[start];
        int indexFromLeft = start + 1;
        int indexFromRight = end;

        while(indexFromLeft <= indexFromRight) {

            while (indexFromLeft <= end && isLessThanPivot(pivot, array[indexFromLeft])) {
                indexFromLeft++;
            }

            while (indexFromRight > start && isBiggerThanPivot(pivot, array[indexFromRight])) {
                indexFromRight--;
            }

            if (indexFromLeft > indexFromRight) {
                swap(start, indexFromRight, array);
            }
            else {
                swap(indexFromLeft, indexFromRight, array);
            }
        }
        quickSort(array, start, indexFromRight - 1);
        quickSort(array, indexFromRight + 1, end);
    }

    private static void swap(int indexFromLeft, int indexFromRight, int[] array) {
        int temp = array[indexFromLeft];
        array[indexFromLeft] = array[indexFromRight];
        array[indexFromRight] = temp;
    }

    private static boolean isLessThanPivot(int pivot, int i) {
        return i <= pivot;
    }

    private static boolean isBiggerThanPivot(int pivot, int i) {
        return i >= pivot;
    }

}
