package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FindParts {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/binary_search/FindParts.txt"));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] parts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] requiredParts = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(parts);

        for (int requiredPart : requiredParts) {
            int start = 0;
            int end = parts.length - 1;
            boolean partFinded = binarySearch(parts, start, end, requiredPart);
            System.out.println((partFinded) ? "yes" : "no");
        }
    }

    private static boolean binarySearch(int[] parts, int start, int end, int requiredPart) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (parts[mid] == requiredPart) {
            return true;
        }

        if (parts[mid] > requiredPart) {
            return binarySearch(parts, start, mid - 1, requiredPart);
        }
        else {
            return binarySearch(parts, mid + 1, end, requiredPart);
        }
    }

}
