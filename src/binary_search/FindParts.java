package binary_search;

import java.io.IOException;
import java.util.Arrays;

public class FindParts {

    public static void main(String[] args) throws IOException {
        int n = 5;
        int[] parts = {8, 3, 7, 9, 2};
        int m = 3;
        int[] required = {5, 7, 9, 8};

        Arrays.sort(parts);

        for (int require : required) {
            boolean binarySearch = binarySearch(parts, require, 0, n - 1);
            if (binarySearch) System.out.println("yes");
        }
    }

    private static boolean binarySearch(int[] parts, int require, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;
        System.out.printf("midIndex: %d, parts[midIndex] : %d\n", midIndex, parts[midIndex]);
        if (parts[midIndex] == require) return true;
        if (startIndex == endIndex) return false;

        if (parts[midIndex] < require) {
            return binarySearch(parts, require, midIndex+1, endIndex);
        } else {
            return binarySearch(parts, require, startIndex, midIndex-1);
        }
    }
}
