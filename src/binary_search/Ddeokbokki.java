package binary_search;

import java.util.Arrays;

public class Ddeokbokki {

    public static void main(String[] args) {

        int n = 4;
        int m = 6;
        int[] ddeoks = {19, 15, 10, 17};
        Arrays.sort(ddeoks);

        int longestDdeok = ddeoks[ddeoks.length - 1];

        int[] cuttedDdeoks = new int[longestDdeok + 1];

        for (int knife = 0; knife < cuttedDdeoks.length; knife++) {
            for (int ddeok : ddeoks) {
                cuttedDdeoks[knife] += Math.max(ddeok - knife, 0);
            }
        }

        System.out.println(binarySearch(cuttedDdeoks, m, 0, cuttedDdeoks.length - 1));
    }

    private static int binarySearch(int[] cuttedDdeoks, int m, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;

        if (startIndex == endIndex) {
            return (cuttedDdeoks[midIndex] < m) ? midIndex - 1 : midIndex;
        }
        if (cuttedDdeoks[midIndex] == m) {
            return midIndex;
        }
        if (cuttedDdeoks[midIndex] > m) {
            return binarySearch(cuttedDdeoks, m, midIndex+1, endIndex);
        } else {
            return binarySearch(cuttedDdeoks, m, startIndex, midIndex-1);
        }
    }

}
