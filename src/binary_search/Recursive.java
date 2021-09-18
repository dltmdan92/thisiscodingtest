package binary_search;

/**
 * 이진 탐색 : 시작점, 끝점, 중간점
 *
 * 찾으려는 값과 중간점에 있는 값을 끊임없이 비교하면서 값을 찾아나가는 과정
 */
public class Recursive {

    public static void main(String[] args) {
        int value = 0;

        int[] data = {0,2,4,6,8,10,12,14,16,18};

        int result = binarySearch(data, 0, data.length - 1, value);

        System.out.println(result);
    }

    private static int binarySearch(int[] data, int start, int end, int value) {
        int mid = (start + end) / 2;

        if (data[mid] == value)
            return mid;

        if (start >= end)
            return -1;

        // 아랫 부분 찾기
        if (data[mid] > value)
            return binarySearch(data, start, mid - 1, value);
        // 윗 부분 찾기
        else
            return binarySearch(data, mid + 1, end, value);
    }

}
