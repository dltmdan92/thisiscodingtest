package sorting;

import java.util.Arrays;

/**
 * 삽입 정렬
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < array.length; i++) {
            for (int n = 0; n < i; n++) {
                int nowStandardVal = array[i];
                int currentPositionVal = array[n];
                if (nowStandardVal < currentPositionVal) {
                    for (int j = i - 1; j >= n; j--) {
                        array[j + 1] = array[j];
                    }
                    array[n] = nowStandardVal;
                }
            }
        }

        for (int element : array) {
            System.out.print(element);
        }
    }
}
