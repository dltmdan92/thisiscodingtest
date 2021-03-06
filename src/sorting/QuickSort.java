package sorting;

/**
 * 기준 데이터를 설정하고, 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법이다.
 * 일반적으로 첫번째 데이터를 기준 데이터 (피벗)으로 설정하고 돌린다.
 *
 * 재귀 함수를 잘 사용해보자
 *
 * 평균적으로는 O(N * logN)의 시간복잡도
 * 최악의 경우 O(N^2)의 시간복잡도
 */
public class QuickSort {
    private static int[] array = {5,7,9,0,3,1,6,2,4,8};

    public static void main(String[] args) {
        quickSort(array, 0, array.length - 1);

        for(int element : array) {
            System.out.print(element);
        }
    }

    private static void quickSort(int[] target, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;
        int pivot = startIdx;
        int left = startIdx + 1;
        int right = endIdx;

        while(left <= right) {
            // 왼쪽 부터 시작해서 피벗보다 큰 값이 나온 부분에서 끝나고 left 인덱스를 반환
            while (left <= endIdx && target[left] <= target[pivot]) {
                left++;
            }
            // 오른쪽 부터 시작해서 피벗보다 작은 값이 나온 부분에서 끝나고 right 인덱스를 반환
            while (right > startIdx && target[right] >= target[pivot]) {
                right--;
            }
            // 큰 녀석이 작은 녀석보다 더 오른쪽에 있을 경우
            // right : 작은 녀석의 인덱스
            // left : 큰 녀석의 인덱스
            if (left > right) {
                int temp = target[pivot];
                target[pivot] = target[right];
                target[right] = temp;
            }
            // 작은 녀석이 큰 녀석보다 오른쪽에 있을 경우
            else {
                int temp = target[right];
                target[right] = target[left];
                target[left] = temp;
            }
        }
        quickSort(target, startIdx, right - 1);
        quickSort(target, right + 1, endIdx);
    }


}
