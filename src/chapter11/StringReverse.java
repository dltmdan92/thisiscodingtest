package chapter11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class StringReverse {

    private static final int GROUP_A = 0;
    private static final int GROUP_B = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/chapter11/StringReverseParam.txt"));

        int[] nums = Arrays.stream(bufferedReader.readLine().split(""))
                .mapToInt(Integer::valueOf)
                .toArray();

        int context = -1;
        int aGroupCount = 0;
        int bGroupCount = 0;

        for (int num : nums) {

            if (num == GROUP_A) {
                if (context != GROUP_A) {
                    aGroupCount++;
                    context = GROUP_A;
                }
            }
            else {
                if (context != GROUP_B) {
                    bGroupCount++;
                    context = GROUP_B;
                }
            }

        }

        System.out.println(Math.min(aGroupCount, bGroupCount));
    }

}
