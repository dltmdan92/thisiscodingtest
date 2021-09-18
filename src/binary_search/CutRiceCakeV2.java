package binary_search;

import java.util.Arrays;

public class CutRiceCakeV2 {

    public static void main(String[] args) {

        int value = 9;
        int[] rices = {19,15,10,17};

        int maxRice = getMaxOfArray(rices);

        int start = 0;
        int end = maxRice;
        int result = 0;

        while (start <= end) {

            int mid = (start + end) / 2;
            int total = 0;

            for (int rice : rices) {
                if (rice > mid) total += (rice - mid);
            }
            // cut more
            if (value > total) {
                end = mid - 1;
            }
            // cut less
            else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);

    }

    private static int getMaxOfArray(int[] rices) {
        return Arrays.stream(rices)
                .max()
                .orElse(-1);
    }

}
