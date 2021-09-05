package sorting;

import java.util.Arrays;

/**
 * 퀵정렬 : 분할 정복의 가장 대표적인 예제
 *
 * 기준 데이터를 설정하고, 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법이다.
 * 일반적으로 첫번째 데이터를 기준 데이터 (피벗)으로 설정하고 돌린다.
 *
 * 재귀 함수를 잘 사용해보자
 *
 * 평균적으로는 O(N * logN)의 시간복잡도
 * 최악의 경우 O(N^2)의 시간복잡도
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5,7,9,0,3,1,6,2,4,8};

        quicksort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void quicksort(int[] array, int startIndex, int lastIndex) {
        System.out.println(Arrays.toString(array));

        if (startIndex >= lastIndex) {
            return;
        }

        int pivot = array[startIndex];

        // find larger one from left
        int left = startIndex + 1;

        // 오름 차순 정렬 버전
        while (array[left] < pivot && left < lastIndex) {
            left++;
        }

        // find smaller one from right
        int right = lastIndex;

        while (array[right] > pivot && right > startIndex) {
            right--;
        }

        /*
        // 내림 차순 정렬 버전
        while (array[left] >= pivot && left <= lastIndex) {
            left++;
        }

        // find smaller one from right
        int right = lastIndex;

        while (array[right] < pivot && right >= startIndex) {
            right--;
        }
        */

        int temp = array[right];

        // swap left and right
        if (left < right) {
            array[right] = array[left];
            array[left] = temp;
            quicksort(array, startIndex, lastIndex);
        }
        // swap pivot and right
        else {
            array[right] = pivot;
            array[startIndex] = temp;
            quicksort(array, startIndex, right - 1);
            quicksort(array, right + 1, lastIndex);
        }
    }

}
