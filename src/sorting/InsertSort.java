package sorting;

import java.util.Arrays;

/**
 * 삽입 정렬
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < array.length; i++) {
            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
                // 이 점 때문에 이미 데이터가 정렬되어 있다면 삽입 정렬이 매우 유리하다!! (시간복잡도 : O(n))
                else break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

}
