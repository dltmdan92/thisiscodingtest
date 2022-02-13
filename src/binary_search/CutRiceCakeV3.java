package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CutRiceCakeV3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/binary_search/CutRiceCake.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        int[] array = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        int start = 0;
        int end = array[n - 1];
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            int riceLength = getRiceLength(array, mid);

            if (riceLength < m) {
                end = mid - 1;
            }
            else {
                // riceLength >= m
                start = mid + 1;
                result = mid;
            }
        }

        //int result = binarySearch(array, start, end, m);
        System.out.println(result);
    }

    private static int binarySearch(int[] array, int start, int end, int m) {
        int mid = (start + end) / 2;
        int riceLength = getRiceLength(array, mid);

        if (start >= end) {
            if (riceLength < m) {
                // 목표치 보다 작을 경우, 더 잘라줌
                return mid - 1;
            } else {
                return mid;
            }
        }

        if (riceLength == m) {
            return mid;
        }

        if (riceLength > m) {
            return binarySearch(array, mid + 1, end, m);
        }
        else {
            return binarySearch(array, start, mid - 1, m);
        }
    }

    private static int getRiceLength(int[] array, int cutLength) {
        int result = 0;
        for (int element : array) {
            if (element > cutLength) {
                result += element - cutLength;
            }
        }
        return result;
    }
}
