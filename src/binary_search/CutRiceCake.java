package binary_search;

import java.util.Arrays;

public class CutRiceCake {

    public static void main(String[] args) {
        int value = 7;
        int[] rices = {19,15,10,17};
        int maxRice = getMaxOfArray(rices);

        int[] cuts = new int[maxRice];
        int currentRices = 0;

        for (int i = maxRice - 1; i >= 1; i--) {
            int finalI = i;
            int cuttedRices = Arrays.stream(rices)
                    .filter(x -> x > finalI)
                    .map(x -> 1)
                    .reduce(0, (x, y) -> x + 1);
            currentRices += cuttedRices;
            cuts[finalI] = currentRices;
        }

        System.out.println(binarySearch(cuts, 0, cuts.length - 1, value));
    }

    private static int getMaxOfArray(int[] rices) {
        return Arrays.stream(rices)
                .max()
                .orElse(-1);
    }

    private static int binarySearch(int[] data, int start, int end, int value) {
        int mid = (start + end) / 2;

        if (data[mid] == value)
            return mid;

        if (start >= end) {
            if (data[mid] > value) {
                return mid;
            }
            else {
                // 어쨌든 고객이 요청한거 이상은 줘야 하기 때문
                return mid - 1;
            }
        }

        if (data[mid] > value) {
            // 윗 부분 찾기
            return binarySearch(data, mid + 1, end, value);
        }
        else {
            // 아랫 부분 찾기
            return binarySearch(data, start, mid - 1, value);
        }
    }

}
