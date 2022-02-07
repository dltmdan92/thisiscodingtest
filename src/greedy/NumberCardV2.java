package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class NumberCardV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("/Users/seungmoo.lee/IdeaProjects/thisiscodingtest/src/greedy/number_card_param.txt"));

        String[] firstLine = bufferedReader.readLine().split(" ");
        int rows = Integer.parseInt(firstLine[0]);
        int cols = Integer.parseInt(firstLine[1]);

        int[] minsOfEachRow = new int[rows + 1];

        String line;
        int currentRow = 1;

        while((line = bufferedReader.readLine()) != null) {
            int[] numsOfRow = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

            int minOfRow = getMinOfArray(numsOfRow);
            minsOfEachRow[currentRow] = minOfRow;
            currentRow++;
        }

        int result = getMaxOfArray(minsOfEachRow);
        System.out.println(result);

    }

    private static int getMinOfArray(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            result = Math.min(result, num);
        }
        return result;
    }

    private static int getMaxOfArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            result = Math.max(result, num);
        }
        return result;
    }
}
